package es.iespuertodelacruz.adrian.restaurante.service;

import es.iespuertodelacruz.adrian.restaurante.entity.Operario;
import es.iespuertodelacruz.adrian.restaurante.repository.OperariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OperarioService implements  GenericService <Operario,Integer>{

    @Autowired
    private OperariosRepository operariosRepository;

    @Override
    @Transactional(readOnly=true)
    public Iterable<Operario> findAll() {
        return operariosRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Page<Operario> findAll(Pageable pageable) {
        return operariosRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Operario> findById(Integer id) {
        return operariosRepository.findById(id);
    }

    @Override
    public Operario save(Operario obj) {
        return operariosRepository.save(obj);
    }

    @Override
    public void deleteById(Integer id) {
        operariosRepository.deleteById(id);
    }

    @Override
    public void delete(Operario obj) {
        operariosRepository.delete(obj);
    }

    public Operario findByNombre(String nombre){
        return operariosRepository.findByNombre(nombre);
    }
}
