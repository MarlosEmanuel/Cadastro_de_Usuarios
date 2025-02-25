package dev.marlosemanuel.Cadastro_de_Usuarios_backend.service;

import dev.marlosemanuel.Cadastro_de_Usuarios_backend.model.Usuario;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> findByNome(String nome) {
        return usuarioRepository.findByNome(nome);
    }
}
