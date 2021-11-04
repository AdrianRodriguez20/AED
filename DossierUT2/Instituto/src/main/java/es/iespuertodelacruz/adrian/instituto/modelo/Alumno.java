package es.iespuertodelacruz.adrian.instituto.modelo;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Alumno {

	String dni;
	String nombre;
	String apellidos;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	Date fechanacimiento;
	@JsonIgnore
	ArrayList<Matricula> matriculas;
	
	
	public Alumno() {
	
	}


	public Alumno(String dni, String nombre, String apellidos, Date fechanacimiento, ArrayList<Matricula> matriculas) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechanacimiento = fechanacimiento;
		this.matriculas = matriculas;
	}



	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public long getFechanacimiento() {
		return fechanacimiento.getTime();
	}



	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}



	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}



	public void setMatriculas(ArrayList<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	
	
	
}
