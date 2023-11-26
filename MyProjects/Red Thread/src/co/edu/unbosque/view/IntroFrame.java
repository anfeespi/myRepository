package co.edu.unbosque.view;

import javax.swing.JFrame;
/**
 * JFrame principal de la intro
 * @author Andres Espitia
 * @author Diego Forero
 * @author Esteban Mejia
 * @author Camilo Uribe
 *
 */
public class IntroFrame extends JFrame {
	/**
	 * Panel de la introduccion
	 */
	private IntroPanel  ip;
	/**
	 * Metodo Constructor
	 */
	public IntroFrame() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents();	}
	/**
	 * Metodo donde iniciamos nuestro panel
	 */
	public void initComponents() {
		ip= new IntroPanel();
		ip.setVisible(true);
		add(ip);
	}
}
