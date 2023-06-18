package co.edu.unbosque.view;

import javax.swing.JFrame;

/**
 * Clase principal del menu
 * @author Esteban Mejia
 * @author Andres Espitia	
 * @author Diego Forero
 * @author Camilo Uribe
 * @author David Gonzalez
 *
 */
public class MainFrame extends JFrame{
	
	/**
	 * Panel principal del menu
	 */
	private MainPanel mp;

	/**
	 * Metodo Constructor
	 */
	public MainFrame() {
		setSize(1200, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		init();
	}
	/**
	 * Metodo que inicia componentes
	 */
	public void init() {
		mp = new MainPanel();
		mp.setVisible(true);
		add(mp);
	}
	/**
	 * @return the mp
	 */
	public MainPanel getMp() {
		return mp;
	}
	/**
	 * @param mp the mp to set
	 */
	public void setMp(MainPanel mp) {
		this.mp = mp;
	}
	
}
