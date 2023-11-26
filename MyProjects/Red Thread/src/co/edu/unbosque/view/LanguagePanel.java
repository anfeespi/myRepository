package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import co.edu.unbosque.model.persistence.FileHandler;
/**
 * Panel donde se podra escoger el idioma principal del programa
 * @author Andres Espitia
 * @author Diego Forero
 * @author Esteban Mejia
 * @author Camilo Uribe
 *
 */
public class LanguagePanel extends JPanel{
	/**
	 * El JLabel del titulo
	 */
	private JLabel title;
	/**
	 * JLabel de escoger el idioma
	 */
	private JLabel choose;
	/**
	 * El Combobox que tendra los idiomas
	 */
	private JComboBox<String> chcLanguage;
	/**
	 * Boton de confirmacion
	 */
	private JButton ok;
	/**
	 * Fuente que tendran los textos
	 */
	private Font font;
	/**
	 * Arreglo con los idiomas del programa
	 */
	private String[] languages = {"English", "Spanish"};
	/**
	 * Clase que usamos para centrar el texto del ComboBox
	 */
	private DefaultListCellRenderer listRenderer;
	/**
	 * Propiedades
	 */
	private Properties prop;
	/**
	 * Metodo Constructor
	 */
	public LanguagePanel() {
		setBounds(0, 0, 500, 500);
		setLayout(null);

		initComponents();
	}
	/**
	 * Metodo que usamos para inicializar nuestros objetos
	 */
	public void initComponents() {
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		font = new Font("Raleway", 0, 30);
		setBackground(Color.BLACK);
		title = new JLabel();
		title.setBounds(29, 75, 442, 130);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/RedThread.png"));
			Image title_resized = bi.getScaledInstance(title.getWidth(), title.getHeight(), Image.SCALE_SMOOTH);
			title.setIcon(new ImageIcon(title_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		title.setVisible(true);
		
		choose = new JLabel("Choose your language");
		choose.setBounds(91,238,318,35);
		choose.setHorizontalAlignment(SwingConstants.CENTER);
		choose.setForeground(Color.WHITE);
		choose.setFont(font);
		choose.setVisible(true);
		
		
		listRenderer = new DefaultListCellRenderer();
	    listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
		chcLanguage= new JComboBox<String>(languages);
		chcLanguage.setFont(font);
		chcLanguage.setRenderer(listRenderer);
		chcLanguage.setBounds(25,288,450,50);
		chcLanguage.setVisible(true);
		
		ok= new JButton("OK");
		ok.setBounds(140,390,220,40);
		ok.setHorizontalAlignment(SwingConstants.CENTER);
		ok.setFont(font);
		ok.setVisible(true);
		
		add(title);
		add(choose);
		add(chcLanguage);
		add(ok);
	}

	/**
	 * @return the title
	 */
	public JLabel getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(JLabel title) {
		this.title = title;
	}

	/**
	 * @return the choose
	 */
	public JLabel getChoose() {
		return choose;
	}

	/**
	 * @param choose the choose to set
	 */
	public void setChoose(JLabel choose) {
		this.choose = choose;
	}

	/**
	 * @return the chcLanguage
	 */
	public JComboBox getChcLanguage() {
		return chcLanguage;
	}

	/**
	 * @param chcLanguage the chcLanguage to set
	 */
	public void setChcLanguage(JComboBox chcLanguage) {
		this.chcLanguage = chcLanguage;
	}

	/**
	 * @return the ok
	 */
	public JButton getOk() {
		return ok;
	}

	/**
	 * @param ok the ok to set
	 */
	public void setOk(JButton ok) {
		this.ok = ok;
	}

	/**
	 * @return the font
	 */
	public Font getFont() {
		return font;
	}

	/**
	 * @param font the font to set
	 */
	public void setFont(Font font) {
		this.font = font;
	}

	/**
	 * @return the languages
	 */
	public String[] getLanguages() {
		return languages;
	}

	/**
	 * @param languages the languages to set
	 */
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
}
