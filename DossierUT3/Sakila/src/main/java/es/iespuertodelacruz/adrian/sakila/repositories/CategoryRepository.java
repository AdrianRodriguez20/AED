package es.iespuertodelacruz.adrian.sakila.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import es.iespuertodelacruz.adrian.sakila.entities.Category;
import es.iespuertodelacruz.adrian.sakila.entities.Film;
import es.iespuertodelacruz.adrian.sakila.servlets.Categoria;



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
			category  = em.createNamedQuery("Category.findByCategoryId", Category.class).setParameter("categoryId",id)
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
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
		return null;
	}

	@Override
	public Category update(Category obj) {
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
        Category categoria = em.find(Category.class, id);
        em.remove(categoria);
        em.getTransaction().commit();
        em.close();
        return false;
	}
}
