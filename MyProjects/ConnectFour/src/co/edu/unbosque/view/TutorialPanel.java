package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.security.PublicKey;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import co.edu.unbosque.model.persistence.FileHandler;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * Panel que muestra el tutorial
 * @author Andres Espitia
 * @author Diego Forero
 * @author Esteban Mejia
 * @author Camilo Uribe
 *
 */
public class TutorialPanel extends JPanel{
	/**
	 * Propiedad perteneciente a la seleccion de lenguaje
	 */
	private Properties propLang;
	/**
	 * Propiedad perteneciente a la seleccion del tema
	 */
	private Properties propTheme;
	/**
	 * Titulo del panel
	 */
	private JLabel lblTurorial;
	/**
	 * Imagen que muestra el tutorial
	 */
	private JLabel imgTutorial;
	/**
	 * Explicacion del juego e indicaciones del tutorial
	 */
	private JLabel lblText;

	/**
	 * Metodo constructor
	 * @param selLang La seleccion del lenguaje
	 * @param selTheme Le seleccion del tema
	 */
	public TutorialPanel(int selLang, int selTheme) {
		propLang = FileHandler.loadPropertiesLang(selLang);
		propTheme = FileHandler.loadPropertiesTheme(selTheme);
		setBounds(0, 0, 600, 800);
		setLayout(null);
		setOpaque(true);

		init();
		setVisible(true);
	}
	
	/**
	 * Inicializar componentes
	 */
	public void init() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		setBackground(Color.black);

		lblTurorial = new JLabel("Tutorial");
		lblTurorial.setForeground(Color.WHITE);
		lblTurorial.setFont(new Font("Transformers Movie", Font.PLAIN, 40));
		lblTurorial.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurorial.setBounds(157, 21, 258, 36);
		add(lblTurorial);
		
		imgTutorial = new JLabel();
		imgTutorial.setBounds(35, 60, 520, 345);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File(propLang.getProperty("persistence.tutorialframe.imgtutorial")));
			Image resized = bi.getScaledInstance(imgTutorial.getWidth(), imgTutorial.getHeight(), Image.SCALE_SMOOTH);
			imgTutorial.setIcon(new ImageIcon(resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		imgTutorial.setVisible(true);
		add(imgTutorial);
		
		lblText = new JLabel();
		lblText.setBounds(35, 405, 520, 345);
		BufferedImage bi2 = null;
		try {
			bi2 = ImageIO.read(new File(propLang.getProperty("persistence.tutorialframe.tutorialText")));
			Image resized = bi2.getScaledInstance(lblText.getWidth(), imgTutorial.getHeight(), Image.SCALE_SMOOTH);
			lblText.setIcon(new ImageIcon(resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		lblText.setVisible(true);
		add(lblText);
	}

}

