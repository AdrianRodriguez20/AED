package es.iespuertodelacruz.juan.matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.iespuertodelacruz.juan.matriculas.entity.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Integer>{

	@Query("SELECT COUNT(m) FROM Matricula m JOIN m.asignaturas a WHERE a = :asignatura")
	Integer getCountAsignaturasInMatricula(@Param("asignatura") Asignatura asignatura);
}
