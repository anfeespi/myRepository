package co.edu.unbosque.view;

import javax.swing.JFrame;

/**
 * Ventana para ver usuarios
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class AdminUsersFrame extends JFrame {
	/**
	 * Panel para ver usuarios
	 */
	private AdminUsersPanel aup;
	
	/**
	 * Metodo constructor
	 */
	public AdminUsersFrame(int lang) {
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
		aup = new AdminUsersPanel(lang);
		aup.setVisible(true);
		add(aup);
	}

	/**
	 * @return the aup
	 */
	public AdminUsersPanel getAup() {
		return aup;
	}

	/**
	 * @param aup the aup to set
	 */
	public void setAup(AdminUsersPanel aup) {
		this.aup = aup;
	}
}
