package co.edu.unbosque.view;

import javax.swing.JFrame;

/**
 * Ventana de inicio de sesion
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class SignInFrame extends JFrame{
	/**
	 * Panel de inicio de sesion
	 */
	private SignInPanel lp;
	
	/**
	 * Metodo constructor
	 */
	public SignInFrame(int lang) {
		setSize(1200, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents(lang);
	}

	/**
	 * metodo para inicializar componentes
	 */
	private void initComponents(int lang) {
		lp = new SignInPanel(lang);
		lp.setVisible(true);
		add(lp);
	}

	/**
	 * @return the lp
	 */
	public SignInPanel getLp() {
		return lp;
	}

	/**
	 * @param lp the lp to set
	 */
	public void setLp(SignInPanel lp) {
		this.lp = lp;
	}
	
	
}
