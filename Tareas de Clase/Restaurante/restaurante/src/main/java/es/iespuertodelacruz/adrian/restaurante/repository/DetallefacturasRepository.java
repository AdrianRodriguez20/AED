package es.iespuertodelacruz.adrian.restaurante.repository;

import java.util.List;

import es.iespuertodelacruz.adrian.restaurante.entity.Detallefactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface DetallefacturasRepository  extends JpaRepository<Detallefactura, Integer> {


    @Query("SELECT d FROM Detallefactura d WHERE d.plato.idplato = ?1 and d.servicio.idservicio =?2")
    public Detallefactura findByPlato(int idplato , int idservicio);

}
