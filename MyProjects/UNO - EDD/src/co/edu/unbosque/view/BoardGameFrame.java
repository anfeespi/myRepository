package co.edu.unbosque.view;

import javax.swing.JFrame;

/**
 * Ventana principal del tablero de juego
 * @author Esteban Mejia
 * @author Andres Espitia	
 * @author Diego Forero
 * @author Camilo Uribe
 * @author David Gonzales
 *
 */
public class BoardGameFrame extends JFrame {
	/**
	 * Panel del tablero de juego
	 */
	private BoardGamePanel bp;
	
	/**
	 * Metodo Constructor
	 */
	public BoardGameFrame() {
		setSize(1200, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		init();
	}
	/**
	 * Metodo para inicializar componentes
	 */
	public void init() {
		bp = new BoardGamePanel();
		bp.setVisible(true);
		add(bp);
	}

	/**
	 * @return the bp
	 */
	public BoardGamePanel getBp() {
		return bp;
	}

	/**
	 * @param bp the bp to set
	 */
	public void setBp(BoardGamePanel bp) {
		this.bp = bp;
	}
	
	
}
