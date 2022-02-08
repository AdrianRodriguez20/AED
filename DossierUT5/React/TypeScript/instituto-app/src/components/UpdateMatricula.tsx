import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { Matricula } from '../interfaces/Matricula';
import { Asignatura } from '../interfaces/Asignatura';

interface IState { matricula?: Matricula, asignaturas?: Array<Asignatura> }
export default function UpdateMatricula() {
    const [stMatricula, setStMatricula] = useState<IState>({});
    const [stasignatura, setSasignaturas] = useState<IState>({});
    const { dni } = useParams();
    const { id } = useParams();
    useEffect(
        () => {
            const getMatricula = async (matriculaid: string | undefined) => {
                let rutaMatricula = "http://localhost:8080/api/alumnos/" + dni + "/matriculas/";
                let { data } = await axios.get(rutaMatricula + matriculaid);
                let matricula = data;
                setStMatricula({ matricula });
            }
            getMatricula(id);

            const getAsignaturas = async () => {
                let rutaDeAsignaturas = "http://localhost:8080/api/asignaturas";
                let { data } = await axios.get(rutaDeAsignaturas);
                let asignaturas: Array<Asignatura> = data;
                setSasignaturas({ asignaturas });
            }
            getAsignaturas();
        },
        [id]
    );
    const [asignaturasSelect, setAsigOption] = useState<String[]>();
    const onChangeHandler = (event: React.ChangeEvent<HTMLSelectElement>) => {
        const selectedOptions = event.currentTarget.selectedOptions;

        const newAsig = []
        for (let i = 0; i < selectedOptions.length; i++) {
            newAsig.push(selectedOptions[i].text);
        }

        setAsigOption(newAsig);
    };



const actualizarMatriculaApi = (event: React.FormEvent<HTMLFormElement>) => {
    let formulario = event.currentTarget;

    let inputaniomatricula: HTMLInputElement = formulario.anio;
    let inputasignaturas: HTMLSelectElement = formulario.asignaturas;

    let anio: number = parseInt(inputaniomatricula.value);
    let asignaturas: Array<Asignatura> = [];;

    for (let i = 0; i < inputasignaturas.selectedOptions.length; i++) {
        let asignatura: Asignatura = {
            "idasignatura": parseInt(inputasignaturas.selectedOptions[i].value),
        }
        asignaturas.push(asignatura);
    }

    let ruta = "http://localhost:8080/api/alumnos/" + dni + "/matriculas/" + id;

    const updateMatricula = {
        "year": anio,
        "asignaturas": asignaturas
    }

    const axiosput = async (rutadeMatricula: string) => {
        try {
            const { data } = await axios.put(rutadeMatricula, updateMatricula);
            console.log(data);
            window.location.href = "/alumnos/" + dni;
        } catch (error) {
            console.log(error);
        }
    }

    axiosput(ruta);
}



return (
    <>
        <div className="container-contact100">
            <div className="wrap-contact100">
                <form className="contact100-form validate-form" onSubmit={actualizarMatriculaApi} >
                    <span className="contact100-form-title">
                        Actualizar Matricula
                    </span>

                    <div className="wrap-input100 validate-input" >
                        <span className="label-input100">Año</span>
                        <input className="input100" type="text" id="anio" defaultValue={JSON.stringify(stMatricula.matricula?.year)?.replaceAll('"', '')} />
                        <span className="focus-input100"></span>
                    </div>



                    <span className="label-input100">Asignaturas</span><br></br>
                    <select className="select mt-3" multiple={true} id="asignaturas" onChange={onChangeHandler}>
                        {
                            stasignatura.asignaturas?.map((asignatura: Asignatura) => {

                                if (stMatricula.matricula?.asignaturas?.find((asignaturaMatricula: Asignatura) => asignaturaMatricula.idasignatura === asignatura.idasignatura)) {

                                    return (

                                        <option className='options' value={asignatura.idasignatura} selected>{asignatura.nombre}</option>
                                    );
                                } else {
                                    return (

                                        <option value={asignatura.idasignatura} >{asignatura.nombre}</option>
                                    );
                                }

                            })
                        })

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