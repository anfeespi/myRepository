package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Properties;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import co.edu.unbosque.model.RoundDTO;
import co.edu.unbosque.model.persistence.FileHandler;
/**
 * Es el panel de la ventana donde aparecen las batallas
 * @author Andres Espitia Rodriguez, Diego Alejandro Forero Espitia, Jaime Esteban Mejia Arevalo, Juan Camilo Uribe Pava
 *
 **/
public class BattlesPanel extends JPanel{
	/**
	 *Es el panel de batallas
	 **/
	private JPanel pnl_battles;
	/**
	 *Son los tipos de fuentes
	 **/
	private Font titleFont, subTitleFont;
	/**
	 *Boton que devuelve
	 **/
	private JButton btn_back;
	/**
	 *El titulo del panel
	 **/
	private JLabel title;
	/**
	 *Las batallas que han sido registradas
	 **/
	private ArrayList<JLabel> lbl_battles;
	/**
	 *Las propiedades del idioma
	 **/
	private Properties propLang;
	/**
	 *Las propiedades del thema
	 **/
	private Properties propTheme;
	/**
	 * el color de las letras
	 **/
	private String color_str;
	/**
	 * Color
	 **/
	private Color c;
	/**
	 * Metodo constructor
	 * @param selLang Lenguaje
	 * @param selTheme Tema
	 */
	public BattlesPanel(int selLang, int selTheme) {
		propLang = FileHandler.loadPropertiesLang(selLang);
		propTheme = FileHandler.loadPropertiesTheme(selTheme);
		color_str = propTheme.getProperty("persistence.frames.color");
		if (color_str.equals("White")) {
			c = Color.WHITE;
		} else {
			c = Color.BLACK;
		}
		titleFont= new Font("Transformers Movie", 0, 67);
		subTitleFont= new Font("Transformers Movie", 0, 16);
		setBounds(36, 110, 1000, 700);
		setLayout(null);
		setOpaque(false);
		init();
		setVisible(true);
	}
	/**
	 * Metodo que inicias
	 **/
	public void init() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println(e);
		}

		//Titulos
		title= new JLabel(propLang.getProperty("persistence.battlesframe.title"));
		title.setBounds(345,40,310,50);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(c);
		title.setFont(titleFont);
		title.setVisible(true);
		add(title);

		//Botones
		btn_back = new JButton();
		btn_back.setBounds(42, 572, 70, 70);
		try {
			BufferedImage bi = ImageIO.read(new File(propTheme.getProperty("persistence.btn_img")));
			Image resized = bi.getScaledInstance(btn_back.getWidth(), btn_back.getHeight(), Image.SCALE_SMOOTH);
			btn_back.setIcon(new ImageIcon(resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		btn_back.setVisible(true);
		btn_back.setContentAreaFilled(false);
		add(btn_back);
	}
	/**
	 * Metodo que agrega batallas
	 **/
	public void initBattles(ArrayList<RoundDTO> rounds){
		pnl_battles = new JPanel();
		pnl_battles.setBounds(150, 107, 700, 535);
		pnl_battles.setLayout(null);
		if(c.equals(Color.white)){
			pnl_battles.setBackground(new Color(255, 255, 255, 123));
		}else{
			pnl_battles.setBackground(new Color(0, 0, 0, 123));
		}
		int y = 0;
		for(int i=0; i<rounds.size(); i++){
			JLabel aux = new JLabel(rounds.get(i).toString());
			aux.setBounds(0, y, pnl_battles.getWidth(), 30);
			aux.setFont(subTitleFont);
			aux.setForeground(c);
			aux.setHorizontalAlignment(SwingConstants.CENTER);
			y+=35;
			aux.setVisible(true);
			pnl_battles.add(aux);
		}
		pnl_battles.setVisible(true);
		add(pnl_battles);
	}

	/**
	 * @return the btn_back
	 */
	public JButton getBtn_back() {
		return btn_back;
	}

	/**
	 * @param btn_back the btn_back to set
	 */
	public void setBtn_back(JButton btn_back) {
		this.btn_back = btn_back;
	}

	/**
	 * @return the lbl_battles
	 */
	public ArrayList<JLabel> getLbl_battles() {
		return lbl_battles;
	}

	/**
	 * @param lbl_battles the lbl_battles to set
	 */
	public void setLbl_battles(ArrayList<JLabel> lbl_battles) {
		this.lbl_battles = lbl_battles;
	}


}
