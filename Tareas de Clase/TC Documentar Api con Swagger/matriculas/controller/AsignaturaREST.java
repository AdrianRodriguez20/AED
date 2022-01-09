package es.iespuertodelacruz.juan.matriculas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.swagger.annotations.ApiParam;
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

import es.iespuertodelacruz.juan.matriculas.dto.ApiErrorDTO;
import es.iespuertodelacruz.juan.matriculas.dto.ApiMessageDTO;
import es.iespuertodelacruz.juan.matriculas.dto.AsignaturaDTO;
import es.iespuertodelacruz.juan.matriculas.entity.Alumno;
import es.iespuertodelacruz.juan.matriculas.entity.Asignatura;
import es.iespuertodelacruz.juan.matriculas.entity.Matricula;
import es.iespuertodelacruz.juan.matriculas.service.AsignaturaService;
import es.iespuertodelacruz.juan.matriculas.utils.ApiError;
import es.iespuertodelacruz.juan.matriculas.utils.ApiMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/asignaturas")
@Api(value="API REST Asignatura")
public class AsignaturaREST {
	
	private Logger logger = LoggerFactory.getLogger(AsignaturaREST.class);
	
	@Autowired
	AsignaturaService asignaturaService;
	
	@GetMapping("")
	@ApiOperation(value="Retorna todas las asignaturas.")
	public List<AsignaturaDTO> getAll(){
		ArrayList<AsignaturaDTO> prods = new ArrayList<>();
		asignaturaService
			.findAll()
			.forEach(p -> prods.add(new AsignaturaDTO((Asignatura) p)));
		return prods;
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Retorna una asignatura por id.")
	public ResponseEntity<?> getById(@ApiParam(
			name =  "id",
			type = "integer",
			value = "Id de la asignatura que quiere buscar",
			example = "1",
			required = true) @PathVariable Integer id){
		Optional<Asignatura> optM = asignaturaService.findById(id);
		if (optM.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(new AsignaturaDTO(optM.get()));
		} else {
			ApiError ae = new ApiError(HttpStatus.NOT_FOUND, "El id de la asignatura no existe."); 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiErrorDTO(ae));
		}
	}
	
	@PostMapping("")
	@ApiOperation(value="Guarda una asignatura.")
	public ResponseEntity<?> save(@ApiParam(
			name =  "asignatura",
			type = "Asignatura",
			value = "Asignatura a guardar",
			required = true) @RequestBody Asignatura asignatura){
		
		if (asignatura.getNombre() == null && asignatura.getCurso() == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiErrorDTO(new ApiError(HttpStatus.BAD_REQUEST, "Debes introducir todos los campos para crear una asignatura.")));
		
		Asignatura a = new Asignatura();
		a.setCurso(asignatura.getCurso());
		a.setNombre(asignatura.getNombre());
		
		AsignaturaDTO savedAsignatura = new AsignaturaDTO(asignaturaService.save(a));
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(savedAsignatura);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Elimina una asignatura por id.")
	public ResponseEntity<?> delete(@ApiParam(
			name =  "id",
			type = "integer",
			value = "Id de la asignatura que desea borrar",
			example = "1",
			required = true) @PathVariable Integer id){
		Optional<Asignatura> asignatura = asignaturaService.findById(id);	
		if(!asignatura.isPresent())
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiErrorDTO(new ApiError(HttpStatus.NOT_FOUND, "El id de la asignatura no existe.")));
		
		Integer count = asignaturaService.getCountAsignaturasInMatricula(asignatura.get());
		logger.info("\n COUNT = " + count + " \n");
		
		if(count > 0)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(new ApiErrorDTO(new ApiError(HttpStatus.BAD_REQUEST, "Esta asignatura esta relacionada con una matricula.")));
		
		
		asignaturaService.deleteById(id);
		ApiMessage am = new ApiMessage("Se ha eliminado correctamente.");
		return ResponseEntity.status(HttpStatus.OK).body(new ApiMessageDTO(am));
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Modifica una asignatura por id.")
	public ResponseEntity<?> update(@ApiParam(
			name =  "id",
			type = "integer",
			value = "Id de la asignatura a modificar",
			example = "1",
			required = true) @PathVariable Integer id, @ApiParam(
			name =  "asignatura",
			type = "Asignatura",
			value = "Asignatura modificada con los datos a actualizar",
			required = true) @RequestBody Asignatura asignatura){
		Optional<Asignatura> asignaturaOpt = asignaturaService.findById(id);
		
		if(!asignaturaOpt.isPresent())
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiErrorDTO(new ApiError(HttpStatus.NOT_FOUND, "El id de la asignatura no existe.")));	

		Asignatura a = asignaturaOpt.get();
		a.setNombre( (asignatura.getNombre() != null) ? asignatura.getNombre() : a.getNombre() );
		a.setCurso( (asignatura.getNombre() != null) ? asignatura.getCurso() : a.getCurso() );
		AsignaturaDTO updatedAsignatura = new AsignaturaDTO(asignaturaService.save(a));
		return ResponseEntity.status(HttpStatus.OK).body(updatedAsignatura);
	}
}
