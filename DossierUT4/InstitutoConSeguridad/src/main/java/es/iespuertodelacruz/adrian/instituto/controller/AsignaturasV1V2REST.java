package es.iespuertodelacruz.adrian.instituto.controller;

import es.iespuertodelacruz.adrian.instituto.dto.AsignaturaDTO;
import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;
import es.iespuertodelacruz.adrian.instituto.service.AsignaturaService;
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
@RequestMapping(value={"/api/v1/asignaturas", "/api/v2/asignaturas"})
public class AsignaturasV1V2REST {

    @Autowired
    AsignaturaService asignaturaService;

    @GetMapping
    public ArrayList<AsignaturaDTO> getAll() {
        ArrayList<AsignaturaDTO> asignaturas = new ArrayList<AsignaturaDTO>();
        asignaturaService.findAll().forEach(p -> {
            Asignatura a = (Asignatura) p;
            AsignaturaDTO uDTO = new AsignaturaDTO(a);
            asignaturas.add(uDTO);
        });
        return asignaturas;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Optional<Asignatura> optA = asignaturaService.findById(id);
        if (optA.isPresent()) {
            AsignaturaDTO uDTO = new AsignaturaDTO(optA.get());
            return ResponseEntity.ok().body(uDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id del registro no existe");
        }

    }
}
