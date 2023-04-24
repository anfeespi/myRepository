package co.edu.unbosque.model;

/**
 * 
 * Clase de tipo gato que guarda valores para el animal respectivo
 * @author Andrés Espitia
 * @author Diego Forero
 *
 */
public class Gato {
	/**
	 * Edad del gato
	 */
	private int edad;
	/**
	 * Nombre del gato
	 */
	private String nombre;
	/**
	 * Raza del gato
	 */
	private String raza;

	/**
	 * Metodo Constructor
	 */
	public Gato() {
		edad = 0;
		nombre = "";
		raza = "";
	}
	
	/**
	 * Metodo constructor
	 * @param edad del gato
	 * @param nombre del gato
	 * @param raza del gato
	 */
	public Gato(int edad, String nombre, String raza) {
		super();
		this.edad = edad;
		this.nombre = nombre;
		this.raza = raza;
	}

	/**
	 * Metodo para devolver la edad
	 * @return edad del gato
	 */
	public int getEdad() {
		return edad;
	}
	
	/**
	 * Metodo para cambiar la edad del gato
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Metodo para devolver el nombre
	 * @return nombre del gato
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo para cambiar el nombre del gato
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo para devolver la raza del gato
	 * @return raza del gato
	 */
	public String getRaza() {
		return raza;
	}

	/**
	 * Metodo para cambiar la raza del gato
	 * @param raza
	 */
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	
}
