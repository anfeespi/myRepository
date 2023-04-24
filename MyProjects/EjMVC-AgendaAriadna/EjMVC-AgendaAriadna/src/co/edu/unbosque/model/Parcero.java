package co.edu.unbosque.model;

public class Parcero {

	private String nombre;
	private long ntelefono;
	
	public Parcero() {
		nombre = "";
		ntelefono = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getNtelefono() {
		return ntelefono;
	}

	public void setNtelefono(long ntelefono) {
		this.ntelefono = ntelefono;
	}

	@Override
	public String toString() {
		return "Nombre= " + nombre + "\n" +
	           "Telefono= " + ntelefono + "\n";
	}
	
}
