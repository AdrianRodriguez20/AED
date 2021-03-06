package es.iespuertodelacruz.adrian.lapices.modelo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Lapiz {

	private int idlapiz;
	private String marca;
	private int numero;

	public Lapiz() {
		super();
	}

	public Lapiz(int idlapiz, String marca, int numero) {
		this.idlapiz = idlapiz;
		this.marca = marca;
		this.numero = numero;
	}
	

	public Lapiz(String marca, int numero) {
		this.marca = marca;
		this.numero = numero;
	}

	public int getIdlapiz() {
		return idlapiz;
	}

	public void setIdlapiz(int idlapiz) {
		this.idlapiz = idlapiz;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		String strLapiz=null;
		try {
			strLapiz = mapper
			.writerWithDefaultPrettyPrinter()
			.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return strLapiz;
	}

	
}
