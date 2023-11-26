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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import co.edu.unbosque.model.OrientationDAO;
import co.edu.unbosque.model.persistence.FileHandler;

/**
 * Panel para la ventana de Inicio de Sesion
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class SignInPanel extends JPanel{
	/**
	 * Titulo
	 */
	private JLabel title;
	/**
	 * Area de texto para el nombre
	 */
	private JTextField name;
	/**
	 * Area de texto para el primer apellido
	 */
	private JTextField firstLastname;
	/**
	 * Area de texto para el segundo apellido
	 */
	private JTextField secondLastname;
	/**
	 * Area de texto para el alias
	 */
	private JTextField alias;
	/**
	 * Fecha de nacimiento
	 */
	private JLabel dof;
	/**
	 * Dias del mes
	 */
	private JComboBox<Integer> day;
	/**
	 * Arreglo con los dias del mes
	 */
	private Integer[] days;
	/**
	 * Meses del año
	 */
	private JComboBox<Integer> month;
	/**
	 * Arreglo con los meses
	 */
	private Integer[] months;
	/**
	 * Años
	 */
	private JComboBox<Integer> year;
	/**
	 * Arreglo con los ultimos 102 años
	 */
	private Integer[] years;
	/**
	 * Campo de texto para el email
	 */
	private JTextField email;
	/**
	 * Genero
	 */
	private JComboBox<String> gender;
	/**
	 * Generos
	 */
	private String[] genders;
	/**
	 * Orientacion Sexual
	 */
	private JComboBox<String> orientation;
	/**
	 * Arreglo con las orientaciones sexuales
	 */
	private String[] orientations;
	/**
	 * Pais de origen
	 */
	private JTextField origin;
	/**
	 * Pais de residencia
	 */
	private JTextField residence;
	/**
	 * Contacto
	 */
	private JTextField contact;
	/**
	 * Contrasena
	 */
	private JTextField password;
	/**
	 * Crear cuenta
	 */
	private JButton signIn;
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
	 * Metodo constructor
	 */
	public SignInPanel(int lang) {
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		prop = FileHandler.loadPropertiesLang(lang);
		genders = new String[2];
		genders[0]= prop.getProperty("properties.update.male");
		genders[1]= prop.getProperty("properties.update.female");
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
		font = new Font("Raleway", 0, 30);
		font2 = new Font("Raleway", 0, 25);
		setBackground(Color.BLACK);
		
		title = new JLabel();
		title.setBounds(354, 5, 493, 145);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/RedThread.png"));
			Image title_resized = bi.getScaledInstance(title.getWidth(), title.getHeight(), Image.SCALE_SMOOTH);
			title.setIcon(new ImageIcon(title_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		title.setVisible(true);
		
		name = new RoundJTextField();
		name.setBounds(125, 170, 450, 50);
		TextPrompt placeholder_n = new TextPrompt("Name", name);
	    placeholder_n.changeAlpha(1.25f);
	    placeholder_n.changeStyle(font);//Usar properties
		name.setFont(font);
		name.setVisible(true);
		
		firstLastname = new RoundJTextField();
		firstLastname.setBounds(125, 248, 450, 50);
		TextPrompt placeholder_fl = new TextPrompt("First Lastname", firstLastname);
	    placeholder_fl.changeAlpha(1.25f);
	    placeholder_fl.changeStyle(font);//Usar properties
		firstLastname.setFont(font);
		firstLastname.setVisible(true);
		
		secondLastname = new RoundJTextField();
		secondLastname.setBounds(125, 323, 450, 50);
		TextPrompt placeholder_sl = new TextPrompt("Second Lastname", secondLastname);
	    placeholder_sl.changeAlpha(1.25f);
	    placeholder_sl.changeStyle(font);//Usar properties
		secondLastname.setFont(font);
		secondLastname.setVisible(true);
		
		alias = new RoundJTextField();
		alias.setBounds(125, 398, 450, 50);
		TextPrompt placeholder_a = new TextPrompt("Alias", alias);
	    placeholder_a.changeAlpha(1.25f);
	    placeholder_a.changeStyle(font);//Usar properties
		alias.setFont(font);
		alias.setVisible(true);
		
		dof = new JLabel("Date of birth"); //Usar properties
		dof.setBounds(275, 480, 170, 35);
		dof.setFont(font2);
		dof.setOpaque(false);
		dof.setBackground(Color.BLACK);
		dof.setForeground(Color.WHITE);
		dof.setVisible(true);
		
		days = new Integer[31];
		for (int i = 1; i <= 31; i++) {
			days[i-1] = i;
		}
		
		day = new JComboBox<Integer>(days);
		day.setBounds(125, 545, 145, 50);
		day.setFont(font);
		day.setVisible(true);
		
		months = new Integer[12];
		for (int i = 1; i <= 12; i++) {
			months[i-1] = i;
		}
		
		month = new JComboBox<Integer>(months);
		month.setBounds(275, 545, 145, 50);
		month.setFont(font);
		month.setVisible(true);
		
		years = new Integer[84];
		int it=0;
		for (int i = 2004; i >= 1921; i--) {
			years[it] = i;
			it++;
		}
		
		year = new JComboBox<Integer>(years);
		year.setBounds(430, 545, 145, 50);
		year.setFont(font);
		year.setVisible(true);
		
		email = new RoundJTextField();
		email.setBounds(626, 170, 450, 50);
		TextPrompt placeholder_e = new TextPrompt("Email", email);
	    placeholder_e.changeAlpha(1.25f);
	    placeholder_e.changeStyle(font);//Usar properties
		email.setFont(font);
		email.setVisible(true);
		
		gender = new JComboBox<String>(genders);
		gender.setBounds(626, 248, 450, 50);
		gender.setFont(font);
		gender.setVisible(true);
		
		new OrientationDAO();
		orientations = new String[OrientationDAO.orientations.size()/2];
		it=0;
		for (int i = 0; i < OrientationDAO.orientations.size(); i+=2) {
			orientations[it] = OrientationDAO.orientations.get(i).getOrientation();
			it++;
		}
		
		orientation = new JComboBox<String>(orientations);
		orientation.setBounds(626, 323, 450, 50);
		orientation.setFont(font);
		orientation.setVisible(true);
		
		origin = new RoundJTextField();
		origin.setBounds(626, 398, 450, 50);
		TextPrompt placeholder_o = new TextPrompt("Country of Origin", origin);
	    placeholder_o.changeAlpha(1.25f);
	    placeholder_o.changeStyle(font);//Usar properties
		origin.setFont(font);
		origin.setVisible(true);
		
		residence = new RoundJTextField();
		residence.setBounds(626, 476, 450, 50);
		TextPrompt placeholder_r = new TextPrompt("Country of Residence", residence);
	    placeholder_r.changeAlpha(1.25f);
	    placeholder_r.changeStyle(font);//Usar properties
		residence.setFont(font);
		residence.setVisible(true);
		
		contact = new RoundJTextField();
		contact.setBounds(626, 544, 450, 50);
		TextPrompt placeholder_co = new TextPrompt("Contact", contact);
	    placeholder_co.changeAlpha(1.25f);
	    placeholder_co.changeStyle(font);//Usar properties
		contact.setFont(font);
		contact.setVisible(true);
		
		password = new RoundJTextField();
		password.setBounds(125, 612, 450, 50);
		TextPrompt placeholder_pass = new TextPrompt("Password", password);
		placeholder_pass.changeAlpha(1.25f);
		placeholder_pass.changeStyle(font);//Usar properties
		password.setFont(font);
		password.setVisible(true);
		
		signIn = new JButton("Sign in"); //Usar properties
		signIn.setBounds(626, 612, 450, 50);
		signIn.setFont(font);
		signIn.setBorder(new LineBorder(Color.BLACK, 2, true));
		signIn.setVisible(true);
		
		add(title);
		add(name);
		add(firstLastname);
		add(secondLastname);
		add(alias);
		add(dof);
		add(day);
		add(month);
		add(year);
		add(email);
		add(gender);
		add(orientation);
		add(origin);
		add(residence);
		add(password);
		add(contact);
		add(signIn);
	}

	/**
	 * @return the name
	 */
	public JTextField getTextName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setTextName(JTextField name) {
		this.name = name;
	}

	/**
	 * @return the firstLastname
	 */
	public JTextField getFirstLastname() {
		return firstLastname;
	}

	/**
	 * @param firstLastname the firstLastname to set
	 */
	public void setFirstLastname(JTextField firstLastname) {
		this.firstLastname = firstLastname;
	}

	/**
	 * @return the secondLastname
	 */
	public JTextField getSecondLastname() {
		return secondLastname;
	}

	/**
	 * @param secondLastname the secondLastname to set
	 */
	public void setSecondLastname(JTextField secondLastname) {
		this.secondLastname = secondLastname;
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
	 * @return the dof
	 */
	public JLabel getDof() {
		return dof;
	}

	/**
	 * @param dof the dof to set
	 */
	public void setDof(JLabel dof) {
		this.dof = dof;
	}

	/**
	 * @return the day
	 */
	public JComboBox<Integer> getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(JComboBox<Integer> day) {
		this.day = day;
	}

	/**
	 * @return the month
	 */
	public JComboBox<Integer> getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(JComboBox<Integer> month) {
		this.month = month;
	}

	/**
	 * @return the age
	 */
	public JComboBox<Integer> getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(JComboBox<Integer> year) {
		this.year = year;
	}

	/**
	 * @return the email
	 */
	public JTextField getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(JTextField email) {
		this.email = email;
	}

	/**
	 * @return the gender
	 */
	public JComboBox<String> getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(JComboBox<String> gender) {
		this.gender = gender;
	}

	/**
	 * @return the orientation
	 */
	public JComboBox<String> getOrientation() {
		return orientation;
	}

	/**
	 * @param orientation the orientation to set
	 */
	public void setOrientation(JComboBox<String> orientation) {
		this.orientation = orientation;
	}

	/**
	 * @return the origin
	 */
	public JTextField getOrigin() {
		return origin;
	}

	/**
	 * @param origin the origin to set
	 */
	public void setOrigin(JTextField origin) {
		this.origin = origin;
	}

	/**
	 * @return the residence
	 */
	public JTextField getResidence() {
		return residence;
	}

	/**
	 * @param residence the residence to set
	 */
	public void setResidence(JTextField residence) {
		this.residence = residence;
	}

	/**
	 * @return the contact
	 */
	public JTextField getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(JTextField contact) {
		this.contact = contact;
	}

	/**
	 * @return the logIn
	 */
	public JButton getLogIn() {
		return signIn;
	}

	/**
	 * @param logIn the logIn to set
	 */
	public void setLogIn(JButton logIn) {
		this.signIn = logIn;
	}

	/**
	 * @return the password
	 */
	public JTextField getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(JTextField password) {
		this.password = password;
	}
	
	
}
