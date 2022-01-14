package es.iespuertodelacruz.adrian.instituto.dto;

import es.iespuertodelacruz.adrian.instituto.entity.Usuario;

public class UsuarioListadoV2 {
	
	private String username;

	public UsuarioListadoV2() {
	
	}

	public UsuarioListadoV2(String username) {
		this.username = username;

	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UsuarioListadoV2 (Usuario u){
		this.username = u.getUsername();

	}

}
