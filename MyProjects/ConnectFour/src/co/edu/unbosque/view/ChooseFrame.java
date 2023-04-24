package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * Esta es la ventana en la que se podra elegir el idioma y el tema
 * @author Andres Espitia Rodriguez, Diego Alejandro Forero Espitia, Jaime Esteban Mejia Arevalo, Juan Camilo Uribe Pava
 *
 **/
public class ChooseFrame extends JFrame {
	/**
	 * Sera el panel de la ventana
	 **/
	private ChoosePanel cp;
	/**
	 * La imagen de fondo
	 **/
	private Background bg;
	/**
	 * Metodo Constructor
	 **/
	public ChooseFrame() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents();
	}
	/**
	 * Iniciar Componentes
	 **/	
	public void initComponents() {
		cp = new ChoosePanel();
		cp.setVisible(true);
		bg = new Background(1);
		add(bg);
		bg.add(cp);

	}

	/**
	 * @return the cp
	 */
	public ChoosePanel getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(ChoosePanel cp) {
		this.cp = cp;
	}

	/**
	 * @return the bg
	 */
	public Background getBg() {
		return bg;
	}

	/**
	 * @param bg the bg to set
	 */
	public void setBg(Background bg) {
		this.bg = bg;
	}
}
