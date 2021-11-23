package es.iespuertodelacruz.adrian.sakila.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import es.iespuertodelacruz.adrian.sakila.entities.Staff;

public class StaffRepository implements Crud<Staff, Integer> {

	private EntityManagerFactory emf;

	public StaffRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Staff> findAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Staff> lista = em.createNamedQuery("Staff.findAll", Staff.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return lista;
	}

	@Override
	public Staff findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Staff staff = em.find(Staff.class, id);
		em.getTransaction().commit();
		em.close();
		return staff;
	}

	public Staff findByUser(String username) {
		EntityManager em = emf.createEntityManager();
		Staff staff =null;
		em.getTransaction().begin();
		try {
			staff = em.createNamedQuery("Staff.findByUsername", Staff.class).setParameter("username",username)
					.getSingleResult();
		}catch (NoResultException nre){
				//Ignore this because as per your logic this is ok!
		}

		em.getTransaction().commit();
		em.close();
		return staff;
	}

	@Override
	public Staff save(Staff obj) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
		return null;
	}

	@Override
	public Staff update(Staff obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

}
