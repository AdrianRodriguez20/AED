package es.iespuertodelacruz.adrian.instituto.dto;

import es.iespuertodelacruz.adrian.instituto.entity.Usuario;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class UsuarioDTO {

	private String username;
	private String rol;
	private String password;
	
	public UsuarioDTO() {
	
	}

	public UsuarioDTO(String username, String rol) {
		this.username = username;
		this.rol = rol;
	}

	public UsuarioDTO (Usuario u){
		this.username = u.getUsername();
		this.password = u.getPassword();
		this.rol = u.getRol();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Usuario toUsuario (){
		return new Usuario(username, BCrypt.hashpw(password, BCrypt.gensalt(10)), rol);
	}


	
	
	
	
	
	
}
