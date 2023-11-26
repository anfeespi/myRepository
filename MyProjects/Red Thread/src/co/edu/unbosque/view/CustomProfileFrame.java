package co.edu.unbosque.view;

import javax.swing.JFrame;
/**
 * Ventana del panel para editar el perfil
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class CustomProfileFrame extends JFrame{
	/**
	 * Panel para editar el perfil del usuario
	 */
	private CustomProfilePanel copp;
	
	/**
	 * Metodo constructor
	 */
	public CustomProfileFrame(int lang) {
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
		copp = new CustomProfilePanel(lang);
		copp.setVisible(true);
		add(copp);
	}

	/**
	 * @return the copp
	 */
	public CustomProfilePanel getCopp() {
		return copp;
	}

	/**
	 * @param copp the copp to set
	 */
	public void setCopp(CustomProfilePanel copp) {
		this.copp = copp;
	}
	
	

}
