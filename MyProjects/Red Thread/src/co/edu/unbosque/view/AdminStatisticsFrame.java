package co.edu.unbosque.view;

import javax.swing.JFrame;

/**
 * Ventana para las estadisticas de administrador
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class AdminStatisticsFrame extends JFrame {
	/**
	 * Panel de las estadisticas de administrador
	 */
	private AdminStatisticsPanel asp;
	
	/**
	 * Constructor
	 */
	public AdminStatisticsFrame(int lang) {
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
		asp = new AdminStatisticsPanel(lang);
		asp.setVisible(true);
		add(asp);
	}

	/**
	 * @return the asp
	 */
	public AdminStatisticsPanel getAsp() {
		return asp;
	}

	/**
	 * @param asp the asp to set
	 */
	public void setAsp(AdminStatisticsPanel asp) {
		this.asp = asp;
	}
}
