import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../../services/api";
import "./ListaUsuarios.css";

const ListaUsuarios = () => {
  const [usuarios, setUsuarios] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchUsuarios = async () => {
      const basicToken = localStorage.getItem("authBasic");
      if (!basicToken) {
        alert("Você precisa estar logado para acessar esta página.");
        navigate("/login");
        return;
      }

      try {
        const { data } = await api.get("/usuario");
        setUsuarios(data);
      } catch (err) {
        alert("Sessão expirada ou sem permissão.");
        navigate("/login");
      }
    };

    fetchUsuarios();
  }, [navigate]);

  return (
    <div className="lista-container">
      <h1>Usuários Cadastrados</h1>
      <div className="usuarios-grid">
        {usuarios.map((u) => (
          <div key={u.id} className="usuario-card">
            <p><strong>Nome:</strong>  {u.nome}</p>
            <p><strong>Idade:</strong> {u.idade}</p>
            <p><strong>E‑mail:</strong> {u.email}</p>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ListaUsuarios;
