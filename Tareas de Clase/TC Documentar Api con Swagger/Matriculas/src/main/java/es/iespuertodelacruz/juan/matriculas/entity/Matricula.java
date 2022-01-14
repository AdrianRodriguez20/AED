package es.iespuertodelacruz.juan.matriculas.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the matriculas database table.
 * 
 */
@Entity
@Table(name="matriculas")
@NamedQuery(name="Matricula.findAll", query="SELECT m FROM Matricula m")
public class Matricula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idmatricula;

	private Integer year;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="dni")
	private Alumno alumno;
	
	/*@ManyToMany(mappedBy="matriculas")*/
	@ManyToMany
	@JoinTable( name="asignatura_matricula",
	joinColumns = @JoinColumn(name="idmatricula"),
	inverseJoinColumns = @JoinColumn(name="idasignatura")
	)
	private List<Asignatura> asignaturas;

	// Constructor
	
	public Matricula() {
	}
	
	// Getters y Setters

	public Integer getIdmatricula() {
		return this.idmatricula;
	}

	public void setIdmatricula(Integer idmatricula) {
		this.idmatricula = idmatricula;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	

}