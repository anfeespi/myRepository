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
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * Panel para la ventana de Inicio de Sesion
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class LogInPanel extends JPanel {
	/**
	 * Titulo
	 */
	private JLabel title;
	/**
	 * Usuario
	 */
	private JTextField username;
	/**
	 * Contraseña
	 */
	private JTextField password;
	/**
	 * Registrarse
	 */
	private JButton signIn;
	/**
	 * Iniciar sesion
	 */
	private JButton logIn;
	/**
	 * Olvidaste la contraseña
	 */
	private JButton forgotPassword;
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
	public LogInPanel(int lang) {
		setBounds(0, 0, 700, 600);
		setLayout(null);
		prop = FileHandler.loadPropertiesLang(lang);
		initComponents();
	}
	
	/**
	 * Metodo para inicializar componentes
	 */
	public void initComponents() {
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		font = new Font("Raleway", 0, 30);
		font2 = new Font("Raleway", 0, 20);
		setBackground(Color.BLACK);
		
		title = new JLabel();
		title.setBounds(129, 70, 442, 130);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/RedThread.png"));
			Image title_resized = bi.getScaledInstance(title.getWidth(), title.getHeight(), Image.SCALE_SMOOTH);
			title.setIcon(new ImageIcon(title_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		title.setVisible(true);
		
		username = new RoundJTextField();
		username.setBounds(125, 220, 450, 50);
		TextPrompt placeholder_u = new TextPrompt(prop.getProperty("properties.login.username"), username);
	    placeholder_u.changeAlpha(1.25f);
	    placeholder_u.changeStyle(font);
		username.setFont(font);
		username.setVisible(true);
		
		password = new RoundJTextField();
		password.setBounds(125, 300, 450, 50);
		TextPrompt placeholder_p = new TextPrompt(prop.getProperty("properties.login.password"), password);
	    placeholder_p.changeAlpha(1.25f);
	    placeholder_p.changeStyle(font);
		password.setFont(font);
		password.setVisible(true);
		
		signIn = new JButton(prop.getProperty("properties.login.signing")); //Usar properties
		signIn.setBounds(125, 410, 220, 40);
		signIn.setFont(font);
		signIn.setBorder(new LineBorder(Color.BLACK, 2, true));
		signIn.setVisible(true);
		
		logIn = new JButton(prop.getProperty("properties.login.login")); //Usar properties
		logIn.setBounds(355, 410, 220, 40);
		logIn.setFont(font);
		logIn.setBorder(new LineBorder(Color.BLACK, 2, true));
		logIn.setVisible(true);
		
		forgotPassword = new JButton(prop.getProperty("properties.login.forgot")); //Usar properties
		forgotPassword.setBounds(195, 465, 315, 35);
		forgotPassword.setFont(font2);
		forgotPassword.setOpaque(false);
		forgotPassword.setBackground(Color.BLACK);
		forgotPassword.setForeground(Color.WHITE);
		forgotPassword.setVisible(true);
		
		add(title);
		add(username);
		add(password);
		add(signIn);
		add(logIn);
		add(forgotPassword);
	}

	/**
	 * @return the username
	 */
	public JTextField getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(JTextField username) {
		this.username = username;
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

	/**
	 * @return the singIn
	 */
	public JButton getSignIn() {
		return signIn;
	}

	/**
	 * @param singIn the singIn to set
	 */
	public void setSignIn(JButton singIn) {
		this.signIn = singIn;
	}

	/**
	 * @return the logIn
	 */
	public JButton getLogIn() {
		return logIn;
	}

	/**
	 * @param logIn the logIn to set
	 */
	public void setLogIn(JButton logIn) {
		this.logIn = logIn;
	}

	/**
	 * @return the forgotPassword
	 */
	public JButton getForgotPassword() {
		return forgotPassword;
	}

	/**
	 * @param forgotPassword the forgotPassword to set
	 */
	public void setForgotPassword(JButton forgotPassword) {
		this.forgotPassword = forgotPassword;
	}
}
