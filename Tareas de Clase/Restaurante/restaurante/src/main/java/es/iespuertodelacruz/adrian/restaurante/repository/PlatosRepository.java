package es.iespuertodelacruz.adrian.restaurante.repository;
import es.iespuertodelacruz.adrian.restaurante.entity.Plato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatosRepository  extends JpaRepository<Plato, Integer> {
}
