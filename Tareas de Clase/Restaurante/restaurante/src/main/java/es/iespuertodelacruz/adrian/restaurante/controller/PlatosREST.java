package es.iespuertodelacruz.adrian.restaurante.controller;


import es.iespuertodelacruz.adrian.restaurante.dto.platos.PlatoDTO;
import es.iespuertodelacruz.adrian.restaurante.entity.Plato;
import es.iespuertodelacruz.adrian.restaurante.service.PlatoService;
import es.iespuertodelacruz.adrian.restaurante.utils.ApiError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/platos")
@Api(value = "API REST Platos V2")
public class PlatosREST {

    @Autowired
    PlatoService platoService;

    @GetMapping
    @ApiOperation(value = "Devuelve todos los platos")
    public ArrayList<PlatoDTO> getAll() {
        ArrayList<PlatoDTO> platos = new ArrayList<PlatoDTO>();
        platoService.findAll().forEach(p -> {
            Plato a = (Plato) p;
            PlatoDTO pDTO = new PlatoDTO(a);
            platos.add(pDTO);
        });
        return platos;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Devuelve un plato")
    public ResponseEntity<?> getById(
            @ApiParam(value = "Id del plato", required = true)
            @PathVariable("id") Integer id) {
        Optional<Plato> optP = platoService.findById(id);
        if (optP.isPresent()) {
            PlatoDTO pDTO = new PlatoDTO(optP.get());
            return ResponseEntity.ok().body(pDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El id del registro no existe"));
        }

    }

    @PostMapping
    @ApiOperation(value = "Crea un plato")
    public ResponseEntity<?> save(
            @ApiParam(value = "Plato a crear", required = true)
            @RequestBody Plato p) {
        if (p.getNombre() == null || p.getNombre().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El nombre del plato no puede estar vacio"));
        }
        if (p.getDescripcion() == null || p.getDescripcion().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "La descripcion del plato no puede estar vacia"));
        }
        if (p.getPreciounidad() == 0.0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El precio del plato no puede ser 0"));
        }


        PlatoDTO pDTO = new PlatoDTO(p);
        Plato save = platoService.save(pDTO.toPlato());
        if (save != null) {
            return ResponseEntity.ok().body(new PlatoDTO(save));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "No se ha puede crear el plato"));
        }

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualiza un plato")
    public ResponseEntity<?> update(
            @ApiParam(value = "Id del plato", required = true)
            @PathVariable Integer id,
            @ApiParam(value = "Plato a actualizar", required = true)
            @RequestBody Plato p) {
        Optional<Plato> optP = platoService.findById(id);
        if (optP.isPresent()) {
            if (p.getNombre() == null || p.getNombre().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El nombre del plato no puede estar vacio"));
            }
            if (p.getDescripcion() == null || p.getDescripcion().isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "La descripcion del plato no puede estar vacia"));
            }
            if (p.getPreciounidad() == 0.0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El precio del plato no puede ser 0"));
            }

            PlatoDTO pDTO = new PlatoDTO(p);
            pDTO.setIdplato(id);
            return ResponseEntity.ok().body(new PlatoDTO(platoService.save(pDTO.toPlato())));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El numero del plato  no existe"));
        }
    }

    @PutMapping("/{id}/disponibilidad")
    @ApiOperation(value = "Actualiza la disponibilidad de un plato")
    public ResponseEntity<?> updateDisponiblidad(
            @ApiParam(value = "Id del plato", required = true)
            @PathVariable Integer id,
            @ApiParam(value = "Disponibilidad del plato", required = true)
            @RequestParam(name = "disponible") Boolean disponibilidad) {
        Optional<Plato> optP = platoService.findById(id);
        if (optP.isPresent()) {
            PlatoDTO pDTO = new PlatoDTO(optP.get());
            pDTO.setIdplato(id);
            pDTO.setDisponible(disponibilidad);
            return ResponseEntity.ok().body(new PlatoDTO(platoService.save(pDTO.toPlato())));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "El numero del plato  no existe"));
        }
    }


}
