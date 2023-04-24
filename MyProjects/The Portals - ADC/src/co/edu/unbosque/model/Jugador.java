package co.edu.unbosque.model;

/**
 * 
 * Clase referente al jugador
 * @author Andres Espitia
 * @author Camilo Uribe
 * @author Diego Forero
 *
 */
public class Jugador {
	/**
	 * Nombre del jugador
	 */
	private String nombre;
	/**
	 * Ficha que usa el jugador
	 */
	private Ficha ficha;
	
	/**
	 * Metodo constructor
	 */
	public Jugador() {
		nombre = "";
		ficha = new Ficha();
	}

	/**
	 * Metodo que devuelve el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que cambia el nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que devuelve la ficha
	 */
	public Ficha getFicha() {
		return ficha;
	}

	/**
	 * Metodo que cambia la ficha
	 */
	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}
	
	
	
}
