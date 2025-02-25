package dev.marlosemanuel.Cadastro_de_Usuarios_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, name="nome")
    private String nome;

    @Column(nullable = false, name = "idade")
    private int idade;

    @Column(unique = true, nullable = false, name = "cpf")
    private String cpf;
}
