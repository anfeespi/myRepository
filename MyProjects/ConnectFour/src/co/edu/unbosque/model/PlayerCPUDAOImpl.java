package co.edu.unbosque.model;
/**
 * Clase que implementa los metodos propios del jugador CPU
 * @author Diego Forero
 * @author Andres Espitia
 * @author Camilo Uribe
 *
 */
public class PlayerCPUDAOImpl implements PlayerDAO{
	/**
	 * 
	 */
	private PlayerCPUDTO cpu;
	/**
	 * Clase que contiene los atributos o caracteristicas del tablero
	 */
	private BoardDTO board;
	/**
	 * Clase que implementa los metodos propios para el tablero de juego
	 */
	private BoardDAOImpl board_actions;

	/**
	 * Metodo constructor
	 */
	public PlayerCPUDAOImpl(){
		board = new BoardDTO();
		board_actions = new BoardDAOImpl();
		board_actions.createBoard();
	}
	/**
	 * Metodo que crea el jugador asignandole un nombre y un lado de la batalla
	 */
	@Override
	public void createPlayer(String name, String team) {
		cpu = new PlayerCPUDTO("CPU", team);
	}
	/**
	 * Metodo que asigna el equipo al que pertenece el jugador y monitorea los movimientos en el tablero
	 */
	@Override
	public boolean[] play(int column, String player_name) {
		boolean[] cond = new boolean[2];
		cond[0] = false;
		cond[1] = false;
		int team = 0;
		if (cpu.getTeam().equals("Autobots")) {
			team = 1;
		} else if (cpu.getTeam().equals("Decepticons")) {
			team = 2;
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
	 * Metodo que asigna el equipo al que pertenece la CPU y monitorea sus movimientos en el tablero
	 * @return
	 */
	public boolean[] compare(){
		int column = 0;
		int cont[] = new int[8];

		int team = 0;
		if (cpu.getTeam().equals("Autobots")) {
			team = 1;
		} else if (cpu.getTeam().equals("Decepticons")) {
			team = 2;
		}

		for (int j = 0; j < 8; j++) {
			int contaux = 0;
			int pos = 0;
			for(int i=0; i<7; i++) {
				if(board.getMatrix()[i][j]!=0) {
					pos = i-1;
					break;
				}
				else if(i==6 && board.getMatrix()[i][j]==0) {
					pos = i;
					break;
				}
			}
			if(pos < 0) {
				cont[j] = 0;
				break;
			}else{
				if(j-1>0 && board.getMatrix()[pos][j-1] == team) {
					contaux++;
				}
				if(pos+1 < 7 && board.getMatrix()[pos+1][j] == team) {
					contaux++;
				}
				if(j+1<8 && board.getMatrix()[pos][j+1] == team) {
					contaux++;
				}
				if(j-1>0 && pos+1 < 7 && board.getMatrix()[pos+1][j-1] == team) {
					contaux++;
				}
				if(j+1<8 && pos+1 < 7 && board.getMatrix()[pos+1][j+1] == team) {
					contaux++;
				}
			}

			cont[j] = contaux;
		}

		int top = 0;
		for(int i=0; i<cont.length; i++){
			if(cont[i]>top){
				column = i;
				top = cont[i];
			}else if(cont[i]==top){
				column = (int)(Math.random()*(7));
			}
		}

		return play(column, "CPU");
	}

}
