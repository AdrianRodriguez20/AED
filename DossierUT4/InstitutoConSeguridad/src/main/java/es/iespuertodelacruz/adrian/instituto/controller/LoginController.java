package es.iespuertodelacruz.adrian.instituto.controller;

import es.iespuertodelacruz.adrian.instituto.entity.Usuario;
import es.iespuertodelacruz.adrian.instituto.service.UsuarioService;
import es.iespuertodelacruz.adrian.instituto.security.GestorDeJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class LoginController {
    private static final Logger logger =
            LoggerFactory.getLogger(LoginController.class);
    /* acepta request del tipo: form urlencode */
    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestParam("name") String
                                           username, @RequestParam("password") String pwd) {
        String token = getJWTToken(username,pwd);
//si token nulo es que usuario/pass no es válido
        if( token != null) {
            return ResponseEntity.ok(token);
        }else
            return
                    ResponseEntity.status(HttpStatus.FORBIDDEN).body("usuario/pass erróneos");
    }
    @Autowired
    UsuarioService usuarioService;
    private String getJWTToken(String username, String
            passTextoPlanoRecibida) {
        String respuesta = null;
        GestorDeJWT gestorDeJWT = GestorDeJWT.getInstance();
        Usuario usuario = usuarioService.findByUsername(username);

        String passwordUsuarioEnHash = "";

        passwordUsuarioEnHash = usuario.getPassword();
        boolean autenticado = BCrypt.checkpw(passTextoPlanoRecibida,
                passwordUsuarioEnHash);

        if(autenticado) {

            String rol = username+", "+usuario.getRol();
            logger.info("El rol obtenido es : " + rol);


            List<GrantedAuthority> grantedAuthorities =
                    AuthorityUtils
                            .commaSeparatedStringToAuthorityList(usuario.getRol());
            List<String> roles = grantedAuthorities.stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            System.out.println("Roles: " + roles);
            int duracionMinutos = 600;
            String token = gestorDeJWT.generarToken(username, roles,
                    duracionMinutos);
            respuesta = gestorDeJWT.BEARERPREFIX + token;
        }
        return respuesta;
    }
}