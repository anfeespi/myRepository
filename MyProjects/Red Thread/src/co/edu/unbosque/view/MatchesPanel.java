package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * Panel para mostrar los matches
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class MatchesPanel extends JPanel{
	/**
	 * Logo de la compañia
	 */
	private JLabel icon;
	/**
	 * Boton de opciones
	 */
	private JButton options;
	/**
	 * Boton para volver a la pantalla principal
	 */
	private JButton home;
	/**
	 * Titulo
	 */
	private JLabel title;
	/**
	 * Fuente principal
	 */
	private Font font;
	/**
	 * Panel de matches
	 */
	private Matches m;
	/**
	 * Contenedor para los matches
	 */
	private JScrollPane matches_container;
	/**
	 * Panel de opciones
	 */
	private OptionUsersPanel op_panel;
	/**
	 * Propiedades
	 */
	private Properties prop;
	/**
	 * Constructor
	 */
	public MatchesPanel(int lang) {
		setBounds(0, 0, 1200, 700);
		setLayout(null);
		prop = FileHandler.loadPropertiesLang(lang);
		initComponents(lang);
	}

	/**
	 * Metodo para inicializar componentes
	 */
	private void initComponents(int lang) {
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		font = new Font("Raleway", 0, 30);
		setBackground(Color.BLACK);
		
		icon = new JLabel();
		icon.setBounds(64, 13, 124, 110);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/RedThreadIcon.png"));
			Image title_resized = bi.getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH);
			icon.setIcon(new ImageIcon(title_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		icon.setVisible(true);
		
		options = new JButton();
		options.setBackground(Color.BLACK);
		options.setBounds(1066, 33, 70, 70);
		options.setIcon(new ImageIcon("src/co/edu/unbosque/util/media/GUIImgs/optionicon.png"));
		options.setVisible(true);
		
		title = new JLabel(prop.getProperty("properties.matchesframe")); //Usar properties
		title.setBounds(480, 50, 317, 40);
		title.setFont(font);
		title.setOpaque(false);
		title.setBackground(Color.BLACK);
		title.setForeground(Color.WHITE);
		title.setVisible(true);
		
		home = new JButton();
		home.setBackground(Color.BLACK);
		home.setBounds(976, 33, 70, 70);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/home.png"));
			Image home_resized = bi.getScaledInstance(home.getWidth(), home.getHeight(), Image.SCALE_SMOOTH);
			home.setIcon(new ImageIcon(home_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		home.setVisible(true);
		
		op_panel = new OptionUsersPanel(lang);
		
		
		add(icon);
		add(options);
		add(title);
		add(home);
	}
	
	public void showMatches(int cant, ArrayList<Integer> matches) {
		m = new Matches(cant, matches);
		m.setVisible(true);
		matches_container = new JScrollPane();
		matches_container.setViewportView(m);
		matches_container.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		matches_container.setBackground(Color.BLACK);
		matches_container.setBounds(60, 170, 1080, 450);
		add(matches_container);
		repaint();
	}
	
	/**
	 * Mostrar opciones
	 */
	public void showOptions() {
		op_panel.setBounds(826, 33, 240, 160);
		op_panel.setVisible(true);
		add(op_panel);
	}

	/**
	 * @return the options
	 */
	public JButton getOptions() {
		return options;
	}

	/**
	 * @param options the options to set
	 */
	public void setOptions(JButton options) {
		this.options = options;
	}

	/**
	 * @return the op_panel
	 */
	public OptionUsersPanel getOp_panel() {
		return op_panel;
	}

	/**
	 * @param op_panel the op_panel to set
	 */
	public void setOp_panel(OptionUsersPanel op_panel) {
		this.op_panel = op_panel;
	}

	/**
	 * @return the home
	 */
	public JButton getHome() {
		return home;
	}

	/**
	 * @param home the home to set
	 */
	public void setHome(JButton home) {
		this.home = home;
	}
}
