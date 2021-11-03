package es.iespuertodelacruz.adrian.acertarnumero.modelo;

import java.io.Serializable;
import java.util.Date;

public class Secreto implements Serializable {

	private int num;
	private Date dateCreado;
	private String ganador;
	private long tiempoEnAcertar;
	
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

	public String getGanador() {
		return ganador;
	}

	public void setGanador(String ganador) {
		this.ganador = ganador;
	}

	public long getTiempoEnAcertar() {
		return tiempoEnAcertar;
	}

	public void setTiempoEnAcertar(Date nuevoSecreto) {
		long diferenciaEn_ms = nuevoSecreto.getTime() - this.dateCreado.getTime();

		this.tiempoEnAcertar= diferenciaEn_ms /1000;

	}

	@Override
	public String toString() {
		return "Secreto [num=" + num + ", ganador=" + ganador + ", tiempoEnAcertar=" + tiempoEnAcertar + "]";
	}

	


	
	
}
