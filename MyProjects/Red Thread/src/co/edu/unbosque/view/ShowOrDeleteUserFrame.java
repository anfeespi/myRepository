package co.edu.unbosque.view;

import javax.swing.JFrame;

/**
 * Ventana para mostrar o borrar usuario
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class ShowOrDeleteUserFrame extends JFrame {
	/**
	 * Panel de mostrar o borrar
	 */
	private ShowOrDeleteUserPanel sdp;
	
	/**
	 * Constructor
	 */
	public ShowOrDeleteUserFrame(int lang) {
		setSize(1200, 450);
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
		sdp = new ShowOrDeleteUserPanel(lang);
		sdp.setVisible(true);
		add(sdp);
	}

	/**
	 * @return the sdp
	 */
	public ShowOrDeleteUserPanel getSdp() {
		return sdp;
	}

	/**
	 * @param sdp the sdp to set
	 */
	public void setSdp(ShowOrDeleteUserPanel sdp) {
		this.sdp = sdp;
	}
}
