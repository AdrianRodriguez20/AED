package es.iespuertodelacruz.juan.matriculas.dto;

import java.util.List;

import es.iespuertodelacruz.juan.matriculas.entity.Asignatura;
import es.iespuertodelacruz.juan.matriculas.entity.Matricula;

public class AsignaturaPostDTO {
	private int idasignatura;
	private String curso;
	private String nombre;
	private List<Matricula> matriculas;
	
	
	public AsignaturaPostDTO() {
		
	}
	
	public AsignaturaPostDTO(Asignatura a) {
		this.idasignatura = a.getIdasignatura();
		this.curso = a.getCurso();
		this.nombre = a.getNombre();
	}
}
