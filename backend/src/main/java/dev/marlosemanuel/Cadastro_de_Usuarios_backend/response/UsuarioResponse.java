package dev.marlosemanuel.Cadastro_de_Usuarios_backend.response;

import lombok.Builder;

@Builder
public record UsuarioResponse(Long id, String nome, int idade, String cpf) {
}
