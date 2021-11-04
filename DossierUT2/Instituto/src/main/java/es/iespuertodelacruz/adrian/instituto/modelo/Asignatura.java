package es.iespuertodelacruz.adrian.instituto.modelo;

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
	
	
	
}
