package es.iespuertodelacruz.adrian.instituto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import es.iespuertodelacruz.adrian.instituto.entity.Alumno;

public interface AlumnosRepository extends JpaRepository<Alumno, String> {

	@Query("select a from Alumno a where a.nombre like ?1")
	List<Alumno>findByName(String nombre);
}
