package co.edu.unbosque.view;

import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.*;

import co.edu.unbosque.model.persistence.FileHandler;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
/**
 * Panel donde se eligen equipos
 * @author Andres Espitia Rodriguez, Diego Alejandro Forero Espitia, Jaime Esteban Mejia Arevalo, Juan Camilo Uribe Pava
 *
 */
public class TeamPanel extends JPanel{
	/**
	 * Propiedades del lenguaje
	 */
	private Properties propLang;
	/**
	 * Propiedades deel tema
	 */
	private Properties propTheme;
	/**
	 * Etiqueta de escojer
	 */
	private JLabel lblChoose;
	/**
	 * Etiqueta de texto
	 */
	private JLabel lblwarrior;
	/**
	 * txt donde se pondra el nombre
	 */
	private JTextField txtwarrior;
	/**
	 * Etiqueta de imagen autobot
	 */
	private JLabel imgAutobots;
	/**
	 * Etiqueta de imagen decepticon
	 */
	private JLabel imgDecepticons;
	/**
	 * CheckBox de autobots
	 */
	private JCheckBox chcAutobots;
	/**
	 * CheckBox de Decepticon
	 */
	private JCheckBox chcDecepticons;
	/**
	 * Boton Pelear
	 */
	private JButton btnFight;
	/**
	 * Color String
	 */
	private String color_str;
	/**
	 * Color del tema
	 */
	private Color c;
	/**
	 * Metodo constructor
	 * @param selLang Lenguaje
	 * @param selTheme Tema
	 */
	public TeamPanel(int selLang, int selTheme) {
		propLang = FileHandler.loadPropertiesLang(selLang);
		propTheme = FileHandler.loadPropertiesTheme(selTheme);
		color_str = propTheme.getProperty("persistence.frames.color");
		if (color_str.equals("White")) {
			c = Color.WHITE;
		} else {
			c = Color.BLACK;
		}
		setBounds(36, 110, 600, 700);
		setLayout(null);
		setOpaque(false);
		init();
		setVisible(true);
	}
	/**
	 * Iniciar Componentes
	 */
	public void init() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println(e);
		}
		lblChoose = new JLabel(propLang.getProperty("persistence.teamframe.choose"));
		lblChoose.setFont(new Font("Transformers Movie", Font.PLAIN, 50));
		lblChoose.setForeground(c);
		lblChoose.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoose.setBounds(85, 75, 422, 37);
		add(lblChoose);
		
		lblwarrior = new JLabel(propLang.getProperty("persistence.teamframe.warrior"));
		lblwarrior.setHorizontalAlignment(SwingConstants.CENTER);
		lblwarrior.setForeground(c);
		lblwarrior.setFont(new Font("Transformers Movie", Font.PLAIN, 20));
		lblwarrior.setBounds(173, 217, 257, 35);
		add(lblwarrior);
		
		txtwarrior = new JTextField();
		txtwarrior.setHorizontalAlignment(SwingConstants.CENTER);
		txtwarrior.setFont(new Font("Transformers Movie", Font.PLAIN, 20));
		txtwarrior.setBounds(123, 240, 355, 45);
		add(txtwarrior);
		txtwarrior.setColumns(10);
		
		imgAutobots = new JLabel();
		imgAutobots.setBounds(123, 350, 96, 96);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File(propTheme.getProperty("persistence.imgautobots")));
			Image resized = bi.getScaledInstance(imgAutobots.getWidth(), imgAutobots.getHeight(), Image.SCALE_SMOOTH);
			imgAutobots.setIcon(new ImageIcon(resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		imgAutobots.setVisible(true);
		add(imgAutobots);
		
		imgDecepticons = new JLabel();
		imgDecepticons.setBounds(382, 350, 96, 96);
		BufferedImage bi2 = null;
		try {
			bi2 = ImageIO.read(new File(propTheme.getProperty("persistence.imgdecepticons")));
			Image resized = bi2.getScaledInstance(imgDecepticons.getWidth(), imgDecepticons.getHeight(), Image.SCALE_SMOOTH);
			imgDecepticons.setIcon(new ImageIcon(resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		imgDecepticons.setVisible(true);
		add(imgDecepticons);
		
		chcAutobots = new JCheckBox("");
		chcAutobots.setBounds(161, 447, 21, 23);
		add(chcAutobots);
		
		chcDecepticons = new JCheckBox("");
		chcDecepticons.setBounds(420, 447, 21, 23);
		add(chcDecepticons);
		
		btnFight = new JButton(propLang.getProperty("persistence.teamframe.fight"));
		btnFight.setFont(new Font("Transformers Movie", Font.PLAIN, 50));
		btnFight.setBounds(165, 520, 270, 60);
		add(btnFight);
	}
	
	public void showError(String err) {
		JOptionPane.showMessageDialog(null, propLang.getProperty(err), null, JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * @return the chcAutobots
	 */
	public JCheckBox getChcAutobots() {
		return chcAutobots;
	}

	/**
	 * @param chcAutobots the chcAutobots to set
	 */
	public void setChcAutobots(JCheckBox chcAutobots) {
		this.chcAutobots = chcAutobots;
	}

	/**
	 * @return the chcDecepticons
	 */
	public JCheckBox getChcDecepticons() {
		return chcDecepticons;
	}

	/**
	 * @param chcDecepticons the chcDecepticons to set
	 */
	public void setChcDecepticons(JCheckBox chcDecepticons) {
		this.chcDecepticons = chcDecepticons;
	}

	/**
	 * @return the btnFight
	 */
	public JButton getBtnFight() {
		return btnFight;
	}

	/**
	 * @param btnFight the btnFight to set
	 */
	public void setBtnFight(JButton btnFight) {
		this.btnFight = btnFight;
	}

	/**
	 * @return the txtwarrior
	 */
	public JTextField getTxtwarrior() {
		return txtwarrior;
	}

	/**
	 * @param txtwarrior the txtwarrior to set
	 */
	public void setTxtwarrior(JTextField txtwarrior) {
		this.txtwarrior = txtwarrior;
	}
}
