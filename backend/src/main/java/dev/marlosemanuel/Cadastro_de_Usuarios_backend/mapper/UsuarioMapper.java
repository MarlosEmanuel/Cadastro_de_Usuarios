package dev.marlosemanuel.Cadastro_de_Usuarios_backend.mapper;

import dev.marlosemanuel.Cadastro_de_Usuarios_backend.model.Usuario;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.request.UsuarioRequest;
import dev.marlosemanuel.Cadastro_de_Usuarios_backend.response.UsuarioResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsuarioMapper {

    public Usuario mapEntity(UsuarioRequest request){
        return Usuario.builder()
                .nome(request.nome())
                .email(request.email())
                .idade(request.idade())
                .build();
    }

    public UsuarioResponse mapResponse(Usuario usuario){
        return UsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .idade(usuario.getIdade())
                .email(usuario.getEmail())
                .build();
    }

}
