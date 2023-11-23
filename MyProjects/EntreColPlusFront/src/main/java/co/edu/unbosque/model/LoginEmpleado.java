package co.edu.unbosque.model;

public class LoginEmpleado {
	private Integer id_usuario;
	private String usuario;
	private String clave;
	private String nombre;
	private Integer id_empleado;
	
	public LoginEmpleado() {
		// TODO Auto-generated constructor stub
	}

	public LoginEmpleado(Integer id_usuario, String usuario, String clave, String nombre, Integer id_empleado) {
		super();
		this.id_usuario = id_usuario;
		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.id_empleado = id_empleado;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(Integer id_empleado) {
		this.id_empleado = id_empleado;
	}
	
	
}
