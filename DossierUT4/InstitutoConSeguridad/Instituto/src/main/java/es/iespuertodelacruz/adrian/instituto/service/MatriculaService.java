package es.iespuertodelacruz.adrian.instituto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.iespuertodelacruz.adrian.instituto.entity.Matricula;
import es.iespuertodelacruz.adrian.instituto.repository.MatriculasRepository;

@Service
public class MatriculaService implements GenericService<Matricula,Integer> {

	@Autowired
	private MatriculasRepository matriculasRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Matricula> findAll() {
		return matriculasRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Matricula> findAll(Pageable pageable) {
		return matriculasRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Matricula> findById(Integer id) {
		return matriculasRepository.findById(id);
	}

	@Override
	public Matricula save(Matricula obj) {
		return matriculasRepository.save(obj);
	}

	@Override
	public void deleteById(Integer id) {
		matriculasRepository.deleteById(id);
		
	}

	@Override
	public void delete(Matricula obj) {
		matriculasRepository.delete(obj);
		
	}

	@Transactional(readOnly=true)
	public Optional<Matricula> findEquals(String dni, Integer idCurso) {
        return matriculasRepository.findByEquals(dni, idCurso);
    }

	@Transactional(readOnly=true)
	public List<Matricula> findByYear(Integer year) {
		return matriculasRepository.findByYear(year);
	}

}

