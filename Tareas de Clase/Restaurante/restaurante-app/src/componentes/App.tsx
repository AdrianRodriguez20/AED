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
import CreateMesas from './mesa/CreateMesas';
import CrearDetalleFactura from './detallefactura/CrearDetalleFactura';
import { RequireAuth } from './RequireAuth';

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Inicio />} />
        <Route path="/platos" element={<ListadoPlatos />} />
        <Route path="/registro" element={<Registro />} />
        <Route path="/servicios" element={<ListadoServicios />} />
        <Route path="/servicios/:id" element={
          <RequireAuth >
            <ManageServicio />
          </RequireAuth>
        } />
        <Route path="/servicios/create" element={
          <RequireAuth >
            <CrearServicio />
          </RequireAuth>
        }
        />
        <Route path="/sobrenosotros" element={
          <SobreNostros />
        }
        />
        <Route path="/mesas" element={
          <RequireAuth >
            <ListMesas />
          </RequireAuth>
        }
        />
        <Route path="/mesas/create" element={
          <RequireAuth >
            <CreateMesas />
          </RequireAuth>
        }
        />
        <Route path="/servicios/:id/create" element={
          <RequireAuth >
            <CrearDetalleFactura />
          </RequireAuth>
        }
        />
      </Routes>
      <Footer />
    </BrowserRouter>

  );
}

export default App;
