package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PokeCard extends JFrame{
	
	private String name;
	private String types_text;
	private CardBackGround bg;
	private JLabel nomnum;
	private Font labelfont;
	private JLabel pokeimg;
	private int types;
	private JLabel type1, type2;
	private JLabel height;
	private JLabel weight;
	private JLabel gender;
	private JLabel hability;
	private JButton generation_Butt;
	
	public PokeCard(String name, int id, int types, String height, String weight, String gender, String hability, String types_text) {
		this.name = name;
		this.types_text = types_text;
		if (name.contains("-")) {			
			this.nomnum = new JLabel(name.split("-")[0]+" #"+id);
		} else {
			this.nomnum = new JLabel(name+" #"+id);
		}
		this.types = types;
		this.height = new JLabel(height);
		this.weight = new JLabel(weight);
		this.gender = new JLabel(gender);
		this.hability = new JLabel(hability);
		
		setSize(400, 630);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents();
	}
	
	public void initComponents() {
		String url = name;
		if (name.contains("-")) {			
			url = name.split("-")[1];
		}
		labelfont = new Font("Acme", Font.BOLD, 15);
		
		bg = new CardBackGround();
		
		nomnum.setHorizontalAlignment(SwingConstants.CENTER);
		nomnum.setBounds(121, 32, 158, 38);
		nomnum.setFont(labelfont);
		nomnum.setVisible(true);
		
		pokeimg = new JLabel();
		pokeimg.setBounds(75, 73, 250, 250);
		BufferedImage bi2 = null;
		try {
			bi2 = ImageIO.read(new File("src/imgs/pokemons/"+url+".png"));
			Image pokemon1_resized = bi2.getScaledInstance(pokeimg.getWidth(), pokeimg.getHeight(), Image.SCALE_SMOOTH);
			pokeimg.setIcon(new ImageIcon(pokemon1_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		pokeimg.setVisible(true);
		
		paintTypes(types_text);
		
		JLabel altaux = new JLabel("Altura: ");
		altaux.setBounds(85, 389, 59, 50);
		altaux.setFont(labelfont);
		altaux.setVisible(true);
		
		height.setBounds(85, 409, 59, 50);
		height.setFont(labelfont);
		height.setVisible(true);
		
		JLabel pesaux = new JLabel("Peso: ");
		pesaux.setBounds(85, 447, 59, 50);
		pesaux.setFont(labelfont);
		pesaux.setVisible(true);
		
		weight.setBounds(85, 467, 59, 50);
		weight.setFont(labelfont);
		weight.setVisible(true);
		
		JLabel genaux = new JLabel("Sexo: ");
		genaux.setBounds(226, 389, 59, 50);
		genaux.setFont(labelfont);
		genaux.setVisible(true);
		
		gender.setBounds(226, 409, 100, 50);
		gender.setFont(labelfont);
		gender.setVisible(true);
		
		JLabel habaux = new JLabel("Habilidad: ");
		habaux.setBounds(226, 447, 100, 50);
		habaux.setFont(labelfont);
		habaux.setVisible(true);
		
		hability.setBounds(226, 467, 100, 50);
		hability.setFont(labelfont);
		hability.setVisible(true);
		
		generation_Butt = new JButton("Generacion");
		generation_Butt.setBounds(100, 515, 200, 40);
		generation_Butt.setFont(labelfont);
		generation_Butt.setForeground(new Color(255, 204, 0));
		generation_Butt.setBackground(Color.black);
		generation_Butt.setBorder(new LineBorder(new Color(255, 204, 0), 2, true));
		generation_Butt.setVisible(true);
		
		add(bg);
		bg.add(nomnum);
		bg.add(pokeimg);
		bg.add(altaux);
		bg.add(height);
		bg.add(pesaux);
		bg.add(weight);
		bg.add(genaux);
		bg.add(gender);
		bg.add(habaux);
		bg.add(hability);
		bg.add(generation_Butt);
	}
	
	public void paintTypes(String stype) {
		if(types == 1) {
			type1 = new JLabel();
			type1.setBounds(143,342,106,40);;
			BufferedImage bi2 = null;
			try {
				bi2 = ImageIO.read(new File("src/imgs/types/type_"+stype.toLowerCase()+".png"));
				Image type_resized = bi2.getScaledInstance(type1.getWidth(), type1.getHeight(), Image.SCALE_SMOOTH);
				type1.setIcon(new ImageIcon(type_resized));
			} catch (Exception e) {
				e.printStackTrace();
			}
			type1.setVisible(true);
			bg.add(type1);
		}else if(types == 2) {
			type1 = new JLabel();
			type1.setBounds(73,342,106,40);;
			BufferedImage bi2 = null;
			try {
				bi2 = ImageIO.read(new File("src/imgs/types/type_"+stype.split("-")[0].toLowerCase()+".png"));
				Image type_resized = bi2.getScaledInstance(type1.getWidth(), type1.getHeight(), Image.SCALE_SMOOTH);
				type1.setIcon(new ImageIcon(type_resized));
			} catch (Exception e) {
				e.printStackTrace();
			}
			type1.setVisible(true);
			bg.add(type1);
			
			type2 = new JLabel();
			type2.setBounds(220,342,106,40);;
			bi2 = null;
			try {
				bi2 = ImageIO.read(new File("src/imgs/types/type_"+stype.split("-")[1].toLowerCase()+".png"));
				Image type_resized = bi2.getScaledInstance(type2.getWidth(), type2.getHeight(), Image.SCALE_SMOOTH);
				type2.setIcon(new ImageIcon(type_resized));
			} catch (Exception e) {
				e.printStackTrace();
			}
			type2.setVisible(true);
			bg.add(type2);
		}
	}

	/**
	 * @return the generation_Butt
	 */
	public JButton getGeneration_Butt() {
		return generation_Butt;
	}

	/**
	 * @param generation_Butt the generation_Butt to set
	 */
	public void setGeneration_Butt(JButton generation_Butt) {
		this.generation_Butt = generation_Butt;
	}
	
	
}
