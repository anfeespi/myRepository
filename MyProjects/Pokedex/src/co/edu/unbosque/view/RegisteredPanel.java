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

public class RegisteredPanel extends JPanel{
	
	private String name_pok;
	private Font buttonfont;
	private Color yellow = new Color(255, 204, 0);
	private Color violet = new Color(142, 154, 247);
	private PokePanel pokpa;
	private JScrollPane pokescroll;
	private JLabel poke_img;
	private JButton details_butt;
	private JButton train_butt;
	
	public RegisteredPanel(ArrayList<String> names) {
		buttonfont = new Font("Acme", Font.BOLD, 15);
		setBounds(38, 35, 925, 520);
		setLayout(null);
		init(names);
	}
	
	public void init(ArrayList<String> names) {
		
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		
		setBackground(violet);
		setBorder(new LineBorder(Color.BLACK, 5, true));
		
		initPanel(names);
		
		poke_img = new JLabel();
		setVisibleAnotherPok("Zekrom");
		
		details_butt = new JButton("Detalles");
		details_butt.setBounds(700, 350, 200, 40);
		details_butt.setFont(buttonfont);
		details_butt.setForeground(yellow);
		details_butt.setBackground(Color.BLACK);
		details_butt.setBorder(new LineBorder(yellow, 3, true));
		details_butt.setVisible(true);
		
		train_butt = new JButton("Entrenar");
		train_butt.setBounds(700, 400, 200, 40);
		train_butt.setFont(buttonfont);
		train_butt.setForeground(yellow);
		train_butt.setBackground(Color.BLACK);
		train_butt.setBorder(new LineBorder(yellow, 3, true));
		train_butt.setVisible(true);
		
		pokescroll = new JScrollPane();
		pokescroll.setViewportView(pokpa);
		pokescroll.setBounds(10, 10, 640, 500);
		pokescroll.setVisible(true);
		
		add(pokescroll);
		add(details_butt);
		add(train_butt);
	}
	
	public void setVisibleAnotherPok(String link) {
		String url;
		name_pok = link;	
		if (link.contains("-")) {
			url = link.split("-")[1];
		} else {
			url = link;
		}
		poke_img.setBounds(700, 100, 200, 200);
		try {
			BufferedImage bi = ImageIO.read(new File("src/imgs/pokemons/"+url+".png"));
			Image pokemon1_resized = bi.getScaledInstance(poke_img.getWidth(), poke_img.getHeight(), Image.SCALE_SMOOTH);
			poke_img.setIcon(new ImageIcon(pokemon1_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		poke_img.setVisible(true);
		add(poke_img);
		repaint();
	}
	
	public void initPanel(ArrayList<String> names) {
		if (names.size()%4 != 0) {
			pokpa = new PokePanel((names.size()/4)+1, 4, names);
			pokpa.setBackground(violet);
			pokpa.setLocation(10, 10);
			pokpa.setVisible(true);
		} else {
			pokpa = new PokePanel(names.size()/4, 4, names);
			pokpa.setBackground(violet);
			pokpa.setLocation(10, 10);
			pokpa.setVisible(true);
		}
	
	}

	/**
	 * @return the details_butt
	 */
	public JButton getDetails_butt() {
		return details_butt;
	}

	/**
	 * @param details_butt the details_butt to set
	 */
	public void setDetails_butt(JButton details_butt) {
		this.details_butt = details_butt;
	}

	/**
	 * @return the train_butt
	 */
	public JButton getTrain_butt() {
		return train_butt;
	}

	/**
	 * @param train_butt the train_butt to set
	 */
	public void setTrain_butt(JButton train_butt) {
		this.train_butt = train_butt;
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
	 * @return the name_pok
	 */
	public String getName_pok() {
		return name_pok;
	}

	/**
	 * @param name_pok the name_pok to set
	 */
	public void setName_pok(String name_pok) {
		this.name_pok = name_pok;
	}
}
