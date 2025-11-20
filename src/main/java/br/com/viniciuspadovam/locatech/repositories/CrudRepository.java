package br.com.viniciuspadovam.locatech.repositories;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {

	Optional<T> findById(long id);
	List<T> findAll(int size, int offset);
	Integer save(T toSave);
	Integer update(long id, T toUpdate);
	Integer delete(long id);
	
}
