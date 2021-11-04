package es.iespuertodelacruz.adrian.instituto.dao;

import java.util.ArrayList;

import es.iespuertodelacruz.adrian.instituto.modelo.Matricula;

public class MatriculaDAO   implements Crud<Matricula, String> {
	
	GestorConexionDDBB gc;

	public MatriculaDAO(GestorConexionDDBB gc) {
		this.gc = gc;
	}

	public Matricula save(Matricula dao) {
		// TODO Auto-generated method stub
		return null;
	}

	public Matricula findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean update(Matricula dao) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<Matricula> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
