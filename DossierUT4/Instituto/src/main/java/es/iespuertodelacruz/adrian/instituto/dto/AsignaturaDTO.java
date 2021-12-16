package es.iespuertodelacruz.adrian.instituto.dto;

import java.util.ArrayList;
import java.util.List;

import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;
import es.iespuertodelacruz.adrian.instituto.entity.Matricula;

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
	
	public  List<AsignaturaDTO> toAsignaturaDTO(List<Asignatura> asignaturas) {
		List<AsignaturaDTO> asignaturasDTO = new ArrayList<>();
        for (Asignatura a : asignaturas) {
            asignaturasDTO.add(new AsignaturaDTO(a));
        }
        return asignaturasDTO;
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
