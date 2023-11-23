package co.edu.unbosque.EntreColPlusBack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_admin")
	private Integer id_admin;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "clave")
	private String clave;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer id_admin, String usuario, String clave) {
		super();
		this.id_admin = id_admin;
		this.usuario = usuario;
		this.clave = clave;
	}

	public Integer getId_admin() {
		return id_admin;
	}

	public void setId_admin(Integer id_admin) {
		this.id_admin = id_admin;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
}
