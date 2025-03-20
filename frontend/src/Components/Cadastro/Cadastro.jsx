import { FaUser, FaBirthdayCake, FaIdCard } from "react-icons/fa";
import { useState } from "react";
import "./Cadastro.css";
import axios from "axios";

const Cadastro = () => {
  const [nome, setNome] = useState("");
  const [idade, setIdade] = useState("");
  const [cpf, setCpf] = useState("");
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
      const response = await axios.post("http://localhost:8080/usuario", {
        nome: nome,
        idade: parsedIdade,
        cpf: cpf,
      });

      console.log("Usuário cadastrado:", response.data);
      alert("Usuário cadastrado com sucesso!");

      // Limpar os campos após o cadastro
      setNome("");
      setIdade("");
      setCpf("");
    } catch (error) {
      console.error("Erro ao cadastrar usuário:", error);
      setError("Falha ao cadastrar. Verifique os dados.");
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

  // Formatação automática do CPF: xxx.xxx.xxx-xx (limite 11 dígitos)
  const handleCpfChange = (e) => {
    let val = e.target.value.replace(/\D/g, "");
    if (val.length > 11) {
      val = val.slice(0, 11);
    }

    let masked = "";
    if (val.length >= 1) {
      masked = val.substring(0, 3);
    }
    if (val.length >= 4) {
      masked += "." + val.substring(3, 6);
    }
    if (val.length >= 7) {
      masked += "." + val.substring(6, 9);
    }
    if (val.length >= 10) {
      masked += "-" + val.substring(9, 11);
    }

    setCpf(masked);
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

        {/* CPF: type="text" para poder inserir '.' e '-' na máscara */}
        <div className="input-field">
          <input
            type="text"
            placeholder="CPF"
            value={cpf}
            onChange={handleCpfChange}
            maxLength={14} // xxx.xxx.xxx-xx => 14 caracteres
            required/>
  <FaIdCard className="icon" />
        </div>

        <button>Cadastrar</button>
      </form>
    </div>
  );
};

export default Cadastro;
