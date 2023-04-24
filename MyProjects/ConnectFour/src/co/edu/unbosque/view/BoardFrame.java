package co.edu.unbosque.view;

import javax.swing.JFrame;
/**
 * Ventana donde sale el tablero
 * @author Andres Espitia Rodriguez, Diego Alejandro Forero Espitia, Jaime Esteban Mejia Arevalo, Juan Camilo Uribe Pava
 *
 **/
public class BoardFrame extends JFrame{
	/**
	 * Es el panel del tablero
	 **/
	private BoardPanel bp;
	/**
	 * La imagen de fondo
	 **/
	private Background bg;
	/**
	 * Metodo constructor
	 * @param selLang Lenguaje
	 * @param selTheme Tema
	 */
	public BoardFrame(int selLang, int selTheme) {
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents(selLang, selTheme);
	}
	/**
	 * Iniciar Componentes
	 * @param selLang Lenguaje
	 * @param selTheme Tema
	 */
	public void initComponents(int selLang, int selTheme) {
		bp = new BoardPanel(selLang, selTheme);
		bp.setVisible(true);
		bg = new Background(selTheme);

		add(bg);
		bg.add(bp);
	}

	/**
	 * @return the bp
	 */
	public BoardPanel getBp() {
		return bp;
	}

	/**
	 * @param bp the bp to set
	 */
	public void setBp(BoardPanel bp) {
		this.bp = bp;
	}
}
