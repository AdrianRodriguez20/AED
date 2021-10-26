package es.iespuertodelacruz.adrian.acertarnumero.modelo;

import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;

public class Jugador {

	private String nick;
	private TreeMap<Date, Integer> listaApuestas = new TreeMap<Date, Integer>();

	public Jugador() {
		super();
	}

	public Jugador(String nick) {
		this.nick = nick;
		this.listaApuestas = new TreeMap<Date, Integer>();
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public TreeMap<Date, Integer> getListaApuestas() {
		return listaApuestas;
	}

	public void setListaApuestas(TreeMap<Date, Integer> listaApuestas) {
		this.listaApuestas = listaApuestas;
	}

	public void clearListaApuestas(Date dateGanadora) {

		for (Iterator<Date> iterator = listaApuestas.keySet().iterator(); iterator.hasNext();) {
			Date key = iterator.next();
			if (key.before(dateGanadora) || key.equals(dateGanadora)) {
				iterator.remove();
			}

		}

	}
	

}
