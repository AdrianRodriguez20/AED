import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Link, Route, BrowserRouter, Routes } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { Alumno } from '../interfaces/Alumno';
import '../style/Alumno.css';

interface IState { alumno?: Alumno }
export default function ManageAlumno() {
    let navigate = useNavigate();
    const [stAlumno, setStAlumno] = useState<IState>({});
    const { dni } = useParams();
    useEffect(() => {
        const getAlumno = async (dni: string | undefined) => {
            let rutaAlumnos = "http://localhost:8080/api/alumnos/";
            let { data } = await axios.get(rutaAlumnos + dni);
            let alumno: Alumno = data;
            setStAlumno({ alumno });
        }
        getAlumno(dni);
    }, [dni]);


    const borrarAlumnoApi = (event: React.FormEvent<HTMLFormElement>) => {
		event.preventDefault();

		let ruta = "http://localhost:8080/api/alumnos/" + dni;
        const axiospost = async (rutaAlumnos: string) => {
            try {
                const { data } = await axios.delete(rutaAlumnos)
                console.log(data);
                navigate('/alumnos');
            } catch (error) {
                console.log(error);
            }
        }
        axiospost(ruta);
	}
    return (
        <>
            <div className="page-content page-container" id="page-content">
                <div className="padding">
                    <div className="row container d-flex justify-content-center">
                        <div className="col-xl-12 col-md-12">
                            <div className="card user-card-full">
                                <div className="row m-l-0 m-r-0">
                                    <div className="col-md-4 bg-c-lite-green user-profile">
                                        <div className="card-block text-center text-white">
                                            <div className="m-b-25"> <img src="https://easystore.com.mx/wa/img/profile-img.png" className="img-radius" style={{width:"50%"}}/> </div>
                                            <h6 className="f-w-600">{JSON.stringify(stAlumno.alumno?.nombre)?.replaceAll('"', '')}</h6>

                                        </div>
                                    </div>
                                    <div className="col-md-8">
                                        <div className="card-block">
                                            <h6 className="m-b-20 p-b-5 b-b-default f-w-600">Información</h6>
                                            <div className="row">
                                                <div className="col-sm-6">
                                                    <p className="m-b-10 f-w-600">Nombre</p>
                                                    <h6 className="text-muted f-w-400">{JSON.stringify(stAlumno.alumno?.nombre)?.replaceAll('"', '')}</h6>
                                                </div>
                                                <div className="col-sm-6">
                                                    <p className="m-b-10 f-w-600">Apellidos</p>
                                                    <h6 className="text-muted f-w-400">{JSON.stringify(stAlumno.alumno?.apellidos)?.replaceAll('"', '')}</h6>
                                                </div>
                                                <div className="col-sm-6">
                                                    <p className="m-b-10 f-w-600">Documento de Identidad</p>
                                                    <h6 className="text-muted f-w-400">{JSON.stringify(stAlumno.alumno?.dni)?.replaceAll('"', '')}</h6>
                                                </div>
                                                <div className="col-sm-6">
                                                    <p className="m-b-10 f-w-600">Fecha de Nacimiento</p>
                                                    <h6 className="text-muted f-w-400">
                                                    {new Date(parseInt(JSON.stringify(stAlumno.alumno?.fechanacimiento))|| 0)?.toISOString().split('T')[0]}
                                                    </h6>
                                                </div>
                                            </div>
                                            <h6 className="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">Matriculas</h6>
                                            <div className="row">
                                                <div className="col-sm-12">
                                                    <p className="m-b-10 f-w-600">Años</p>
                                                    {
                                                        stAlumno.alumno?.matriculas?.map((matricula: any) => (
                                                     <Link to={`/alumnos/${JSON.stringify(stAlumno.alumno?.dni)?.replaceAll('"', '')}/matriculas/${JSON.stringify(matricula?.id)?.replaceAll('"', '')}`} > 
                                                       <h6 className="text-muted f-w-400 matriculas">{JSON.stringify(matricula?.year)}<i className="fas fa-eye" style={{fontSize:"90%", margin:"1%"}}></i> </h6>
                                                     </Link>
                                                        ))
                                                    }

                                                </div>

                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <Link to={`/alumnos/${JSON.stringify(stAlumno.alumno?.dni)?.replaceAll('"', '')}/matriculas`} > 
                <button className="botonF3">
                    <span><i className="fas fa-book-medical" style={{fontSize:"25px", width:"50px"}}></i></span>
                </button>
            </Link>
            <Link to={`/alumnos/${JSON.stringify(stAlumno.alumno?.dni)?.replaceAll('"', '')}/update`} > 
                <button className="botonF2">
                    <span><i className="fas fa-user-edit" style={{fontSize:"25px", width:"70px"}}></i></span>
                </button>
            </Link>
            <form onSubmit={borrarAlumnoApi}>
                <button type="submit"className="botonF1">
                    <span><i className="fas fa-trash" style={{fontSize:"25px", width:"50px"}}></i></span>
                </button>
            </form>
         
        </>
    );
}