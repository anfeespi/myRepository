package co.edu.unbosque.DressCode.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.DressCode.model.SaleDetail;
import java.util.List;


public interface SaleDetailRepository extends CrudRepository<SaleDetail, Integer>{
	public List<SaleDetail> findById_sale(Integer id_sale);
}
