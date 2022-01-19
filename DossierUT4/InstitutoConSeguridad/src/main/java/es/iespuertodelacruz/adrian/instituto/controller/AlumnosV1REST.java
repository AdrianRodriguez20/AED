package es.iespuertodelacruz.adrian.instituto.controller;

import es.iespuertodelacruz.adrian.instituto.dto.ListadoAlumnosDTO;
import es.iespuertodelacruz.adrian.instituto.dto.ListadoAlumnosV1DTO;
import es.iespuertodelacruz.adrian.instituto.dto.MatriculaDTO;
import es.iespuertodelacruz.adrian.instituto.entity.Alumno;
import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;
import es.iespuertodelacruz.adrian.instituto.entity.Matricula;
import es.iespuertodelacruz.adrian.instituto.service.AlumnoService;
import es.iespuertodelacruz.adrian.instituto.service.AsignaturaService;
import es.iespuertodelacruz.adrian.instituto.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/alumnos")
public class AlumnosV1REST {
    // private Logger logger = LoggerFactory.getLogger(AlumnosREST.class);

    @Autowired
    AlumnoService alumnoService;
    @Autowired
    MatriculaService matriculaService;
    @Autowired
    AsignaturaService asignaturaService;

    @GetMapping()
    public ArrayList<ListadoAlumnosV1DTO> getAll(@RequestParam(required=false, name="nombre") String nombre) {
        ArrayList<ListadoAlumnosV1DTO> alumnos = new ArrayList<ListadoAlumnosV1DTO>();
        if (nombre==null) {
            alumnoService.findAll().forEach(p -> {
                Alumno a = (Alumno) p;
                ListadoAlumnosV1DTO uDTO = new ListadoAlumnosV1DTO(a);
                alumnos.add(uDTO);
            });
        }else {
            alumnoService.findByName(nombre).forEach(p -> {
                Alumno a = (Alumno) p;
                ListadoAlumnosV1DTO uDTO = new ListadoAlumnosV1DTO(a);
                alumnos.add(uDTO);
            });
        }

        return alumnos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        Optional<Alumno> optA = alumnoService.findById(id);
        if (optA.isPresent()) {
            ListadoAlumnosV1DTO uDTO = new ListadoAlumnosV1DTO(optA.get());
            return ResponseEntity.ok().body(uDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id del registro no existe");
        }

    }









}
