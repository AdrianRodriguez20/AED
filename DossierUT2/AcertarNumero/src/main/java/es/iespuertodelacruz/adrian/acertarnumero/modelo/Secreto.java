package es.iespuertodelacruz.adrian.acertarnumero.modelo;

import java.util.Date;

public class Secreto {

	private int num;
	private Date dateCreado;
	
	public Secreto() {
		super();
		this.num =(int)(Math.random()*10000+1);
		this.dateCreado = new Date();
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



	
	
}
