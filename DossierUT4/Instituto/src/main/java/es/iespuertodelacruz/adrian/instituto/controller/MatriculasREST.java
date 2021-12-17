package es.iespuertodelacruz.adrian.instituto.controller;

import es.iespuertodelacruz.adrian.instituto.dto.ListadoAlumnosDTO;
import es.iespuertodelacruz.adrian.instituto.dto.MatriculaDTO;
import org.springframework.beans.factory.annotation.Autowired;

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
import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;
import es.iespuertodelacruz.adrian.instituto.entity.Matricula;
import es.iespuertodelacruz.adrian.instituto.service.AlumnoService;
import es.iespuertodelacruz.adrian.instituto.service.AsignaturaService;
import es.iespuertodelacruz.adrian.instituto.service.MatriculaService;

@RestController
@RequestMapping("/api/matriculas")

public class MatriculasREST {
	
	private Logger logger = LoggerFactory.getLogger(MatriculasREST.class);
	@Autowired
	MatriculaService matriculaService;
	@Autowired
	AlumnoService alumnoService;
	@Autowired
	AsignaturaService asignaturaService;



	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") String id) {
		Optional<Matricula> optM = matriculaService.findById(Integer.parseInt(id));
		return ResponseEntity.ok().body(new MatriculaDTO(optM.get()));
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		Optional<Matricula> optM = matriculaService.findById(id);
		if (optM.isPresent()) {
			matriculaService.deleteById(id);
			return ResponseEntity.ok("Matricula borrada");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id del registro no existe");
		}
	}
}