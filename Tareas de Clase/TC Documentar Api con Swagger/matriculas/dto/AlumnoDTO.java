package es.iespuertodelacruz.juan.matriculas.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import es.iespuertodelacruz.juan.matriculas.entity.Alumno;
import es.iespuertodelacruz.juan.matriculas.entity.Matricula;
import io.swagger.annotations.ApiParam;

public class AlumnoDTO {
	private String dni;
	private String nombre;
	private String apellidos;
	private Long fechaNacimiento;
	private List<MatriculaDTO> matriculas;
	
	public AlumnoDTO() {
		
	}
	
	public AlumnoDTO(Alumno a) {
		this.dni = a.getDni();
		this.nombre = a.getNombre();
		this.apellidos = a.getApellidos();
		this.fechaNacimiento = a.getFechanacimiento();
		
		ArrayList<MatriculaDTO> matriculas = new ArrayList<>();
		a.getMatriculas().forEach( m -> matriculas.add(new MatriculaDTO(m)));
		this.matriculas = matriculas;
	}

	// Getters y Setters
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellido() {
		return apellidos;
	}

	public void setApellido(String apellido) {
		this.apellidos = apellido;
	}

	public String getFechaNacimiento() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		return format.format(fechaNacimiento);
	}

	public void setFechaNacimiento(Long fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<MatriculaDTO> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<MatriculaDTO> matriculas) {
		this.matriculas = matriculas;
	} 
	
	
}
