package es.iespuertodelacruz.adrian.restaurante.service;

import es.iespuertodelacruz.adrian.restaurante.entity.Plato;
import es.iespuertodelacruz.adrian.restaurante.repository.PlatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PlatoService implements GenericService <Plato , Integer> {

    @Autowired
    private PlatosRepository platosRepository;

    @Override
    @Transactional(readOnly=true)
    public Iterable<Plato> findAll() {
        return platosRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Page<Plato> findAll(Pageable pageable) {
        return platosRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Plato> findById(Integer id) {
        return platosRepository.findById(id);
    }

    @Override
    public Plato save(Plato obj) {
        return platosRepository.save(obj);
    }

    @Override
    public void deleteById(Integer id) {
        platosRepository.deleteById(id);
    }

    @Override
    public void delete(Plato obj) {
        platosRepository.delete(obj);
    }

   public void updateDisponible(Integer id, boolean disponible) {
        platosRepository.updateDisponible(disponible,id);
    }

}
