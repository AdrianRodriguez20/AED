package es.iespuertodelacruz.juan.matriculas.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

import es.iespuertodelacruz.juan.matriculas.utils.ApiError;

public class ApiErrorDTO {
	private HttpStatus status;
    private List<String> errors;
    
    public ApiErrorDTO() {
	}

	public ApiErrorDTO(ApiError ae) {
        super();
        this.status = ae.getStatus();
        this.errors = ae.getErrors();
    }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
    
   
}
