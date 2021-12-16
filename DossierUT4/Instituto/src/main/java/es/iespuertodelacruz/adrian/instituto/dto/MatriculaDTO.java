package es.iespuertodelacruz.adrian.instituto.dto;

import java.util.ArrayList;
import java.util.List;

import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;
import es.iespuertodelacruz.adrian.instituto.entity.Matricula;

public class MatriculaDTO {
	
	private int year;
	private List<Asignatura> asignaturas;
	
	
	public MatriculaDTO() {

	}

	public MatriculaDTO(Matricula m) {
		this.year = m.getYear();
		this.asignaturas = m.getAsignaturas();
	}

	public static List<MatriculaDTO> toMatriculaDTO(List<Matricula> matriculas) {
		List<MatriculaDTO> matriculasDTO = new ArrayList<>();
        for (Matricula m : matriculas) {
            matriculasDTO.add(new MatriculaDTO(m));
        }
        return matriculasDTO;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	public Matricula toMatricula() {
		return new Matricula (year,asignaturas);
	}
	
	
}
