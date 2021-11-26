package es.iespuertodelacruz.adrian.sakila.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


import es.iespuertodelacruz.adrian.sakila.entities.Language;

public class LanguageRepository  implements Crud<Language, Short> {

	private EntityManagerFactory emf;

	public LanguageRepository(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public List<Language> findAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Language> lista = em.createNamedQuery("Language.findAll", Language.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return lista;
	}

	@Override
	public Language findById(Short id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Language save(Language obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Language update(Language obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Short id) {
		// TODO Auto-generated method stub
		return false;
	}
}
