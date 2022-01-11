package es.iespuertodelacruz.adrian.instituto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.iespuertodelacruz.adrian.instituto.dto.AsignaturaDTO;
import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;
import es.iespuertodelacruz.adrian.instituto.service.AsignaturaService;

@RestController
@RequestMapping("/api/v1/asignaturas")

public class AsignaturasREST {

	// private Logger logger = LoggerFactory.getLogger(AlumnosREST.class);

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

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Asignatura a) {
		Optional<Asignatura> optA = asignaturaService.findEquals(a.getNombre(), a.getCurso());
		if (!optA.isPresent()) {
			AsignaturaDTO aDTO = new AsignaturaDTO(a);

			return ResponseEntity.ok().body(new AsignaturaDTO(asignaturaService.save(aDTO.toAsignatura())));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La Asignatura  ya existe");
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		Optional<Asignatura> optA = asignaturaService.findById(id);
		if (optA.isPresent()) {
			try {

				asignaturaService.deleteById(id);
				return ResponseEntity.ok("Asignatura borrado");
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("No se puede eliminar esta asignatura , debido a que está asociada a otras matriculas");
			}
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id del registro no existe");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Asignatura a) {
		Optional<Asignatura> optA = asignaturaService.findById(id);
		if (optA.isPresent()) {
			AsignaturaDTO aDTO = new AsignaturaDTO(a);
			Optional<Asignatura> optAs = asignaturaService.findEquals(a.getNombre(), a.getCurso());
			if (!optAs.isPresent()) {
				return ResponseEntity.ok().body(new AsignaturaDTO(asignaturaService.save(aDTO.toAsignatura())));
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La Asignatura  ya existe");
			}

		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id del registro no existe");
		}
	}
}
