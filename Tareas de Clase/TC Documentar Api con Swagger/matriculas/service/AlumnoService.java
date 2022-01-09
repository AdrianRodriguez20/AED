package es.iespuertodelacruz.juan.matriculas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.iespuertodelacruz.juan.matriculas.entity.Alumno;
import es.iespuertodelacruz.juan.matriculas.repository.AlumnoRepository;


@Service
public class AlumnoService implements GenericService<Alumno,String>{
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Alumno> findAll() {
		return alumnoRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Alumno> findAll(Pageable pageable) {
		return alumnoRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Alumno> findById(String id) {
		return alumnoRepository.findById(id);
	}
	
	@Transactional(readOnly=true)
	public Iterable<Alumno> findByNombre(String nombre) {
		return alumnoRepository.findByNombre(nombre);
	}

	@Override
	@Transactional
	public Alumno save(Alumno obj) {
		return alumnoRepository.save(obj);
	}

	@Override
	@Transactional
	public void deleteById(String id) {
		alumnoRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(Alumno entity) {
		alumnoRepository.delete(entity);
	}


}
