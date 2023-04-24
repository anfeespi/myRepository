package co.edu.unbosque.model;

public class Encargo {
	int nit_cliente;
	int tipo_servicio;
	String direccion;
	//1 Sur 2 Norte 3 Oriente 4 Occidente
	int sector;
	
	public Encargo() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param nit_cliente
	 * @param tipo_servicio
	 * @param direccion
	 * @param sector
	 */
	public Encargo(int nit_cliente, int tipo_servicio, String direccion, int sector) {
		super();
		this.nit_cliente = nit_cliente;
		this.tipo_servicio = tipo_servicio;
		this.direccion = direccion;
		this.sector = sector;
	}
	/**
	 * @return the nit_cliente
	 */
	public int getNit_cliente() {
		return nit_cliente;
	}
	/**
	 * @param nit_cliente the nit_cliente to set
	 */
	public void setNit_cliente(int nit_cliente) {
		this.nit_cliente = nit_cliente;
	}
	/**
	 * @return the tipo_servicio
	 */
	public int getTipo_servicio() {
		return tipo_servicio;
	}
	/**
	 * @param tipo_servicio the tipo_servicio to set
	 */
	public void setTipo_servicio(int tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the sector
	 */
	public int getSector() {
		return sector;
	}
	/**
	 * @param sector the sector to set
	 */
	public void setSector(int sector) {
		this.sector = sector;
	}

	@Override
	public String toString() {
		return "[nit_cliente=" + nit_cliente + ", tipo_servicio=" + tipo_servicio + ", direccion=" + direccion
				+ ", sector=" + sector + "]";
	}
	
	
	
}
