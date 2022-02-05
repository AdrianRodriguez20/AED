import axios from 'axios';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom'
import { Asignatura } from "../interfaces/Asignatura";
import '../style/ListAsignaturas.css'
interface IState { asignaturas?: Array<Asignatura>; }
export default function ListAsignaturas() {
    const [asignaturas, setAsignaturas] = useState<IState>({});
    useEffect(
        () => {
            const getAsignatura = async () => {
                let rutaDeAsignaturas = "http://localhost:8080/api/v1/asignaturas";
                let { data } = await axios.get(rutaDeAsignaturas);
                let asignaturas: Array<Asignatura> = data;
                console.log("Asignaturas" + asignaturas);
                setAsignaturas({ asignaturas });
            }
            getAsignatura();
        },
        []
    )

    return (
        <div className="container-fluid">
                   <h3 style={{textAlign:'center'}} >Asignaturas</h3>
            <div className="row">
                {                 
                    asignaturas.asignaturas?.map((asignatura: Asignatura) => {
                        return (
                            <div className='col-md-2 mb-3 mt-3'>
                            <article className="card bg--deep-purple depth--two">
                                <div className="card__body">
                                    <header className="card__primary-title">
                                        <h2>{JSON.parse(JSON.stringify(asignatura.nombre))}</h2>
                                    </header>
                                    <div className="card__supporting-text">
                                      {JSON.parse(JSON.stringify(asignatura.curso))}
                                    </div>
                                </div>
                                <footer className="card__actions">
                                    <a className="btn" href="#">Ver más</a>
                                </footer>
                            </article>
                            </div>
                        );
                        
                    })
          
        }
         </div>
        </div>
    )
}