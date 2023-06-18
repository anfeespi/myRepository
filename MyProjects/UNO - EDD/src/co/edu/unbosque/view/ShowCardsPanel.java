package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class ShowCardsPanel extends JPanel{
	/**
	 * Fuente que lleva el panel
	 */
	private Font font;
	private Font font_two;
	/**
	 * Label que tiene el gif del bot
	 */
	private JLabel text;
	/**
	 * Label con el fondo
	 */
	private JLabel backgroundlbl;
	private JButton accept;
	private JLabel[] cards;
	private JPanel cards_panel;
	private JScrollPane scroll;
	
	public ShowCardsPanel(String[] cards, String str) {
		setBounds(0 , 0, 550, 295);
		setLayout(null);
		init(cards, str);
	}
	
	public void init(String[] cards, String str) {
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
		
		text = new JLabel(str);
		text.setBounds(15,39,500, 40);
		text.setFont(font);
		text.setBackground(Color.WHITE);
		text.setOpaque(true);
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setBorder(new LineBorder(Color.BLACK, 2, true));
		text.setVisible(true);
		
		
		showCards(cards);
		
		accept = new JButton("Aceptar");
		accept.setBounds(156,240,150,35);
		accept.setFont(font_two);
		accept.setBackground(Color.WHITE);
		accept.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		add(text);
		add(accept);
		add(backgroundlbl);
	}
	
	public void showCards(String[] cards) {
		scroll = new JScrollPane();
		scroll.setBounds(35, 110, 469, 125);
		this.cards = new JLabel[cards.length];
		cards_panel = new JPanel();
		scroll.setViewportView(cards_panel);
		cards_panel.setLayout(null);
		cards_panel.setPreferredSize(new Dimension(this.cards.length*67, 100));
		cards_panel.setOpaque(false);
		int left = 0;
		for (int i = 0; i < cards.length; i++) {
			this.cards[i] = new JLabel();
			this.cards[i].setBounds(left,0,67,100);
			try {
				BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/"+cards[i]+".png"));
				Image player_cardbtn_resized = bi.getScaledInstance(this.cards[i].getWidth(),this.cards[i].getHeight(), Image.SCALE_SMOOTH);
				this.cards[i].setIcon(new ImageIcon(player_cardbtn_resized));
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.cards[i].setVisible(true);
			this.cards[i].setBackground(Color.BLUE);
			cards_panel.add(this.cards[i]);
			left+=67;
		}
		add(scroll);
		repaint();
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
	 * @return the text
	 */
	public JLabel getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(JLabel text) {
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
