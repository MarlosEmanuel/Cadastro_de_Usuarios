// frontend/src/App.jsx
import { Routes, Route } from "react-router-dom";
import Cadastro        from "./Components/Cadastro/Cadastro";
import Login           from "./Components/Login/Login";
import ListaUsuarios   from "./Components/ListaUsuarios/ListaUsuarios";

function App() {
  return (
    <Routes>
      {/* rota da Home (cadastro) */}
      <Route path="/"            element={<Cadastro />} />

      {/* tela de login */}
      <Route path="/login"       element={<Login />}   />

      {/* LISTA – ajuste o path aqui para combinar com seus <Navigate> */}
      <Route path="/usuarios"    element={<ListaUsuarios />} />
      {/*            └──────   ← troquei de /lista-usuarios para /usuarios */}

      {/* 404 simples (opcional) */}
      {/* <Route path="*" element={<h1>Página não encontrada</h1>} /> */}
    </Routes>
  );
}

export default App;
