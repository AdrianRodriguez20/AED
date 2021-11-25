package es.iespuertodelacruz.adrian.sakila.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import es.iespuertodelacruz.adrian.sakila.entities.Category;
import es.iespuertodelacruz.adrian.sakila.entities.Film;



public class CategoryRepository implements Crud<Category, Short> {

	private EntityManagerFactory emf;

	public CategoryRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Category> findAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Category> lista = em.createNamedQuery("Category.findAll", Category.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return lista;
	}

	@Override
	public Category findById(Short id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Category category =null;
		try {
			category  = em.createNamedQuery("Film.findByCategoryId", Category.class).setParameter("categoryId",id)
					.getSingleResult();
		}catch (NoResultException nre){
				//Ignore this because as per your logic this is ok!
		}


		em.getTransaction().commit();
		em.close();
		return category ;
	}

	@Override
	public Category save(Category obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category update(Category obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Short id) {
		// TODO Auto-generated method stub
		return false;
	}
}
