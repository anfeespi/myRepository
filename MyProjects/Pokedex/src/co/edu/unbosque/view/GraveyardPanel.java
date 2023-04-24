package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class GraveyardPanel extends JPanel{
	
	private String namepok;
	private JScrollPane pokescroll;
	private JLabel poke_ghost;
	private JLabel poke_aux;
	private PokePanel pokpa;
	private Font buttonfont;
	private JButton delete_button;
	private Color yellow = new Color(255, 204, 0);
	private Color bg_color = new Color(64, 70, 118);
	
	public GraveyardPanel(ArrayList<String> names) {
		setBackground(bg_color);
		setBorder(new LineBorder(Color.BLACK, 5, true));
		buttonfont = new Font("Acme", Font.BOLD, 15);
		setBounds(38, 35, 925, 520);
		setLayout(null);
		init(names);
		setVisible(true);
	}
	
	public void init(ArrayList<String> names) {
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		
		
		initPanel(names);
		
		poke_ghost = new JLabel();
		poke_aux = new JLabel();
		setVisibleAnotherPok("Zekrom");
		
		pokescroll = new JScrollPane();
		pokescroll.setViewportView(pokpa);
		pokescroll.setBounds(10, 10, 640, 500);
		pokescroll.setVisible(true);
		
		
		delete_button = new JButton("Q.E.P.D");
		delete_button.setBounds(688, 408, 200, 40);
		delete_button.setFont(buttonfont);
		delete_button.setForeground(yellow);
		delete_button.setBackground(Color.black);
		delete_button.setBorder(new LineBorder(yellow, 2, true));
		delete_button.setVisible(true);
		
		add(pokescroll);
		add(poke_ghost);
		add(delete_button);

	}
	
	public void initPanel(ArrayList<String> names) {
		if (names.size()%4 != 0) {
			pokpa = new PokePanel((names.size()/4)+1, 4, names);
			pokpa.setBackground(bg_color);
			pokpa.setLocation(10, 10);
			pokpa.setVisible(true);
		} else {
			pokpa = new PokePanel(names.size()/4, 4, names);
			pokpa.setBackground(bg_color);
			pokpa.setLocation(10, 10);
			pokpa.setVisible(true);
		}
	
	}
	
	public void setVisibleAnotherPok(String link) {
		String url;
		if (link.contains("-")) {			
			namepok = link.split("-")[0];
			url = link.split("-")[1];
		} else {
			namepok = link;	
			url = link;
		}
		poke_ghost.setVisible(false);
		poke_aux.setBounds(664, 146, 250, 250);
		try {
			BufferedImage bi = ImageIO.read(new File("src/imgs/pokemons/"+url+".png"));
			Image pokemon1_resized = bi.getScaledInstance(poke_aux.getWidth(), poke_aux.getHeight(), Image.SCALE_SMOOTH);
			poke_aux.setIcon(new ImageIcon(pokemon1_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		poke_aux.setVisible(true);
		add(poke_aux);
		repaint();
	}
	
	public void pokeDie() {
		poke_aux.setVisible(false);
		poke_ghost.setBounds(664, 146, 250, 250);
		try {
			BufferedImage bi = ImageIO.read(new File("src/imgs/pokemons/fantasma.png"));
			Image pokemon1_resized = bi.getScaledInstance(poke_ghost.getWidth(), poke_ghost.getHeight(), Image.SCALE_SMOOTH);
			poke_ghost.setIcon(new ImageIcon(pokemon1_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		poke_ghost.setVisible(true);
		add(poke_ghost);
		repaint();
	}

	/**
	 * @return the pokpa
	 */
	public PokePanel getPokpa() {
		return pokpa;
	}

	/**
	 * @param pokpa the pokpa to set
	 */
	public void setPokpa(PokePanel pokpa) {
		this.pokpa = pokpa;
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

	/**
	 * @return the namepok
	 */
	public String getNamepok() {
		return namepok;
	}

	/**
	 * @param namepok the namepok to set
	 */
	public void setNamepok(String namepok) {
		this.namepok = namepok;
	}
}
