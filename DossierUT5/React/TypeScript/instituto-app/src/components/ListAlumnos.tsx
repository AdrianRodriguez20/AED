import axios from 'axios';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom'
import { Alumno } from "../interfaces/Alumno";

interface IState { alumnos?: Array<Alumno>; }
export default function ListAlumnos() {
    const [alumnos, setAlumnos] = useState<IState>({});
    useEffect(
        () => {
            const getAlumno = async () => {
                let rutaDeAlumno = "http://localhost:8080/api/v1/alumnos";
                let { data } = await axios.get(rutaDeAlumno);
                let alumnos: Array<Alumno> = data;
                console.log("Alumno" + alumnos);
                setAlumnos({ alumnos });
            }
            getAlumno();
        },
        []
    )
    return (
        <>

            <div id="content">
                <h3 style={{ textAlign: 'center' }} >Alumnos</h3>
                <hr></hr>
                <div className='container-fluid'>
                    <div className='row'>
                        {
                            alumnos.alumnos?.map((alumno: Alumno) => {
                                return (

                                    <div className='col-md-3 mb-3 mt-3'>
                                        <article className="card bg--deep-purple depth--two">
                                            <div className="card__body">
                                                <header className="card__primary-title">
                                                    <h3>{JSON.parse(JSON.stringify(alumno.nombre))} {JSON.parse(JSON.stringify(alumno.apellidos))}</h3>
                                                </header>
                                                <div className="card__supporting-text">
                                                    <b>Fecha de Nacimiento: </b>  {new Date(parseInt(JSON.stringify(alumno.fechanacimiento))).toISOString().split('T')[0]}<br></br>
                                                    <b>Dni :</b>  {JSON.parse(JSON.stringify(alumno.dni))}<br></br>
                                                </div>
                                            </div>
                                            <footer className="card__actions">
                                                <Link className="btn" to={`/alumnos/${JSON.parse(JSON.stringify(alumno.dni))}`} > Ver mas </Link> &nbsp;
                                            </footer>
                                        </article>
                                    </div>

                                );
                            })

                        }
                    </div>

                </div>
                <Link to="/alumnos/create">
                <button className="botonF1">
                    <span>+</span>
                </button>
                </Link>
            </div >


        </>
    );

}