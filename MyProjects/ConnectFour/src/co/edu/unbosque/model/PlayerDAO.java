package co.edu.unbosque.model;
/**
 * Interface que contiene los metodos propios del jugador
 * @author Diego Forero
 * @author Andres Espitia
 * @author Camilo Uribe
 *
 */
public interface PlayerDAO {
	/**
	 * Metodo que crea el jugador
	 * @param name Nombre del jugador
	 * @param team Equipo al que pertenece el jugador
	 */
	public void createPlayer(String name, String team);
	/**
	 * Metodo que asigna el equipo al que pertenece el jugador y monitorea los movimientos en el tablero
	 * @param colum Columna en la que pone la ficha
	 * @param player_name Nombre del jugador
	 * @return Retorna un booleano
	 */
	public boolean[] play(int colum, String player_name);
}
