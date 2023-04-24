package co.edu.unbosque.model;

import java.util.Random;

/**
 * Inicialziación de los atributos de los portales rojos o que hacen retroceder en el tablero
 * @author Andres Espitia
 * @author Camilo Uribe
 * @author Diego Forero
 *
 */
public class PortalRetroceder {
	/**
	 * Arreglo de tipo 'Portal' para los portales de entrada rojos que se generan en el tablero
	 */
	private Portal[] portal_entrada;
	/**
	 * Arreglo de tipo 'Portal' para los portales de salida rojos que se generan en el tablero
	 */
	private Portal[] portal_salida;
	/**
	 * Entero que indica la columna en que se ubican los portales rojos
	 */
	private int columnas;
	/**
	 * Entero que indica la fila en la que se ubican los portales rojos
	 */
	private int filas;
	
	/**
	 * Metodo constructor
	 * @param filas
	 * @param columnas
	 * @param aux
	 */
	public PortalRetroceder(int filas, int columnas, PortalAvanzar aux) {
		this.columnas = columnas;
		this.filas = filas;
		portal_entrada = new Portal[filas-1];
		portal_salida = new Portal[filas-1];
		for (int i = 0; i < (filas-1); i++) {
			portal_entrada[i] = new Portal();
			portal_salida[i] = new Portal();
		}
		generarPortalesSalida(aux);
		generarPortalesEntrada(aux);
	}
	
	/**
	 * Metodo que genera los portales de salida rojos dentro del mapa con base en la la posición de los portales azules generados en el mapa
	 * @param aux
	 */
	public void generarPortalesSalida(PortalAvanzar aux) {
		int auxcol;
		for(int i = 0; i < portal_entrada.length; i++){
			do {
				auxcol = generarAleatorioColumna();
			} while ((i == 0 && auxcol < 1) || compararS(i, auxcol, aux));
			portal_salida[i].setFila(i);
			portal_salida[i].setColumna(auxcol);
		}
	}
	
	/**
	 * Metodo que compara la posicion de los portales de salida azules antes creados con los rojos a generar
	 * @param i
	 * @param comp
	 * @param aux
	 * @return
	 */
	public boolean compararS(int i, int comp, PortalAvanzar aux) {
		if(aux.getPortal_entrada()[i].getColumna() == comp) {
			return true;
		}
		if(i<portal_entrada.length-1 && aux.getPortal_salida()[i+1].getColumna() == comp) {
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo que genera los portales de entrada rojos
	 * @param aux
	 */
	public void generarPortalesEntrada(PortalAvanzar aux) {
		int auxcol;
		for (int i = 0; i < portal_entrada.length; i++) {
			do {
				auxcol = generarAleatorioColumna();
			} while (i == portal_entrada.length-1 && auxcol >= columnas-3 || compararE(i, auxcol, aux));
			portal_entrada[i].setColumna(auxcol);
			portal_entrada[i].setFila(i+1);
		}		
	}
	
	/**
	 * Metodo que compara la posicion de los portales de entrada azules antes creados con los rojos a generar
	 * @param i
	 * @param comp
	 * @param aux
	 * @return
	 */
	public boolean compararE(int i, int comp, PortalAvanzar aux) {
		if(aux.getPortal_salida()[i].getColumna() == comp) {
			return true;
		}
		if(i<portal_entrada.length-1 && (aux.getPortal_entrada()[i+1].getColumna() == comp || portal_salida[i+1].getColumna() == comp)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Metodo para ubicar y generar de forma aleatoria los portales rojos en las filas del mapa
	 * @return
	 */
	public int generarAleatorioFila() {
		Random random = new Random();

		return random.nextInt(filas);
	}
	
	/**
	 * Metodo para ubicar y generar, de igual forma, los portales rojos en las columnas del mapa
	 * @return
	 */
	public int generarAleatorioColumna() {
		Random random = new Random();

		return random.nextInt(columnas);
	}

	/**
	 * Metodo para devolver la posicion de los portales de entrada rojos
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