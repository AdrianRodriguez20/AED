package es.iespuertodelacruz.adrian.instituto.controller;

import es.iespuertodelacruz.adrian.instituto.dto.UsuarioDTO;
import es.iespuertodelacruz.adrian.instituto.dto.UsuarioListadoV2;
import es.iespuertodelacruz.adrian.instituto.entity.Usuario;
import es.iespuertodelacruz.adrian.instituto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2/usuarios")
public class UsuarioControlV2REST {

    @Autowired
    private UsuarioService usuarioService;
    

	@GetMapping()
    public ArrayList<UsuarioListadoV2> getAll() {
        ArrayList<UsuarioListadoV2> usuarios = new ArrayList<UsuarioListadoV2>();

        	usuarioService.findAll().forEach(p -> {
                Usuario a = (Usuario) p;
                UsuarioListadoV2 uDTO = new UsuarioListadoV2(a);
                usuarios.add(uDTO);
            });

        return usuarios;
    }

    

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String username) {
 
        if (username.equals(SecurityContextHolder.getContext().getAuthentication().getName())) {
            Optional<Usuario> optA = usuarioService.findById(username);
            if (optA.isPresent()) {
                UsuarioDTO uDTO = new UsuarioDTO(optA.get());
                return ResponseEntity.ok().body(uDTO);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id del registro no existe");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No tienes permisos para ver este registro");
        }
    }

}
