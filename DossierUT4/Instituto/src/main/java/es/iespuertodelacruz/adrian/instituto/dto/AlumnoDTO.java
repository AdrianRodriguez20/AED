package es.iespuertodelacruz.adrian.instituto.dto;

import java.math.BigInteger;
import java.util.List;

import es.iespuertodelacruz.adrian.instituto.entity.Alumno;
import es.iespuertodelacruz.adrian.instituto.entity.Matricula;

/**
 * @author dama
 *
 */
public class AlumnoDTO {

	private String dni;
	private String apellidos;
	private BigInteger fechanacimiento;
	private String nombre;
	private List<ListadoMatriculasAlumnoDTO> matriculas;
	private ListadoMatriculasAlumnoDTO listadoMatriculasAlumnoDTO = new ListadoMatriculasAlumnoDTO();
	public AlumnoDTO() {
		
	}

	public AlumnoDTO(Alumno a) {
		this.dni = a.getDni();
		this.apellidos = a.getApellidos();
		this.fechanacimiento = a.getFechanacimiento();
		this.nombre = a.getNombre();
		this.matriculas = listadoMatriculasAlumnoDTO.toListadoMatriculasAlumnoDTO(a.getMatriculas());
			
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public BigInteger getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(BigInteger fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ListadoMatriculasAlumnoDTO> getMatriculas() {
		return matriculas;
	}

	public Alumno toAlumno() {
		return new Alumno(dni,apellidos,fechanacimiento,nombre);
		
	}
	

	
	
	
	
}
