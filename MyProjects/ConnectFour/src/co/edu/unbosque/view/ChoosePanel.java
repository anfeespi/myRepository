package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import co.edu.unbosque.model.persistence.FileHandler;
/**
 * Es el panel donde estaran los botones para elegir idioma y tema
 * @author Andres Espitia Rodriguez, Diego Alejandro Forero Espitia, Jaime Esteban Mejia Arevalo, Juan Camilo Uribe Pava
 *
 **/
public class ChoosePanel extends JPanel{
	/**
	 * Los textos de lenguaje y tema
	 **/
	private JLabel language, theme;
	/**
	 * Boton para guardar los datos
	 **/
	private JButton btnSave;
	/**
	 *  Los combobox que tendran las distintas opciones
	 **/
	private JComboBox<String> chcLanguage, chcTheme;
	/**
	 * Las fuentes del panel
	 **/
	private Font titleFont, comboFont;
	/**
	 * Los archivos Properties
	 **/
	private Properties propLang, propTheme;
	/**
	 *  Los lenguajes a elegir
	 **/
	private String[] languages;
	/**
	 *  Los temas a elegir
	 **/
	private String[] themes;
	/**
	 * Metodo Constructor
	 **/
	public ChoosePanel() {
		propLang = FileHandler.loadPropertiesLang(2);
		propTheme = FileHandler.loadPropertiesTheme(1);
		languages = new String[2];
		themes = new String[2];
		languages[0] = propLang.getProperty("persistence.chooseframe.english");
		languages[1] = propLang.getProperty("persistence.chooseframe.spanish");
		themes[0] = propLang.getProperty("persistence.chooseframe.white");
		themes[1] = propLang.getProperty("persistence.chooseframe.black");
		titleFont = new Font("Transformers Movie", 0, 25);
		comboFont = new Font("Transformers Movie", 0, 15);
		setBounds(0, 0, 500, 500);
		setLayout(null);
		setOpaque(false);
		init();
		setVisible(true);
	}
	/**
	 * Iniciar componentes
	 **/
	public void init() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println(e);
		}
		language = new JLabel(propLang.getProperty("persistence.chooseframe.language"));
		language.setForeground(Color.WHITE);
		language.setHorizontalAlignment(SwingConstants.CENTER);
		language.setBounds(150,200,300,50);
		language.setFont(titleFont);
		language.setVisible(true);
		add(language);

		theme= new JLabel(propLang.getProperty("persistence.chooseframe.theme"));
		theme.setForeground(Color.WHITE);
		theme.setHorizontalAlignment(SwingConstants.CENTER);
		theme.setFont(titleFont);
		theme.setBounds(150,300,300,50);
		theme.setVisible(true);
		add(theme);

		btnSave = new JButton(propLang.getProperty("persistence.chooseframe.saveBtn"));
		btnSave.setBounds(150,400,300,50);
		btnSave.setFont(titleFont);
		btnSave.setVisible(true);
		add(btnSave);

		chcLanguage = new JComboBox<String>(languages);
		chcLanguage.setFont(comboFont);
		chcLanguage.setBounds(150,250,300,50);
		add(chcLanguage);

		chcTheme = new JComboBox<String>(themes);
		chcTheme.setFont(comboFont);
		chcTheme.setBounds(150,350,300,50);
		add(chcTheme);
	}
	/**
	 * @return the btnSave
	 */
	public JButton getBtnSave() {
		return btnSave;
	}
	/**
	 * @param btnSave the btnSave to set
	 */
	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	/**
	 * @return the language
	 */
	public JLabel getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(JLabel language) {
		this.language = language;
	}
	/**
	 * @return the theme
	 */
	public JLabel getTheme() {
		return theme;
	}
	/**
	 * @param theme the theme to set
	 */
	public void setTheme(JLabel theme) {
		this.theme = theme;
	}
	/**
	 * @return the chcLanguage
	 */
	public JComboBox<String> getChcLanguage() {
		return chcLanguage;
	}
	/**
	 * @param chcLanguage the chcLanguage to set
	 */
	public void setChcLanguage(JComboBox<String> chcLanguage) {
		this.chcLanguage = chcLanguage;
	}
	/**
	 * @return the chcTheme
	 */
	public JComboBox<String> getChcTheme() {
		return chcTheme;
	}
	/**
	 * @param chcTheme the chcTheme to set
	 */
	public void setChcTheme(JComboBox<String> chcTheme) {
		this.chcTheme = chcTheme;
	}
	/**
	 * @return the titleFont
	 */
	public Font getTitleFont() {
		return titleFont;
	}
	/**
	 * @param titleFont the titleFont to set
	 */
	public void setTitleFont(Font titleFont) {
		this.titleFont = titleFont;
	}
	/**
	 * @return the propLang
	 */
	public Properties getPropLang() {
		return propLang;
	}
	/**
	 * @param propLang the propLang to set
	 */
	public void setPropLang(Properties propLang) {
		this.propLang = propLang;
	}
	/**
	 * @return the propTheme
	 */
	public Properties getPropTheme() {
		return propTheme;
	}
	/**
	 * @param propTheme the propTheme to set
	 */
	public void setPropTheme(Properties propTheme) {
		this.propTheme = propTheme;
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
	/**
	 * @return the themes
	 */
	public String[] getThemes() {
		return themes;
	}
	/**
	 * @param themes the themes to set
	 */
	public void setThemes(String[] themes) {
		this.themes = themes;
	}
}
