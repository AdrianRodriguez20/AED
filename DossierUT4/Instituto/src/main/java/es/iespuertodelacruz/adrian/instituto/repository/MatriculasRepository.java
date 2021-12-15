package es.iespuertodelacruz.adrian.instituto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.iespuertodelacruz.adrian.instituto.entity.Matricula;

public interface MatriculasRepository  extends JpaRepository<Matricula,Integer> {

}
