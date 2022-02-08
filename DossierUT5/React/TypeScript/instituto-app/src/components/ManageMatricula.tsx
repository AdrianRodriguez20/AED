import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Link, Route, BrowserRouter, Routes } from 'react-router-dom';
import { Matricula } from '../interfaces/Matricula';
import { useNavigate } from 'react-router-dom';

interface IState { matricula?: Matricula }
export default function ManageMatricula() {
    let navigate = useNavigate();

    const [stMatricula, setStMatricula] = useState<IState>({});
    const { id } = useParams();
    const { dni } = useParams();
    useEffect(
        () => {
            const getMatricula = async (matriculaid: string | undefined) => {
                let rutaMatricula = "http://localhost:8080/api/alumnos/"+dni+"/matriculas/";
                let { data } = await axios.get(rutaMatricula + matriculaid);
                let matricula = data;
                setStMatricula({ matricula });
            }
            getMatricula(id);
        },
        [id]
    );
    const borrarMatriculaApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
    }

    return (
        <>
            <h1>MANAGE Matricula</h1>
            {JSON.stringify(stMatricula.matricula)}
            <Link to={`/alumnos/${dni}/matriculas/${id}/update`} > 
                <button className="botonF2">
                    <span><i className="fas fa-pencil-alt" style={{fontSize:"25px", width:"60px"}}></i></span>
                </button>
            </Link>
            <form onSubmit={borrarMatriculaApi}>
                <button type="submit"className="botonF1">
                    <span><i className="fas fa-trash" style={{fontSize:"25px", width:"50px"}}></i></span>
                </button>
            </form>
        </>
    )
}