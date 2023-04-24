package co.edu.unbosque.view;

import javax.swing.*;
/**
 * Ventana donde se escoje el modo de juego
 * @author Andres Espitia Rodriguez, Diego Alejandro Forero Espitia, Jaime Esteban Mejia Arevalo, Juan Camilo Uribe Pava
 *
 **/
public class ModeFrame extends JFrame{
	/**
	 * Panel principal
	 **/
	private ModePanel mop;
	/**
	 * Imagen de fondo
	 **/
	private Background bg;
	/**
	 * Metodo constructor
	 * @param selLang Lenguaje
	 * @param selTheme Tema
	 */
	public ModeFrame(int selLang, int selTheme) {
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents(selLang, selTheme);
	}
	/**
	 * Iniciar componentes
	 * @param selLang Lenguaje
	 * @param selTheme Tema
	 */
	public void initComponents(int selLang, int selTheme) {
		mop = new ModePanel(selLang, selTheme);
		mop.setVisible(true);
		bg = new Background(selTheme);

		add(bg);
		bg.add(mop);
	}

	/**
	 * @return the mop
	 */
	public ModePanel getMop() {
		return mop;
	}

	/**
	 * @param mop the mop to set
	 */
	public void setMop(ModePanel mop) {
		this.mop = mop;
	}
}
