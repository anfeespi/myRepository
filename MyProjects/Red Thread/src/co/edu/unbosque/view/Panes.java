package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;

/**
 * Clase para utilizar JOptionPane personalizados
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class Panes extends JFrame {
	/**
	 * Panel principal
	 */
	private JPanel panel;
	/**
	 * Mensaje
	 */
	private JLabel message;
	/**
	 * Boton de ok
	 */
	private JButton ok;
	/**
	 * Logo
	 */
	private JLabel icon;
	/**
	 * Fuente
	 */
	private Font font;
	
	
	/**
	 * Constructor
	 */
	public Panes() {
		setSize(550, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false);
		setLayout(null);
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
		font = new Font("Raleway", 0, 16);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 550, 200);
		panel.setLayout(null);
		panel.setBackground(Color.BLACK);
		
		message = new JLabel();
		message.setBounds(180, 50, 400, 25);
		message.setForeground(Color.WHITE);
		message.setBackground(Color.BLACK);
		message.setFont(font);
		message.setVisible(true);
		
		icon = new JLabel();
		icon.setBounds(100, 30, 71, 62);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/media/GUIImgs/RedThreadIcon.png"));
			Image title_resized = bi.getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH);
			icon.setIcon(new ImageIcon(title_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		icon.setVisible(true);
		
		ok = new JButton("OK");
		ok.setBounds(225, 90, 100, 30);
		ok.setFont(font);
		ok.setBorder(new LineBorder(Color.BLACK, 2, true));
		ok.setVisible(true);
		
	}

	/**
	 * Metodo para mostrar un mensaje
	 * @param text
	 */
	public void showMessage(String text) {
		message.setText(text);
		
		add(panel);
		panel.add(message);
		panel.add(icon);
		panel.add(ok);
		
		setVisible(true);
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
}
