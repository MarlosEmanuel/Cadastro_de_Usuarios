package dev.marlosemanuel.Cadastro_de_Usuarios_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "tb_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    private long id;

    @Column(nullable = false, name="nome")
    private String nome;

    @Column(nullable = false, name = "idade")
    private int idade;

    @Column(unique = true, nullable = false, name = "cpf")
    private String cpf;
}
