import { FaUser, FaBirthdayCake, FaIdCard } from "react-icons/fa";
import { useState } from "react";
import "./Cadastro.css";
import axios from "axios";
import { Link } from "react-router-dom";

const Cadastro = () => {
  const [nome, setNome] = useState("");
  const [idade, setIdade] = useState("");
  const [email, setEmail] = useState(""); // Alterado de cpf para email
  const [error, setError] = useState("");

  const handleSubmit = async (event) => {
    event.preventDefault();

    // Verificação simples em JS para garantir 18..120:
    const parsedIdade = parseInt(idade, 10);
    if (isNaN(parsedIdade) || parsedIdade < 18 || parsedIdade > 120) {
      alert("Idade inválida! Digite um valor entre 18 e 120 anos.");
      return;
    }

    try {
      const response = await axios.post("https://cadastrodeusuarios-production.up.railway.app/usuario", {
        nome: nome,
        idade: parsedIdade,
        email: email,  // Enviando o email para o backend
      });

      console.log("Usuário cadastrado:", response.data);
      alert("Usuário cadastrado com sucesso!");

      // Limpar os campos após o cadastro
      setNome("");
      setIdade("");
      setEmail("");  // Limpar o campo de email
    } catch (error) {
      console.error("Erro ao cadastrar usuário:", error);

      // Verificar o status code da resposta de erro
      if (error.response) {
        if (error.response.status === 400) {
          alert("O campo 'Nome' está vazio. Por favor, preencha-o.");
        } else {
          alert("Erro desconhecido. Tente novamente.");
        }
      } 
    }
  };

  // Lógica para limitar a idade em até 3 dígitos
  const handleIdadeChange = (e) => {
    let val = e.target.value;

    // Limitar a 3 caracteres
    if (val.length > 3) {
      val = val.slice(0, 3);
    }

    setIdade(val);
  };

  // A validação do e-mail pode ser feita com um regex simples para garantir que o valor inserido seja um email válido
  const handleEmailChange = (e) => {
    setEmail(e.target.value);  // Aqui, apenas configuramos o valor do email
  };

  return (
    <div className="container">
      <link rel="icon" />
      <title>Cadastro de Usuário</title>

      <form onSubmit={handleSubmit}>
        <h1>Cadastro de Usuário</h1>

        {/* Nome: texto, até 30 caracteres */}
        <div className="input-field">
          <input
            type="text"
            placeholder="Nome"
            value={nome}
            maxLength={30}
            onChange={(e) => setNome(e.target.value)}
          />
          <FaUser className="icon" />
        </div>

        {/* Idade: limita a 3 dígitos. Bloqueia 'e', 'E', '+', '-' e aceita [18..120] na validação do submit */}
        <div className="input-field">
          <input
            type="number"
            placeholder="Idade"
            value={idade}
            onChange={handleIdadeChange}
            onKeyDown={(e) =>
              ["e", "E", "+", "-"].includes(e.key) && e.preventDefault()
            }
            min={18}
            max={120}
            required
          />
          <FaBirthdayCake className="icon" />
        </div>

        {/* E-mail: aceitando caracteres comuns para email */}
        <div className="input-field">
          <input
            type="email"  // Alterado para 'email' para garantir que é um campo de e-mail
            placeholder="E-mail"
            value={email}
            onChange={handleEmailChange}
            required
          />
          <FaIdCard className="icon" />
        </div>

        <button>Cadastrar</button>
        <Link to="/lista-usuarios" className="lista-btn">
        Ver Usuários Cadastrados
        </Link>
      </form>
    </div>
  );
};

export default Cadastro;
