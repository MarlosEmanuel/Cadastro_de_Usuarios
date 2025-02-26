package dev.marlosemanuel.Cadastro_de_Usuarios_backend.service;

import dev.marlosemanuel.Cadastro_de_Usuarios_backend.mapper.UsuarioMapper;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.model.Usuario;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.repository.UsuarioRepository;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.request.UsuarioRequest;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.response.UsuarioResponse;
import lombok.RequiredArgsConstructor;
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

    public UsuarioResponse save(UsuarioRequest request) {
        Usuario usuario = UsuarioMapper.mapEntity(request);
        usuarioRepository.save(usuario);
        return UsuarioMapper.mapResponse(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<UsuarioResponse> findById(Long id) {
        return usuarioRepository.findById(id).map(UsuarioMapper::mapResponse);
    }



    //Implementar no controller !!
    public Optional<Usuario> findByNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }
}
