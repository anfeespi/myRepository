package co.edu.unbosque.model;

/**
 * Inicialización de los atributos de los portales (Tanto azules como rojos)
 * @author Diego Forero
 * @author Andrés Espitia
 * @author Camilo Uribe
 *
 */
public class Portal {
	/**
	 * Valor entero que indica las coordenadas de los portales en las columnas
	 */
	private int columna;
	/**
	 * Valor entero que indica las coordenadas de los portales en las filas
	 */
	private int fila;
	
	/**
	 * Metodo constructor
	 */
	public Portal() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo que devuelve las coordenadas de las columnas
	 * @return
	 */
	public int getColumna() {
		return columna;
	}

	/**
	 * Metodo que cambia las coordenadas de las columnas
	 * @param columna
	 */
	public void setColumna(int columna) {
		this.columna = columna;
	}

	/**
	 * Metodo que devuelve las coordenadas de las filas
	 * @return
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * Metodo que cambia las coordenadas de las filas
	 * @param fila
	 */
	public void setFila(int fila) {
		this.fila = fila;
	}
	
}
