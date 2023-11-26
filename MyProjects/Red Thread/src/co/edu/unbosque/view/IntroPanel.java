package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
/**
 * Panel Principal de la introduccion
 * @author Andres Espitia
 * @author Diego Forero
 * @author Esteban Mejia
 * @author Camilo Uribe
 *
 */
public class IntroPanel extends JPanel{
	/**
	 * Gif de la introduccion
	 */
	private JLabel intro;
	/**
	 * Metodo Constructor
	 */
	public IntroPanel() {
		setBounds(0, 0, 500, 500);
		setLayout(null);
		setBackground(Color.BLACK);
		initComponents();
	}
	/**
	 * Metodo donde iniciamos nuestros objetos
	 */
	public void initComponents() {
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		intro = new JLabel();
		intro.setBounds(10, 160, 500, 120);
		
		ImageIcon im = new ImageIcon(getClass().getResource("/co/edu/unbosque/util/media/GUIImgs/RedThread.gif"));
		ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
		intro.setIcon(icono);
		
		intro.setVisible(true);
		
		add(intro);
		
	}
}
