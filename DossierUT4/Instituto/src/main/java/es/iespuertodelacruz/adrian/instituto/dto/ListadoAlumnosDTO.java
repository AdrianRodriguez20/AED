package es.iespuertodelacruz.adrian.instituto.dto;

import java.math.BigInteger;
import java.util.List;

import es.iespuertodelacruz.adrian.instituto.entity.Alumno;

public class ListadoAlumnosDTO {
	private String dni;
	private String apellidos;
	private BigInteger fechanacimiento;
	private String nombre;
	
	public ListadoAlumnosDTO() {
		
	}

	public ListadoAlumnosDTO (Alumno a) {
		this.dni = a.getDni();
		this.apellidos = a.getApellidos();
		this.fechanacimiento = a.getFechanacimiento();
		this.nombre = a.getNombre();
			
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public BigInteger getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(BigInteger fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Alumno toAlumno() {
		return new Alumno(dni,apellidos,fechanacimiento,nombre);
		
	}
	

	
	
	
	
}