package es.iespuertodelacruz.adrian.instituto.service;

import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;
import es.iespuertodelacruz.adrian.instituto.entity.Usuario;
import es.iespuertodelacruz.adrian.instituto.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements GenericService<Usuario,Integer> {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public Iterable<Usuario> findAll() {
        return null;
    }

    @Override
    public Page<Usuario> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Usuario save(Usuario obj) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void delete(Usuario obj) {

    }

    public Usuario findByUsername(String username){
        return usuariosRepository.findByUsername(username);
    }
}