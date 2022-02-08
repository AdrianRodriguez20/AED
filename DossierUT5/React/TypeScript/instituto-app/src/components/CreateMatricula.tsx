import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import { Asignatura } from '../interfaces/Asignatura';
import { useParams } from 'react-router-dom';

interface IState { asignaturas?: Array<Asignatura> }
export default function CreateMatricula() {



    const { dni } = useParams();
    const [stasignatura, setSasignaturas] = useState<IState>({});

    useEffect(
        () => {
            const getAsignaturas = async () => {
                let rutaDeAsignaturas = "http://localhost:8080/api/asignaturas";
                let { data } = await axios.get(rutaDeAsignaturas);
                let asignaturas: Array<Asignatura> = data;
                setSasignaturas({ asignaturas });
            }
            getAsignaturas();

        },
        []
    );

    const [asignaturasSelect, setAsigOption] = useState<String[]>();
    const onChangeHandler = (event: React.ChangeEvent<HTMLSelectElement>) => {
        const selectedOptions = event.currentTarget.selectedOptions;

        const newAsig = [];
        for (let i = 0; i < selectedOptions.length; i++) {
            newAsig.push(selectedOptions[i].text);
        }

        setAsigOption(newAsig);
    };

    const agregarMatriculaApi = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        let formulario = event.currentTarget;

        let inputaniomatricula: HTMLInputElement = formulario.anio;
        let inputasignaturas: HTMLSelectElement = formulario.asignaturas;

        let anio: number = parseInt(inputaniomatricula.value);
        let asignaturas: Array<Asignatura> = []; ;
        for (let i = 0; i < inputasignaturas.selectedOptions.length; i++) {
            let asignatura :Asignatura = {
                "idasignatura" : parseInt(inputasignaturas.selectedOptions[i].value),
            }
            asignaturas.push(asignatura);
        }
      
        let newmatricula = {
            "year" : anio,
            "asignaturas" : asignaturas
        }

        let ruta = "http://localhost:8080/api/alumnos/"+dni +"/matriculas";
        const axiospost =async (rutaAlumnos:string) => {
            try{
                const {data} = await axios.post(rutaAlumnos, newmatricula);
                console.log(data);
                window.location.href ="/alumnos/"+dni;
            }catch(error){
                console.log(error);
            }
            
        }

        axiospost(ruta);

    }


    return (
        <>
            <div className="container-contact100">
                <div className="wrap-contact100">
                    <form className="contact100-form validate-form" onSubmit={agregarMatriculaApi} >
                        <span className="contact100-form-title">
                            Crear Matricula
                        </span>

                        <div className="wrap-input100 validate-input" >
                            <span className="label-input100">Año</span>
                            <input className="input100" type="text" id="anio" placeholder="Introduce el año" />
                            <span className="focus-input100"></span>
                        </div>



                        <span className="label-input100">Asignaturas</span><br></br>
                        <select className="select mt-3" multiple={true} onChange={onChangeHandler} id="asignaturas">
                            {
                                stasignatura.asignaturas?.map((asignatura: Asignatura) => {
                                    return (
                                        <option value={asignatura.idasignatura}>{asignatura.nombre} → {asignatura.curso}</option>
                                    );
                                })
                            }
                        </select>

                        <div>
                            {asignaturasSelect?.map((asig) => <span className="color">{asig}</span>)}
                        </div>

                        <div className="container-contact100-form-btn mt-5">
                            <div className="wrap-contact100-form-btn">
                                <div className="contact100-form-bgbtn"></div>
                                <button type='submit' className="contact100-form-btn">
                                    <span className='btn-accion'>Agregar </span>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </>
    )
}