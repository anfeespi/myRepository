package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import co.edu.unbosque.model.persistence.FileHandler;
/**
 * Panel principal
 * @author Andres Espitia Rodriguez, Diego Alejandro Forero Espitia, Jaime Esteban Mejia Arevalo, Juan Camilo Uribe Pava
 *
 **/
public class MainPanel extends JPanel{
	/**
	 * Las fuentes del panel
	 **/
	private Font buttonfont,titleFont,subTitleFont;
	/**
	 *  Los botones
	 **/
	private JButton play, matches, tutorial, btnOptions;
	/**
	 * Las etiquetas de texto
	 **/
	private JLabel title, subTitle, lblAutobots, lblDecepticon, lblOptions;
	/**
	 * Los archivos properties del lenguaje
	 **/
	private Properties propLang;
	/**
	 * Los archivos properties del tema
	 **/
	private Properties propTheme;
	/**
	 * El color inicial
	 **/
	private String color_str;
	/**
	 *  El color que se elige a partir del anterior
	 **/
	private Color c;
	/**
	 * Metodo Constructor
	 * @param selLang lenguaje
	 * @param selTheme tema
	 */
	public MainPanel(int selLang, int selTheme) {
		propLang = FileHandler.loadPropertiesLang(selLang);
		propTheme = FileHandler.loadPropertiesTheme(selTheme);
		color_str = propTheme.getProperty("persistence.frames.color");
		if (color_str.equals("White")) {
			c = Color.WHITE;
		} else {
			c = Color.BLACK;
		}
		buttonfont = new Font("Transformers Movie", 0, 50);
		titleFont= new Font("Transformers Movie", 0, 90);
		subTitleFont= new Font("Transformers Movie", 0, 16);
		setBounds(36, 110, 1000, 700);
		setLayout(null);
		setOpaque(false);
		init();
		setVisible(true);
	}
	/**
	 * 
	 **/
	public void init() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println(e);
		}

		//Titulos
		title= new JLabel(propLang.getProperty("persistence.mainframe.title"));
		title.setBounds(196,70,800,200);
		title.setForeground(c);
		title.setFont(titleFont);
		title.setVisible(true);
		add(title);

		subTitle= new JLabel(propLang.getProperty("persistence.mainframe.subtitle"));
		subTitle.setBounds(466,180,400,50);
		subTitle.setForeground(c);
		subTitle.setFont(subTitleFont);
		subTitle.setVisible(true);
		add(subTitle);

		lblOptions= new JLabel();
		lblOptions.setBounds(870,610,50,50);
		BufferedImage bi3 = null;
		try {
			bi3 = ImageIO.read(new File(propTheme.getProperty("persistence.config_img")));
			Image option = bi3.getScaledInstance(lblOptions.getWidth(), lblOptions.getHeight(), Image.SCALE_SMOOTH);
			lblOptions.setIcon(new ImageIcon(option));
		} catch (Exception e) {
			e.printStackTrace();
		}
		lblOptions.setVisible(true);
		add(lblOptions);

		lblAutobots = new JLabel();
		lblAutobots.setBounds(824, 120, 80, 80);
		BufferedImage bi2 = null;
		try {
			bi2 = ImageIO.read(new File(propTheme.getProperty("persistence.imgautobots")));
			Image autobots = bi2.getScaledInstance(lblAutobots.getWidth(), lblAutobots.getHeight(), Image.SCALE_SMOOTH);
			lblAutobots.setIcon(new ImageIcon(autobots));
		} catch (Exception e) {
			e.printStackTrace();
		}
		lblAutobots.setVisible(true);
		add(lblAutobots);

		lblDecepticon = new JLabel();
		lblDecepticon.setBounds(84, 122, 80, 80);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File(propTheme.getProperty("persistence.imgdecepticons")));
			Image decepticon = bi.getScaledInstance(lblDecepticon.getWidth(), lblDecepticon.getHeight(), Image.SCALE_SMOOTH);
			lblDecepticon.setIcon(new ImageIcon(decepticon));
		} catch (Exception e) {
			e.printStackTrace();
		}
		lblDecepticon.setVisible(true);
		add(lblDecepticon);

		//Botones
		play = new JButton(propLang.getProperty("persistence.mainframe.playButt"));
		play.setBounds(365, 330, 270, 60);
		play.setFont(buttonfont);
		play.setVisible(true);
		add(play);

		matches = new JButton(propLang.getProperty("persistence.mainframe.matchesButt"));
		matches.setBounds(365,410,270,60);
		matches.setFont(buttonfont);
		matches.setVisible(true);
		add(matches);

		tutorial = new JButton(propLang.getProperty("persistence.mainframe.tutorialButt"));
		tutorial.setBounds(365,500,270,60);
		tutorial.setFont(buttonfont);
		tutorial.setVisible(true);
		add(tutorial);

		btnOptions = new JButton();
		btnOptions.setBounds(870,610,50,50);
		btnOptions.setVisible(true);
		btnOptions.setOpaque(false);
		add(btnOptions);
	}

	/**
	 * @return the play
	 */
	public JButton getPlay() {
		return play;
	}

	/**
	 * @param play the play to set
	 */
	public void setPlay(JButton play) {
		this.play = play;
	}

	/**
	 * @return the matches
	 */
	public JButton getMatches() {
		return matches;
	}

	/**
	 * @param matches the matches to set
	 */
	public void setMatches(JButton matches) {
		this.matches = matches;
	}

	/**
	 * @return the tutorial
	 */
	public JButton getTutorial() {
		return tutorial;
	}

	/**
	 * @param tutorial the tutorial to set
	 */
	public void setTutorial(JButton tutorial) {
		this.tutorial = tutorial;
	}

	/**
	 * @return the btnOptions
	 */
	public JButton getBtnOptions() {
		return btnOptions;
	}

	/**
	 * @param btnOptions the btnOptions to set
	 */
	public void setBtnOptions(JButton btnOptions) {
		this.btnOptions = btnOptions;
	}
}