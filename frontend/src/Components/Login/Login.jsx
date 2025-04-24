import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../services/api";
import "./Login.css";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate  = useNavigate();

  const saveBasic = (token) => localStorage.setItem("authBasic", token);

  const handleSubmit = async (e) => {
    e.preventDefault();

    /* gera o Basic (Base64) */
    const basicToken = btoa(`${username}:${password}`);

    try {
      /* faz uma chamada “ping” só para confirmar as credenciais */
      await api.get("/usuario", {
        headers: { Authorization: `Basic ${basicToken}` },
      });

      /* se chegou aqui, usuário/senha estão corretos */
      saveBasic(basicToken);
      alert("Login realizado com sucesso");
      navigate("/usuarios");
    } catch (err) {
      alert("Credenciais inválidas");
    }
  };

  return (
    <div className="login-container">
      <h1>Login</h1>

      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Usuário"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          required
        />
        <input
          type="password"
          placeholder="Senha"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <button type="submit">Entrar</button>
      </form>
    </div>
  );
};

export default Login;
