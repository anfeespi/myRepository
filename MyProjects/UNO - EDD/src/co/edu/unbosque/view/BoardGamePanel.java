package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
/**
 * panel principal del tablero de juego
 * @author Esteban Mejia
 * @author Andres Espitia	
 * @author Diego Forero
 * @author Camilo Uribe
 * @author David Gonzalez
 *
 */
public class BoardGamePanel extends JPanel {
	/**
	 * Cartas del bot uno
	 */
	private JButton bot_cards_onebtn;
	/**
	 * Cartas del bot dos
	 */
	private JButton bot_cards_twobtn;
	/**
	 * Boton para botar carta
	 */
	private JButton throw_cardbtn;
	/**
	 * Boton para decir uno
	 */
	private JButton say_onebtn;
	/**
	 * Boton para coger carta
	 */
	private JButton pick_cardbtn;
	/**
	 * Boton para mostrar las cartas por debajo
	 */
	private JButton show_cardbtn;
	/**
	 * Las cartas que tiene el jugador
	 */
	private JButton[] player_cardbtn;
	/**
	 * Nombre del bot uno
	 */
	private VerticalLabel bot_one_namelbl;
	/**
	 * Nombre del bot dos
	 */
	private VerticalLabel bot_two_namelbl;
	/**
	 * Imagen que lleva el sentido del juego
	 */
	private JLabel directionlbl;
	/**
	 * Texto que inidica el jugador que juega
	 */
	private JLabel player_turnlbl;
	/**
	 * Imagen que muestra la carta que vas a tirar
	 */
	private JLabel select_cardlbl;
	/**
	 * Imagen de fondo del juego
	 */
	private JLabel backgroundlbl;
	/**
	 * Fuente que lleva el panel
	 */
	private Font font;
	private Font font_two;
	private JPanel buttons_panel;
	private JScrollPane scroll;
	private JButton show_steal_cards;
	
	public BoardGamePanel() {
		setBounds(0 , 0, 1200, 700);
		setLayout(null);
		init();
	}
	
	public void init() {
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		font = new Font("Impact", 0, 20);
		font_two = new Font("Impact", 0, 32);
		
		backgroundlbl = new JLabel();
		backgroundlbl.setBounds(0, 0, 1200, 700);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/backgroundUNO.jpg"));
			Image background_resized = bi.getScaledInstance(backgroundlbl.getWidth(), backgroundlbl.getHeight(), Image.SCALE_SMOOTH);
			backgroundlbl.setIcon(new ImageIcon(background_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		backgroundlbl.setVisible(true);
		
		bot_cards_onebtn = new JButton();
		bot_cards_onebtn.setBounds(110,137,105,277);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/sevencardsbot1.png"));
			Image bot_cards_onebtn_resized = bi.getScaledInstance(bot_cards_onebtn.getWidth(), bot_cards_onebtn.getHeight(), Image.SCALE_SMOOTH);
			bot_cards_onebtn.setIcon(new ImageIcon(bot_cards_onebtn_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		bot_cards_onebtn.setVisible(true);
		
		
		bot_cards_twobtn = new JButton();
		bot_cards_twobtn.setBounds(985,136,105,277);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/sevencardsbot2.png"));
			Image bot_cards_twobtn_resized = bi.getScaledInstance(bot_cards_twobtn.getWidth(), bot_cards_twobtn.getHeight(), Image.SCALE_SMOOTH);
			bot_cards_twobtn.setIcon(new ImageIcon(bot_cards_twobtn_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		bot_cards_twobtn.setVisible(true);
		
		throw_cardbtn = new JButton("Lanzar carta");
		throw_cardbtn.setBounds(996,582,150,35);
		throw_cardbtn.setFont(font);
		throw_cardbtn.setBackground(Color.WHITE);
		throw_cardbtn.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		say_onebtn = new JButton("UNO!");
		say_onebtn.setBounds(996,532,150,35);
		say_onebtn.setFont(font);
		say_onebtn.setBackground(Color.WHITE);
		say_onebtn.setBorder(new LineBorder(Color.BLACK, 2, true));
		
		player_cardbtn = new JButton[7];
		
		pick_cardbtn = new JButton();
		pick_cardbtn.setBounds(775,174,137,205);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/back_multi.png"));
			Image pick_cardbtn_resized = bi.getScaledInstance(pick_cardbtn.getWidth(), pick_cardbtn.getHeight(), Image.SCALE_SMOOTH);
			pick_cardbtn.setIcon(new ImageIcon(pick_cardbtn_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		pick_cardbtn.setBorder(new LineBorder(Color.WHITE, 8, false));
		pick_cardbtn.setVisible(true);
		
		show_steal_cards = new JButton("Mostrar Cartas");
		show_steal_cards.setBounds(775, 400, 137, 50);
		show_steal_cards.setFont(font);
		show_steal_cards.setBackground(Color.WHITE);
		show_steal_cards.setBorder(new LineBorder(Color.BLACK, 2, true));
		show_steal_cards.setVisible(true);
	
		directionlbl = new JLabel();
		directionlbl.setBounds(275,40,450,420);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/game_right.png"));
			Image directionlbl_resized = bi.getScaledInstance(directionlbl.getWidth(), directionlbl.getHeight(), Image.SCALE_SMOOTH);
			directionlbl.setIcon(new ImageIcon(directionlbl_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		directionlbl.setVisible(true);

		player_turnlbl = new JLabel("Turno de Jugador");
		player_turnlbl.setBounds(840,50,306,45);
		player_turnlbl.setFont(font);
		player_turnlbl.setBackground(Color.WHITE);
		player_turnlbl.setOpaque(true);
		player_turnlbl.setHorizontalAlignment(SwingConstants.CENTER);
		player_turnlbl.setBorder(new LineBorder(Color.BLACK, 2, true));
		player_turnlbl.setVisible(true);
		
		
		bot_one_namelbl = new VerticalLabel("Juan tiene 7 cartas");
		bot_one_namelbl.setRotation(VerticalLabel.ROTATE_LEFT);
		bot_one_namelbl.setBounds(60,110,39,300);
		bot_one_namelbl.setFont(font_two);
		bot_one_namelbl.setForeground(Color.WHITE);
		bot_one_namelbl.setVisible(true);
		
		bot_two_namelbl = new VerticalLabel("Mia tiene 7 cartas");
		bot_two_namelbl.setRotation(VerticalLabel.ROTATE_RIGHT);
		bot_two_namelbl.setBounds(1100,146,39,300);
		bot_two_namelbl.setFont(font_two);
		bot_two_namelbl.setForeground(Color.WHITE);
		bot_two_namelbl.setVisible(true);
		
		select_cardlbl = new JLabel();
		buttons_panel = new JPanel();
		show_cardbtn = new JButton();
		
		scroll = new JScrollPane();
		scroll.setViewportView(buttons_panel);
		scroll.setBounds(60, 470, 700, 171);
		scroll.setOpaque(false);
		scroll.setVisible(true);
		
		add(bot_two_namelbl);
		add(bot_one_namelbl);
		add(player_turnlbl);
		add(directionlbl);
		add(pick_cardbtn);
		add(show_steal_cards);
		add(say_onebtn);
		add(throw_cardbtn);
		add(bot_cards_twobtn);
		add(bot_cards_onebtn);
		add(scroll);
		add(backgroundlbl);
	}
	public void changeCardsBot(int pos, int cards) {
		if(pos==1) {
			bot_one_namelbl.setText("Juan tiene "+cards+" cartas");			
		}else if(pos==2) {
			bot_two_namelbl.setText("Mia tiene "+cards+" cartas");
		}
	}
	public void changeDirection(int dir) {
		if (dir == 1) {			
			try {
				BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/game_right.png"));
				Image directionlbl_resized = bi.getScaledInstance(directionlbl.getWidth(), directionlbl.getHeight(), Image.SCALE_SMOOTH);
				directionlbl.setIcon(new ImageIcon(directionlbl_resized));
			} catch (Exception e) {
				e.printStackTrace();
			}
			directionlbl.setVisible(true);
		} else {
			try {
				BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/game_left.png"));
				Image directionlbl_resized = bi.getScaledInstance(directionlbl.getWidth(), directionlbl.getHeight(), Image.SCALE_SMOOTH);
				directionlbl.setIcon(new ImageIcon(directionlbl_resized));
			} catch (Exception e) {
				e.printStackTrace();
			}
			directionlbl.setVisible(true);
		}
		repaint();
	}
	
	public void changeTurn(String text) {
		player_turnlbl.setText("Turno de: "+text);
		repaint();
	}
	
	public void changeSelectedCard(String card) {
		select_cardlbl.setBounds(885,500,100,150);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/"+card+".png"));
			Image select_card_resized = bi.getScaledInstance(select_cardlbl.getWidth(), select_cardlbl.getHeight(), Image.SCALE_SMOOTH);
			select_cardlbl.setIcon(new ImageIcon(select_card_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		select_cardlbl.setVisible(true);
		add(select_cardlbl);
		add(backgroundlbl);
		repaint();
	}
	
	public void changePlayerCards(String[] cards) {
		player_cardbtn = new JButton[cards.length];
		buttons_panel = new JPanel();
		scroll.setViewportView(buttons_panel);
		buttons_panel.setLayout(null);
		buttons_panel.setPreferredSize(new Dimension(player_cardbtn.length*100, 150));
		buttons_panel.setOpaque(false);
		int left = 0;
		for (int i = 0; i < cards.length; i++) {
			player_cardbtn[i] = new JButton();
			player_cardbtn[i].setBounds(left,0,100,150);
			try {
				BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/"+cards[i]+".png"));
				Image player_cardbtn_resized = bi.getScaledInstance(player_cardbtn[i].getWidth(),player_cardbtn[i].getHeight(), Image.SCALE_SMOOTH);
				player_cardbtn[i].setIcon(new ImageIcon(player_cardbtn_resized));
			} catch (Exception e) {
				e.printStackTrace();
			}
			player_cardbtn[i].setVisible(true);
			player_cardbtn[i].setBackground(Color.BLUE);
			buttons_panel.add(player_cardbtn[i]);
			left+=100;
		}
		repaint();
	}
	
	public void changeDiscard(String card) {
		show_cardbtn.setBounds(424,122,150,225);
		try {
			BufferedImage bi = ImageIO.read(new File("src/co/edu/unbosque/util/img/"+card+".png"));
			Image show_cardbtn_resized = bi.getScaledInstance(show_cardbtn.getWidth(), show_cardbtn.getHeight(), Image.SCALE_SMOOTH);
			show_cardbtn.setIcon(new ImageIcon(show_cardbtn_resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		show_cardbtn.setBorder(new LineBorder(Color.WHITE, 8, false));
		show_cardbtn.setVisible(true);
		add(show_cardbtn);
		add(backgroundlbl);
		repaint();
	}

	/**
	 * @return the bot_cards_onebtn
	 */
	public JButton getBot_cards_onebtn() {
		return bot_cards_onebtn;
	}
	/**
	 * @param bot_cards_onebtn the bot_cards_onebtn to set
	 */
	public void setBot_cards_onebtn(JButton bot_cards_onebtn) {
		this.bot_cards_onebtn = bot_cards_onebtn;
	}
	/**
	 * @return the bot_cards_twobtn
	 */
	public JButton getBot_cards_twobtn() {
		return bot_cards_twobtn;
	}
	/**
	 * @param bot_cards_twobtn the bot_cards_twobtn to set
	 */
	public void setBot_cards_twobtn(JButton bot_cards_twobtn) {
		this.bot_cards_twobtn = bot_cards_twobtn;
	}
	/**
	 * @return the throw_cardbtn
	 */
	public JButton getThrow_cardbtn() {
		return throw_cardbtn;
	}
	/**
	 * @param throw_cardbtn the throw_cardbtn to set
	 */
	public void setThrow_cardbtn(JButton throw_cardbtn) {
		this.throw_cardbtn = throw_cardbtn;
	}
	/**
	 * @return the say_onebtn
	 */
	public JButton getSay_onebtn() {
		return say_onebtn;
	}
	/**
	 * @param say_onebtn the say_onebtn to set
	 */
	public void setSay_onebtn(JButton say_onebtn) {
		this.say_onebtn = say_onebtn;
	}
	/**
	 * @return the pick_cardbtn
	 */
	public JButton getPick_cardbtn() {
		return pick_cardbtn;
	}
	/**
	 * @param pick_cardbtn the pick_cardbtn to set
	 */
	public void setPick_cardbtn(JButton pick_cardbtn) {
		this.pick_cardbtn = pick_cardbtn;
	}
	/**
	 * @return the show_cardbtn
	 */
	public JButton getShow_cardbtn() {
		return show_cardbtn;
	}
	/**
	 * @param show_cardbtn the show_cardbtn to set
	 */
	public void setShow_cardbtn(JButton show_cardbtn) {
		this.show_cardbtn = show_cardbtn;
	}
	/**
	 * @return the player_cardbtn
	 */
	public JButton[] getPlayer_cardbtn() {
		return player_cardbtn;
	}
	/**
	 * @param player_cardbtn the player_cardbtn to set
	 */
	public void setPlayer_cardbtn(JButton[] player_cardbtn) {
		this.player_cardbtn = player_cardbtn;
	}
	/**
	 * @return the bot_one_namelbl
	 */
	public VerticalLabel getBot_one_namelbl() {
		return bot_one_namelbl;
	}
	/**
	 * @param bot_one_namelbl the bot_one_namelbl to set
	 */
	public void setBot_one_namelbl(VerticalLabel bot_one_namelbl) {
		this.bot_one_namelbl = bot_one_namelbl;
	}
	/**
	 * @return the bot_two_namelbl
	 */
	public VerticalLabel getBot_two_namelbl() {
		return bot_two_namelbl;
	}
	/**
	 * @param bot_two_namelbl the bot_two_namelbl to set
	 */
	public void setBot_two_namelbl(VerticalLabel bot_two_namelbl) {
		this.bot_two_namelbl = bot_two_namelbl;
	}
	/**
	 * @return the directionlbl
	 */
	public JLabel getDirectionlbl() {
		return directionlbl;
	}
	/**
	 * @param directionlbl the directionlbl to set
	 */
	public void setDirectionlbl(JLabel directionlbl) {
		this.directionlbl = directionlbl;
	}
	/**
	 * @return the player_turnlbl
	 */
	public JLabel getPlayer_turnlbl() {
		return player_turnlbl;
	}
	/**
	 * @param player_turnlbl the player_turnlbl to set
	 */
	public void setPlayer_turnlbl(JLabel player_turnlbl) {
		this.player_turnlbl = player_turnlbl;
	}
	/**
	 * @return the select_cardlbl
	 */
	public JLabel getSelect_cardlbl() {
		return select_cardlbl;
	}
	/**
	 * @param select_cardlbl the select_cardlbl to set
	 */
	public void setSelect_cardlbl(JLabel select_cardlbl) {
		this.select_cardlbl = select_cardlbl;
	}

	public JButton getShow_steal_cards() {
		return show_steal_cards;
	}

	public void setShow_steal_cards(JButton show_steal_cards) {
		this.show_steal_cards = show_steal_cards;
	}
}
