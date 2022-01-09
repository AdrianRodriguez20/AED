package es.iespuertodelacruz.juan.matriculas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.iespuertodelacruz.juan.matriculas.entity.Alumno;
import es.iespuertodelacruz.juan.matriculas.entity.Matricula;
import es.iespuertodelacruz.juan.matriculas.repository.MatriculaRepository;

@Service
public class MatriculaService implements GenericService<Matricula,Integer>{

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Matricula> findAll() {
		return matriculaRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Matricula> findAll(Pageable pageable) {
		return matriculaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Matricula> findById(Integer id) {
		return matriculaRepository.findById(id);
	}
	
	@Transactional(readOnly=true)
	public Optional<Matricula> findByAnioAlumno(Integer year, Optional<Alumno> alumno){
		return matriculaRepository.findByAnioAlumno(year, alumno);
	}
	
	@Transactional(readOnly=true)
	public Iterable<Matricula> findByAnio(Integer year){
		return matriculaRepository.findByAnio(year);
	}

	@Override
	@Transactional
	public Matricula save(Matricula obj) {
		return matriculaRepository.save(obj);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		matriculaRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(Matricula entity) {
		matriculaRepository.delete(entity);
	}
}
