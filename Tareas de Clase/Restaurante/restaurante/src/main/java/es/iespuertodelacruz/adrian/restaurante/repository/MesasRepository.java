package es.iespuertodelacruz.adrian.restaurante.repository;
import es.iespuertodelacruz.adrian.restaurante.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesasRepository  extends JpaRepository<Mesa, Integer> {
}
