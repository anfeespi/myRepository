package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CardBackGround extends JLabel{
	public CardBackGround() {
		setBounds(0, 0, 400, 600);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File("src/imgs/presets/preset_carta.png"));
			Image resized = bi.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
			setIcon(new ImageIcon(resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		setVisible(true);
	}
}
