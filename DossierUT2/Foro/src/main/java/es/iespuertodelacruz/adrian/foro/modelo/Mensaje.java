package es.iespuertodelacruz.adrian.foro.modelo;

public class Mensaje {

	private String remitente;
	private String contenido;
	
	public Mensaje() {
	
	}

	public Mensaje(String remitente, String contenido) {
		super();
		this.remitente = remitente;
		this.contenido = contenido;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return  remitente + " : " + contenido;
	}
	
	
	
}
