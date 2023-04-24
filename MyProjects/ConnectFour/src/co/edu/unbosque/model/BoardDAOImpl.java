package co.edu.unbosque.model;
/**
 * Clase que implementa los metodos propios para el tablero de juego
 * @author Diego Forero
 * @author Andres Espitia
 * @author Camilo Uribe
 *
 */
public class BoardDAOImpl implements BoardDAO {
	/**
	 * Clase que contiene los atributos o caracteristicas del tablero
	 */
	private BoardDTO board;
	/**
	 * Matriz que crea el tablero de juego
	 */
	private static int[][] auxmatrix;
	/**
	 * Direcciones en las que es posible ganar
	 */
	private int right, left, up, down, diag1, diag2, diag3, diag4;
	/**
	 * Metodo constructor
	 */
	public BoardDAOImpl() {
		board = new BoardDTO();
		auxmatrix = new int[7][8];
	}
	/**
	 * Metodo que crea el tablero de juego
	 */
	@Override
	public void createBoard() {
		for (int i = 0; i < auxmatrix.length; i++) {
			for (int j = 0; j < auxmatrix[i].length; j++) {
				auxmatrix[i][j] = 0;
			}
		}
		board.setMatrix(auxmatrix);
	}
	/**
	 * Metodo que llena y pone las fichas
	 * @param team Equipo al que pertenece el jugador
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	@Override
	public void fillBoard(int team, int row, int column) {
		auxmatrix[row][column] = team;
		board.setMatrix(auxmatrix);
	}
	/**
	 * Metodo que revisa la direccion en la que gana el jugador
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 * @return Retorna un booleano
	 */
	@Override
	public boolean win(int row, int column) {
		right = 0; 
		left = 0; 
		up = 0; 
		down = 0;
		diag1 = 0;
		diag2 = 0;
		diag3 = 0;
		diag4 = 0;
		winHorRight(row, column);
		winHorLeft(row, column);
		if (right == 3 || left == 3 || (right + left) == 3) {
			return true;
		}
		winVerUp(row, column);
		winVerDown(row, column);
		if (up == 3 || down == 3 || (up + down) == 3) {
			return true;
		}
		winDiag1(row, column);
		winDiag2(row, column);
		if (diag1 == 3 || diag2 == 3 || (diag1 + diag2) == 3) {
			return true;
		}
		winDiag3(row, column);
		winDiag4(row, column);
		if (diag3 == 3 || diag4 == 3 || (diag3 + diag4) == 3) {
			return true;
		}
		return false;
	}
	/**
	 * Metodo que revisa y registra si gano de forma horizontal hacia la derecha
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	@Override
	public void winHorRight(int row, int column) {
		if (column+1 < 8 && board.getMatrix()[row][column] == board.getMatrix()[row][column+1]) {
			right++;
			winHorRight(row, column+1);
		}
	}
	/**
	 * Metodo que revisa y registra si gano de forma horizontal hacia la derecha
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	@Override
	public void winHorLeft(int row, int column) {
		if (column-1 >= 0 && board.getMatrix()[row][column] == board.getMatrix()[row][column-1]) {
			left++;
			winHorLeft(row, column-1);
		}
	}
	/**
	 * Metodo que revisa y registra si gano de forma horizontal hacia la izquierda
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	@Override
	public void winVerUp(int row, int column) {
		if (row-1 >= 0 && board.getMatrix()[row][column] == board.getMatrix()[row-1][column]) {
			up++;
			winVerUp(row-1, column);
		}
	}
	/**
	 * Metodo que revisa y registra si gano de forma vertical hacia arriba
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	@Override
	public void winVerDown(int row, int column) {
		if (row+1 < 7 && board.getMatrix()[row][column] == board.getMatrix()[row+1][column]) {
			down++;
			winVerDown(row+1, column);
		}
	}
	/**
	 * Metodo que revisa y registra si gano de forma vertical hacia abajo
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	@Override
	public void winDiag1(int row, int column) {
		if (column+1 < 8 && row+1 < 7 && board.getMatrix()[row][column] == board.getMatrix()[row+1][column+1]) {
			diag1++;
			winDiag1(row+1, column+1);
		}
	}
	/**
	 * Metodo que revisa y registra si gano de forma diagonal
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	@Override
	public void winDiag2(int row, int column) {
		if (column-1 >= 0 && row-1 >= 0 && board.getMatrix()[row][column] == board.getMatrix()[row-1][column-1]) {
			diag2++;
			winDiag2(row-1, column-1);
		}
	}
	/**
	 * Metodo que revisa y registra si gano de forma diagonal
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	@Override
	public void winDiag3(int row, int column) {
		if (column+1 < 8 && row-1 >= 0 && board.getMatrix()[row][column] == board.getMatrix()[row-1][column+1]) {
			diag3++;
			winDiag3(row-1, column+1);
		}
	}
	/**
	 * Metodo que revisa y registra si gano de forma diagonal
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	@Override
	public void winDiag4(int row, int column) {
		if (column-1 >= 0 && row+1 < 7 && board.getMatrix()[row][column] == board.getMatrix()[row+1][column-1]) {
			diag4++;
			winDiag4(row+1, column-1);
		}
	}
}
