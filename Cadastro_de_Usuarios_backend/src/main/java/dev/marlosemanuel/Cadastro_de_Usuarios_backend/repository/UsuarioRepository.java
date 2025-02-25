package dev.marlosemanuel.Cadastro_de_Usuarios_backend.repository;

import dev.marlosemanuel.Cadastro_de_Usuarios_backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByNome(String nome);
}
