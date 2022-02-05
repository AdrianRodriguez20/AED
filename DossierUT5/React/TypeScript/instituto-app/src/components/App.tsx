
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import ListAlumnos from './ListAlumnos';
import ListAsignaturas from './ListAsignaturas';
import '../style/App.css'
import Inicio from './Inicio';
import Navbar from './Navbar';





function App() {

        
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Inicio />} />
        <Route path="/alumnos" element={<ListAlumnos />} />
        <Route path="/alumnos/:id" />
        <Route path="/asignaturas" element={<ListAsignaturas/>} />


      </Routes>
    </BrowserRouter>
  );

}

export default App;