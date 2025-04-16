package dev.marlosemanuel.Cadastro_de_Usuarios_backend.repository;

import dev.marlosemanuel.Cadastro_de_Usuarios_backend.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    List<Usuario> findByNomeContainingIgnoreCase(String nome);
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
}
