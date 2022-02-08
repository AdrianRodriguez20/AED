import React from 'react'
import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Alumno } from '../interfaces/Alumno';
import { useNavigate } from 'react-router-dom';

interface IState { alumno?: Alumno }
export default function UpdateAlumno() {
	let navigate = useNavigate();
	const [stalumno, setStalumno] = useState<IState>({});
	const { dni } = useParams();
	useEffect(() => {
		const getAlumno = async (dni: string | undefined) => {
			let rutaAlumnos = "http://localhost:8080/api/alumnos/";
			let { data } = await axios.get(rutaAlumnos + dni);
			let alumno: Alumno = data;
			setStalumno({ alumno });
		}
		getAlumno(dni);
	}, []);
	const actualizarAlumnoApi = (event: React.FormEvent<HTMLFormElement>) => {
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
			"nombre": nombrAlumno,
			"apellidos": apellidosAlumno,
			"fechanacimiento": fechanacimientoAlumno,
			"dni": dniAlumno
		}


		let ruta = "http://localhost:8080/api/alumnos/" + dni;

		const axiospost = async (rutaAlumnos: string) => {
			try {
				const { data } = await axios.put(rutaAlumnos, alumno);
				console.log(data);

				navigate('/alumnos/' + dni);
			} catch (error) {
				console.log(error);
			
			}

		}

		axiospost(ruta);
	}





     return (
			<>
				<div className="container-contact100">
					<div className="wrap-contact100">
						<form className="contact100-form validate-form" onSubmit={actualizarAlumnoApi}>
							<span className="contact100-form-title">
								Editar Alumno
							</span>

							<div className="wrap-input100 validate-input" >
								<span className="label-input100">Nombre</span>
								<input className="input100" type="text" id="nombre" placeholder="Introduce tu nombre" 
							
								defaultValue={JSON.stringify(stalumno.alumno?.nombre)?.replaceAll('"', '')} />
								<span className="focus-input100"></span>
							</div>

							<div className="wrap-input100 validate-input" >
								<span className="label-input100">Apellidos</span>
								<input className="input100" type="text" id="apellidos" placeholder="Introduce tus apellidos" defaultValue={JSON.stringify(stalumno.alumno?.apellidos)?.replaceAll('"', '')} />
								<span className="focus-input100"></span>
							</div>

							<div className="wrap-input100 validate-input" >
								<span className="label-input100">DNI</span>
								<input className="input100" type="text" id="dni" placeholder="Introduce tu DNI" defaultValue={JSON.stringify(stalumno.alumno?.dni)?.replaceAll('"', '')} readOnly />
								<span className="focus-input100"></span>
							</div>


							<div className="wrap-input100 validate-input" >
								<span className="label-input100">Fecha de Nacimiento</span>
								
								<input className="input100" type="text" id="fechanacimiento" 
								defaultValue={new Date(parseInt(JSON.stringify(stalumno.alumno?.fechanacimiento)) || 0)?.toISOString().split('T')[0]}
					
								 />
								<span className="focus-input100"></span>
							</div>


							<div className="container-contact100-form-btn">
								<div className="wrap-contact100-form-btn">
									<div className="contact100-form-bgbtn"></div>
									<button type='submit' className="contact100-form-btn">
										<span>Actualizar </span>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>

			</>
		)
	}