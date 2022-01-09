package es.iespuertodelacruz.juan.matriculas.dto;

import es.iespuertodelacruz.juan.matriculas.utils.ApiMessage;

public class ApiMessageDTO {

	private String message;
	
	public ApiMessageDTO() {
		
	}
	
	public ApiMessageDTO(ApiMessage am) {
		this.message = am.getMessage();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
