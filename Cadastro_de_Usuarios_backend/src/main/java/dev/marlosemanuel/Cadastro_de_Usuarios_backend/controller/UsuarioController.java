package dev.marlosemanuel.Cadastro_de_Usuarios_backend.controller;

import dev.marlosemanuel.Cadastro_de_Usuarios_backend.model.Usuario;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        usuarioService.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (usuarioService.findById(id).isPresent()) {
            usuarioService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
