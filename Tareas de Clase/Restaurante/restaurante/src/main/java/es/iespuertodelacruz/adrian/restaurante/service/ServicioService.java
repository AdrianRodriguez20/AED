package es.iespuertodelacruz.adrian.restaurante.service;

import es.iespuertodelacruz.adrian.restaurante.entity.Servicio;
import es.iespuertodelacruz.adrian.restaurante.repository.ServiciosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ServicioService implements GenericService<Servicio,Integer> {

    @Autowired
    private ServiciosRepository serviciosRepository;

    @Override
    @Transactional(readOnly=true)
    public Iterable<Servicio> findAll() {
        return serviciosRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Page<Servicio> findAll(Pageable pageable) {
        return serviciosRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Servicio> findById(Integer id) {
        return serviciosRepository.findById(id);
    }

    @Override
    public Servicio save(Servicio obj) {
        return serviciosRepository.save(obj);
    }

    @Override
    public void deleteById(Integer id) {
        serviciosRepository.deleteById(id);
    }

    @Override
    public void delete(Servicio obj) {
        serviciosRepository.delete(obj);
    }
}
