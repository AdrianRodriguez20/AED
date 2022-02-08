import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Link, Route, BrowserRouter, Routes } from 'react-router-dom';
import { Matricula } from '../interfaces/Matricula';
import { useNavigate } from 'react-router-dom';
import '../style/Matricula.css';

interface IState { matricula?: Matricula }
export default function ManageMatricula() {
    let navigate = useNavigate();

    const [stMatricula, setStMatricula] = useState<IState>({});
    const { id } = useParams();
    const { dni } = useParams();
    useEffect(
        () => {
            const getMatricula = async (matriculaid: string | undefined) => {
                let rutaMatricula = "http://localhost:8080/api/alumnos/" + dni + "/matriculas/";
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
        let ruta = "http://localhost:8080/api/matriculas/";

        const axiosdelete = async (rutaAsignaturas: string) => {
            try {
                const { data } = await axios.delete(rutaAsignaturas + id)
                console.log(data);
                navigate('/alumnos/' + dni);
            } catch (error) {
                console.log(error);
            }
        }
        axiosdelete(ruta);

    }

    return (
        <>
            <h2 className='titleH2'>Matrícula   {JSON.stringify(stMatricula.matricula?.year)?.replaceAll('"', '')}</h2>

            <div className="limiter">
                <div className="container-table100">
                    <div className="wrap-table100">
                        <div className="table100 ver1 m-b-110">
                            <div className="table100-head">
                                <table>
                                    <thead>
                                        <tr className="row100 head">
                                            <th className="cell100 column1">ID</th>
                                            <th className="cell100 column2">Nombre</th>
                                            <th className="cell100 column3">Curso</th>
                                        </tr>
                                    </thead>
                                </table>
                            </div>

                            <div className="table100-body js-pscroll">
                                <table>
                                    {
                                    stMatricula.matricula?.asignaturas?.map((asignatura: any) => (
                                           <tbody>
                                        <tr className="row100 body">
                                            <td className="cell100 column1">{asignatura.idasignatura}</td>
                                            <td className="cell100 column2">{asignatura.nombre}</td>
                                            <td className="cell100 column3">{asignatura.curso}</td>
                                        </tr>
                                        </tbody>
                                    ))
                                    }
                                  
                                </table>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            
            <Link to={`/alumnos/${dni}/matriculas/${id}/update`} >
                <button className="botonF2">
                    <span><i className="fas fa-pencil-alt" style={{ fontSize: "25px", width: "60px" }}></i></span>
                </button>
            </Link>
            <form onSubmit={borrarMatriculaApi}>
                <button type="submit" className="botonF1">
                    <span><i className="fas fa-trash" style={{ fontSize: "25px", width: "50px" }}></i></span>
                </button>
            </form>
        </>
    )
}