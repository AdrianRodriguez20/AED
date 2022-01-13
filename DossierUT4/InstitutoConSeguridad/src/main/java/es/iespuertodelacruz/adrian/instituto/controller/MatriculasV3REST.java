package es.iespuertodelacruz.adrian.instituto.controller;

import es.iespuertodelacruz.adrian.instituto.dto.ListadoMatriculasByYearDTO;
import es.iespuertodelacruz.adrian.instituto.dto.ListadoMatriculasDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.iespuertodelacruz.adrian.instituto.entity.Matricula;
import es.iespuertodelacruz.adrian.instituto.service.AlumnoService;
import es.iespuertodelacruz.adrian.instituto.service.AsignaturaService;
import es.iespuertodelacruz.adrian.instituto.service.MatriculaService;

@RestController
@RequestMapping("/api/V3/matriculas")

public class MatriculasV3REST {
	
	private Logger logger = LoggerFactory.getLogger(MatriculasV3REST.class);
	@Autowired
	MatriculaService matriculaService;
	@Autowired
	AlumnoService alumnoService;
	@Autowired
	AsignaturaService asignaturaService;


	@GetMapping
	public ResponseEntity<?> getAll(@RequestParam(required=false, name="year") Integer year) {

		if(year == null) {
			ArrayList<ListadoMatriculasDTO> matriculas= new ArrayList<>();
			matriculaService.findAll().forEach(p -> {
				Matricula m = (Matricula) p;
				ListadoMatriculasDTO mDTO = new ListadoMatriculasDTO(m);
				matriculas.add(mDTO);

			});
			return ResponseEntity.ok().body(matriculas);
		}else{
			ArrayList<ListadoMatriculasByYearDTO> matriculas= new ArrayList<>();
			matriculaService.findByYear(year).forEach(p -> {
				Matricula m = p;
				ListadoMatriculasByYearDTO mDTO = new ListadoMatriculasByYearDTO(m);

				matriculas.add(mDTO);
			});
			return ResponseEntity.ok().body(matriculas);
		}


	}


	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") String id) {
		Optional<Matricula> optM = matriculaService.findById(Integer.parseInt(id));
		if (optM.isPresent()) {
			return ResponseEntity.ok().body(new ListadoMatriculasDTO(optM.get()));
		}else{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id del registro no existe");
		}

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