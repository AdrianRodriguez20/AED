import React from 'react'
import axios from 'axios';
import { Link, Route, BrowserRouter, Routes } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

export default  function CreateAsignatura(){
	let navigate = useNavigate();
    const agregarAsignaturaApi = (event: React.FormEvent<HTMLFormElement>) => {

		event.preventDefault();
		let formulario: HTMLFormElement = event.currentTarget;

		let inputnombrasignatura: HTMLInputElement = formulario.nombre;
		let inputcursoasignatura: HTMLInputElement = formulario.curso;


		let nombre = inputnombrasignatura.value;
		let curso = inputcursoasignatura.value;


		let asignatura = {
			"nombre": nombre,
			"curso": curso,

		}

		let ruta = "http://localhost:8080/api/asignaturas";
		
		const axiospost =async (rutaAsignaturas:string) => {
			try{
				const {data} = await axios.post(rutaAsignaturas, asignatura);
				console.log(data);
				navigate("/asignaturas");
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
			<form className="contact100-form validate-form" onSubmit={agregarAsignaturaApi}>
				<span className="contact100-form-title">
					Crear Asignatura
				</span>

				<div className="wrap-input100 validate-input" >
					<span className="label-input100">Nombre</span>
					<input className="input100" type="text" id="nombre" placeholder="Introduce el nombre"/>
					<span className="focus-input100"></span>
				</div>

				<div className="wrap-input100 validate-input" >
					<span className="label-input100">Curso</span>
					<input className="input100" type="text" id="curso" placeholder="Introduce el curso"/>
					<span className="focus-input100"></span>
				</div>


				<div className="container-contact100-form-btn">
					<div className="wrap-contact100-form-btn">
						<div className="contact100-form-bgbtn"></div>
						<button type='submit' className="contact100-form-btn">
							<span>Agregar </span>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>


        </>
    )
}