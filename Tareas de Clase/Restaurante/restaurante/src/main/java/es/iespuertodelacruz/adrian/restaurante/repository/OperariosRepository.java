package es.iespuertodelacruz.adrian.restaurante.repository;
import es.iespuertodelacruz.adrian.restaurante.entity.Operario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OperariosRepository  extends JpaRepository<Operario, Integer> {

    @Query("select o from Operario o where o.nombre = ?1")
    Operario findByNombre(String nombre);
}
