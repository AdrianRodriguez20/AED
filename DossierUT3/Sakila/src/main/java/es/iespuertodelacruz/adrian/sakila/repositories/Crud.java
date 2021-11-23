package es.iespuertodelacruz.adrian.sakila.repositories;

import java.util.List;

public interface Crud<T, E> {
	List<T> findAll();

	T findById(E id);

	T save(T obj);

	T update(T obj);

	boolean delete(E id);
}
