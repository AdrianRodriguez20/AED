package es.iespuertodelacruz.adrian.instituto.service;

import es.iespuertodelacruz.adrian.instituto.entity.Alumno;
import es.iespuertodelacruz.adrian.instituto.entity.Asignatura;
import es.iespuertodelacruz.adrian.instituto.entity.Usuario;
import es.iespuertodelacruz.adrian.instituto.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements GenericService<Usuario,String> {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
	@Transactional(readOnly=true)
    public Iterable<Usuario> findAll() {
        return usuariosRepository.findAll();
    }

    @Override
	@Transactional(readOnly=true)
    public Page<Usuario> findAll(Pageable pageable) {
        return usuariosRepository.findAll(pageable);
    }

    @Override
	@Transactional(readOnly=true)
    public Optional<Usuario> findById(String id) {
        return usuariosRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario obj) {
        return usuariosRepository.save(obj);
    }

    @Override
    public void deleteById(String id) {
    	usuariosRepository.deleteById(id);
    }

    @Override
    public void delete(Usuario obj) {
    	usuariosRepository.delete(obj);
    }

    public Usuario findByUsername(String username){
        return usuariosRepository.findByUsername(username);
    }


}