package es.iespuertodelacruz.adrian.restaurante.repository;

import es.iespuertodelacruz.adrian.restaurante.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiciosRepository  extends JpaRepository<Servicio, Integer> {
}
