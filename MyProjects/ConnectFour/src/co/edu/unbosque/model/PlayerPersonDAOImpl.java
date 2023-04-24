package co.edu.unbosque.model;

import java.util.ArrayList;

import co.edu.unbosque.util.NameException;
/**
 * Clase que implementa los metodos propios de la clase Jugador
 * @author Diego Forero
 * @author Andres Espitia
 * @author Camilo Uribe
 *
 */
public class PlayerPersonDAOImpl implements PlayerDAO{
	/**
	 * Clase que contiene los atributos o caracteristicas del jugador
	 */
	private PlayerPersonDTO person;
	/**
	 * Clase que contiene los atributos o caracteristicas del tablero
	 */
	private BoardDTO board;
	/**
	 * Clase que implementa los m�todos propios para el tablero de juego
	 */
	private BoardDAOImpl board_actions;
	/**
	 * Arreglo de jugadores
	 */
	private static ArrayList<PlayerPersonDTO> plyr_list;
	/**
	 * Metodo constructor
	 */
	public PlayerPersonDAOImpl() {
		board = new BoardDTO();
		board_actions = new BoardDAOImpl();
		board_actions.createBoard();
		plyr_list = new ArrayList<>();
	}
	/**
	 * Metodo que crea el jugado
	 */
	@Override
	public void createPlayer(String name, String team) {
		try {
			if (name.length() > 20) {
				throw new NameException("The name is too long!");
			} else {				
				person = new PlayerPersonDTO(name, team);
				PlayerPersonDAOImpl.plyr_list.add(person);
			}
		} catch (NameException e) {
			e.getMessage();
		}
	}
	/**
	 * Metodo que asigna el equipo al que pertenece el jugador y monitorea los movimientos en el tablero
	 * @param colum Columna en la que pone la ficha
	 * @param player_name Nombre del jugador
	 * @return Retorna un booleano
	 */
	@Override
	public boolean[] play(int column, String player_name) {
		boolean[] cond = new boolean[2];
		cond[0] = false;
		cond[1] = false;
		int team = 0;
		for (PlayerPersonDTO player : plyr_list) {			
			if (player.getName().equals(player_name) && player.getTeam().equals("Autobots")) {
				team = 1;
			} else if (player.getName().equals(player_name) && player.getTeam().equals("Decepticons")) {
				team = 2;
			}
		}
		for (int i = board.getMatrix().length-1; i >= 0 ; i--) {
			if (board.getMatrix()[i][column] == 0) {
				board_actions.fillBoard(team, i, column);
				cond[1] = board_actions.win(i, column);
				cond[0] = true;
				break;
			} else {
				cond[0] = false;
			}
		}
		return cond;
	}

	/**
	 * @return the plyr_list
	 */
	public static ArrayList<PlayerPersonDTO> getPlyr_list() {
		return plyr_list;
	}

	/**
	 * @param plyr_list the plyr_list to set
	 */
	public static void setPlyr_list(ArrayList<PlayerPersonDTO> plyr_list) {
		PlayerPersonDAOImpl.plyr_list = plyr_list;
	}

}
