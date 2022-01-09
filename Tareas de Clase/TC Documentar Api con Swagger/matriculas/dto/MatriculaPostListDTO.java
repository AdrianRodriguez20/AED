package es.iespuertodelacruz.juan.matriculas.dto;

import java.util.ArrayList;
import java.util.List;

import es.iespuertodelacruz.juan.matriculas.entity.Alumno;
import es.iespuertodelacruz.juan.matriculas.entity.Asignatura;
import es.iespuertodelacruz.juan.matriculas.entity.Matricula;

public class MatriculaPostListDTO {
	private int idmatricula;
	private int year;
	private AlumnoListDTO alumno;
	private List<AsignaturaDTO> asignaturas;
	
	public MatriculaPostListDTO() {
		
	}
	
	public MatriculaPostListDTO(Matricula m) {
		this.idmatricula = m.getIdmatricula();
		this.alumno = new AlumnoListDTO(m.getAlumno());
		this.year = m.getYear();
		ArrayList<AsignaturaDTO> asignaturas = new ArrayList<>();
		m.getAsignaturas().forEach( a -> asignaturas.add(new AsignaturaDTO(a)));
		this.asignaturas = asignaturas;
	}

	// Getters y Setters
	
	public int getIdmatricula() {
		return idmatricula;
	}

	public void setIdmatricula(int idmatricula) {
		this.idmatricula = idmatricula;
	}

	public AlumnoListDTO getAlumno() {
		return alumno;
	}

	public void setAlumno(AlumnoListDTO alumno) {
		this.alumno = alumno;
	}

	public List<AsignaturaDTO> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<AsignaturaDTO> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	
}
