package es.iespuertodelacruz.adrian.restaurante.controller;


import es.iespuertodelacruz.adrian.restaurante.dto.PlatoDTO;
import es.iespuertodelacruz.adrian.restaurante.entity.Plato;
import es.iespuertodelacruz.adrian.restaurante.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/platos")
public class PlatosController {

    @Autowired
    PlatoService platoService;

    @GetMapping
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
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Optional<Plato> optP = platoService.findById(id);
        if (optP.isPresent()) {
            PlatoDTO pDTO = new PlatoDTO(optP.get());
            return ResponseEntity.ok().body(pDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id del registro no existe");
        }

    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Plato p) {
            PlatoDTO pDTO = new PlatoDTO(p);
            return ResponseEntity.ok().body(new PlatoDTO(platoService.save(pDTO.toPlato())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Plato p) {
        Optional<Plato> optP = platoService.findById(id);
        if (optP.isPresent()) {
            PlatoDTO pDTO = new PlatoDTO(p);
            pDTO.setIdplato(id);
            return ResponseEntity.ok().body(new PlatoDTO(platoService.save(pDTO.toPlato())));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id del registro no existe");
        }
    }

}
