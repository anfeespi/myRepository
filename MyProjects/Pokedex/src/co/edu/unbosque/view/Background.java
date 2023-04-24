package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Background extends JLabel {
	public Background() {
		setBounds(0, 0, 1000, 672);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File("src/imgs/presets/preset_pantalla.png"));
			Image resized = bi.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
}
