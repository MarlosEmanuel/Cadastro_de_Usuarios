import React from 'react';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Cadastro from './Components/Cadastro/Cadastro';
import ListaUsuarios from './Components/ListaUsuarios/ListaUsuarios';
import BackGround from './assets/BackGround.webp';

function App() {
  return (
    <Router>
      <div className='App' style={{
        backgroundImage: `url(${BackGround})`,
        backgroundSize: 'cover',
        backgroundPosition: 'center'
      }}>
        <Routes>
          <Route path="/" element={<Cadastro />} />
          <Route path="/lista-usuarios" element={<ListaUsuarios />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;