package es.iespuertodelacruz.juan.matriculas.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.iespuertodelacruz.juan.matriculas.entity.Asignatura;
import es.iespuertodelacruz.juan.matriculas.repository.AsignaturaRepository;

@Service
public class AsignaturaService implements GenericService<Asignatura,Integer>{

	@Autowired
	private AsignaturaRepository asignaturaRepository;

	@Override
	@Transactional(readOnly=true)
	public Iterable<Asignatura> findAll() {
		return asignaturaRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Asignatura> findAll(Pageable pageable) {
		return asignaturaRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Asignatura> findById(Integer id) {
		return asignaturaRepository.findById(id);
	}
	
	@Transactional(readOnly=true)
	public Integer getCountAsignaturasInMatricula(Asignatura asignatura) {
		return asignaturaRepository.getCountAsignaturasInMatricula(asignatura);
	}

	@Override
	@Transactional
	public Asignatura save(Asignatura obj) {
		return asignaturaRepository.save(obj);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		asignaturaRepository.deleteById(id);
	}

	@Override
	@Transactional
	public void delete(Asignatura entity) {
		asignaturaRepository.delete(entity);
	}
}
