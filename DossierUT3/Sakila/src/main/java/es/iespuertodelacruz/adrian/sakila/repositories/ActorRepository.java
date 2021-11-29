package es.iespuertodelacruz.adrian.sakila.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import es.iespuertodelacruz.adrian.sakila.entities.Actor;
import es.iespuertodelacruz.adrian.sakila.entities.Category;
import es.iespuertodelacruz.adrian.sakila.servlets.Categoria;

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
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Actor actor =null;
		try {
			actor  = em.createNamedQuery("Actor.findByActorId", Actor.class).setParameter("actorId",id)
					.getSingleResult();
		}catch (NoResultException nre){
				//Ignore this because as per your logic this is ok!
		}


		em.getTransaction().commit();
		em.close();
		return actor ;
	}

	@Override
	public Actor save(Actor obj) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
		return null;
	}

	@Override
	public Actor update(Actor obj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();
        return null;
	}

	@Override
	public boolean delete(Short id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Actor actor = em.find(Actor.class, id);
        em.remove(actor);
        em.getTransaction().commit();
        em.close();
        return false;
	}

}
