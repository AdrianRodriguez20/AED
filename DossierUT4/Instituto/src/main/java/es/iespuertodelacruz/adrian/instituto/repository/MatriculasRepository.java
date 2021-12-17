package es.iespuertodelacruz.adrian.instituto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespuertodelacruz.adrian.instituto.entity.Matricula;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedNativeQuery;
import java.util.Optional;

public interface MatriculasRepository  extends JpaRepository<Matricula,Integer> {

    @Query("select m from Matricula m where m.alumno.dni =?1 and m.year = ?2")
    Optional<Matricula> findByEquals(String dni, int year);


}
