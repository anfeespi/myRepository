package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * Apariencia y apartado visual de los portales, tanto de los azules de entrada y salida, como los rojos
 * @author Diego Forero
 * @author Andrés Espitia
 * @author Camilo Uribe
 *
 */
public class Portales extends JLabel {
	/**
	 * Metodo constructor 
	 * @param tipo_portal
	 */
	public Portales(String tipo_portal) {
		new JLabel();
		setSize(60, 95);
		if(tipo_portal.equals("azul-entrada")) {
			setLocation(240, 85);
		}else if(tipo_portal.equals("azul-salida")) {
			setLocation(0, 85);
		}else if(tipo_portal.equals("rojo-entrada")) {
			setLocation(240, 85);
		}else if(tipo_portal.equals("rojo-salida")) {
			setLocation(0, 85);
		}
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File("src/img/portal-"+tipo_portal+".png"));
			Image redimensionado = bi.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(redimensionado));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
	
}
