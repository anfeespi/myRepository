package co.edu.unbosque.model;

/**
 * 
 * Clase que guarda las partidas
 * @author Andres Espitia
 * @author Camilo Uribe
 * @author Diego Forero
 *
 */
public class Partida {
	/**
	 * Filas del tablero de la partida
	 */
	private int filas;
	/**
	 * Columnas del tablero de la partida
	 */
	private int columnas;
	/**
	 * Numero de jugadores de la partida
	 */
	private int njugadores;
	/**
	 * Jugadores de la partida
	 */
	private Jugador[] jugadores;
	
	/**
	 * Metodo constructor
	 */
	public Partida() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Metodo que devuelve el numero de jugadores
	 */
	public int getNjugadores() {
		return njugadores;
	}
	/**
	 * Metodo que cambia el numero de jugadores
	 */
	public void setNjugadores(int njugadores) {
		this.njugadores = njugadores;
	}
	/**
	 * Metodo que devuelve los jugadores
	 */
	public Jugador[] getJugadores() {
		return jugadores;
	}
	/**
	 * Metodo que cambia los jugadores
	 */
	public void setJugadores(Jugador[] jugadores) {
		this.jugadores = jugadores;
	}
	/**
	 * Metodo que devuelve las filas
	 */
	public int getFilas() {
		return filas;
	}
	/**
	 * Metodo que cambia las filas
	 */
	public void setFilas(int filas) {
		this.filas = filas;
	}
	/**
	 * Metodo que devuelve las columnas
	 */
	public int getColumnas() {
		return columnas;
	}
	/**
	 * Metodo que cambia las columnas
	 */
	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}
	
	
}