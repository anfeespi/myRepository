package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class PokePanel extends JPanel{
	private int rows;
	private int columns;
	private JButton[][] boxes;
	
	public PokePanel(int rows, int columns, ArrayList<String> names) {
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		this.rows = rows;
		this.columns = columns;
		setBackground(new Color(142, 154, 247));
		setLayout(null);
		setPreferredSize(new Dimension(columns*150, (rows*165)+20));
		
		boxes = new JButton[rows][columns];
		int x = 10, y = 10, n = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				boxes[i][j] = new JButton();
				boxes[i][j].setBackground(new Color(142, 154, 247));
				boxes[i][j].setBounds(x, y, 150, 165);
				try {					
					putPokemons(boxes[i][j], names.get(n));
				} catch (Exception e) {
					putPokemons(boxes[i][j], "fantasma");
				}
				boxes[i][j].setVisible(true);
				
				add(boxes[i][j]);
				x += 150;
				n++;
			}
			y += 165;
			x = 10;
		}
	}
	
	public void putPokemons(JButton aux, String name) {
		if (name.contains("-")) {
			try {
				BufferedImage bi = ImageIO.read(new File("src/imgs/pokemons/"+name.split("-")[1]+".png"));
				Image pokemon1_resized = bi.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
				aux.setIcon(new ImageIcon(pokemon1_resized));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				BufferedImage bi = ImageIO.read(new File("src/imgs/pokemons/"+name+".png"));
				Image pokemon1_resized = bi.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
				aux.setIcon(new ImageIcon(pokemon1_resized));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return the boxes
	 */
	public JButton[][] getBoxes() {
		return boxes;
	}

	/**
	 * @param boxes the boxes to set
	 */
	public void setBoxes(JButton[][] boxes) {
		this.boxes = boxes;
	}
	
	
}
