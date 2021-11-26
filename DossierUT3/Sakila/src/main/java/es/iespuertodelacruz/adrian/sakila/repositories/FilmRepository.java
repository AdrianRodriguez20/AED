package es.iespuertodelacruz.adrian.sakila.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

import es.iespuertodelacruz.adrian.sakila.entities.Film;
import es.iespuertodelacruz.adrian.sakila.entities.FilmActor;
import es.iespuertodelacruz.adrian.sakila.entities.FilmCategory;
import es.iespuertodelacruz.adrian.sakila.entities.Staff;


public class FilmRepository implements Crud<Film, Short> {

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
    public Film findById(Short id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Film film = null;
        try {
            film = em.createNamedQuery("Film.findByFilmId", Film.class).setParameter("filmId", id)
                    .getSingleResult();
        } catch (NoResultException nre) {
            //Ignore this because as per your logic this is ok!
        }


        em.getTransaction().commit();
        em.close();
        return film;
    }

    @Override
    public Film save(Film obj) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(obj);
        //list filmActor
        System.out.println("id" +obj.getFilmId());
       for( FilmActor actor : obj.getFilmActorList() ){
           actor.getFilmActorPK().setFilmId(obj.getFilmId());
           ;
        }
       for (FilmCategory category : obj.getFilmCategoryList()){
           category.getFilmCategoryPK().setFilmId(obj.getFilmId());
       }

        em.getTransaction().commit();
        em.close();

        return obj;
    }

    @Override
    public Film update(Film obj) {
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

        Film film = em.find(Film.class, id);
        em.remove(film);

        em.getTransaction().commit();
        em.close();
        return false;
    }

}
