package es.iespuertodelacruz.adrian.instituto.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;


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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idmatricula;

	private int year;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="dni")
	private Alumno alumno;

	//bi-directional many-to-many association to Asignatura
	//
	@ManyToMany
	@JoinTable( name="asignatura_matricula",
	joinColumns = @JoinColumn(name="idmatricula"),
	inverseJoinColumns = @JoinColumn(name="idasignatura")
	)
	private List<Asignatura> asignaturas;

	public Matricula() {
	}
	
	

	public Matricula(int year, Alumno alumno, List<Asignatura> asignaturas) {
		this.year = year;
		this.alumno = alumno;
		this.asignaturas = asignaturas;
	}

	public Matricula( Alumno alumno, int idmatricula, List<Asignatura> asignaturas) {
		this.idmatricula = idmatricula;
		this.alumno = alumno;
		this.asignaturas = asignaturas;
	}


	public Matricula(int year, List<Asignatura> asignaturas) {
		this.year = year;
		this.asignaturas = asignaturas;
	}

	public Matricula (int year , int idmatricula){
		this.year = year;
        this.idmatricula = idmatricula;
	}

	public Matricula(Alumno alumno, List<Asignatura> asignaturas) {
		this.alumno = alumno;
		this.asignaturas = asignaturas;
	}

	public int getIdmatricula() {
		return this.idmatricula;
	}

	public void setIdmatricula(int idmatricula) {
		this.idmatricula = idmatricula;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Asignatura> getAsignaturas() {
		return this.asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

}