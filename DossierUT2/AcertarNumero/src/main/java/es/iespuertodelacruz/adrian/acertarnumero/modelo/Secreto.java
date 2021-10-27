package es.iespuertodelacruz.adrian.acertarnumero.modelo;

import java.util.Date;

public class Secreto {

	private int num;
	private Date dateCreado;
	private String ganador;
	
	public Secreto() {
		super();
		this.num =(int)(Math.random()*10000+1);
		this.dateCreado = new Date();
		this.ganador=null;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getDateCreado() {
		return dateCreado;
	}

	public void setDateCreado(Date dateCreado) {
		this.dateCreado = dateCreado;
	}

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

	


	
	
}
