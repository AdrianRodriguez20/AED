package es.iespuertodelacruz.adrian.sakila.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.iespuertodelacruz.adrian.sakila.entities.Film;


public class FilmRepository implements Crud<Film, Integer> {

	private EntityManagerFactory emf;

	public FilmRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Film> findAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Film> lista = em.createNamedQuery("Film.findAll", Film.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return lista;
	}

	@Override
	public Film findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film save(Film obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film update(Film obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
