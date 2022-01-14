package es.iespuertodelacruz.juan.matriculas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.iespuertodelacruz.juan.matriculas.entity.Alumno;
import es.iespuertodelacruz.juan.matriculas.entity.Asignatura;
import es.iespuertodelacruz.juan.matriculas.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Integer>{
	
	@Query("SELECT m FROM Matricula m WHERE m.year = :year AND m.alumno = :alumno")
	Optional<Matricula> findByAnioAlumno(@Param("year") Integer year, @Param("alumno") Optional<Alumno> alumno);
	
	@Query("SELECT m FROM Matricula m WHERE m.year = :year")
	Iterable<Matricula> findByAnio(@Param("year") Integer year);
}
