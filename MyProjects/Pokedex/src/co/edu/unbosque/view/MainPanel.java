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

public class MainPanel extends JPanel{
	
	private JLabel background;
	private JLabel title;
	private JLabel pokemon1;
	private JLabel pokemon2;
	private Font buttonfont;
	private JButton registered_button;
	private JButton new_pokemon_button;
	private JButton delete_button;
	private Color yellow = new Color(255, 204, 0);
	private Color blue = new Color(0, 117, 190);
	
	public MainPanel() {
		buttonfont = new Font("Acme", Font.BOLD, 15);
		setBounds(38, 35, 925, 520);
		setLayout(null);
		init();
		setVisible(true);
	}
	
	public void init() {
		
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		
		background = new JLabel();
		background.setBounds(0, 0, 925, 520);
		try {
			ImageIcon img = new javax.swing.ImageIcon("src/imgs/presets/fondo_panel_principal.gif");
			background.setIcon(img);
		} catch (Exception e) {
			e.printStackTrace();
		}
		background.setVisible(true);
		
		title = new JLabel();
		title.setBounds(300, 30, 325, 212);
		try {
			BufferedImage bi = ImageIO.read(new File("src/imgs/presets/title.png"));
			Image title_resized = bi.getScaledInstance(title.getWidth(), title.getHeight(), Image.SCALE_SMOOTH);
			title.setIcon(new ImageIcon(title_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		title.setVisible(true);
		
		pokemon1 = new JLabel();
		pokemon1.setBounds(20, 200, 250, 250);
		try {
			BufferedImage bi = ImageIO.read(new File("src/imgs/presets/Zekrom_principal.png"));
			Image pokemon1_resized = bi.getScaledInstance(pokemon1.getWidth(), pokemon1.getHeight(), Image.SCALE_SMOOTH);
			pokemon1.setIcon(new ImageIcon(pokemon1_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		pokemon1.setVisible(true);
		
		pokemon2 = new JLabel();
		pokemon2.setBounds(650, 200, 250, 250);
		try {
			BufferedImage bi = ImageIO.read(new File("src/imgs/presets/Reshiram_principal.png"));
			Image pokemon2_resized = bi.getScaledInstance(pokemon2.getWidth(), pokemon2.getHeight(), Image.SCALE_SMOOTH);
			pokemon2.setIcon(new ImageIcon(pokemon2_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		pokemon2.setVisible(true);
		
		registered_button = new JButton("Pokémons Registrados!");
		registered_button.setBounds(50, 450, 250, 40);
		registered_button.setFont(buttonfont);
		registered_button.setForeground(blue);
		registered_button.setBackground(yellow);
		registered_button.setVisible(true);
		
		new_pokemon_button = new JButton("Atrapé un pokemon!");
		new_pokemon_button.setBounds(335, 450, 250, 40);
		new_pokemon_button.setFont(buttonfont);
		new_pokemon_button.setForeground(blue);
		new_pokemon_button.setBackground(yellow);
		new_pokemon_button.setVisible(true);
		
		delete_button = new JButton("Pueblo Lavanda");
		delete_button.setBounds(625, 450, 250, 40);
		delete_button.setFont(buttonfont);
		delete_button.setForeground(blue);
		delete_button.setBackground(yellow);
		delete_button.setVisible(true);
		
		add(background);
		background.add(title);
		background.add(pokemon1);
		background.add(pokemon2);
		background.add(registered_button);
		background.add(new_pokemon_button);
		background.add(delete_button);
	}

	/**
	 * @return the registered_button
	 */
	public JButton getRegistered_button() {
		return registered_button;
	}

	/**
	 * @param registered_button the registered_button to set
	 */
	public void setRegistered_button(JButton registered_button) {
		this.registered_button = registered_button;
	}

	/**
	 * @return the new_pokemon_button
	 */
	public JButton getNew_pokemon_button() {
		return new_pokemon_button;
	}

	/**
	 * @param new_pokemon_button the new_pokemon_button to set
	 */
	public void setNew_pokemon_button(JButton new_pokemon_button) {
		this.new_pokemon_button = new_pokemon_button;
	}

	/**
	 * @return the delete_button
	 */
	public JButton getDelete_button() {
		return delete_button;
	}

	/**
	 * @param delete_button the delete_button to set
	 */
	public void setDelete_button(JButton delete_button) {
		this.delete_button = delete_button;
	}
	
	
}
