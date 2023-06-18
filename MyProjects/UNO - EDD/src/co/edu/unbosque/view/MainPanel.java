package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
/**
 * Panel principal del menu
 * @author Esteban Mejia
 * @author Andres Espitia	
 * @author Diego Forero
 * @author Camilo Uribe
 * @author David Gonzales
 *
 */
public class MainPanel extends JPanel {
	/**
	 * Imagen de fondo
	 */
	private JLabel backgroundimg;
	/**
	 * Imagen del robot
	 */
	private JLabel botimg;
	/**
	 * Imagen del titulo
	 */
	private JLabel titleimg;
	/**
	 * Boton de jugar
	 */
	private JButton playbtn;
	/**
	 * Boton de salir
	 */
	private JButton exitbtn;
	/**
	 * Fuente de texto
	 */
	private Font font;
	/**
	 * Metodo Constructor
	 */
	public MainPanel() {
		setBounds(0 , 0, 1200, 700);
		setLayout(null);
		init();
	}
	/**
	 * Metodo para iniciar componentes
	 */
	public void init() {
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		
		font = new Font("Impact", 0, 64);
		
		backgroundimg = new JLabel();
		backgroundimg.setBounds(0, 0, 1200, 700);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/backgroundUNO.jpg"));
			Image background_resized = bi.getScaledInstance(backgroundimg.getWidth(), backgroundimg.getHeight(), Image.SCALE_SMOOTH);
			backgroundimg.setIcon(new ImageIcon(background_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		backgroundimg.setVisible(true);
		
		botimg = new JLabel();
		botimg.setBounds(655,143,324,334);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/bot_explaining.png"));
			Image botimg_resized = bi.getScaledInstance(botimg.getWidth(), botimg.getHeight(), Image.SCALE_SMOOTH);
			botimg.setIcon(new ImageIcon(botimg_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		botimg.setVisible(true);
		
		titleimg = new JLabel();
		titleimg.setBounds(140,56,672,430);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/UNOTEACHER.png"));
			Image titleimg_resized = bi.getScaledInstance(titleimg.getWidth(), titleimg.getHeight(), Image.SCALE_SMOOTH);
			titleimg.setIcon(new ImageIcon(titleimg_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		playbtn = new JButton("Play");
		playbtn.setBounds(221,516,360,90);
		playbtn.setBackground(Color.WHITE);
		playbtn.setFont(font);
		playbtn.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		exitbtn = new JButton("Exit");
		exitbtn.setBounds(619,516,360,90);
		exitbtn.setBackground(Color.WHITE);
		exitbtn.setFont(font);
		exitbtn.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		add(exitbtn);
		add(playbtn);
		add(titleimg);
		add(botimg);
		add(backgroundimg);
		
	}
	/**
	 * @return the backgroundimg
	 */
	public JLabel getBackgroundimg() {
		return backgroundimg;
	}
	/**
	 * @param backgroundimg the backgroundimg to set
	 */
	public void setBackgroundimg(JLabel backgroundimg) {
		this.backgroundimg = backgroundimg;
	}
	/**
	 * @return the botimg
	 */
	public JLabel getBotimg() {
		return botimg;
	}
	/**
	 * @param botimg the botimg to set
	 */
	public void setBotimg(JLabel botimg) {
		this.botimg = botimg;
	}
	/**
	 * @return the titleimg
	 */
	public JLabel getTitleimg() {
		return titleimg;
	}
	/**
	 * @param titleimg the titleimg to set
	 */
	public void setTitleimg(JLabel titleimg) {
		this.titleimg = titleimg;
	}
	/**
	 * @return the playbtn
	 */
	public JButton getPlaybtn() {
		return playbtn;
	}
	/**
	 * @param playbtn the playbtn to set
	 */
	public void setPlaybtn(JButton playbtn) {
		this.playbtn = playbtn;
	}
	/**
	 * @return the exitbtn
	 */
	public JButton getExitbtn() {
		return exitbtn;
	}
	/**
	 * @param exitbtn the exitbtn to set
	 */
	public void setExitbtn(JButton exitbtn) {
		this.exitbtn = exitbtn;
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
	
		
	
}
