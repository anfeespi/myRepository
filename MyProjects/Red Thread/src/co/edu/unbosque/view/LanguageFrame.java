package co.edu.unbosque.view;

import javax.swing.JFrame;
/**
 * JFrame principal del menu para seleccionar idioma
 * @author Andres Espitia
 * @author Diego Forero
 * @author Esteban Mejia
 * @author Camilo Uribe
 *
 */
public class LanguageFrame extends JFrame{
	/**
	 * Panel del JFrame 
	 */
	private LanguagePanel lp;
	/**
	 * Metodo Constructors
	 */
	public LanguageFrame() {
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents();
	}
	/**
	 * Metodo donde iniciamos el panel del JFrame
	 */
	public void initComponents(){
		lp = new LanguagePanel();
		lp.setVisible(true);
		add(lp);
	}
	/**
	 * @return the lp
	 */
	public LanguagePanel getLp() {
		return lp;
	}
	/**
	 * @param lp the lp to set
	 */
	public void setLp(LanguagePanel lp) {
		this.lp = lp;
	}
	
}
