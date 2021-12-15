package es.iespuertodelacruz.adrian.instituto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespuertodelacruz.adrian.instituto.entity.Alumno;

public interface AlumnosRepository extends JpaRepository<Alumno, String> {

}
