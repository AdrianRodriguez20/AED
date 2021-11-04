package es.iespuertodelacruz.adrian.lapices;

import es.iespuertodelacruz.adrian.lapices.dao.GestorConexionDDBB;
import es.iespuertodelacruz.adrian.lapices.dao.LapizDAO;
import es.iespuertodelacruz.adrian.lapices.modelo.Lapiz;

public class Main {
	
	public static void main(String[] args) {
		
		GestorConexionDDBB gc = new GestorConexionDDBB("oficina","root","");
		
		LapizDAO  lapizDAO = new LapizDAO(gc);
		
		System.out.println("M�todo save()");
		
		
		System.out.println("M�todo findAll()");
		
		for(Lapiz lapiz :lapizDAO.findAll()) {
			System.out.println(lapiz);
		}
		
		System.out.println("M�todo delete()");
		lapizDAO.delete("2");
		
		
		System.out.println("M�todo findById()");
		System.out.println(lapizDAO.findById("1"));
		
		System.out.println("M�todo findByMarca()");
		for(Lapiz lapiz : lapizDAO.findByMarca("alpino")) {
			System.out.println(lapiz);
		}

		System.out.println("M�todo update()");
		lapizDAO.update(new Lapiz ( 1, "Auchan",2));
	}
	
}
