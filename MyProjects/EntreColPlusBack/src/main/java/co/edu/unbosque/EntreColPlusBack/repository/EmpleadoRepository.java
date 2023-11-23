package co.edu.unbosque.EntreColPlusBack.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.EntreColPlusBack.model.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Integer>{
	public List<Empleado> findAll();
}
