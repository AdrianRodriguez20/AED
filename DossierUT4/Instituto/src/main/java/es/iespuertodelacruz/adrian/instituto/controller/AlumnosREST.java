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

import es.iespuertodelacruz.adrian.instituto.entity.Alumno;
import es.iespuertodelacruz.adrian.instituto.service.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")

public class AlumnosREST {

	//private Logger logger = LoggerFactory.getLogger(AlumnosREST.class);

	@Autowired
	AlumnoService alumnoService;

	@GetMapping
	public List<Alumno> getAll() {
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		alumnoService.findAll().forEach(p -> alumnos.add((Alumno) p));
		return alumnos;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") String id) {
		Optional<Alumno> optA = alumnoService.findById(id);
		return ResponseEntity.ok().body(optA);
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Alumno alum) {
		Alumno a = new Alumno();
		a.setNombre(alum.getNombre());
		a.setApellidos(alum.getApellidos());
		a.setDni(alum.getDni());
		a.setFechanacimiento(alum.getFechanacimiento());
		alumnoService.save(a);
		return ResponseEntity.ok().body(a);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		Optional<Alumno> optA = alumnoService.findById(id);
		if (optA.isPresent()) {
			alumnoService.deleteById(id);
			return ResponseEntity.ok("Alumno borrado");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id del registro no existe");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody Alumno alum) {
		Optional<Alumno> optA = alumnoService.findById(id);
		if (optA.isPresent()) {
			Alumno a = new Alumno();
			a.setNombre(alum.getNombre());
			a.setApellidos(alum.getApellidos());
			a.setDni(alum.getDni());
			a.setFechanacimiento(alum.getFechanacimiento());
			return ResponseEntity.ok(alumnoService.save(a));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}
}
