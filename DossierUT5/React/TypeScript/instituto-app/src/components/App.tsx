
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ListAlumnos from './ListAlumnos';
import ListAsignaturas from './ListAsignaturas';
import CreateAlumno from './CreateAlumno';
import '../style/App.css'
import Inicio from './Inicio';
import Navbar from './Navbar';
import ManageAlumno from './ManageAlumno';





function App() {

        
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Inicio />} />
        <Route path="/alumnos" element={<ListAlumnos />} />
        <Route path="/alumnos/create" element={<CreateAlumno />} />
        <Route path="/alumnos/:id" element={<ManageAlumno/>}/>
        <Route path="/asignaturas" element={<ListAsignaturas/>} />


      </Routes>
    </BrowserRouter>
  );

}

export default App;