package es.iespuertodelacruz.adrian.restaurante.repository;
import es.iespuertodelacruz.adrian.restaurante.entity.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlatosRepository  extends JpaRepository<Plato, Integer> {


    @Query("UPDATE Plato p SET p.disponible = ?1 WHERE p.idplato = ?2")
    void updateDisponible(boolean disponible, int id);
}
