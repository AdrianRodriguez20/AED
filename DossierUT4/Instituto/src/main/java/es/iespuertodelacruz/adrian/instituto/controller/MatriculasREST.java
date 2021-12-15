package es.iespuertodelacruz.adrian.instituto.controller;

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
	
	@GetMapping
	public List<Matricula> getAll() {
		ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
		matriculaService.findAll().forEach(p -> matriculas.add((Matricula) p));
		return matriculas;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") String id) {
		Optional<Matricula> optM = matriculaService.findById(Integer.parseInt(id));
		return ResponseEntity.ok().body(optM);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Matricula matricula) {
		Optional<Alumno> optA = alumnoService.findById(matricula.getAlumno().getDni());
		if (optA.isPresent()) {
			
			Matricula m = new Matricula();
			ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
			for(Asignatura a : matricula.getAsignaturas()) {
				
				Optional<Asignatura> optAsig = asignaturaService.findById(a.getIdasignatura());
				if (optAsig.isPresent()) {
					asignaturas.add(a);
				}
			}
			if (asignaturas.size()>0 && asignaturas.size()==matricula.getAsignaturas().size()) {
				m.setYear(matricula.getYear());
				m.setAlumno(matricula.getAlumno());
				m.setAsignaturas(matricula.getAsignaturas());
				matriculaService.save(m);
				return ResponseEntity.ok().body(m);
			
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El alumno no se ha matriculado de ninguna asignatura");
			}
			
			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("EL Alumno no existe");
		}
		
	}

}