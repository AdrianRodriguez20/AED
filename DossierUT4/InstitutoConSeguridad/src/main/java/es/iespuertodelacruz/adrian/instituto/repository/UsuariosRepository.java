package es.iespuertodelacruz.adrian.instituto.repository;

import es.iespuertodelacruz.adrian.instituto.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuariosRepository extends JpaRepository<Usuario,Integer>{

@Query("select u from Usuario u where u.username = ?1")
Usuario findByUsername(String username);


}
