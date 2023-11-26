package co.edu.unbosque.view;

import javax.swing.JFrame;

/**
 * Ventana para crear perfil
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class CreateProfileFrame extends JFrame{
	/**
	 * Panel para crear perfil
	 */
	private CreateProfilePanel cpp;
	
	/**
	 * Metodo constructor
	 */
	public CreateProfileFrame(int lang) {
		setSize(1000, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents(lang);
	}

	/**
	 * Metodo para inicializar variables
	 */
	private void initComponents(int lang) {
		cpp = new CreateProfilePanel(lang);
		cpp.setVisible(true);
		add(cpp);
	}

	/**
	 * @return the cpp
	 */
	public CreateProfilePanel getCpp() {
		return cpp;
	}

	/**
	 * @param cpp the cpp to set
	 */
	public void setCpp(CreateProfilePanel cpp) {
		this.cpp = cpp;
	}
}
