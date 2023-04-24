package co.edu.unbosque.model;
/**
 * 
 * Clase de tipo Perro que guarda valores para el animal respectivo
 * @author Andrés Espitia
 * @author Diego Forero
 *
 */
public class Perro {
	/**
	 * Edad del perro
	 */
	private int edad;
	/**
	 * Nombre del perro
	 */
	private String nombre;
	/**
	 * Raza del perro
	 */
	private String raza;

	/**
	 * Metodo constructor
	 */
	public Perro() {
		edad = 0;
		nombre = "";
		raza = "";
	}

	/**
	 * Metodo constructor
	 * @param edad del perro
	 * @param nombre del perro
	 * @param raza del perro
	 */
	public Perro(int edad, String nombre, String raza) {
		super();
		this.edad = edad;
		this.nombre = nombre;
		this.raza = raza;
	}
	
	/**
	 * Metodo que devuelve la edad del perro
	 * @return edad del perro
	 */
	public int getEdad() {
		return edad;
	}
	
	/**
	 * Metodo que cambia la edad del perro
	 * @param edad
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * Metodo que devuelve el nombre del perro
	 * @return nombre del perro
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que cambia el nombre del perro
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que devuelve la raza del perro
	 * @return raza del perro
	 */
	public String getRaza() {
		return raza;
	}

	/**
	 * Metodo que cambia la raza del perro
	 * @param raza
	 */
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	
}
