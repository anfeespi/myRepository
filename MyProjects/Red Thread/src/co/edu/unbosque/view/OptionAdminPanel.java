package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

import co.edu.unbosque.model.persistence.FileHandler;

/**
 * Panel para mostrar opciones de administrador
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class OptionAdminPanel extends JPanel {
	/**
	 * Boton para mostrar usuarios
	 */
	private JButton show_users;
	/**
	 * Mostrar estadisticas
	 */
	private JButton stats;
	/**
	 * Generar reportes
	 */
	private JButton reports;
	/**
	 * Cambiar el idioma
	 */
	private JButton language;
	/**
	 * Cerrar sesion
	 */
	private JButton logOut;
	/**
	 * Mostrar/Borrar
	 */
	private JButton ShowDelete;
	/**
	 * Fuente
	 */
	private Font font;
	/**
	 * 
	 */
	private Properties prop;
	/**
	 * Metodo constructor
	 */
	public OptionAdminPanel(int lang) {
		setLayout(null);
		prop = FileHandler.loadPropertiesLang(lang);
		initComponents();
	}

	/**
	 * Metodo para inicializar 
	 */
	private void initComponents() {
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		setBackground(Color.BLACK);
		font = new Font("Raleway", 0, 25);
		
		show_users = new JButton(prop.getProperty("properties.option.admin.show.user"));//Utilizar prop
		show_users.setBounds(0, 0, 240, 40);
		show_users.setFont(font);
		show_users.setBackground(Color.BLACK);
		show_users.setForeground(Color.WHITE);
		show_users.setVisible(true);
		
		stats = new JButton(prop.getProperty("properties.option.admin.show.stats"));//Utilizar prop
		stats.setBounds(0, 40, 240, 40);
		stats.setFont(font);
		stats.setBackground(Color.BLACK);
		stats.setForeground(Color.WHITE);
		stats.setVisible(true);
		
		language = new JButton(prop.getProperty("properties.option.admin.language"));//Utilizar prop
		language.setBounds(0, 80, 240, 40);
		language.setFont(font);
		language.setBackground(Color.BLACK);
		language.setForeground(Color.WHITE);
		language.setVisible(true);
		
		reports = new JButton(prop.getProperty("properties.option.admin.generate"));//Utilizar prop
		reports.setBounds(0, 120, 240, 40);
		reports.setFont(font);
		reports.setBackground(Color.BLACK);
		reports.setForeground(Color.WHITE);
		reports.setVisible(true);
		
		ShowDelete = new JButton(prop.getProperty("properties.option.admin.show/delete"));//Utilizar prop
		ShowDelete.setBounds(0, 160, 240, 40);
		ShowDelete.setFont(font);
		ShowDelete.setBackground(Color.BLACK);
		ShowDelete.setForeground(Color.WHITE);
		ShowDelete.setVisible(true);
		
		logOut = new JButton(prop.getProperty("properties.option.admin.logout"));//Utilizar prop
		logOut.setBounds(0, 200, 240, 40);
		logOut.setFont(font);
		logOut.setBackground(Color.BLACK);
		logOut.setForeground(Color.WHITE);
		logOut.setVisible(true);
		
		add(show_users);
		add(language);
		add(reports);
		add(stats);
		add(ShowDelete);
		add(logOut);
	}

	/**
	 * @return the show_users
	 */
	public JButton getShow_users() {
		return show_users;
	}

	/**
	 * @param show_users the show_users to set
	 */
	public void setShow_users(JButton show_users) {
		this.show_users = show_users;
	}

	/**
	 * @return the stats
	 */
	public JButton getStats() {
		return stats;
	}

	/**
	 * @param stats the stats to set
	 */
	public void setStats(JButton stats) {
		this.stats = stats;
	}

	/**
	 * @return the reports
	 */
	public JButton getReports() {
		return reports;
	}

	/**
	 * @param reports the reports to set
	 */
	public void setReports(JButton reports) {
		this.reports = reports;
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

	/**
	 * @return the showDelete
	 */
	public JButton getShowDelete() {
		return ShowDelete;
	}

	/**
	 * @param showDelete the showDelete to set
	 */
	public void setShowDelete(JButton showDelete) {
		ShowDelete = showDelete;
	}
}
