import { FaUser, FaBirthdayCake, FaEnvelope } from "react-icons/fa";
import { useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import "./Cadastro.css";

const Cadastro = () => {
  const [nome,  setNome]  = useState("");
  const [idade, setIdade] = useState("");
  const [email, setEmail] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();

    const parsed = parseInt(idade, 10);
    if (isNaN(parsed) || parsed < 18 || parsed > 120) {
      alert("Idade inválida (digite 18–120).");
      return;
    }

    try {
      await axios.post("https://cadastrodeusuarios-production.up.railway.app/usuario", {
        nome,
        idade: parsed,
        email,
      });
      alert("Usuário cadastrado com sucesso!");
      setNome(""); setIdade(""); setEmail("");
    } catch (err) {
      if (err.response?.status === 400) {
        alert("O campo 'Nome' está vazio.");
      } else {
        alert("Erro desconhecido. Tente novamente.");
      }
    }
  };

  return (
    <div className="container">
      <form onSubmit={handleSubmit}>
        <h1>Cadastro de Usuário</h1>

        {/* Nome */}
        <div className="input-field">
          <FaUser className="icon" />
          <input
            type="text"
            placeholder="Nome"
            maxLength={30}
            value={nome}
            onChange={(e) => setNome(e.target.value)}
            required
          />
        </div>

        {/* Idade */}
        <div className="input-field">
          <FaBirthdayCake className="icon" />
          <input
            type="number"
            placeholder="Idade"
            value={idade}
            onChange={(e) => setIdade(e.target.value.slice(0, 3))}
            onKeyDown={(e) => ["e", "E", "+", "-"].includes(e.key) && e.preventDefault()}
            min={18}
            max={120}
            required
          />
        </div>

        {/* E‑mail */}
        <div className="input-field">
          <FaEnvelope className="icon" />
          <input
            type="email"
            placeholder="E-mail"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>

        <button type="submit">Cadastrar</button>

        {/* Ajuste a rota conforme seu app */}
        <Link to="/usuarios" className="lista-btn">
          Usuários Cadastrados
        </Link>
      </form>
    </div>
  );
};

export default Cadastro;
