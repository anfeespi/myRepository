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
public class LogInFrame extends JFrame{
	/**
	 * Panel de inicio de sesion
	 */
	private LogInPanel sp;
	
	/**
	 * Metodo constructor
	 */
	public LogInFrame(int lang) {
		setSize(700, 600);
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
		sp = new LogInPanel(lang);
		sp.setVisible(true);
		add(sp);
	}

	/**
	 * @return the sp
	 */
	public LogInPanel getSp() {
		return sp;
	}

	/**
	 * @param sp the sp to set
	 */
	public void setSp(LogInPanel sp) {
		this.sp = sp;
	}
}
