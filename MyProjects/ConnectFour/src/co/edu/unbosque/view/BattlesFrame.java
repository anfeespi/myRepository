package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.UIManager;
/**
 * Es el JFrame es la ventana que aparece el registro de batallas
 * @author Andres Espitia Rodriguez, Diego Alejandro Forero Espitia, Jaime Esteban Mejia Arevalo, Juan Camilo Uribe Pava
 *
 **/
public class BattlesFrame extends JFrame{
	/**
	 *Es el panel de la ventana
	 **/
	private BattlesPanel bp;
	/**
	 *Es la imagen de fondo
	 **/
	private Background bg;
	/**
	 * Metodo constructor
	 * @param selLang Lenguaje
	 * @param selTheme Tema
	 */
	public BattlesFrame(int selLang, int selTheme) {
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents(selLang, selTheme);
	}
	/**
	 *Iniciar Componentes
	 * @param selLang Lenguaje
	 * @param selTheme Tema
	 **/
	public void initComponents(int selLang, int selTheme) {
		bp = new BattlesPanel(selLang, selTheme);
		bp.setVisible(true);
		bg = new Background(selTheme);

		add(bg);
		bg.add(bp);
	}

	/**
	 * @return the bp
	 */
	public BattlesPanel getBp() {
		return bp;
	}

	/**
	 * @param bp the bp to set
	 */
	public void setBp(BattlesPanel bp) {
		this.bp = bp;
	}

}