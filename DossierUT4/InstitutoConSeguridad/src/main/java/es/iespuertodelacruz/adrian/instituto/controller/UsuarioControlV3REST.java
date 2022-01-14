package es.iespuertodelacruz.adrian.instituto.controller;

import java.util.ArrayList;
import java.util.Optional;

import es.iespuertodelacruz.adrian.instituto.dto.AlumnoDTO;
import es.iespuertodelacruz.adrian.instituto.entity.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import es.iespuertodelacruz.adrian.instituto.dto.ListadoAlumnosV1DTO;
import es.iespuertodelacruz.adrian.instituto.dto.UsuarioDTO;
import es.iespuertodelacruz.adrian.instituto.entity.Usuario;
import es.iespuertodelacruz.adrian.instituto.service.UsuarioService;

@RestController
@RequestMapping("/api/v3/usuarios")
public class UsuarioControlV3REST {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping()
    public ArrayList<UsuarioDTO> getAll(@RequestParam(required=false, name="username") String username) {
        ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();

        	usuarioService.findAll().forEach(p -> {
                Usuario a = (Usuario) p;
                UsuarioDTO uDTO = new UsuarioDTO(a);
                usuarios.add(uDTO);
            });

        return usuarios;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String username) {
        Optional<Usuario> optA = usuarioService.findById(username);
        if (optA.isPresent()) {
            UsuarioDTO uDTO = new UsuarioDTO(optA.get());
            return ResponseEntity.ok().body(uDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id del registro no existe");
        }

    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Usuario a) {
        Optional<Usuario> optA = usuarioService.findById(a.getUsername());
        if (!optA.isPresent()) {
            UsuarioDTO aDTO = new UsuarioDTO(a);
            usuarioService.save(aDTO.toUsuario());
            return ResponseEntity.ok().body(aDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario ya existe");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String username) {
        Optional<Usuario> optA = usuarioService.findById(username);
        if (optA.isPresent()) {
            usuarioService.deleteById(username);
            return ResponseEntity.ok("Usuario borrado");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El id del registro no existe");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") String username, @RequestBody Usuario u) {
        Optional<Usuario> optA = usuarioService.findById(username);
        if (optA.isPresent()) {
            UsuarioDTO uDTO = new UsuarioDTO(u);
            usuarioService.save(uDTO.toUsuario());
            return ResponseEntity.ok(uDTO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("el id del registro no existe");
        }
    }



}
