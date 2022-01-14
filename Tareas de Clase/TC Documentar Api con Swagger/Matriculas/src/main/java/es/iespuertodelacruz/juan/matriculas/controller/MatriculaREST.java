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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.iespuertodelacruz.juan.matriculas.dto.AlumnoListDTO;
import es.iespuertodelacruz.juan.matriculas.dto.ApiErrorDTO;
import es.iespuertodelacruz.juan.matriculas.dto.ApiMessageDTO;
import es.iespuertodelacruz.juan.matriculas.dto.MatriculaDTO;
import es.iespuertodelacruz.juan.matriculas.dto.MatriculaPostListDTO;
import es.iespuertodelacruz.juan.matriculas.entity.Alumno;
import es.iespuertodelacruz.juan.matriculas.entity.Matricula;
import es.iespuertodelacruz.juan.matriculas.service.MatriculaService;
import es.iespuertodelacruz.juan.matriculas.utils.ApiError;
import es.iespuertodelacruz.juan.matriculas.utils.ApiMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/matriculas")
@Api(value="API REST Matricula")
public class MatriculaREST {
	
	private Logger logger = LoggerFactory.getLogger(MatriculaREST.class);
	
	@Autowired
	MatriculaService matriculaService;
	
	@GetMapping("")
	@ApiOperation(value="Retorna todos las matriculas.")
	public List<MatriculaPostListDTO> getAll(@ApiParam(
			name =  "year",
			type = "integer",
			value = "Puede recibir un parametro para filtrar por año.",
			example = "2021",
			required=false)@RequestParam(required=false, name="year") Integer year){
		
		ArrayList<MatriculaPostListDTO> prods = new ArrayList<>();
		List<Matricula> matriculas = (year == null) 
				? (ArrayList<Matricula>) matriculaService.findAll() 
				: (ArrayList<Matricula>) matriculaService.findByAnio(year);
		
		matriculas
			.forEach(p -> prods.add( new MatriculaPostListDTO((Matricula) p)));
		return prods;
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Retorna una matricula por id.")
	public ResponseEntity<?> getById(@ApiParam(
			name =  "id",
			type = "integer",
			value = "Id de la matricula",
			example = "1",
			required = true) @PathVariable Integer id){
		Optional<Matricula> matricula = matriculaService.findById(id);
		if (matricula.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(new MatriculaPostListDTO(matricula.get()));
		} else {
			ApiError ae = new ApiError(HttpStatus.NOT_FOUND, "El id de la matricula no existe."); 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiErrorDTO(ae));
		}
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value="Elimina una matricula por id.")
	public ResponseEntity<?> delete(@ApiParam(
			name =  "id",
			type = "integer",
			value = "Id de la matricula",
			example = "1",
			required = true) @PathVariable Integer id){
		Optional<Matricula> matricula = matriculaService.findById(id);
		if(matricula.isPresent()) {
			matriculaService.deleteById(id);
			ApiMessage am = new ApiMessage("Se ha eliminado correctamente.");
			return ResponseEntity.status(HttpStatus.OK).body(new ApiMessageDTO(am));
		}else {
			ApiError ae = new ApiError(HttpStatus.NOT_FOUND, "El id de la matricula no existe."); 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiErrorDTO(ae));
		}
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Modifica una matricula por id.")
	public ResponseEntity<?> update(@ApiParam(
			name =  "id",
			type = "integer",
			value = "Id de la matricula",
			example = "1",
			required = true) @PathVariable Integer id, @ApiParam(
			name =  "matricula",
			type = "Matricula",
			value = "Matrícula con los datos modificados",
			required = true)  @RequestBody Matricula matricula){
		Optional<Matricula> matriculaOpt = matriculaService.findById(id);
		
		if(!matriculaOpt.isPresent())
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiErrorDTO(new ApiError(HttpStatus.NOT_FOUND, "El id de la matricula no existe.")));	

		Matricula m = matriculaOpt.get();
		m.setAlumno( (matricula.getAlumno() != null) ? matricula.getAlumno() : m.getAlumno() );
		m.setAsignaturas( (matricula.getAsignaturas() != null) ? matricula.getAsignaturas() : m.getAsignaturas() );
		m.setYear( (matricula.getYear() != null) ? matricula.getYear() : m.getYear() );
		
		MatriculaDTO updatedMarticula = new MatriculaDTO(matriculaService.save(m));
		return ResponseEntity.status(HttpStatus.OK).body(updatedMarticula);
	}
}
