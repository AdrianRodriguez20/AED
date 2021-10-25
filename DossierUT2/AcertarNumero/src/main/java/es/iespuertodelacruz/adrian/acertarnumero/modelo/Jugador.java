package es.iespuertodelacruz.adrian.acertarnumero.modelo;

import java.util.ArrayList;

public class Jugador {

	String nick;
	ArrayList<Integer> listaApuestas;
	
	
	
	public Jugador() {
		super();
	}


	public Jugador(String nick) {
		this.nick = nick;
		this.listaApuestas=new ArrayList<Integer>();
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public ArrayList<Integer> getListaApuestas() {
		return listaApuestas;
	}


	public void setListaApuestas(ArrayList<Integer> listaApuestas) {
		this.listaApuestas = listaApuestas;
	}
	
	public void clearListaApuestas() {
		this.listaApuestas.clear();
	}
	
	
}
