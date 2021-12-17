package es.iespuertodelacruz.adrian.instituto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;
import es.iespuertodelacruz.adrian.instituto.repository.AsignaturasRepository;

@Service
public class AsignaturaService implements GenericService<Asignatura,Integer> {
	
	@Autowired
	private AsignaturasRepository asignaturasRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Asignatura> findAll() {
		return asignaturasRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Asignatura> findAll(Pageable pageable) {
		return asignaturasRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Asignatura> findById(Integer id) {
		return asignaturasRepository.findById(id);
	}

	@Override
	public Asignatura save(Asignatura obj) {
		return asignaturasRepository.save(obj);
	}

	@Override
	public void deleteById(Integer id) {
		asignaturasRepository.deleteById(id);
		
	}

	@Override
	public void delete(Asignatura obj) {
		asignaturasRepository.delete(obj);
		
	}
	@Transactional(readOnly=true)
	public Optional<Asignatura> findEquals(String nombre, String curso) {
		return asignaturasRepository.findEquals( nombre, curso);
	}

}
