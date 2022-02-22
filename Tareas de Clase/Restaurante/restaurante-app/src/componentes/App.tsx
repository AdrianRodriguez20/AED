import { BrowserRouter, Route, Routes } from 'react-router-dom';

import Inicio from './Inicio';
import Footer from './Footer';
import Navbar from './Navbar';
import Menu from './plato/Menu';
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
import CreatePlatos from './plato/CreatePlato';
import UpdatePlatos from './plato/UpdatePlato';
import UpdateMesas from './mesa/UpdateMesas';
import UpdateServicio from './servicio/UpdateServicio';
import UpdateDetalleFactura from './detallefactura/UpdateDetalleFactura';
import MainMenu from './otros/MainAdmin';

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Inicio />} />
        <Route path="/menu" element={<Menu />} />
        <Route path="/registro" element={<Registro />} />
        <Route path="/menu" element={<Menu />} />
        <Route path="/platos" element={
          <RequireAuth>
            <ListadoPlatos />
          </RequireAuth>
        }
        />
        <Route path="/platos/create" element={
          <RequireAuth>
            <CreatePlatos />
          </RequireAuth>
        }
        />
        <Route path="/platos/:id/update" element={
          <RequireAuth>
            <UpdatePlatos />
          </RequireAuth>
        }
        />

        <Route path="/servicios" element={
          <RequireAuth >
            <ListadoServicios />
          </RequireAuth>
        }
        />
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
        <Route path="/servicios/:id/update" element={
          <RequireAuth >
            <UpdateServicio />
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
        <Route path="/mesas/:id/update" element={
          <RequireAuth >
            <UpdateMesas />
          </RequireAuth>
        }
        />

        <Route path="/servicios/:id/platos/create" element={
          <RequireAuth >
            <CrearDetalleFactura />
          </RequireAuth>
        }
        />
        <Route path="/servicios/:id/platos/:idplato/update" element={
          <RequireAuth >
            <UpdateDetalleFactura />
          </RequireAuth>
        }
        />
            <Route path="/main" element={
          <RequireAuth >
            <MainMenu />
          </RequireAuth>
        }
        />

      </Routes>
      <Footer />
    </BrowserRouter>

  );
}

export default App;
