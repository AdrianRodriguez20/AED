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

import es.iespuertodelacruz.adrian.instituto.dto.AlumnoDTO;
import es.iespuertodelacruz.adrian.instituto.dto.ListadoAlumnosDTO;
import es.iespuertodelacruz.adrian.instituto.dto.MatriculaDTO;
import es.iespuertodelacruz.adrian.instituto.entity.Alumno;
import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;
import es.iespuertodelacruz.adrian.instituto.entity.Matricula;
import es.iespuertodelacruz.adrian.instituto.service.AlumnoService;
import es.iespuertodelacruz.adrian.instituto.service.AsignaturaService;
import es.iespuertodelacruz.adrian.instituto.service.MatriculaService;

@RestController
@RequestMapping("/api/alumnos")

public class AlumnosREST {

	// private Logger logger = LoggerFactory.getLogger(AlumnosREST.class);

	@Autowired
	AlumnoService alumnoService;
	@Autowired
	MatriculaService matriculaService;
	@Autowired
	AsignaturaService asignaturaService;
	
	@GetMapping
	public ArrayList<ListadoAlumnosDTO> getAll() {
		ArrayList<ListadoAlumnosDTO> alumnos = new ArrayList<ListadoAlumnosDTO>();
		alumnoService.findAll().forEach(p -> {
			Alumno a = (Alumno) p;
			ListadoAlumnosDTO uDTO = new ListadoAlumnosDTO(a);
			alumnos.add(uDTO);
		});
		return alumnos;
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") String id) {
		Optional<Alumno> optA = alumnoService.findById(id);
		if (optA.isPresent()) {
			AlumnoDTO uDTO = new AlumnoDTO(optA.get());
			return ResponseEntity.ok().body(uDTO);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id del registro no existe");
		}

	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Alumno a) {
		Optional<Alumno> optA = alumnoService.findById(a.getDni());
		if (!optA.isPresent()) {
			AlumnoDTO aDTO = new AlumnoDTO(a);
			alumnoService.save(aDTO.toAlumno());
			return ResponseEntity.ok().body(a);
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario ya existe");
		}

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
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody Alumno a) {
		Optional<Alumno> optA = alumnoService.findById(id);
		if (optA.isPresent()) {
			AlumnoDTO aDTO = new AlumnoDTO(a);
			alumnoService.save(aDTO.toAlumno());
			return ResponseEntity.ok(alumnoService.save(a));
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
		}
	}

	@GetMapping("/{idA}/matriculas/{idM}")
	public ResponseEntity<?> getMatriculaById(@PathVariable("idA") String idA, @PathVariable("idM") Integer idM) {
		Optional<Alumno> optA = alumnoService.findById(idA);
		if (optA.isPresent()) {
			Optional<Matricula> optM = matriculaService.findById(idM);
			if (optM.isPresent() && optM.get().getAlumno().getDni().equals(idA)) {
				MatriculaDTO mDTO = new MatriculaDTO(optM.get());
				return ResponseEntity.ok().body(mDTO);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La matrícula no existe");
			}

		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El alumno no existe");
		}

	}
	
	@PostMapping("/{idA}/matriculas")
	public ResponseEntity<?> saveMatricula(@PathVariable("idA") String idA, @RequestBody Matricula matricula) {
		Optional<Alumno> optA = alumnoService.findById(idA);
		if (optA.isPresent()) {
			matricula.setAlumno(optA.get());
			
			ArrayList<Asignatura> asignaturas = new ArrayList<Asignatura>();
			for(Asignatura a : matricula.getAsignaturas()) {
				
				Optional<Asignatura> optAsig = asignaturaService.findById(a.getIdasignatura());
				if (optAsig.isPresent()) {
					asignaturas.add(a);
				}
			}
			if (asignaturas.size()>0 && asignaturas.size()==matricula.getAsignaturas().size()) {
				MatriculaDTO mDTO = new MatriculaDTO(matricula);
				matriculaService.save(mDTO.toMatricula());
				return ResponseEntity.ok().body(mDTO);
			
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El alumno no se ha matriculado de ninguna asignatura");
			}
			
			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("EL Alumno no existe");
		}
		
	}

}
