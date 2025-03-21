package dev.marlosemanuel.Cadastro_de_Usuarios_backend.service;

import dev.marlosemanuel.Cadastro_de_Usuarios_backend.mapper.UsuarioMapper;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.model.Usuario;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.repository.UsuarioRepository;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.request.UsuarioRequest;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.response.UsuarioResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<UsuarioResponse> findAll() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioMapper::mapResponse)
                .collect(Collectors.toList());
    }

    public ResponseEntity<?> save(UsuarioRequest request) {
       if (request == null) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Requisição Invalida");
       }
       if (request.nome().isEmpty()  || request.idade() == 0 || request.cpf().isEmpty()) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Todos os campos devem ser obrigatorios");
       }
       if (usuarioRepository.existsByCpf(request.cpf())) {
           return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF ja cadastrado.");
       }
       try {
           Usuario usuario = UsuarioMapper.mapEntity(request);
           usuario.setCpf(formatarCpf(usuario.getCpf()));
           usuarioRepository.save(usuario);

           return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.mapResponse(usuario));
       } catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao salvar usuario");
       }
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<UsuarioResponse> findById(Long id) {
        return usuarioRepository.findById(id).map(UsuarioMapper::mapResponse);
    }

    public List<UsuarioResponse> findByNome(String nome) {
        return usuarioRepository.findByNomeContainingIgnoreCase(nome).stream()
                .map(UsuarioMapper::mapResponse)
                .collect(Collectors.toList());
    }

    public UsuarioResponse edit(Long id, UsuarioRequest request) {
        return usuarioRepository.findById(id)
                .map(user -> {
                    user.setNome(request.nome());
                    user.setIdade(request.idade());
                    user.setCpf(request.cpf());
                    usuarioRepository.save(user);
                    return UsuarioMapper.mapResponse(user);
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    private String formatarCpf(String cpf) {
        if (cpf != null) {
            // Remove todos os caracteres não numéricos
            return cpf.replaceAll("[^0-9]", "");
        }
        return null;
    }
}
