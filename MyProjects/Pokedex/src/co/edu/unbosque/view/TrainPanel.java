package co.edu.unbosque.view;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TrainPanel extends JPanel{
	
	private ArrayList<String> abilitiesC1;
	private ArrayList<String> abilitiesC2;
	private ArrayList<String> abilitiesC3;
	private ArrayList<String> abilitiesC4;
	private Font titlefont;
	private Font labelfont;
	private JLabel nomnum;
	private JLabel pokeimg;
	private JLabel abilities_label;
	private JComboBox<String> hab1;
	private JComboBox<String> hab2;
	private JComboBox<String> hab3;
	private JComboBox<String> hab4;
	private JButton train_Butt;
	
	
	public TrainPanel(String name, int id, ArrayList<String> C1, ArrayList<String> C2, ArrayList<String> C3, ArrayList<String> C4) {
		String aux_name = name, url = name;
		if (name.contains("-")) {
			aux_name = name.split("-")[0];
			url = name.split("-")[1];
		}
		this.nomnum = new JLabel(aux_name+" #"+id);
		abilitiesC1 = C1;
		abilitiesC2 = C2;
		abilitiesC3 = C3;
		abilitiesC4 = C4;
		
		setBorder(new LineBorder(Color.BLACK, 5, true));
		titlefont = new Font("Acme", Font.BOLD, 30);
		labelfont = new Font("Acme", Font.BOLD, 15);
		setBackground(new Color(142, 154, 247));
		setBounds(38, 35, 925, 520);
		setLayout(null);
		init(url);
		setVisible(true);
	}
	
	public void init(String url) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		nomnum.setHorizontalAlignment(SwingConstants.CENTER);
		nomnum.setBounds(170, 100, 200, 40);
		nomnum.setBackground(Color.white);
		nomnum.setOpaque(true);
		nomnum.setBorder(new LineBorder(Color.BLACK, 3, true));
		nomnum.setFont(titlefont);
		nomnum.setVisible(true);
		
		pokeimg = new JLabel();
		pokeimg.setBounds(130, 150, 300, 300);
		BufferedImage bi2 = null;
		try {
			bi2 = ImageIO.read(new File("src/imgs/pokemons/"+url+".png"));
			Image pokemon1_resized = bi2.getScaledInstance(pokeimg.getWidth(), pokeimg.getHeight(), Image.SCALE_SMOOTH);
			pokeimg.setIcon(new ImageIcon(pokemon1_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		pokeimg.setVisible(true);
		
		
		abilities_label = new JLabel("Habilidades:");
		abilities_label.setFont(titlefont);
		abilities_label.setBounds(550, 100, 300, 38);
		
		String[] a1 = new String[abilitiesC1.size()];
		a1 = abilitiesC1.toArray(a1);
		hab1 = new JComboBox<>(a1);
		hab1.setEditable(true);
		hab1.setBounds(550, 150, 300, 50);
		hab1.setPreferredSize(getSize());
		hab1.setFont(labelfont);
		hab1.setVisible(true);
		
		String[] a2 = new String[abilitiesC2.size()];
		a2 = abilitiesC1.toArray(a2);
		hab2 = new JComboBox<>(a2);
		hab2.setEditable(true);
		hab2.setBounds(550, 220, 300, 50);
		hab2.setPreferredSize(getSize());
		hab2.setFont(labelfont);
		hab2.setVisible(true);
		
		String[] a3 = new String[abilitiesC3.size()];
		a3 = abilitiesC1.toArray(a3);
		hab3 = new JComboBox<>(a3);
		hab3.setEditable(true);
		hab3.setBounds(550, 290, 300, 50);
		hab3.setPreferredSize(getSize());
		hab3.setFont(labelfont);
		hab3.setVisible(true);
		
		String[] a4 = new String[abilitiesC4.size()];
		a4 = abilitiesC1.toArray(a4);
		hab4 = new JComboBox<>(a4);
		hab4.setEditable(true);
		hab4.setBounds(550, 360, 300, 50);
		hab4.setPreferredSize(getSize());
		hab4.setFont(labelfont);
		hab1.setVisible(true);
		
		train_Butt = new JButton("Entrenar");
		train_Butt.setBounds(590, 450, 200, 40);
		train_Butt.setFont(labelfont);
		train_Butt.setForeground(new Color(255, 204, 0));
		train_Butt.setBackground(Color.black);
		train_Butt.setBorder(new LineBorder(new Color(255, 204, 0), 2, true));
		train_Butt.setVisible(true);
		
		add(abilities_label);
		add(hab1);
		add(hab2);
		add(hab3);
		add(hab4);
		add(nomnum);
		add(pokeimg);
		add(train_Butt);
	}

	/**
	 * @return the hab1
	 */
	public JComboBox<String> getHab1() {
		return hab1;
	}

	/**
	 * @param hab1 the hab1 to set
	 */
	public void setHab1(JComboBox<String> hab1) {
		this.hab1 = hab1;
	}

	/**
	 * @return the hab2
	 */
	public JComboBox<String> getHab2() {
		return hab2;
	}

	/**
	 * @param hab2 the hab2 to set
	 */
	public void setHab2(JComboBox<String> hab2) {
		this.hab2 = hab2;
	}

	/**
	 * @return the hab3
	 */
	public JComboBox<String> getHab3() {
		return hab3;
	}

	/**
	 * @param hab3 the hab3 to set
	 */
	public void setHab3(JComboBox<String> hab3) {
		this.hab3 = hab3;
	}

	/**
	 * @return the hab4
	 */
	public JComboBox<String> getHab4() {
		return hab4;
	}

	/**
	 * @param hab4 the hab4 to set
	 */
	public void setHab4(JComboBox<String> hab4) {
		this.hab4 = hab4;
	}

	/**
	 * @return the train_Butt
	 */
	public JButton getTrain_Butt() {
		return train_Butt;
	}

	/**
	 * @param train_Butt the train_Butt to set
	 */
	public void setTrain_Butt(JButton train_Butt) {
		this.train_Butt = train_Butt;
	}
	
	
}
