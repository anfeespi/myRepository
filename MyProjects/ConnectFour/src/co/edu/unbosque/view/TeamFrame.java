package co.edu.unbosque.view;

import javax.swing.*;
/**
 * Ventana donde se van a escojer los equipos
 * @author Andres Espitia Rodriguez, Diego Alejandro Forero Espitia, Jaime Esteban Mejia Arevalo, Juan Camilo Uribe Pava
 *
 *
 */
public class TeamFrame extends JFrame{
	/**
	 * Panel Principal
	 */
	private TeamPanel tp;
	/**
	 * Imagen de fondo
	 */
	private Background bg;
	/**
	 * Metodo constructor
	 * @param selLang Lenguaje
	 * @param selTheme Tema
	 */
	public TeamFrame(int selLang, int selTheme) {
		setSize(600, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents(selLang, selTheme);
	}
	/**
	 * Iniciar Componentes
	 * @param selLang Lenguaje
	 * @param selTheme Tema
	 */
	public void initComponents(int selLang, int selTheme) {
		tp = new TeamPanel(selLang, selTheme);
		tp.setVisible(true);
		bg = new Background(selTheme);

		add(bg);
		bg.add(tp);
	}

	/**
	 * @return the tp
	 */
	public TeamPanel getTp() {
		return tp;
	}

	/**
	 * @param tp the tp to set
	 */
	public void setTp(TeamPanel tp) {
		this.tp = tp;
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