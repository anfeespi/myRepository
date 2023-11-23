package co.edu.unbosque.EntreColPlusBack.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.EntreColPlusBack.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{
	public List<Admin> findAll();
}
