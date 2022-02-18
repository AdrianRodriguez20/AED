package es.iespuertodelacruz.adrian.restaurante.repository;
import es.iespuertodelacruz.adrian.restaurante.entity.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MesasRepository  extends JpaRepository<Mesa, Integer> {


    @Query(value =
            "SELECT mesas.nummesa, mesas.ocupantesmax " +
                    "FROM mesas INNER JOIN servicios" +
                    " ON mesas.nummesa = servicios.fk_nummesa WHERE :fecha >= (UNIX_TIMESTAMP()*1000) " +
                    "AND ((:fecha + 7200000  < servicios.fechacomienzo " +
                    "OR :fecha >= servicios.fechafin) " +
                    "OR (servicios.pagada = true)) " +
                    "AND :comensales<= mesas.ocupantesmax",
            nativeQuery = true)
    Optional<Mesa> findByNumero(long fecha, int comensales);
    public List<Optional>findMesasDisponibles();


    /**
     *
     SELECT mesas.nummesa
     FROM mesas
     WHERE mesas.nummesa NOT IN (SELECT servicios.fk_nummesa FROM servicios);
     */

    /**
     * SELECT mesas.nummesa, mesas.ocupantesmax FROM mesas
     * INNER JOIN servicios ON mesas.nummesa = servicios.fk_nummesa
     * WHERE 1645313612000 >= (UNIX_TIMESTAMP()*1000)AND
     * ((1645313612000 + 7200000 < servicios.fechacomienzo OR 1645313612000 >= servicios.fechafin) OR
     * (servicios.pagada = true)) OR mesas.nummesa NOT IN (SELECT servicios.fk_nummesa FROM servicios) AND 1 <= mesas.ocupantesmax;
     */
}
