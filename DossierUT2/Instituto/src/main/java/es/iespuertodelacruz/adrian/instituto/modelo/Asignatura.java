package es.iespuertodelacruz.adrian.instituto.modelo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Objects;

public class Asignatura {

	private int idAsignatura;
	private String nombre;
	private String curso;
	
	
	public Asignatura() {

	}


	public Asignatura(int idAsignatura, String nombre, String curso) {
		this.idAsignatura = idAsignatura;
		this.nombre = nombre;
		this.curso = curso;
	}
	
	


	public Asignatura(String nombre, String curso) {
		this.nombre = nombre;
		this.curso = curso;
	}


	public int getIdAsignatura() {
		return idAsignatura;
	}


	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	@Override
	public String toString() {
		
		ObjectMapper mapper = new ObjectMapper();
		String strAsignatura=null;
		try {
			strAsignatura = mapper
			.writerWithDefaultPrettyPrinter()
			.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return strAsignatura; 
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Asignatura that = (Asignatura) o;
		return Objects.equals(nombre, that.nombre) && Objects.equals(curso, that.curso);
	}


}
