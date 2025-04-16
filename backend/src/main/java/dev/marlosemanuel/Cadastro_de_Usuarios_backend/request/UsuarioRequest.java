package dev.marlosemanuel.Cadastro_de_Usuarios_backend.request;

import lombok.Builder;

@Builder
public record UsuarioRequest(String nome, int idade, String email) {
}
