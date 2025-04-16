package dev.marlosemanuel.Cadastro_de_Usuarios_backend.controller;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.request.UsuarioRequest;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.response.UsuarioResponse;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponse> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable String id) {
        return usuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UsuarioRequest request) {
        return usuarioService.save(request);
    }

    @GetMapping("/pesquisa/{nome}")
    public ResponseEntity<List<UsuarioResponse>> findByNome(@PathVariable String nome) {
        List<UsuarioResponse> usuarios = usuarioService.findByNome(nome);

        if (!usuarios.isEmpty()) {
            return ResponseEntity.ok(usuarios);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (usuarioService.findById(id).isPresent()) {
            usuarioService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> update(@PathVariable String id, @RequestBody UsuarioRequest request) {
        Optional<UsuarioResponse> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            UsuarioResponse response = usuarioService.edit(id, request);
            return ResponseEntity.ok(response);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
