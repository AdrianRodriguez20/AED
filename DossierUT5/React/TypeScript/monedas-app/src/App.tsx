import React from 'react';
import { Link, Route, BrowserRouter, Routes } from 'react-router-dom';
import logo from './logo.svg';
import './App.css';
import Monedas from './Monedas';
import ManageMoneda from './ManageMoneda';
import CreateMoneda from './CreateMoneda';
import UpdateMoneda from './UpdateMoneda';
import DeleteMoneda from './DeleteMoneda';
import CreateHistorico from './CreateHistorico';

function App() {

        return (
            <BrowserRouter>
                <h1>Aplicación Monedas</h1>
                <Navbar />
                <Routes>
                    <Route path="/" element={<Monedas />} />
                    <Route path="/monedas" element={<Monedas />} />
                    <Route path="/monedas/create" element={<CreateMoneda />} />
                    <Route path="/monedas/update/:idmoneda" element={<UpdateMoneda />} />
                    <Route path="/monedas/delete/:idmoneda" element={<DeleteMoneda />} />
                    <Route path="/monedas/:idmoneda" element={<ManageMoneda />} />
                    <Route path="/monedas/:idmoneda/createHistorico" element={<CreateHistorico />} />
                </Routes>
            </BrowserRouter>
        );
    
}
function Navbar() {
    // visible on every page
    return (
        <nav>
            <Link to="/"> Inicio </Link> &nbsp;
            <Link to="/monedas/create"> Crear </Link> &nbsp;
            <Link to="/monedas"> Monedas </Link>
        </nav>
    );
}
export default App;