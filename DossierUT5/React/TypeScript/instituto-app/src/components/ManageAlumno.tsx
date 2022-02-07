import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Link, Route, BrowserRouter, Routes } from 'react-router-dom';
import { json } from 'stream/consumers';
import { Alumno } from '../interfaces/Alumno';

interface IState { alumno?: Alumno }
export default function ManageAlumno() {
    const [ stAlumno, setStAlumno ] = useState<IState>({});
    const { dni } = useParams();
    useEffect(() => {
        const getAlumno = async (dni :string |undefined) => {
            let rutaAlumnos = "http://localhost:8080/api/v1/alumnos/";
            let {data} = await axios.get(rutaAlumnos + dni);
            let alumno: Alumno = data;
            setStAlumno({ alumno });
        }
        getAlumno(dni);
    }, [dni]);
    return (
        <>
         <div><b>Nombre: </b> {JSON.parse(JSON.stringify(stAlumno.alumno?.nombre))}</div>
        </>
    );
}