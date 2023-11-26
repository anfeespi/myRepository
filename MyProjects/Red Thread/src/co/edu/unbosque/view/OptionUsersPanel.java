package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * Panel para mostrar las opciones
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class OptionUsersPanel extends JPanel {
	/**
	 * Ver matches
	 */
	private JButton matches;
	/**
	 * Cambiar el idioma
	 */
	private JButton language;
	/**
	 * Cerrar sesion
	 */
	private JButton logOut;
	/**
	 * Fuente
	 */
	private Font font;
	/**
	 * Propiedades
	 */
	private Properties prop;
	/**
	 * Metodo constructor
	 */
	public OptionUsersPanel(int lang) {
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
		setBackground(Color.BLACK);
		font = new Font("Raleway", 0, 25);
		
		matches = new JButton(prop.getProperty("properties.option.users.show"));
		matches.setBounds(0, 0, 240, 40);
		matches.setFont(font);
		matches.setBackground(Color.BLACK);
		matches.setForeground(Color.WHITE);
		matches.setVisible(true);
		
		language = new JButton(prop.getProperty("properties.option.users.language"));
		language.setBounds(0, 40, 240, 40);
		language.setFont(font);
		language.setBackground(Color.BLACK);
		language.setForeground(Color.WHITE);
		language.setVisible(true);
		
		logOut = new JButton(prop.getProperty("properties.option.users.logout"));
		logOut.setBounds(0, 80, 240, 40);
		logOut.setFont(font);
		logOut.setBackground(Color.BLACK);
		logOut.setForeground(Color.WHITE);
		logOut.setVisible(true);
		
		add(matches);
		add(language);
		add(logOut);
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
	 * @return the language
	 */
	public JButton getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(JButton language) {
		this.language = language;
	}

	/**
	 * @return the logOut
	 */
	public JButton getLogOut() {
		return logOut;
	}

	/**
	 * @param logOut the logOut to set
	 */
	public void setLogOut(JButton logOut) {
		this.logOut = logOut;
	}
}
