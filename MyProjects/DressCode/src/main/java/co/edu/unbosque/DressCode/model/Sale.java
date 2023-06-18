package co.edu.unbosque.DressCode.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sale")
public class Sale {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_sale;
	private String customer_document;
	private float total;
	private float iva;
	private float total_iva;
	
	public Sale() {
		// TODO Auto-generated constructor stub
	}
	
	public Sale(String customer_document, float total, float iva, float total_iva) {
		super();
		this.customer_document = customer_document;
		this.total = total;
		this.iva = iva;
		this.total_iva = total_iva;
	}



	public Integer getId_sale() {
		return id_sale;
	}
	public void setId_sale(Integer id_sale) {
		this.id_sale = id_sale;
	}
	public String getCustomer_document() {
		return customer_document;
	}
	public void setCustomer_document(String customer_document) {
		this.customer_document = customer_document;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getIva() {
		return iva;
	}
	public void setIva(float iva) {
		this.iva = iva;
	}
	public float getTotal_iva() {
		return total_iva;
	}
	public void setTotal_iva(float total_iva) {
		this.total_iva = total_iva;
	}
}
