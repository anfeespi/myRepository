package co.edu.unbosque.DressCode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "saledetail")
public class SaleDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_sale_detail;
	private Integer id_product;
	private Integer id_sale;
	private int quantity;
	private float unit_value;
	private float total_value;
	
	public SaleDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public SaleDetail(Integer id_product, Integer id_sale, int quantity, float unit_value, float total_value) {
		super();
		this.id_product = id_product;
		this.id_sale = id_sale;
		this.quantity = quantity;
		this.unit_value = unit_value;
		this.total_value = total_value;
	}



	public Integer getId_sale_detail() {
		return id_sale_detail;
	}
	public void setId_sale_detail(Integer id_sale_detail) {
		this.id_sale_detail = id_sale_detail;
	}
	public Integer getId_product() {
		return id_product;
	}
	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}
	public Integer getId_sale() {
		return id_sale;
	}
	public void setId_sale(Integer id_sale) {
		this.id_sale = id_sale;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getUnit_value() {
		return unit_value;
	}
	public void setUnit_value(float unit_value) {
		this.unit_value = unit_value;
	}
	public float getTotal_value() {
		return total_value;
	}
	public void setTotal_value(float total_value) {
		this.total_value = total_value;
	}
}
