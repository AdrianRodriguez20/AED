package es.iespuertodelacruz.adrian.instituto.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.iespuertodelacruz.adrian.instituto.entity.Alumno;
import es.iespuertodelacruz.adrian.instituto.service.AlumnoService;

@RestController
@RequestMapping("/api/alumnos")

public class AlumnosREST {
	
	private Logger logger = LoggerFactory.getLogger(AlumnosREST.class);
	
	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping 
	public List<Alumno> getAll(){
	ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
	alumnoService
	.findAll()
			.forEach(p -> alumnos.add((Alumno) p) );
	return alumnos;
	}

	
	
}
