package co.edu.unbosque.model;
/**
 * Interface que contiene los metodos propios que aplican a las rondas o partidas de juego
 * @author Diego Forero
 * @author Andres Espitia
 * @author Camilo Uribe
 *
 */
public interface RoundDAO {
	/**
	 * Metodo que crea y registra la partida que se juega o jugo
	 * @param winner Ganador de la partida
	 * @param pieces Piezas que se movieron para que hubiera un ganador
	 * @param date Fecha del dia en que se jugo la partida
	 * @param team Equipo al que pertenece el ganador
	 */
	public void createRound(String winner, int pieces, String date, String team);
}
