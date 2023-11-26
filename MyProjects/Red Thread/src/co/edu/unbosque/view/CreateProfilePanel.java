package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * Panel para crear un perfil
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class CreateProfilePanel extends JPanel{
	/**
	 * Titulo
	 */
	private JLabel title;
	/**
	 * Foto 1
	 */
	private JButton photo1;
	/**
	 * Foto 2
	 */
	private JButton photo2;
	/**
	 * Foto 3
	 */
	private JButton photo3;
	/**
	 * Foto 4
	 */
	private JButton photo4;
	/**
	 * Texto 1
	 */
	private JLabel text1;
	/**
	 * Texto 2
	 */
	private JLabel text2;
	/**
	 * Descripcion
	 */
	private JTextField description;
	/**
	 * Ingresos/Divorcios
	 */
	private JTextField income_divorces;
	/**
	 * crear cuenta
	 */
	private JButton create;
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
	public CreateProfilePanel(int lang) {
		setBounds(0, 0, 1000, 800);
		setLayout(null);
		prop = FileHandler.loadPropertiesLang(lang);
		initComponents();
	}

	/**
	 * Metodo para inicializar componentes
	 */
	private void initComponents() {
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		font = new Font("Raleway", 0, 20);
		font2 = new Font("Raleway", 0, 25);
		setBackground(Color.BLACK);
		
		title = new JLabel();
		title.setBounds(254, 30, 493, 145);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/RedThread.png"));
			Image title_resized = bi.getScaledInstance(title.getWidth(), title.getHeight(), Image.SCALE_SMOOTH);
			title.setIcon(new ImageIcon(title_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		title.setVisible(true);
		
		photo1 = new JButton();
		photo1.setBounds(55, 180, 200, 300);
		photo1.setIcon(new ImageIcon("src/co/edu/unbosque/util/media/GUIImgs/newphotoicon.png"));
		photo1.setFont(font);
		photo1.setBackground(Color.BLACK);
		photo1.setBorder(new LineBorder(Color.WHITE, 2, true));
		photo1.setVisible(true);
		
		photo2 = new JButton();
		photo2.setBounds(285, 180, 200, 300);
		photo2.setIcon(new ImageIcon("src/co/edu/unbosque/util/media/GUIImgs/newphotoicon.png"));
		photo2.setFont(font);
		photo2.setBackground(Color.BLACK);
		photo2.setBorder(new LineBorder(Color.WHITE, 2, true));
		photo2.setVisible(true);
		
		photo3 = new JButton();
		photo3.setBounds(515, 180, 200, 300);
		photo3.setIcon(new ImageIcon("src/co/edu/unbosque/util/media/GUIImgs/newphotoicon.png"));
		photo3.setFont(font);
		photo3.setBackground(Color.BLACK);
		photo3.setBorder(new LineBorder(Color.WHITE, 2, true));
		photo3.setVisible(true);
		
		photo4 = new JButton();
		photo4.setBounds(745, 180, 200, 300);
		photo4.setIcon(new ImageIcon("src/co/edu/unbosque/util/media/GUIImgs/newphotoicon.png"));
		photo4.setFont(font);
		photo4.setBackground(Color.BLACK);
		photo4.setBorder(new LineBorder(Color.WHITE, 2, true));
		photo4.setVisible(true);
		
		text1 = new JLabel(prop.getProperty("properties.create.description")); //Usar properties
		text1.setBounds(55, 510, 165, 35);
		text1.setFont(font2);
		text1.setOpaque(false);
		text1.setBackground(Color.BLACK);
		text1.setForeground(Color.WHITE);
		text1.setVisible(true);
		
		text2 = new JLabel(prop.getProperty("properties.create.income")); //Usar properties
		text2.setBounds(515, 510, 370, 35);
		text2.setFont(font2);
		text2.setOpaque(false);
		text2.setBackground(Color.BLACK);
		text2.setForeground(Color.WHITE);
		text2.setVisible(true);
		
		description = new RoundJTextField();
		description.setBounds(55, 555, 430, 160);
		description.setBackground(Color.BLACK);
		description.setForeground(Color.WHITE);
		description.setHorizontalAlignment(SwingConstants.LEFT);
		description.setMaximumSize(new Dimension(430, 160));
		description.setBorder(new LineBorder(Color.WHITE, 2, true));
		description.setFont(font);
		description.setVisible(true);
		
		income_divorces = new RoundJTextField();
		income_divorces.setBounds(515, 555, 430, 60);
		income_divorces.setBackground(Color.BLACK);
		income_divorces.setForeground(Color.WHITE);
		income_divorces.setBorder(new LineBorder(Color.WHITE, 3, true));
		income_divorces.setFont(font);
		income_divorces.setVisible(true);
		
		create = new JButton(prop.getProperty("properties.create.create")); //Usar properties
		create.setBounds(588, 675, 285, 40);
		create.setFont(font);
		create.setBorder(new LineBorder(Color.BLACK, 2, true));
		create.setVisible(true);
		
		add(title);
		add(photo1);
		add(photo2);
		add(photo3);
		add(photo4);
		add(text1);
		add(text2);
		add(description);
		add(income_divorces);
		add(create);
	}

	/**
	 * @return the photo1
	 */
	public JButton getPhoto1() {
		return photo1;
	}

	/**
	 * @param photo1 the photo1 to set
	 */
	public void setPhoto1(JButton photo1) {
		this.photo1 = photo1;
	}

	/**
	 * @return the photo2
	 */
	public JButton getPhoto2() {
		return photo2;
	}

	/**
	 * @param photo2 the photo2 to set
	 */
	public void setPhoto2(JButton photo2) {
		this.photo2 = photo2;
	}

	/**
	 * @return the photo3
	 */
	public JButton getPhoto3() {
		return photo3;
	}

	/**
	 * @param photo3 the photo3 to set
	 */
	public void setPhoto3(JButton photo3) {
		this.photo3 = photo3;
	}

	/**
	 * @return the photo4
	 */
	public JButton getPhoto4() {
		return photo4;
	}

	/**
	 * @param photo4 the photo4 to set
	 */
	public void setPhoto4(JButton photo4) {
		this.photo4 = photo4;
	}

	/**
	 * @return the create
	 */
	public JButton getCreate() {
		return create;
	}

	/**
	 * @param create the create to set
	 */
	public void setCreate(JButton create) {
		this.create = create;
	}

	/**
	 * @return the text2
	 */
	public JLabel getText2() {
		return text2;
	}

	/**
	 * @param text2 the text2 to set
	 */
	public void setText2(JLabel text2) {
		this.text2 = text2;
	}

	/**
	 * @return the description
	 */
	public JTextField getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(JTextField description) {
		this.description = description;
	}

	/**
	 * @return the income_divorces
	 */
	public JTextField getIncome_divorces() {
		return income_divorces;
	}

	/**
	 * @param income_divorces the income_divorces to set
	 */
	public void setIncome_divorces(JTextField income_divorces) {
		this.income_divorces = income_divorces;
	}
	
	
	
	
}
