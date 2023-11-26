package co.edu.unbosque.view;

import javax.swing.JFrame;
/**
 * Ventana del panel principal
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class MainFrame extends JFrame{
	/**
	 * Panel principal
	 */
	private MainPanel mp;
	
	/**
	 * Metodo constructor
	 */
	public MainFrame(int lang) {
		setSize(1200, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents(lang);
	}
	
	/**
	 * Donde se inicializan los componentes de la ventana
	 */
	private void initComponents(int lang) {
		mp = new MainPanel(lang);
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
