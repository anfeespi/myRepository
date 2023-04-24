package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import co.edu.unbosque.model.persistence.FileHandler;
	/**
	* Clase que carga la imagen de fondo
	* @author Andres Espitia Rodriguez, Diego Alejandro Forero Espitia, Jaime Esteban Mejia Arevalo, Juan Camilo Uribe Pava
	*
	**/
public class Background extends JLabel{
	/**
	* Son las propiedades
	**/
	private Properties prop;
	/**
	 * Metodo constructor
	 * @param sel Seleccion
	 */
	public Background(int sel) {
		prop = FileHandler.loadPropertiesTheme(sel);
		setBounds(-36, -110, 1160, 1160);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File(prop.getProperty("persistence.background.frames")));
			Image resized = bi.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
}
