package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import co.edu.unbosque.model.OrientationDAO;
import co.edu.unbosque.model.UserDTO;
import co.edu.unbosque.model.persistence.FileHandler;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
/**
 * Panel para editar el perfil de usuario
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class CustomProfilePanel extends JPanel{
	/**
	 * Fuente 1
	 */
	private Font font;
	/**
	 * Icono de la aplicacion
	 */
	private JLabel icon;
	/**
	 * Alias que escogio el usuario
	 */
	private JTextField txtAlias;
	/**
	 * Email del usuario
	 */
	private JTextField txtEmail;
	/**
	 * Pais de origen
	 */
	private JTextField txtCOO;
	/**
	 * Pais de residencia
	 */
	private JTextField txtCOR;
	/**
	 * Numero o forma de contacto
	 */
	private JTextField txtContact;
	/**
	 * Cantidad de matches del usuario
	 */
	private JTextField txtMatches;
	/**
	 * Orientacion del usuario
	 */
	private JComboBox<String> orientation;
	/**
	 * Boton para actualizar la info del usuario
	 */
	private JButton btnUpdate;
	/**
	 * Boton de ajustes generales
	 */
	private JButton btnSettings;
	/**
	 * Arreglo con las orientaciones sexuales
	 */
	private String[] orientations;
	/**
	 * Panel de opciones
	 */
	private OptionUsersPanel op_panel;
	/**
	 * Propiedades
	 */
	private Properties prop;
	private TextPrompt placeholder_u;
	private TextPrompt placeholder_e;
	private TextPrompt placeholder_coo;
	private TextPrompt placeholder_cor;
	private TextPrompt placeholder_c;
	/**
	 * Metodo constructor
	 */
	public CustomProfilePanel(int lang) {
		setBackground(Color.BLACK);
		setBounds(0, 0, 1200, 700);
		setLayout(null);
		prop = FileHandler.loadPropertiesLang(lang);
		initComponents(lang);
	}

	/**
	 * Donde se inicializan los componentes del panel
	 */
	private void initComponents(int lang) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println(e);
		}
		font = new Font("Raleway", 0, 30);
		
		icon = new JLabel();
		icon.setBounds(64, 13, 124, 110);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/RedThreadIcon.png"));
			Image icon_resized = bi.getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH);
			icon.setIcon(new ImageIcon(icon_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(icon);
		
		
		txtAlias = new RoundJTextField();
		txtAlias.setHorizontalAlignment(SwingConstants.CENTER);
		txtAlias.setFont(font);
		txtAlias.setBounds(112, 170, 450, 50);
		add(txtAlias);
		
		txtEmail = new RoundJTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setFont(font);
		txtEmail.setBounds(112, 260, 450, 50);
		add(txtEmail);
		
		txtCOO = new RoundJTextField();
		txtCOO.setHorizontalAlignment(SwingConstants.CENTER);
		txtCOO.setFont(font);
		txtCOO.setBounds(638, 170, 450, 50);
		add(txtCOO);
		
		txtCOR = new RoundJTextField();
		txtCOR.setHorizontalAlignment(SwingConstants.CENTER);
		txtCOR.setFont(font);
		txtCOR.setBounds(638, 260, 450, 50);
		add(txtCOR);
		
		txtContact = new RoundJTextField();
		txtContact.setHorizontalAlignment(SwingConstants.CENTER);
		txtContact.setFont(font);
		txtContact.setBounds(638, 351, 450, 50);
		add(txtContact);
		
		txtMatches = new RoundJTextField();
		txtMatches.setEditable(false);
		txtMatches.setHorizontalAlignment(SwingConstants.CENTER);
		txtMatches.setFont(font);
		txtMatches.setBounds(638, 440, 450, 50);
		add(txtMatches);
		
		orientations = new String[OrientationDAO.orientations.size()/2];
		int it=0;
		for (int i = 0; i < OrientationDAO.orientations.size(); i+=2) {
			orientations[it] = OrientationDAO.orientations.get(i).getOrientation();
			it++;
		}
		
		orientation = new JComboBox<>(orientations);
		orientation.setBounds(112, 350, 450, 50);
		orientation.setFont(font);
		add(orientation);
		
		btnUpdate = new JButton(prop.getProperty("properties.update.update"));
		btnUpdate.setBounds(490, 560, 220, 50);
		btnUpdate.setFont(font);
		add(btnUpdate);
		
		btnSettings = new JButton("");
		btnSettings.setBackground(Color.BLACK);
		btnSettings.setBounds(1066, 33, 70, 70);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/optionicon.png"));
			Image title_resized = bi.getScaledInstance(btnSettings.getWidth(), btnSettings.getHeight(), Image.SCALE_SMOOTH);
			btnSettings.setIcon(new ImageIcon(title_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(btnSettings);
		
		op_panel = new OptionUsersPanel(lang);
		
	}
	
	/**
	 * Cambia los placeholders
	 * @param u objeto
	 */
	public void replacePlaceholders(UserDTO u){
		
		placeholder_u = new TextPrompt(u.getAlias(), txtAlias);
	    placeholder_u.changeAlpha(1.25f);
	    placeholder_u.changeStyle(font);
	    
	    placeholder_e = new TextPrompt(u.getEmail(), txtEmail);
	    placeholder_e.changeAlpha(1.25f);
	    placeholder_e.changeStyle(font);
	    
	    placeholder_coo = new TextPrompt(u.getOrigin(), txtCOO);
	    placeholder_coo.changeAlpha(1.25f);
	    placeholder_coo.changeStyle(font);
	    placeholder_cor = new TextPrompt(u.getResidence(), txtCOR);
	    placeholder_cor.changeAlpha(1.25f);
	    placeholder_cor.changeStyle(font);
	    
	    placeholder_c = new TextPrompt(u.getContact(), txtContact);
	    placeholder_c.changeAlpha(1.25f);
	    placeholder_c.changeStyle(font);
	    
	    txtMatches.setText(prop.getProperty("properties.update.matches")+": "+u.getMatches());
	}
	
	/**
	 * Muestra el panel de opciones
	 */
	public void showOptions() {
		op_panel.setBounds(826, 33, 240, 160);
		op_panel.setVisible(true);
		add(op_panel);
	}

	/**
	 * @return the icon
	 */
	public JLabel getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(JLabel icon) {
		this.icon = icon;
	}

	/**
	 * @return the txtAlias
	 */
	public JTextField getTxtAlias() {
		return txtAlias;
	}

	/**
	 * @param txtAlias the txtAlias to set
	 */
	public void setTxtAlias(JTextField txtAlias) {
		this.txtAlias = txtAlias;
	}

	/**
	 * @return the txtEmail
	 */
	public JTextField getTxtEmail() {
		return txtEmail;
	}

	/**
	 * @param txtEmail the txtEmail to set
	 */
	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}

	/**
	 * @return the txtCOO
	 */
	public JTextField getTxtCOO() {
		return txtCOO;
	}

	/**
	 * @param txtCOO the txtCOO to set
	 */
	public void setTxtCOO(JTextField txtCOO) {
		this.txtCOO = txtCOO;
	}

	/**
	 * @return the txtCOR
	 */
	public JTextField getTxtCOR() {
		return txtCOR;
	}

	/**
	 * @param txtCOR the txtCOR to set
	 */
	public void setTxtCOR(JTextField txtCOR) {
		this.txtCOR = txtCOR;
	}

	/**
	 * @return the txtContact
	 */
	public JTextField getTxtContact() {
		return txtContact;
	}

	/**
	 * @param txtContact the txtContact to set
	 */
	public void setTxtContact(JTextField txtContact) {
		this.txtContact = txtContact;
	}

	/**
	 * @return the txtMatches
	 */
	public JTextField getTxtMatches() {
		return txtMatches;
	}

	/**
	 * @param txtMatches the txtMatches to set
	 */
	public void setTxtMatches(JTextField txtMatches) {
		this.txtMatches = txtMatches;
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
	 * @return the btnUpdate
	 */
	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	/**
	 * @param btnUpdate the btnUpdate to set
	 */
	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	/**
	 * @return the btnSettings
	 */
	public JButton getBtnSettings() {
		return btnSettings;
	}

	/**
	 * @param btnSettings the btnSettings to set
	 */
	public void setBtnSettings(JButton btnSettings) {
		this.btnSettings = btnSettings;
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
}

