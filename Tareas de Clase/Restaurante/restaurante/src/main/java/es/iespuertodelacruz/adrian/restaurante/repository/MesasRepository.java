package es.iespuertodelacruz.adrian.restaurante.repository;
import es.iespuertodelacruz.adrian.restaurante.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MesasRepository  extends JpaRepository<Mesa, Integer> {


    @Query(value =
            "SELECT mesas.nummesa, mesas.ocupantesmax FROM mesas "
                    + "LEFT JOIN servicios ON mesas.nummesa = servicios.fk_nummesa "
                    + "WHERE :fechaSolicitada >= :fechaAhora AND "
                    + "((:fechaSolicitada + 7200000 < servicios.fechacomienzo OR :fechaSolicitada >= servicios.fechafin) "
                    + "OR (servicios.pagada = true) OR mesas.nummesa NOT IN (SELECT servicios.fk_nummesa FROM servicios) "
                    + ") AND "
                    + ":comensales <= mesas.ocupantesmax",
                 
            nativeQuery = true)
    List<Mesa> findMesasDisponibles(long fechaSolicitada, long fechaAhora ,  int comensales);




}
