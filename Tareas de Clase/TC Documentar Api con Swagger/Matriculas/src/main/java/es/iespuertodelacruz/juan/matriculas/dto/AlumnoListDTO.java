package es.iespuertodelacruz.juan.matriculas.dto;

import java.text.SimpleDateFormat;
import es.iespuertodelacruz.juan.matriculas.entity.Alumno;
import io.swagger.annotations.ApiParam;

public class AlumnoListDTO {
	private String dni;
	private String nombre;
	private String apellidos;
	private Long fechaNacimiento;
	
	public AlumnoListDTO() {
		
	}
	
	public AlumnoListDTO(Alumno a) {
		this.dni = a.getDni();
		this.nombre = a.getNombre();
		this.apellidos = a.getApellidos();
		this.fechaNacimiento = a.getFechanacimiento();
	}

	// Getters y Setters
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellidos;
	}

	public void setApellido(String apellido) {
		this.apellidos = apellido;
	}

	public String getFechaNacimiento() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return (this.fechaNacimiento != null)?format.format(fechaNacimiento):"a";
	}

	public void setFechaNacimiento(Long fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
