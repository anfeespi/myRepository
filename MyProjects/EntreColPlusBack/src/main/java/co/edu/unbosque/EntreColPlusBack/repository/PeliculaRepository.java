package co.edu.unbosque.EntreColPlusBack.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.EntreColPlusBack.model.Pelicula;

public interface PeliculaRepository extends CrudRepository<Pelicula, Integer>{
	public List<Pelicula> findAll();
}
