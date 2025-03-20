# 📌 Projeto: Cadastro de Usuários - Integração Frontend & Backend


## 🚀 Tecnologias Utilizadas
- **React** - Framework para construção da interface.
- **Vite** - Build rápido para React.
- **Axios** - Para fazer chamadas HTTP ao backend.
- **React Icons** - Biblioteca de ícones.
- **ESLint** - Ferramenta para padronização do código.

---

## 📦 Dependências do Projeto

### 📌 **Principais**
| Dependência | Função |
|------------|--------|
| **react** | Biblioteca para criação da interface. |
| **react-dom** | Renderiza componentes React no navegador. |
| **axios** | Faz requisições HTTP para o backend. |
| **react-icons** | Biblioteca de ícones. |
| **@react-icons/all-files** | Permite importar ícones de forma otimizada. |

### 🛠 **Dependências de Desenvolvimento**
| Dependência | Função |
|------------|--------|
| **vite** | Build rápido para desenvolvimento React. |
| **@vitejs/plugin-react** | Plugin do Vite para React. |
| **eslint** | Padronização e correção de código. |
| **eslint-plugin-react-hooks** | Verifica o uso correto dos hooks do React. |
| **eslint-plugin-react-refresh** | Auxilia no hot reload do React. |
| **@types/react** | Tipagens do React para TypeScript. |
| **@types/react-dom** | Tipagens do React DOM para TypeScript. |

---

## 🔧 Como Rodar o Projeto

1️⃣ **Clone o Repositório**
```sh
- git clone <URL_DO_REPOSITORIO>
- cd nome-do-projeto
```
2️⃣ ️**Instale as Dependências**
```sh
- npm install
```
3️⃣ **Inicie o Servidor**
```sh
- npm run dev
```

---

## 🧪 Testando o Projeto

Para garantir que a integração entre o **frontend e o backend** está funcionando corretamente, siga os passos abaixo:

### **1️⃣ Cadastro de um Usuário**
1. Com o **backend rodando** (`mvn spring-boot:run`).
2. Acesse o frontend (`http://localhost:5173`).
3. Preencha os campos de **Nome, Idade e CPF** e clique em **Cadastrar**.
4. Se o cadastro for bem-sucedido, o usuário será salvo no banco de dados.

---

### **2️⃣ Verificando o Cadastro no Backend (Usando o Postman)**
1. **Abra o Postman** e crie uma nova requisição **GET**.
2. **Use a URL**: http://localhost:8080/usuario
3. **Clique em "Send"**.
4. Se o backend estiver rodando corretamente, ele irá retornar o status code 200 e você verá a **lista de usuários cadastrados**, como no exemplo abaixo:

```json
[
    {
        "id": 1,
        "nome": "João Silva",
        "idade": 30,
        "cpf": "12345678900"
    },
    {
        "id": 2,
        "nome": "Maria Oliveira",
        "idade": 25,
        "cpf": "98765432100"
    }
]