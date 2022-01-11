package es.iespuertodelacruz.adrian.instituto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AsignaturasRepository extends JpaRepository<Asignatura,Integer> {

    @Query("select a from Asignatura a where a.nombre = ?1 and a.curso =?2")
    Optional<Asignatura> findEquals(String nombre, String curso);
}
