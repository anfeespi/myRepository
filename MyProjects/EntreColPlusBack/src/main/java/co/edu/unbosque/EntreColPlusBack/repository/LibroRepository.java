package co.edu.unbosque.EntreColPlusBack.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.EntreColPlusBack.model.Libro;

public interface LibroRepository extends CrudRepository<Libro, Integer>{
	public List<Libro> findAll();
}
