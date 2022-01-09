package es.iespuertodelacruz.juan.matriculas.dto;

import java.util.ArrayList;
import java.util.List;

import es.iespuertodelacruz.juan.matriculas.entity.Alumno;
import es.iespuertodelacruz.juan.matriculas.entity.Asignatura;
import es.iespuertodelacruz.juan.matriculas.entity.Matricula;

public class MatriculaDTO {
	private int idmatricula;
	private int year;
	private List<AsignaturaDTO> asignaturas;
	
	public MatriculaDTO() {
		
	}
	
	public MatriculaDTO(Matricula m) {
		this.idmatricula = m.getIdmatricula();
		this.year = m.getYear();
		
		ArrayList<AsignaturaDTO> asignaturas = new ArrayList<>();
		m.getAsignaturas().forEach( a -> asignaturas.add(new AsignaturaDTO(a)));
		this.asignaturas = asignaturas;
	}

	public int getIdmatricula() {
		return idmatricula;
	}

	public void setIdmatricula(int idmatricula) {
		this.idmatricula = idmatricula;
	}

	public List<AsignaturaDTO> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<AsignaturaDTO> asignaturas) {
		this.asignaturas = asignaturas;
	}
}
