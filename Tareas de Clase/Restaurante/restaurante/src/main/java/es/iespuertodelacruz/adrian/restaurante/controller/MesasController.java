package es.iespuertodelacruz.adrian.restaurante.controller;

import es.iespuertodelacruz.adrian.restaurante.dto.MesaDTO;
import es.iespuertodelacruz.adrian.restaurante.entity.Mesa;
import es.iespuertodelacruz.adrian.restaurante.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/mesas")
public class MesasController {


    @Autowired
    MesaService mesaService;

    @GetMapping
    public ArrayList<MesaDTO> getAll(@RequestParam(required = false, name = "disponible") Boolean disponible,
                                     @RequestParam(required = false, name = "fecha") Long fecha,
                                     @RequestParam(required = false, name = "comensales") Integer comensales) {

        ArrayList<MesaDTO> mesas = new ArrayList<>();
        if (disponible == null) {
            mesaService.findAll().forEach(p -> {
                Mesa m = (Mesa) p;
                MesaDTO mDTO = new MesaDTO(m);
                mesas.add(mDTO);
            });
        } else if (disponible) {
            mesaService.findMesasDisponibles(fecha, new Date().getTime(), comensales).forEach(p -> {
                Mesa m = (Mesa) p;
                MesaDTO mDTO = new MesaDTO(m);
                mesas.add(mDTO);
            });
        }
        return mesas;
    }

}
