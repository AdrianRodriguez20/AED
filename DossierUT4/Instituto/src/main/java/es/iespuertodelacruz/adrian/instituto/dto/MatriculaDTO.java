package es.iespuertodelacruz.adrian.instituto.dto;

import java.util.ArrayList;
import java.util.List;

import es.iespuertodelacruz.adrian.instituto.entity.Alumno;
import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;
import es.iespuertodelacruz.adrian.instituto.entity.Matricula;

public class MatriculaDTO {
	
	private int year;
	private List<AsignaturaDTO> asignaturas;
	AsignaturaDTO asignaturaDTO = new AsignaturaDTO();
	private Alumno alumno ;

	public MatriculaDTO() {

	}

	public MatriculaDTO(Matricula m) {
		this.year = m.getYear();
		this.asignaturas = asignaturaDTO.toAsignaturaDTO(m.getAsignaturas());
		this.alumno=m.getAlumno();
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
	public List<AsignaturaDTO> getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(List<AsignaturaDTO> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	public List<Asignatura> toAsignaturas(){
		List<Asignatura>asignaturasModel = new ArrayList<Asignatura>();
		for(AsignaturaDTO a : asignaturas) {
			asignaturasModel.add(new Asignatura (a.getIdasignatura(),a.getCurso(),a.getNombre()));
		}
		return asignaturasModel ;
	}

	public Matricula toMatricula() {
		return new Matricula (year,alumno,toAsignaturas());
	}
	
	
}
