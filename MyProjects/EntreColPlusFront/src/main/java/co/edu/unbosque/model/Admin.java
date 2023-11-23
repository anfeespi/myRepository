package co.edu.unbosque.model;

public class Admin {
	private Integer id_admin;
	private String usuario;
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
