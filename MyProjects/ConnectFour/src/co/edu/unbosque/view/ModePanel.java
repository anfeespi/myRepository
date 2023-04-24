package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

import javax.swing.*;

import co.edu.unbosque.model.persistence.FileHandler;
/**
 * Panel donde se escoje el modo de juego
 * @author Andres Espitia Rodriguez, Diego Alejandro Forero Espitia, Jaime Esteban Mejia Arevalo, Juan Camilo Uribe Pava
 *
 **/
public class ModePanel extends JPanel{
	/**
	 * Las propiedades del idioma
	 **/
	private Properties propLang;
	/**
	 * Propiedades del tema
	 **/
	private Properties propTheme;
	/**
	 *  Etiqueta de texto
	 **/
	private JLabel lblMode;
	/**
	 * Boton 1v1
	 **/
	private JButton btn1vs1;
	/**
	 * Boton 1 vs cpu
	 **/
	private JButton btnVsCpu;
	/**
	 * Color string
	 **/
	private String color_str;
	/**
	 * El color del tema
	 **/
	private Color c;
	/**
	 * Metodo constructor
	 * @param selLang Lenguaje
	 * @param selTheme Tema
	 */
	public ModePanel(int selLang, int selTheme) {
		propLang = FileHandler.loadPropertiesLang(selLang);
		propTheme = FileHandler.loadPropertiesTheme(selTheme);
		color_str = propTheme.getProperty("persistence.frames.color");
		if (color_str.equals("White")) {
			c = Color.WHITE;
		} else {
			c = Color.BLACK;
		}
		setBounds(36, 110, 600, 500);
		setLayout(null);
		setOpaque(false);
		init();
		setVisible(true);
	}
	/**
	 * Iniciar Componentes
	 **/
	public void init() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println(e);
		}
		lblMode = new JLabel(propLang.getProperty("persistence.modeframe.mode"));
		lblMode.setFont(new Font("Transformers Movie", Font.PLAIN, 45));
		lblMode.setForeground(c);
		lblMode.setHorizontalAlignment(SwingConstants.CENTER);
		lblMode.setBounds(35, 70, 527, 41);
		add(lblMode);

		btn1vs1 = new JButton(propLang.getProperty("persistence.modeframe.1vs1"));
		btn1vs1.setFont(new Font("Transformers Movie", Font.PLAIN, 50));
		btn1vs1.setBounds(165, 199, 270, 60);
		add(btn1vs1);

		btnVsCpu = new JButton(propLang.getProperty("persistence.modeframe.vscpu"));
		btnVsCpu.setFont(new Font("Transformers Movie", Font.PLAIN, 50));
		btnVsCpu.setBounds(165, 295, 270, 60);
		add(btnVsCpu);

	}

	/**
	 * @return the btn1vs1
	 */
	public JButton getBtn1vs1() {
		return btn1vs1;
	}

	/**
	 * @param btn1vs1 the btn1vs1 to set
	 */
	public void setBtn1vs1(JButton btn1vs1) {
		this.btn1vs1 = btn1vs1;
	}

	/**
	 * @return the btnVsCpu
	 */
	public JButton getBtnVsCpu() {
		return btnVsCpu;
	}

	/**
	 * @param btnVsCpu the btnVsCpu to set
	 */
	public void setBtnVsCpu(JButton btnVsCpu) {
		this.btnVsCpu = btnVsCpu;
	}


}
