package co.edu.unbosque.model;

import java.util.Random;

/**
 * 
 * Inicialización de los atributos de los portales azules o que permiten avanzar en el tablero
 * @author Diego Forero
 * @author Andrés Espitia
 * @author Camilo Uribe
 *
 */
public class PortalAvanzar {
	/**
	 * Arreglo de tipo 'Portal' para los portales de entrada azules que se generan en el tablero
	 */
	private Portal[] portal_entrada;
	/**
	 * Arreglo de tipo 'Portal' para los portales de salida azules que se generan en el tablero
	 */
	private Portal[] portal_salida;
	/**
	 * Entero que indica la columna en que se ubican los portales azules
	 */
	private int columnas;
	/**
	 * Entero que indica la fila en la que se ubican los portales azules
	 */
	private int filas;
	
	/**
	 * Metodo constructor
	 * @param filas
	 * @param columnas
	 */
	public PortalAvanzar(int filas, int columnas) {
		this.columnas = columnas;
		this.filas = filas;
		portal_entrada = new Portal[filas-1];
		portal_salida = new Portal[filas-1];
		for (int i = 0; i < (filas-1); i++) {
			portal_entrada[i] = new Portal();
			portal_salida[i] = new Portal();
		}
		generarPortalesEntrada();
		generarPortalesSalida();
	}
	
	/**
	 * Metodo que genera los portales de entrada azules dentro del mapa
	 */
	public void generarPortalesEntrada() {
		int auxcol;
		for(int i = 0; i < portal_entrada.length; i++){
			do {
				auxcol = generarAleatorioColumna();
			} while (i == 0 && auxcol <= 2);
			portal_entrada[i].setFila(i);
			portal_entrada[i].setColumna(auxcol);
		}
	}
	
	/**
	 * Metodo que genera los portales de salida azules dentro del mapa con base en la longitud del arreglo antes creado
	 */
	public void generarPortalesSalida() {
		int auxcol;
		for (int i = 0; i < portal_entrada.length; i++) {
			do {
				auxcol = generarAleatorioColumna();
			} while (i == portal_entrada.length-1 && auxcol >= columnas-3 || comparar(i, auxcol));
			portal_salida[i].setColumna(auxcol);
			portal_salida[i].setFila(portal_entrada[i].getFila()+1);
		}		
	}
	
	/**
	 * Metodo que compara las coordenadas de los portales azules y si estan ocupados por otros
	 * @param i
	 * @param comp
	 * @return
	 */
	public boolean comparar(int i, int comp) {
		if(i<portal_entrada.length-1 && comp==portal_entrada[i+1].getColumna()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo para ubicar y generar de forma aleatoria los portales azules en las filas del mapa
	 * @return
	 */
	public int generarAleatorioFila() {
		Random random = new Random();

		return random.nextInt(filas);
	}
	
	/**
	 * Metodo para ubicar y generar, de igual forma, los portales azules en las columnas del mapa
	 * @return
	 */
	public int generarAleatorioColumna() {
		Random random = new Random();

		return random.nextInt(columnas);
	}
	
	/**
	 * Metodo para devolver la posicion de los portales de entrada azules
	 * @return
	 */
	public Portal[] getPortal_entrada() {
		return portal_entrada;
	}
	
	/**
	 * Metodo para cambiar la posicion los portales de entrada azules
	 * @param portal_entrada
	 */
	public void setPortal_entrada(Portal[] portal_entrada) {
		this.portal_entrada = portal_entrada;
	}
	
	/**
	 * Metodo para devolver la posicion los portales de salida azules
	 * @return
	 */
	public Portal[] getPortal_salida() {
		return portal_salida;
	}
	
	/**
	 * Metodo para cambiar la posicion los portales de salida azules
	 * @param portal_salida
	 */
	public void setPortal_salida(Portal[] portal_salida) {
		this.portal_salida = portal_salida;
	}
	
}