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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * Panel para mostrar o borrar usuarios
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class ShowOrDeleteUserPanel extends JPanel {
	/**
	 * Logo de la compañia
	 */
	private JLabel icon;
	/**
	 * Opciones
	 */
	private JButton options;
	/**
	 * Panel con las opciones
	 */
	private OptionAdminPanel op_panel;
	/**
	 * Alias
	 */
	private JTextField alias;
	/**
	 * Boton de mostrar
	 */
	private JButton show;
	/**
	 * Boton de eliminar
	 */
	private JButton delete;
	/**
	 * Informacion del usuario
	 */
	private JTextArea info;
	/**
	 * Fuente principal
	 */
	private Font font;
	/**
	 * Fuente secundaria
	 */
	private Font font2;
	/**
	 * Propiedades
	 */
	private Properties prop;
	/**
	 * Constructor
	 */
	public ShowOrDeleteUserPanel(int lang) {
		setBounds(0, 0, 1200, 450);
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
		font2 = new Font("Raleway", 0, 25);
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
		
		alias = new RoundJTextField();
		alias.setBounds(125, 150, 350, 40);
		TextPrompt placeholder_a = new TextPrompt(prop.getProperty("properties.show/delete.username"), alias);
	    placeholder_a.changeAlpha(1.25f);
	    placeholder_a.changeStyle(font);//Usar properties
		alias.setFont(font);
		alias.setVisible(true);
		
		show = new JButton(prop.getProperty("properties.show/delete.info")); //Usar properties
		show.setBounds(530, 150, 250, 40);
		show.setFont(font);
		show.setBorder(new LineBorder(Color.BLACK, 2, true));
		show.setVisible(true);
		
		delete = new JButton(prop.getProperty("properties.show/delete.delete")); //Usar properties
		delete.setBounds(820, 150, 250, 40);
		delete.setFont(font);
		delete.setBorder(new LineBorder(Color.BLACK, 2, true));
		delete.setVisible(true);
		
		info = new JTextArea();
		info.setBounds(50, 215, 1100, 165);
		TextPrompt placeholder_b = new TextPrompt(prop.getProperty("properties.show/delete.userinfo"), info);
	    placeholder_b.changeAlpha(1.25f);
	    placeholder_b.changeStyle(font2);//Usar properties
	    info.setFont(font2);
	    info.setVisible(true);
		
		op_panel = new OptionAdminPanel(lang);
		
		add(icon);
		add(options);
		add(alias);
		add(show);
		add(delete);
		add(info);
	}
	
	/**
	 * Mostrar opciones
	 */
	public void showOptions() {
		op_panel.setBounds(826, 33, 240, 240);
		op_panel.setVisible(true);
		add(op_panel, 1);
	}

	/**
	 * @return the op_panel
	 */
	public OptionAdminPanel getOp_panel() {
		return op_panel;
	}

	/**
	 * @param op_panel the op_panel to set
	 */
	public void setOp_panel(OptionAdminPanel op_panel) {
		this.op_panel = op_panel;
	}

	/**
	 * @return the alias
	 */
	public JTextField getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(JTextField alias) {
		this.alias = alias;
	}

	/**
	 * @return the show
	 */
	public JButton getShow() {
		return show;
	}

	/**
	 * @param show the show to set
	 */
	public void setShow(JButton show) {
		this.show = show;
	}

	/**
	 * @return the delete
	 */
	public JButton getDelete() {
		return delete;
	}

	/**
	 * @param delete the delete to set
	 */
	public void setDelete(JButton delete) {
		this.delete = delete;
	}

	/**
	 * @return the info
	 */
	public JTextArea getInfo() {
		return info;
	}

	/**
	 * @param info the info to set
	 */
	public void setInfo(JTextArea info) {
		this.info = info;
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
}
