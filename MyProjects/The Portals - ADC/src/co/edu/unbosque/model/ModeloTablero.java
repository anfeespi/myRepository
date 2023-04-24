package co.edu.unbosque.model;

/**
 * 
 * Clase que crea un modelo de tablero para mover la ficha
 * @author Andres Espitia
 * @author Camilo Uribe
 * @author Diego Forero
 *
 */
public class ModeloTablero {
	/**
	 * Matriz de casillas
	 */
	private int[][] casillas;
	/**
	 * Columnas del tablero
	 */
	private int columnas;
	/**
	 * Filas del tablero
	 */
	private int filas;
	/**
	 * Columna que ocupa el objeto que usa el modelo de tablero
	 */
	private int i;
	/**
	 * Fila que ocupa el objeto que usa el modelo de tablero
	 */
	private int j;
	/**
	 * Variable que dice si el objeto llegó al final del tablero
	 */
	private boolean final_tablero;
	
	/**
	 * Metodo constructor
	 */
	public ModeloTablero(int filas, int columnas) {
		this.columnas = columnas;
		this.filas = filas;
		casillas = new int[this.filas][this.columnas];
		i = 0;
		j = 0;
		final_tablero = false;
		init();
	}
	
	/**
	 * Metodo para inicializar las casillas
	 */
	public void init() {
		int aux = 1;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				casillas[i][j] = aux;
				aux++;
			}
		}
	}
	
	/**
	 * Metodo para mover la ficha por el tablero segun el numero del dado
	 */
	public void moverFicha(int dado_numero) {
		for (int i = 0; i < dado_numero; i++) {
			if(this.j+1 < filas) {
				this.j++;
			} else if((this.i+1) < columnas){
				this.i++;
				this.j = 0;
			} else {
				final_tablero = true;
				break;
			}
			if (this.j >= columnas-1 && this.i >= filas-1) {
				final_tablero = true;
				break;
			}
		}
	}

	/**
	 * Metodo que devuelve la fila en la que está el objeto
	 */
	public int getI() {
		return i;
	}

	/**
	 * Metodo que cambia la fila en la que está el objeto
	 */
	public void setI(int i) {
		this.i = i;
	}

	/**
	 * Metodo que devuelve la columna en la que está el objeto
	 */
	public int getJ() {
		return j;
	}

	/**
	 * Metodo que cambia la columna en la que está el tablero
	 */
	public void setJ(int j) {
		this.j = j;
	}

	/**
	 * Metodo que dice si está al final del tablero
	 */
	public boolean isFinal_tablero() {
		return final_tablero;
	}

	/**
	 * Metodo que cambia si está al final del tablero
	 */
	public void setFinal_tablero(boolean final_tablero) {
		this.final_tablero = final_tablero;
	}
	
	
}
