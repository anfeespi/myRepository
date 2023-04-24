package co.edu.unbosque.model;

/**
 * 
 * Clase referente a las fichas del juego
 * @author Andres Espitia
 * @author Camilo Uribe
 * @author Diego Forero
 *
 */
public class Ficha {
	/**
	 * Nombre del personaje que se usa
	 */
	private String personaje;
	/**
	 * Posición en las filas del personaje
	 */
	private int i; 
	/**
	 * Posición en las columnas del personaje
	 */
	private int j;
	/**
	 * Modelo del tablero de la ficha
	 */ 
	private ModeloTablero mt;
	
	/**
	 * Metodo constructor
	 */
	public Ficha() {
		personaje = "";
		i = 0;
		j = 0;
	}
	
	/**
	 * Metodo para crear un modelo de tablero
	 */
	public void crearTablero(int filas, int columnas) {
		mt = new ModeloTablero(filas, columnas);
	}

	/**
	 * Metodo que devuelve el nombre de personaje
	 */
	public String getPersonaje() {
		return personaje;
	}

	/**
	 * Metodo que cambia el nombre del personaje
	 */
	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}

	/**
	 * Metodo para devolver la fila
	 */
	public int getI() {
		return i;
	}

	/**
	 * Metodo para cambiar la fila
	 */
	public void setI(int i) {
		this.i = i;
	}

	/**
	 * Metodo para devolver la columna
	 */
	public int getJ() {
		return j;
	}

	/**
	 * Metodo para cambiar la columna
	 */
	public void setJ(int j) {
		this.j = j;
	}

	/**
	 * Metodo para devolver el modelo de tablero
	 */
	public ModeloTablero getMt() {
		return mt;
	}

	/**
	 * Metodo para cambiar el modelo de tablero
	 */
	public void setMt(ModeloTablero mt) {
		this.mt = mt;
	}
	
	
	
}
