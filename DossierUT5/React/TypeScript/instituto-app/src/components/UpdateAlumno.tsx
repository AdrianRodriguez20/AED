import React from 'react'
import axios from 'axios';
import { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { Alumno } from '../interfaces/Alumno';
import { useNavigate } from 'react-router-dom';


export default function UpdateAlumno() {
	let navigate = useNavigate();
	const [stalumno, setStalumno] = useState<Alumno>({} as Alumno);
	const { dni } = useParams();

	useEffect(() => {
		const getAlumno = async (dni: string | undefined) => {
			let rutaAlumnos = "http://localhost:8080/api/alumnos/";
			let { data } = await axios.get(rutaAlumnos + dni);
			let alumno: Alumno = data;

			setStalumno({
				"dni": alumno.dni,
				"nombre": alumno.nombre,
				"apellidos": alumno.apellidos,
				"fechanacimiento": alumno.fechanacimiento
			});

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

	const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
		event.preventDefault();
		const name = event.target.id;
		const value = event.target.value;

		setStalumno({
			...stalumno,
			[name]: value
		});
		
	}
	const updateDate = (event: React.ChangeEvent<HTMLInputElement>) => {
		event.preventDefault();

		let fecha = new Date(event.target.value);
		let fechaFormateada = fecha.getTime();
		setStalumno({
			...stalumno,
			fechanacimiento: fechaFormateada
		});

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
							<input
								className="input100"
								type="text"
								id="nombre"
								placeholder="Introduce tu nombre"
								value={stalumno.nombre}
								onChange={handleChange}

							/>
							<span className="focus-input100"></span>
						</div>

						<div className="wrap-input100 validate-input" >
							<span className="label-input100">Apellidos</span>
							<input
								className="input100"
								type="text"
								id="apellidos"
								value={stalumno.apellidos}
								onChange={handleChange}
							/>
							<span className="focus-input100"></span>
						</div>

						<div className="wrap-input100 validate-input" >
							<span className="label-input100">DNI</span>
							<input
								className="input100"
								type="text"
								id="dni"
								placeholder="Introduce tu DNI"
								value={stalumno.dni}
								onChange={handleChange}
								readOnly />
							<span className="focus-input100"></span>
						</div>


						<div className="wrap-input100 validate-input" >
							<span className="label-input100">Fecha de Nacimiento</span>

							<input 
							className="input100"
							id="fechanacimiento"
							placeholder="yyyy-mm-dd"
							type="date"
							value=	{new Date(parseInt(JSON.stringify(stalumno.fechanacimiento)) || 0)?.toISOString().split('T')[0]}
							onChange={updateDate}
							
							
							/>
	
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