package dev.marlosemanuel.Cadastro_de_Usuarios_backend.repository;

import dev.marlosemanuel.Cadastro_de_Usuarios_backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNomeContainingIgnoreCase(String nome);
}
