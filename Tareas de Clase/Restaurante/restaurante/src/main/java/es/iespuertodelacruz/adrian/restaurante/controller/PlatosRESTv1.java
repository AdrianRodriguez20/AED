package es.iespuertodelacruz.adrian.restaurante.controller;

import java.util.ArrayList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.iespuertodelacruz.adrian.restaurante.dto.platos.PlatoDTO;
import es.iespuertodelacruz.adrian.restaurante.entity.Plato;
import es.iespuertodelacruz.adrian.restaurante.service.PlatoService;

@RestController
@RequestMapping("/api/v1/platos")
@Api(value="API REST Platos V1")
public class PlatosRESTv1 {

    @Autowired
    PlatoService platoService;

    @GetMapping
    @ApiOperation(value="Devuelve todos los platos")
    public ArrayList<PlatoDTO> getAll() {
        ArrayList<PlatoDTO> platos = new ArrayList<PlatoDTO>();
        platoService.findAll().forEach(p -> {
            Plato a = (Plato) p;
            PlatoDTO pDTO = new PlatoDTO(a);
            platos.add(pDTO);
        });
        return platos;
    }
}
