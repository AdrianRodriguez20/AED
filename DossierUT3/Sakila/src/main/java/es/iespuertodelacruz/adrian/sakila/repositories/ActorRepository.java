package es.iespuertodelacruz.adrian.sakila.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import es.iespuertodelacruz.adrian.sakila.entities.Actor;

public class ActorRepository  implements Crud<Actor, Short> {

	private EntityManagerFactory emf;

	public ActorRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Actor> findAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Actor> lista = em.createNamedQuery("Actor.findAll", Actor.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return lista;
	}

	@Override
	public Actor findById(Short id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Actor save(Actor obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Actor update(Actor obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Short id) {
		// TODO Auto-generated method stub
		return false;
	}

}
