package es.iespuertodelacruz.juan.matriculas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.swagger.annotations.*;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.iespuertodelacruz.juan.matriculas.dto.AlumnoDTO;
import es.iespuertodelacruz.juan.matriculas.dto.AlumnoListDTO;
import es.iespuertodelacruz.juan.matriculas.dto.ApiErrorDTO;
import es.iespuertodelacruz.juan.matriculas.dto.ApiMessageDTO;
import es.iespuertodelacruz.juan.matriculas.dto.AsignaturaDTO;
import es.iespuertodelacruz.juan.matriculas.dto.MatriculaPostListDTO;
import es.iespuertodelacruz.juan.matriculas.entity.Alumno;
import es.iespuertodelacruz.juan.matriculas.entity.Asignatura;
import es.iespuertodelacruz.juan.matriculas.entity.Matricula;
import es.iespuertodelacruz.juan.matriculas.service.AlumnoService;
import es.iespuertodelacruz.juan.matriculas.service.AsignaturaService;
import es.iespuertodelacruz.juan.matriculas.service.MatriculaService;
import es.iespuertodelacruz.juan.matriculas.utils.ApiError;
import es.iespuertodelacruz.juan.matriculas.utils.ApiMessage;

@RestController
@RequestMapping("/api/alumnos")
@Api(value="API REST Alumnos")
public class AlumnoREST {
	
	private Logger logger = LoggerFactory.getLogger(AlumnoREST.class);
	
	@Autowired
	AlumnoService alumnoService;
	@Autowired
	MatriculaService matriculaService;
	@Autowired
	AsignaturaService asignaturaService;
	
	/* GESTION DE ALUMNOS */
	
	@GetMapping("")
	@ApiOperation(value="Retorna todos los alumnos.")
	public List<AlumnoListDTO> getAll(	@ApiParam(
			name =  "nombre",
			type = "String",
			value = "Puede recibir un parametro para filtrar por nombre.",
			example = "Verstappen",
			required=false) @RequestParam(required=false, name="nombre") String strNombre){
		ArrayList<AlumnoListDTO> prods = new ArrayList<>();
		List<Alumno> alumnos = (strNombre == null) 
				? (ArrayList<Alumno>) alumnoService.findAll() 
				: (ArrayList<Alumno>) alumnoService.findByNombre('%' + strNombre + '%');
		alumnos
			.forEach(p -> prods.add(new AlumnoListDTO((Alumno) p)));
		return prods;
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Retorna un alumno por dni.")
	public ResponseEntity<?> getById( @ApiParam(
			name =  "dni",
			type = "String",
			value = "DNI del Alumno que desea buscar",
			example = "48758911J",
			required = true) @PathVariable String id){
		Optional<Alumno> alumno = alumnoService.findById(id);
		// Comprobamos si el alumno existe
		if (alumno.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(new AlumnoDTO(alumno.get()));
		} else {
			ApiError ae = new ApiError(HttpStatus.NOT_FOUND, "El dni no existe."); 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiErrorDTO(ae));
		}
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value="Elimina un alumno por dni.")
	public ResponseEntity<?> delete(	@ApiParam(
			name =  "dni",
			type = "String",
			value = "DNI del Alumno que desea eliminar",
			example = "48758911J",
			required = true) @PathVariable String id){
		Optional<Alumno> alumno = alumnoService.findById(id);
		// Comprobamos si el alumno existe
		if(alumno.isPresent()) {
			alumnoService.deleteById(id);
			ApiMessage am = new ApiMessage("Se ha eliminado correctamente.");
			return ResponseEntity.status(HttpStatus.OK).body(new ApiMessageDTO(am));
		}else {
			ApiError ae = new ApiError(HttpStatus.NOT_FOUND, "El dni no existe."); 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiErrorDTO(ae));
		}
	}
	
	@PostMapping("")
	@ApiOperation(value="Guarda un alumno.")
	public ResponseEntity<?> saveAlumno(@ApiParam(
			name =  "alumno",
			type = "Alumno",
			value = "Alumno que se desea guardar",
			required = true) @RequestBody Alumno alumno){
		// Comprobamos que el dni o la fecha de nacimiento son nulas
		if (alumno.getDni() == null || alumno.getFechanacimiento() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiErrorDTO(new ApiError(HttpStatus.BAD_REQUEST, "Debes introducir el dni y la fecha de nacimiento para crear un alumno.")));
		
		// Comprobamos si el alumno existe
		Optional<Alumno> alumnoOpt = alumnoService.findById(alumno.getDni());
		if (alumnoOpt.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiErrorDTO(new ApiError(HttpStatus.BAD_REQUEST, "Ya existe un alumno con ese dni.")));
		
		// Creamos el alumno
		Alumno a = new Alumno();
		a.setDni(alumno.getDni());
		a.setNombre(alumno.getNombre());
		a.setApellidos(alumno.getApellidos());
		a.setFechanacimiento(alumno.getFechanacimiento());
		a.setMatriculas(alumno.getMatriculas());
		
		AlumnoListDTO savedAlumno = new AlumnoListDTO(alumnoService.save(a));
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(savedAlumno);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Modifica un alumno por dni.")
	public ResponseEntity<?> updateAlumno(@ApiParam(
			name =  "dni",
			type = "String",
			value = "DNI del Alumno del  que desea actualizar su información",
			example = "48758911J",
			required = true)  @PathVariable String id, @ApiParam(
            name =  "alumno",
            type = "Alumno",
            value = "Alumno actualizado con la información a modificar",
            required = true) @RequestBody Alumno alumno){
		Optional<Alumno> alumnoOpt = alumnoService.findById(id);
		
		if(!alumnoOpt.isPresent())
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiErrorDTO(new ApiError(HttpStatus.NOT_FOUND, "El alumno con ese dni no existe.")));	

		Alumno a = alumnoOpt.get();
		a.setNombre( (alumno.getNombre() != null) ? alumno.getNombre() : a.getNombre() );
		a.setApellidos( (alumno.getApellidos() != null) ? alumno.getApellidos() : a.getApellidos() );
		a.setFechanacimiento( (alumno.getFechanacimiento() != null) ? alumno.getFechanacimiento() : a.getFechanacimiento() );
		
		AlumnoListDTO updatedAlumno = new AlumnoListDTO(alumnoService.save(a));
		return ResponseEntity.status(HttpStatus.OK).body(updatedAlumno);
	}
	
	/* GESTION DE MATRICULAS */
	
	@PostMapping("/{id}/matriculas")
	@ApiOperation(value="Guarda una matricula.")
	public ResponseEntity<?> saveMatricula(@ApiParam(
			name =  "matricula",
			type = "Matricula",
			value = "Matrícula del Alumno",
			required = true) @RequestBody Matricula matricula, @ApiParam(
			name =  "dni",
			type = "String",
			value = "DNI del Alumno que desea matricular",
			required = true)  @PathVariable("id") String id){
		Optional<Alumno> alumno = alumnoService.findById(id);
		
		// Comprobamos si el alumno existe
		if (!alumno.isPresent())
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiErrorDTO(new ApiError(HttpStatus.NOT_FOUND, "No existe el alumno.")));
		
		// Comprobamos si el año o las asignaturas son nulas
		if (matricula.getYear() == null || matricula.getAsignaturas() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiErrorDTO(new ApiError(HttpStatus.BAD_REQUEST, "Debes introducir todos los campos para crear la matricula.")));
		
		// Comprobamos si la matricula ya existe
		Optional<Matricula> matriculaFinded = matriculaService.findByAnioAlumno(matricula.getYear(), alumno);
		if (matriculaFinded.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiErrorDTO(new ApiError(HttpStatus.BAD_REQUEST, "Ya existe una matricula con ese año en ese alumno.")));
	
		// Creamos la matricula
		Matricula m = new Matricula();
		ArrayList<Asignatura> asignaturas = new ArrayList<>();
		
		if (matricula.getAsignaturas().size() > 0) {
			matricula.getAsignaturas().forEach( a -> {
				Optional<Asignatura> asignatura = this.asignaturaService.findById(a.getIdasignatura());
				if (asignatura.isPresent())
					asignaturas.add(asignatura.get());
			});
		}
		
		m.setAsignaturas(asignaturas);
		m.setYear(matricula.getYear());
		m.setAlumno(alumno.get());
		
		MatriculaPostListDTO savedMatricula = new MatriculaPostListDTO(matriculaService.save(m));
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(savedMatricula);
	}
}
