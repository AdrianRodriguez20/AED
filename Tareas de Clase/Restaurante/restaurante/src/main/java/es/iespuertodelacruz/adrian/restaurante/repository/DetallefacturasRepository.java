package es.iespuertodelacruz.adrian.restaurante.repository;

import java.util.List;

import es.iespuertodelacruz.adrian.restaurante.entity.Detallefactura;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DetallefacturasRepository  extends JpaRepository<Detallefactura, Integer> {

}
