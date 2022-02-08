
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ListAlumnos from './ListAlumnos';
import ListAsignaturas from './ListAsignaturas';
import CreateAlumno from './CreateAlumno';
import UpdateAlumno  from './UpdateAlumno';

import '../style/App.css'
import Inicio from './Inicio';
import Navbar from './Navbar';
import ManageAlumno from './ManageAlumno';
import CreateMatricula from './CreateMatricula';





function App() {

        
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Inicio />} />
        <Route path="/alumnos" element={<ListAlumnos />} />
        <Route path="/alumnos/create" element={<CreateAlumno />} />
        <Route path="/alumnos/:dni" element={<ManageAlumno/>}/>
        <Route path="/alumnos/:dni/update" element={<UpdateAlumno />} />
        <Route path="/alumnos/:dni/matriculas" element={<CreateMatricula/>}/>
        <Route path="/alumnos/:dni/matriculas/:id" />
        <Route path="/asignaturas" element={<ListAsignaturas/>} />
        


      </Routes>
    </BrowserRouter>
  );

}

export default App;