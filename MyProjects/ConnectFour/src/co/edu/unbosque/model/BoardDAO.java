package co.edu.unbosque.model;
/**
 * Interface que contiene los metodos propios para el tablero de juego
 * @author Diego Forero
 * @author Andres Espitia
 * @author Camilo Uribe
 *
 */
public interface BoardDAO {
	/**
	 * Metodo que crea el tablero de juego
	 */
	public void createBoard();
	/**
	 * Metodo que llena y pone las fichas
	 * @param team Equipo al que pertenece el jugador
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	public void fillBoard(int team, int row, int column);
	/**
	 * Metodo que revisa la direccion en la que gana el jugador
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 * @return Retorna un booleano
	 */
	public boolean win(int row, int column);
	/**
	 * Metodo que revisa y registra si gano de forma horizontal hacia la derecha
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	public void winHorRight(int row, int column);
	/**
	 * Metodo que revisa y registra si gano de forma horizontal hacia la derecha
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	public void winHorLeft(int row, int column);
	/**
	 * Metodo que revisa y registra si gano de forma horizontal hacia la izquierda
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	public void winVerUp(int row, int column);
	/**
	 * Metodo que revisa y registra si gano de forma vertical hacia arriba
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	public void winVerDown(int row, int column);
	/**
	 * Metodo que revisa y registra si gano de forma vertical hacia abajo
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	public void winDiag1(int row, int column);
	/**
	 * Metodo que revisa y registra si gano de forma diagonal
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	public void winDiag2(int row, int column);
	/**
	 * Metodo que revisa y registra si gano de forma diagonal
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	public void winDiag3(int row, int column);
	/**
	 * Metodo que revisa y registra si gano de forma diagonal
	 * @param row Fila en donde se pone la ficha
	 * @param column Columna donde se pone la ficha
	 */
	public void winDiag4(int row, int column);
}
