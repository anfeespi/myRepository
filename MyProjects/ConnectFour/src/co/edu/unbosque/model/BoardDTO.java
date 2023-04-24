package co.edu.unbosque.model;
/**
 * Clase de tipo DTO que establece los atributos del tablero
 * @author Diego Forero
 * @author Andres Espitia
 * @author Camilo Uribe
 *
 */
public class BoardDTO {
	/**
	 * Matriz que crea que el tablero de juego
	 */
	public static int[][] matrix;
	/**
	 * Metodo constructor
	 */
	public BoardDTO() {
		
	}

	/**
	 * @param matrix
	 */
	public BoardDTO(int[][] matrix) {
		super();
		BoardDTO.matrix = matrix;
	}

	/**
	 * @return the matrix
	 */
	public int[][] getMatrix() {
		return matrix;
	}

	/**
	 * @param matrix the matrix to set
	 */
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
}
