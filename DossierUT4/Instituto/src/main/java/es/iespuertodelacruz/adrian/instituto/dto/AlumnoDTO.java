package es.iespuertodelacruz.adrian.instituto.dto;

import java.math.BigInteger;

/**
 * @author dama
 *
 */
public class AlumnoDTO {

	private String dni;
	private String apellidos;
	private BigInteger fechanacimiento;
	private String nombre;
	
	public AlumnoDTO() {
		
	}

	public AlumnoDTO(String dni, String apellidos, BigInteger fechanacimiento, String nombre) {
		this.dni = dni;
		this.apellidos = apellidos;
		this.fechanacimiento = fechanacimiento;
		this.nombre = nombre;
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
	
	
	
	
}
