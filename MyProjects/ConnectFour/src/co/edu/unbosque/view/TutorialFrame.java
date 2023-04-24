package co.edu.unbosque.view;

import javax.swing.*;

/**
 * Ventana donde se puede ver el tutorial de juego
 * @author Andres Espitia
 * @author Diego Forero
 * @author Esteban Mejia
 * @author Camilo Uribe
 *
 */
public class TutorialFrame extends JFrame{
	/**
	 * Panel correspondiente
	 */
	private TutorialPanel tup;

	/**
	 * Metodo constructor 
	 * @param selLang La seleccion del lenguaje
	 * @param selTheme Le seleccion del tema
	 */
	public TutorialFrame(int selLang, int selTheme) {
		setSize(600, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		initComponents(selLang, selTheme);
	}

	/**
	 * Inicializar componentes de la ventana
	 * @param selLang
	 * @param selTheme
	 */
	public void initComponents(int selLang, int selTheme) {
		tup = new TutorialPanel(selLang, selTheme);
		tup.setVisible(true);

		add(tup);
	}
}
