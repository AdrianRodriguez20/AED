package es.iespuertodelacruz.adrian.instituto.dto;

import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;

public class AsignaturaDTO {

	private int idasignatura;
	private String curso;
	private String nombre;
	
	public AsignaturaDTO() {
		
	}

	public AsignaturaDTO(Asignatura a) {
		this.idasignatura = a.getIdasignatura();
		this.curso = a.getCurso();
		this.nombre = a.getNombre();
	}

	public int getIdasignatura() {
		return idasignatura;
	}

	public void setIdasignatura(int idasignatura) {
		this.idasignatura = idasignatura;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Asignatura toAsignatura() {
		return new Asignatura (idasignatura,curso,nombre);
	}
	
	
}
