import { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";
import "./ListaUsuarios.css";

const ListaUsuarios = () => {
  const [usuarios, setUsuarios] = useState([]);

  useEffect(() => {
    const fetchUsuarios = async () => {
      try {
        const response = await axios.get("https://cadastrodeusuarios-production.up.railway.app/usuario");
        setUsuarios(response.data);
      } catch (error) {
        console.error("Erro ao buscar usuários:", error);
      }
    };

    fetchUsuarios();
  }, []);

  return (
    <div className="lista-container">
      <h1>Usuários Cadastrados</h1>
      <Link to="/" className="voltar-btn">
        Voltar para Cadastro
      </Link>
      
      <div className="usuarios-grid">
        {usuarios.map((usuario) => (
          <div key={usuario.id} className="usuario-card">
            <p><strong>Nome:</strong> {usuario.nome}</p>
            <p><strong>Idade:</strong> {usuario.idade}</p>
            <p><strong>E-mail:</strong> {usuario.email}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ListaUsuarios;