package es.iespuertodelacruz.adrian.restaurante.service;

import es.iespuertodelacruz.adrian.restaurante.entity.Mesa;
import es.iespuertodelacruz.adrian.restaurante.repository.MesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class MesaService implements GenericService<Mesa, Integer> {

    @Autowired
    private MesasRepository mesasRepository;

    @Override
    @Transactional(readOnly=true)
    public Iterable<Mesa> findAll() {
        return mesasRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Page<Mesa> findAll(Pageable pageable) {
        return mesasRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Mesa> findById(Integer id) {
        return mesasRepository.findById(id);
    }

    @Override
    public Mesa save(Mesa obj) {
        return mesasRepository.save(obj);
    }

    @Override
    public void deleteById(Integer id) {
        mesasRepository.deleteById(id);
    }

    @Override
    public void delete(Mesa obj) {
        mesasRepository.delete(obj);
    }


    @Transactional(readOnly=true)
    public Iterable<Mesa> findMesasDisponibles(long fechaSolicitada, long fechaAhora ,  int comensales) {
        return mesasRepository.findMesasDisponibles(fechaSolicitada, fechaAhora, comensales);
    }
}
