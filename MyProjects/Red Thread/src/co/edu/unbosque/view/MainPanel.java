package co.edu.unbosque.view;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
/**
 * Panel principal que muestra los perfiles interactivos de los usuarios
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class MainPanel extends JPanel{
	/**
	 * Fuente 1
	 */
	private Font font;
	/**
	 * Fuente 2
	 */
	private Font font2;
	/**
	 * Icono de la aplicacion
	 */
	private JLabel icon;
	/**
	 * Nombre y edad el usuario
	 */
	private JLabel lblNameAge;
	/**
	 * Descripcion del usuario
	 */
	private JTextArea txtDescription;
	/**
	 * Boton de me gusta
	 */
	private JButton btnLike;
	/**
	 * Boton de no me gusta
	 */
	private JButton btnDislike;
	/**
	 * Boton de superlike
	 */
	private JButton btnSuperlike;
	/**
	 * Boton de ajustes del perfil
	 */
	private JButton btnProfile;
	/**
	 * Boton de ajustes generales
	 */
	private JButton btnSettings;
	/**
	 * Imagen del usuario
	 */
	private JLabel image;
	/**
	 * Boton para ver la foto anterior
	 */
	private JButton btnLast;
	/**
	 * Boton para ver la sigueinte foto
	 */
	private JButton btnLast_1;
	/**
	 * Panel de opciones
	 */
	private OptionUsersPanel op_panel;
	
	/**
	 * Constructor
	 */
	public MainPanel(int lang) {
		setBackground(Color.BLACK);
		setBounds(0, 0, 1200, 700);
		setLayout(null);
		initComponents(lang);
	}
	
	/**
	 * Donde se inicializan los componentes del panel
	 */
	private void initComponents(int lang) {
		font = new Font("Raleway", 0, 40);
		font2 = new Font("Raleway", 0, 35);

		icon = new JLabel();
		icon.setBounds(64, 13, 124, 110);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/RedThreadIcon.png"));
			Image title_resized = bi.getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH);
			icon.setIcon(new ImageIcon(title_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(icon);
		
		lblNameAge = new JLabel("Name & Age");
		lblNameAge.setBounds(64, 153, 400, 47);
		lblNameAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblNameAge.setFont(font);
		lblNameAge.setOpaque(false);
		lblNameAge.setBackground(Color.BLACK);
		lblNameAge.setForeground(Color.WHITE);
		add(lblNameAge);
		
		txtDescription = new JTextArea();
		txtDescription.setBackground((new Color(41, 37, 37)));
		txtDescription.setForeground(Color.white);
		txtDescription.setText("Description");
		txtDescription.setBounds(507, 153, 629, 305);
		txtDescription.setFont(font2);
		txtDescription.setEditable(false);
		add(txtDescription);
		
		btnLike = new JButton("");
		btnLike.setBackground(Color.BLACK);
		btnLike.setBounds(567, 528, 120, 120);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/likeicon.png"));
			Image like_resized = bi.getScaledInstance(btnLike.getWidth()-10, btnLike.getHeight()-5, Image.SCALE_SMOOTH);
			btnLike.setIcon(new ImageIcon(like_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(btnLike);
		
		btnSuperlike = new JButton("");
		btnSuperlike.setBackground(Color.BLACK);
		btnSuperlike.setBounds(762, 468, 120, 120);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/superlikeicon.png"));
			Image superlike_resized = bi.getScaledInstance(btnSuperlike.getWidth(), btnSuperlike.getHeight(), Image.SCALE_SMOOTH);
			btnSuperlike.setIcon(new ImageIcon(superlike_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(btnSuperlike);
		
		btnDislike = new JButton("");
		btnDislike.setBackground(Color.BLACK);
		btnDislike.setBounds(957, 528, 120, 120);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/dislikeicon.png"));
			Image dislike_resized = bi.getScaledInstance(btnDislike.getWidth()+30, btnDislike.getHeight()+30, Image.SCALE_SMOOTH);
			btnDislike.setIcon(new ImageIcon(dislike_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(btnDislike);
		
		btnProfile = new JButton("");
		btnProfile.setBackground(Color.BLACK);
		btnProfile.setBounds(976, 33, 70, 70);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/profileicon.png"));
			Image profile_resized = bi.getScaledInstance(btnProfile.getWidth(), btnProfile.getHeight(), Image.SCALE_SMOOTH);
			btnProfile.setIcon(new ImageIcon(profile_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(btnProfile);
		
		btnSettings = new JButton("");
		btnSettings.setBackground(Color.BLACK);
		btnSettings.setBounds(1066, 33, 70, 70);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/optionicon.png"));
			Image settings_resized = bi.getScaledInstance(btnSettings.getWidth(), btnSettings.getHeight(), Image.SCALE_SMOOTH);
			btnSettings.setIcon(new ImageIcon(settings_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		add(btnSettings);
		
		image = new JLabel();
		
		op_panel = new OptionUsersPanel(lang);
		
		btnLast = new JButton("");
		btnLast.setBounds(64, 234, 50, 400);
		add(btnLast);
		
		btnLast_1 = new JButton("");
		btnLast_1.setBounds(414, 234, 50, 400);
		add(btnLast_1);
	}
	
	/**
	 * Metodo para cambiar la imagen
	 * @param url
	 */
	public void changeImage(String url) {
		if (image.isVisible()) {
			remove(image);
		}
		image = new JLabel();
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setBounds(114, 234, 300, 400);
		try {
			BufferedImage bi = ImageIO.read(new File(url));
			Image ima_resized = bi.getScaledInstance(image.getWidth(), image.getHeight()-20, Image.SCALE_SMOOTH);
			image.setIcon(new ImageIcon(ima_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		image.setOpaque(true);
		image.setBackground(Color.LIGHT_GRAY);
		image.setForeground(Color.BLACK);
		add(image);
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
	 * @return the lblNameAge
	 */
	public JLabel getLblNameAge() {
		return lblNameAge;
	}

	/**
	 * @param lblNameAge the lblNameAge to set
	 */
	public void setLblNameAge(JLabel lblNameAge) {
		this.lblNameAge = lblNameAge;
	}

	/**
	 * @return the txtDescription
	 */
	public JTextArea getTxtDescription() {
		return txtDescription;
	}

	/**
	 * @param txtDescription the txtDescription to set
	 */
	public void setTxtDescription(JTextArea txtDescription) {
		this.txtDescription = txtDescription;
	}

	/**
	 * @return the btnLike
	 */
	public JButton getBtnLike() {
		return btnLike;
	}

	/**
	 * @param btnLike the btnLike to set
	 */
	public void setBtnLike(JButton btnLike) {
		this.btnLike = btnLike;
	}

	/**
	 * @return the btnDislike
	 */
	public JButton getBtnDislike() {
		return btnDislike;
	}

	/**
	 * @param btnDislike the btnDislike to set
	 */
	public void setBtnDislike(JButton btnDislike) {
		this.btnDislike = btnDislike;
	}

	/**
	 * @return the btnSuperlike
	 */
	public JButton getBtnSuperlike() {
		return btnSuperlike;
	}

	/**
	 * @param btnSuperlike the btnSuperlike to set
	 */
	public void setBtnSuperlike(JButton btnSuperlike) {
		this.btnSuperlike = btnSuperlike;
	}

	/**
	 * @return the btnProfile
	 */
	public JButton getBtnProfile() {
		return btnProfile;
	}

	/**
	 * @param btnProfile the btnProfile to set
	 */
	public void setBtnProfile(JButton btnProfile) {
		this.btnProfile = btnProfile;
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
	 * @return the image
	 */
	public JLabel getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(JLabel image) {
		this.image = image;
	}

	/**
	 * @return the btnLast
	 */
	public JButton getBtnLast() {
		return btnLast;
	}

	/**
	 * @param btnLast the btnLast to set
	 */
	public void setBtnLast(JButton btnLast) {
		this.btnLast = btnLast;
	}

	/**
	 * @return the btnLast_1
	 */
	public JButton getBtnLast_1() {
		return btnLast_1;
	}

	/**
	 * @param btnLast_1 the btnLast_1 to set
	 */
	public void setBtnLast_1(JButton btnLast_1) {
		this.btnLast_1 = btnLast_1;
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
