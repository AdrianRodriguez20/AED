import axios from 'axios';
import { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { Asignatura } from "../interfaces/Asignatura";
import '../style/ListAsignaturas.css'

interface IState { asignaturas?: Array<Asignatura>; }
export default function ListAsignaturas() {
    let navigate = useNavigate();
    const [asignaturas, setAsignaturas] = useState<IState>({});
    useEffect(
        () => {
            const getAsignatura = async () => {
                let rutaDeAsignaturas = "http://localhost:8080/api/asignaturas";
                let { data } = await axios.get(rutaDeAsignaturas);
                let asignaturas: Array<Asignatura> = data;
                console.log("Asignaturas" + asignaturas);
                setAsignaturas({ asignaturas });
            }
            getAsignatura();
        },
        []
    )
    const borrarAsignaturaApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        let formulario: HTMLFormElement   = event.currentTarget;
        let inputId: HTMLInputElement  = formulario.idasignatura;
        let id = inputId.value;

        let ruta = "http://localhost:8080/api/asignaturas/";
        const axiosdelete = async (rutaAsignaturas: string) => {
            try {
                const { data } = await axios.delete(rutaAsignaturas +id)
                console.log(data);
                setAsignaturas({ asignaturas: asignaturas?.asignaturas?.filter(asignatura => asignatura.idasignatura !== Number(id)) });
            }catch (error) {
                console.log(error);
            }
        } 
         axiosdelete(ruta);
            
    }

    return (
        <div className="container-fluid">
            <h3 style={{ textAlign: 'center' }} >Asignaturas</h3>
            <hr></hr>
            <div className="row">
                {
                    asignaturas.asignaturas?.map((asignatura: Asignatura) => {
                        return (
                            <div className='col-md-2  col-12 col-sm-6 col-xl-3  mb-3 mt-3'>
                                <article className="card bg--deep-purple depth--two">
                                <div className="row">
                                    <div className='col-10'>
                                        <div className="card__body">
                                            <header className="card__primary-title">
                                                <h2>{JSON.parse(JSON.stringify(asignatura.nombre))}</h2>
                                            </header>
                                            <div className="card__supporting-text">
                                                {JSON.parse(JSON.stringify(asignatura.curso))}
                                            </div>

                                        </div>
                                    </div>
                                    <div className='col-2'>
                                        <footer className="card__actions mt-2">
                                            <form onSubmit={borrarAsignaturaApi}>
                                                <button type="submit" className='btn' >
                                                    <input type="hidden" id="idasignatura" value={asignatura.idasignatura} />
                                                    <span><i className="fas fa-trash" style={{ fontSize: "20px", width: "30px",color:'white' }}></i></span>
                                                </button>
                                            </form>
                                            <Link to={`/asignaturas/${JSON.parse(JSON.stringify(asignatura.idasignatura))}/update`} >
                                                <button className='btn'  >
                                                    <span><i className="fas fa-pencil-alt" style={{ fontSize: "20px", width: "30px", color:'white' }}></i></span>
                                                </button>
                                            </Link>
                                        </footer>
                                    </div>
                                    
                                    </div>
                                </article>
                            </div>
                        );

                    })

                }
            </div>
            <Link to="/asignaturas/create">
                <button className="botonF1">
                    <span>+</span>
                </button>
            </Link>
        </div>
    )
}