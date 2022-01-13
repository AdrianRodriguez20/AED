package es.iespuertodelacruz.adrian.instituto.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ArrayList<UsuarioDTO> getAll(@RequestParam(required=false, name="nombre") String nombre) {
        ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
        if (nombre==null) {
        	usuarioService.findAll().forEach(p -> {
                Usuario a = (Usuario) p;
                UsuarioDTO uDTO = new UsuarioDTO();
                usuarios.add(uDTO);
            });
        }else {
 
        }

        return usuarios;
    }

}
