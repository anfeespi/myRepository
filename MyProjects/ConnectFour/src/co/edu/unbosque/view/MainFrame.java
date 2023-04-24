package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.UIManager;
/**
 * La ventana del menu principas
 * @author Andres Espitia Rodriguez, Diego Alejandro Forero Espitia, Jaime Esteban Mejia Arevalo, Juan Camilo Uribe Pava
 *
 **/
public class MainFrame extends JFrame{
	/**
	 * Panel principal
	 **/
	private MainPanel mp;
	/**
	 * Imagen de fondo
	 **/
	private Background bg;
	/**
	 * Metodo constructor
	 * @param selLang Lenguaje
	 * @param selTheme Tema
	 */
	public MainFrame(int selLang, int selTheme) {
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents(selLang, selTheme);
	}
	/**
	 * Iniciar componentes
	 * @param selLang Lenguaje
	 * @param selTheme Tema
	 */
	public void initComponents(int selLang, int selTheme) {
		mp = new MainPanel(selLang, selTheme);
		mp.setVisible(true);
		bg = new Background(selTheme);

		add(bg);
		bg.add(mp);
	}

	/**
	 * @return the mp
	 */
	public MainPanel getMp() {
		return mp;
	}

	/**
	 * @param mp the mp to set
	 */
	public void setMp(MainPanel mp) {
		this.mp = mp;
	}
}
