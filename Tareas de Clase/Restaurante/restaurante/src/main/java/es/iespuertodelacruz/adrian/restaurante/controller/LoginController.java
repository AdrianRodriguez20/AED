package es.iespuertodelacruz.adrian.restaurante.controller;

import es.iespuertodelacruz.adrian.restaurante.entity.Operario;
import es.iespuertodelacruz.adrian.restaurante.security.GestorDeJWT;
import es.iespuertodelacruz.adrian.restaurante.service.OperarioService;
import es.iespuertodelacruz.adrian.restaurante.utils.ApiError;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(value="API REST Login ")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    /*  funciona el form urlencode */
    @PostMapping(path = "/api/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<?> login(
            @RequestParam("nombre") String nombre, @RequestParam("password") String pwd) {


        String token = getJWTToken(nombre,pwd);

        //token nulo si usuario/pass no es válido
        if( token != null) {
            return ResponseEntity.ok(token);
        }else
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("usuario/pass erróneos");

    }


    static class OperarioJsonLogin{
        String name;
        String password;
        public String getName() { return name;};
        public String getPassword() {return password;};
        public void setName(String name ) {this.name = name;};
        public void setPassword(String password ) {this.password = password;};

    }

    /* json post */
    @PostMapping(path = "/api/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Login, devuelve un token con el rol del usuario y credenciales")
    public ResponseEntity<?> login(
            @ApiParam(value = "Usuario y contraseña" , required = true)
            @RequestBody OperarioJsonLogin usuarioJson) {


        String token = getJWTToken(usuarioJson.name, usuarioJson.password);

        //token nulo si usuario/pass no es válido
        if( token != null) {
            return ResponseEntity.ok(token);
        }else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "usuario/pass erróneos"));

    }

    @PostMapping(path = "/api/registro", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Registro de un nuevo usuario")
    public ResponseEntity<?> registro(
            @ApiParam(value = "Usuario y contraseña" , required = true)
            @RequestBody OperarioJsonLogin usuarioJson) {
        if (usuarioJson.name == null || usuarioJson.name.trim().isEmpty() || usuarioJson.password == null ||usuarioJson.password.trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiError(HttpStatus.BAD_REQUEST, "Usuario/pass vacios"));
        }
        if (operarioService.findByNombre(usuarioJson.name) != null) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiError(HttpStatus.FORBIDDEN, "Usuario ya existe"));
        }else{
            Operario operario = new Operario();
            operario.setNombre(usuarioJson.name);
            String enHash = BCrypt.hashpw(usuarioJson.password, BCrypt.gensalt(10));
            operario.setPassword(enHash);
            operario.setRol("ROLE_USER");
            operarioService.save(operario);
            if (operarioService.findByNombre(usuarioJson.name) != null) {
                return ResponseEntity.ok("Usuario registrado");
            }else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiError(HttpStatus.FORBIDDEN, "Usuario no registrado"));
            }
        }


    }

    @Autowired
    OperarioService operarioService;


    private String getJWTToken(String nombre, String passTextoPlanoRecibida) {

        String respuesta = null;

        GestorDeJWT gestorDeJWT = GestorDeJWT.getInstance();

        Operario operario = operarioService.findByNombre(nombre);


        String passwordUsuarioEnHash = "";
        boolean autenticado = false;

        if(operario != null) {
            passwordUsuarioEnHash = operario.getPassword();

            autenticado = BCrypt.checkpw(passTextoPlanoRecibida, passwordUsuarioEnHash);

        }



        if(autenticado) {


            String rol = operario.getRol();
            List<String> roles = new ArrayList<String>();
            roles.add(rol);
            logger.info("los roles obtenidos: " + roles);


            int duracionMinutos = 600;

            String token = gestorDeJWT.generarToken(nombre, roles, duracionMinutos);

            respuesta = gestorDeJWT.BEARERPREFIX + token;
        }

        return respuesta;

    }

}