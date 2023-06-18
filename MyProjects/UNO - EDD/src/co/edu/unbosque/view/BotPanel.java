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
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class BotPanel extends JPanel{
	
	/**
	 * Fuente que lleva el panel
	 */
	private Font font;
	private Font font_two;
	/**
	 * Label que tiene el gif del bot
	 */
	private JLabel bot;
	/**
	 * Label con la imagen de la nube en la que va en texto
	 */
	private JLabel cloud;
	/**
	 * Label con el texto
	 */
	private JTextArea text;
	/**
	 * Label con el fondo
	 */
	private JLabel backgroundlbl;
	private JButton accept;
	
	public BotPanel(String str) {
		setBounds(0 , 0, 550, 295);
		setLayout(null);
		init(str);
	}
	
	public void init(String str) {
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		font = new Font("Impact", 0, 24);
		font_two = new Font("Impact", 0, 16);
		
		setBorder(new LineBorder(Color.WHITE, 3, true));
		setBackground(Color.BLACK);
		
		backgroundlbl = new JLabel();
		backgroundlbl.setBounds(0, 0, 550, 320);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/backgroundUNO.jpg"));
			Image background_resized = bi.getScaledInstance(backgroundlbl.getWidth(), backgroundlbl.getHeight(), Image.SCALE_SMOOTH);
			backgroundlbl.setIcon(new ImageIcon(background_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		backgroundlbl.setVisible(true);
		
		bot = new JLabel();
		bot.setBounds(400, 170, 137, 150);
		try {
			ImageIcon img = new javax.swing.ImageIcon("src/co/edu/unbosque/util/img/bot.gif");
			bot.setIcon(img);
		} catch (Exception e) {
			e.printStackTrace();
		}
		bot.setVisible(true);
		
		cloud = new JLabel();
		cloud.setBounds(21, 22, 449, 207);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/cloud.png"));
			Image background_resized = bi.getScaledInstance(cloud.getWidth(), cloud.getHeight(), Image.SCALE_SMOOTH);
			cloud.setIcon(new ImageIcon(background_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		cloud.setVisible(true);
		
		text = new JTextArea(str, 2, 1);
		text.setBounds(36, 37, 390, 155);
		text.setBorder(null);
		text.setBackground(Color.decode("#D02424"));
		text.setForeground(Color.WHITE);
		text.setOpaque(false);
		text.setFont(font);
		text.setEditable(false);
		text.setLineWrap(true);
		text.setVisible(true);
		
		accept = new JButton("Aceptar");
		accept.setBounds(156,240,150,35);
		accept.setFont(font_two);
		accept.setBackground(Color.WHITE);
		accept.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		add(bot);
		add(text);
		add(cloud);
		add(accept);
		add(backgroundlbl);
	}

	/**
	 * @return the font
	 */
	public Font getFont() {
		return font;
	}

	/**
	 * @param font the font to set
	 */
	public void setFont(Font font) {
		this.font = font;
	}

	/**
	 * @return the font_two
	 */
	public Font getFont_two() {
		return font_two;
	}

	/**
	 * @param font_two the font_two to set
	 */
	public void setFont_two(Font font_two) {
		this.font_two = font_two;
	}

	/**
	 * @return the bot
	 */
	public JLabel getBot() {
		return bot;
	}

	/**
	 * @param bot the bot to set
	 */
	public void setBot(JLabel bot) {
		this.bot = bot;
	}

	/**
	 * @return the cloud
	 */
	public JLabel getCloud() {
		return cloud;
	}

	/**
	 * @param cloud the cloud to set
	 */
	public void setCloud(JLabel cloud) {
		this.cloud = cloud;
	}

	/**
	 * @return the text
	 */
	public JTextArea getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(JTextArea text) {
		this.text = text;
	}

	/**
	 * @return the backgroundlbl
	 */
	public JLabel getBackgroundlbl() {
		return backgroundlbl;
	}

	/**
	 * @param backgroundlbl the backgroundlbl to set
	 */
	public void setBackgroundlbl(JLabel backgroundlbl) {
		this.backgroundlbl = backgroundlbl;
	}

	/**
	 * @return the accept
	 */
	public JButton getAccept() {
		return accept;
	}

	/**
	 * @param accept the accept to set
	 */
	public void setAccept(JButton accept) {
		this.accept = accept;
	}
}
