package es.iespuertodelacruz.adrian.restaurante.controller;


import es.iespuertodelacruz.adrian.restaurante.dto.servicios.ListadoServiciosDTO;

import es.iespuertodelacruz.adrian.restaurante.dto.servicios.ServicioDetallesDTO;
import es.iespuertodelacruz.adrian.restaurante.entity.Servicio;
import es.iespuertodelacruz.adrian.restaurante.service.ServicioService;
import es.iespuertodelacruz.adrian.restaurante.utils.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/servicios")
public class ServiciosREST {

    @Autowired
    ServicioService servicioService;

    @GetMapping
    public ArrayList<ListadoServiciosDTO> getAll() {
        ArrayList<ListadoServiciosDTO> listadoServiciosDTOS = new ArrayList<ListadoServiciosDTO>();
        servicioService.findAll().forEach(p -> {
            Servicio s= (Servicio) p;
            ListadoServiciosDTO sDTO = new ListadoServiciosDTO(s);
            listadoServiciosDTOS.add(sDTO);
        });
        return listadoServiciosDTOS;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Optional<Servicio> optS = servicioService.findById(id);
        if (optS.isPresent()) {
            ServicioDetallesDTO sDTO = new ServicioDetallesDTO(optS.get());
            return ResponseEntity.ok().body(sDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST,"El id de servicio no se encuentra"));
        }

    }
}
