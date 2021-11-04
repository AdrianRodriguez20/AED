package es.iespuertodelacruz.adrian.instituto.modelo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Matricula {

	int idmatricula;
	Alumno alumno;
	
	@JsonProperty("a�o")
	int year;
	ArrayList<Asignatura> asignaturas;
	
	
	public Matricula() {
	
	}


	public Matricula(int idmatricula, Alumno alumno, int year, ArrayList<Asignatura> asignaturas) {
		this.idmatricula = idmatricula;
		this.alumno = alumno;
		this.year = year;
		this.asignaturas = asignaturas;
	}


	public int getIdmatricula() {
		return idmatricula;
	}


	public void setIdmatricula(int idmatricula) {
		this.idmatricula = idmatricula;
	}


	public Alumno getAlumno() {
		return alumno;
	}


	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}


	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	
	
}