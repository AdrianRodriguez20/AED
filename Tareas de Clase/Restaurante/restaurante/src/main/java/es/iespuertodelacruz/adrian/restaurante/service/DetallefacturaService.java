package es.iespuertodelacruz.adrian.restaurante.service;

import java.util.List;
import java.util.Optional;

import es.iespuertodelacruz.adrian.restaurante.entity.Detallefactura;
import es.iespuertodelacruz.adrian.restaurante.repository.DetallefacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DetallefacturaService  implements GenericService<Detallefactura,Integer> {

    @Autowired
    private DetallefacturasRepository detallefacturasRepository;

    @Override
    @Transactional(readOnly=true)
    public Iterable<Detallefactura> findAll() {
        return detallefacturasRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Page<Detallefactura> findAll(Pageable pageable) {
        return detallefacturasRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly=true)
    public Optional<Detallefactura> findById(Integer id) {
        return detallefacturasRepository.findById(id);
    }

    @Override
    public Detallefactura save(Detallefactura obj) {
        return detallefacturasRepository.save(obj);
    }

    @Override
    public void deleteById(Integer id) {
        detallefacturasRepository.deleteById(id);
    }

    @Override
    public void delete(Detallefactura obj) {
        detallefacturasRepository.delete(obj);
    }

    @Transactional(readOnly=true)
    public Detallefactura findByPlato(Integer idplato, Integer idservicio) {
        return detallefacturasRepository.findByPlato(idplato , idservicio);
    }
}
