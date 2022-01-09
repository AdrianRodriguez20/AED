package es.iespuertodelacruz.juan.matriculas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.iespuertodelacruz.juan.matriculas.entity.Alumno;
import es.iespuertodelacruz.juan.matriculas.entity.Matricula;

public interface AlumnoRepository extends JpaRepository<Alumno, String>{

	@Query("SELECT a FROM Alumno a WHERE a.nombre LIKE :nombre")
	Iterable<Alumno> findByNombre(@Param("nombre") String nombre);
}
