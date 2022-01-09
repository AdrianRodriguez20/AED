package es.iespuertodelacruz.adrian.instituto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.iespuertodelacruz.adrian.instituto.entity.Alumno;
import es.iespuertodelacruz.adrian.instituto.repository.AlumnosRepository;

@Service
public class AlumnoService implements GenericService<Alumno,String> {

	@Autowired
	private AlumnosRepository alumnosRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Alumno> findAll() {
		return alumnosRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Alumno> findAll(Pageable pageable) {
		return alumnosRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Alumno> findById(String id) {
		return alumnosRepository.findById(id);
	}

	@Override
	public Alumno save(Alumno obj) {
		return alumnosRepository.save(obj);
	}

	@Override
	public void deleteById(String id) {
		alumnosRepository.deleteById(id);
		
	}

	@Override
	public void delete(Alumno obj) {
		alumnosRepository.delete(obj);
		
	}
	public List<Alumno> findByName(String nombre){
		return alumnosRepository.findByName("%"+nombre+"%");
	}


}
