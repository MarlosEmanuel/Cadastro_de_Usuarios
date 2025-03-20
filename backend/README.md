# Cadastro de Usuários

Este sistema fornece uma API para cadastro, listagem e remoção de usuários.

## Endpoints Disponíveis

### 1. Listar todos os usuários

**Método:** GET\
**URL:** `http://localhost:8080/usuarios`\
**Descrição:** Retorna uma lista com todos os usuários cadastrados.

### 2. Cadastrar um novo usuário

**Método:** POST\
**URL:** `http://localhost:8080/usuarios`\
**Descrição:** Salva um novo usuário no sistema.

**Corpo da Requisição (JSON):**

```json
{
    "nome": "João Guibaz",
    "idade": 21,
    "cpf": "12314102781312"
}
```

#### 2.1 Respostas:
- 201 - Usuario criado com sucesso.
- 409 - Conflito, existe um usuario cadastrado com o mesmo cpf.
- 400 - Todos os campos precisam ser obrigatorios.
### 3. Buscar um usuário por ID

**Método:** GET\
**URL:** `http://localhost:8080/usuarios/{id}`\
**Descrição:** Retorna os detalhes de um usuário específico com base no ID fornecido.

### 4. Deletar um usuário por ID

**Método:** DELETE\
**URL:** `http://localhost:8080/usuarios/{id}`\
**Descrição:** Remove um usuário do sistema com base no ID fornecido.

### 5. Pesquisar por nome

**Método:** GET\
**URL:** `http://localhost:8080/usuarios/pesquisa/{nome}`\
**Descrição:** Retorna os detalhes de um usuário específico com base no NOME fornecido.

### 6. Editar um usuario

**Método:** PUT\
**URL:** `http://localhost:8080/usuarios/{id}`\
**Descrição:** edita um usuario

**Corpo da Requisição (JSON):**

```json
{
    "nome": "João Guibaz",
    "idade": 21,
    "cpf": "12314102781312"
}
```

OBS: caso um campo fique sem nada, vai ser salvo como null no banco de dados.


