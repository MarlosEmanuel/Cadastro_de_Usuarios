﻿# Cadastro_de_Usuarios

metodo GET
localhost:8080/usuarios
Lista todos os usuarios

metodo POST
localhost:8080/usuarios/save
salva um usuario
json: 

{
    "nome": "João Guibaz",
    "idade": 21,
    "cpf": "12314102781312"
}

metodo GET
localhost:8080/usuarios/id
lista o usuario por ID

metodo DELETE
localhost:8080/usuarios/delete/id
deleta um usuario por id
