package co.edu.unbosque.view;

import javax.swing.JFrame;

/**
 * Ventana para mostrar los matches
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class MatchesFrame extends JFrame{
	/**
	 * Panel de matches
	 */
	private MatchesPanel mp;
	
	/**
	 * Constructor
	 */
	public MatchesFrame(int lang) {
		setSize(1200, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents(lang);
	}

	/**
	 * Metodo para inicializar componentes
	 */
	private void initComponents(int lang) {
		mp = new MatchesPanel(lang);
		mp.setVisible(true);
		add(mp);
	}

	/**
	 * @return the mp
	 */
	public MatchesPanel getMp() {
		return mp;
	}

	/**
	 * @param mp the mp to set
	 */
	public void setMp(MatchesPanel mp) {
		this.mp = mp;
	}
}
