import React from 'react'
import axios from 'axios';
import '../style/Form.css'
export default function CreateAlumno() {

	const agregarAlumnoApi = (event: React.FormEvent<HTMLFormElement>) => {
		event.preventDefault();
		let formulario: HTMLFormElement = event.currentTarget;

		let inputnombrealumno: HTMLInputElement = formulario.nombre;
		let inputapellidosalumno: HTMLInputElement = formulario.apellidos;
		let inputfechanacimientoalumno: HTMLInputElement = formulario.fechanacimiento;
		let inputdni: HTMLInputElement = formulario.dni;

		let nombrAlumno = inputnombrealumno.value;
		let apellidosAlumno = inputapellidosalumno.value;
		let fechanacimientoAlumno = new Date(inputfechanacimientoalumno.value).getTime();
		let dniAlumno = inputdni.value;

		let alumno = {
			nombre: nombrAlumno,
			apellidos: apellidosAlumno,
			fechanacimiento: fechanacimientoAlumno,
			dni: dniAlumno
		}

		let ruta = "http://localhost:8080/api/alumnos";
		
		const axiospost =async (rutaAlumnos:string) => {
			try{
				const {data} = await axios.post(rutaAlumnos, alumno);
				console.log(data);
				window.location.href ="/alumnos";
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
			<form className="contact100-form validate-form" onSubmit={agregarAlumnoApi }>
				<span className="contact100-form-title">
					Añadir Alumno
				</span>

				<div className="wrap-input100 validate-input" >
					<span className="label-input100">Nombre</span>
					<input className="input100" type="text" id="nombre" placeholder="Introduce tu nombre"/>
					<span className="focus-input100"></span>
				</div>

				<div className="wrap-input100 validate-input" >
					<span className="label-input100">Apellidos</span>
					<input className="input100" type="text" id="apellidos" placeholder="Introduce tus apellidos"/>
					<span className="focus-input100"></span>
				</div>

				<div className="wrap-input100 validate-input" >
					<span className="label-input100">DNI</span>
					<input className="input100" type="text" id="dni" placeholder="Introduce tu DNI"/>
					<span className="focus-input100"></span>
				</div>


				<div className="wrap-input100 validate-input" >
					<span className="label-input100">Fecha de Nacimiento</span>
					<input className="input100" type="text" id="fechanacimiento" placeholder="dd/mm/yyyy"/>
					<span className="focus-input100"></span>
				</div>
                

				<div className="container-contact100-form-btn">
					<div className="wrap-contact100-form-btn">
						<div className="contact100-form-bgbtn"></div>
						<button type='submit' className="contact100-form-btn">
							<span>Submit </span>
						</button>
					</div>
				</div>
			</form>
		</div>
	</div>


        </>
    )

    
}