import { BrowserRouter, Route, Routes } from 'react-router-dom';

import Inicio from './Inicio';
import Footer from './Footer';
import Navbar from './Navbar';
import SobreNostros from './otros/SobreNosotros';
import Registro from './operario/Registro';
import ListadoPlatos from './plato/ListadoPlatos';
import ListadoServicios from './servicio/ListadoServicios';
import ManageServicio from './servicio/ManageServicio';
import CrearServicio from './servicio/CrearServicios';
import ListMesas from './mesa/ListMesas';

function App() {
  return (
    <BrowserRouter>
    <Navbar/>
    <Routes>
      <Route path="/" element={<Inicio />} />
      <Route path="/platos" element={<ListadoPlatos />} />
      <Route path="/registro" element={<Registro />} />
      <Route path="/servicios" element={<ListadoServicios />} />
      <Route path="/servicios/:id" element={<ManageServicio />} />
      <Route path="/servicios/create" element={<CrearServicio />} />
      <Route path="/sobrenosotros" element={<SobreNostros />} />
      <Route path="/mesas" element={<ListMesas />} />
      
    </Routes>
    <Footer/>
    </BrowserRouter>

  );
}

export default App;
