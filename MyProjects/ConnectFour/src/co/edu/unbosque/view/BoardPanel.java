package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import co.edu.unbosque.model.persistence.FileHandler;
/**
 * Panel del tablero
 * @author Andres Espitia Rodriguez, Diego Alejandro Forero Espitia, Jaime Esteban Mejia Arevalo, Juan Camilo Uribe Pava
 *
 **/
public class BoardPanel extends JPanel {
	/**
	 * Tipos de fuente
	 **/
	private Font font, button_font;
	/**
	 * Las propiedades del idioma
	 **/
	private Properties propLang;
	/**
	 * Propiedades del tema
	 **/
	private Properties propTheme;
	/**
	 *  El turno
	 **/
	private JLabel turn;
	/**
	 * Nombre
	 **/
	private JLabel name;
	/**
	 *  Icono de equipo
	 **/
	private JLabel iconteam;
	/**
	 *  Color
	 **/
	private String color_str;
	/**
	 *  Color de propiedad
	 **/
	private Color c;
	/**
	 *  Arreglo de botones
	 **/
	private JButton[] playButts;
	/**
	 * Boton devolver
	 **/
	private JButton btn_back;
	/**
	 * Matriz del tablero
	 **/
	private static JLabel[][] board;
	/**
	 * Metodo constructor
	 * @param selLang Lenguaje
	 * @param selTheme Tema
	 */
	public BoardPanel(int selLang, int selTheme) {
		propLang = FileHandler.loadPropertiesLang(selLang);
		propTheme = FileHandler.loadPropertiesTheme(selTheme);
		color_str = propTheme.getProperty("persistence.frames.color");
		if (color_str.equals("White")) {
			c = Color.WHITE;
		} else {
			c = Color.BLACK;
		}
		font= new Font("Transformers Movie", 0, 25);
		button_font= new Font("Transformers Movie", 0, 16);
		setBounds(36, 110, 1000, 700);
		setLayout(null);
		setOpaque(false);
		init();
		setVisible(true);
	}
	/**
	 * Iniciar Componentes 
	 **/
	public void init() {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			System.out.println(e);
		}
		turn = new JLabel(propLang.getProperty("persistence.boardframe.turn"));
		turn.setFont(font);
		turn.setForeground(c);
		turn.setBounds(27, 288, 140, 30);
		turn.setHorizontalAlignment(SwingConstants.CENTER);
		turn.setVisible(true);

		iconteam = new JLabel();

		name = new JLabel();
		name.setFont(font);
		name.setForeground(c);
		name.setBounds(27, 428, 140, 30);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setVisible(true);

		playButts = new JButton[8];
		int x = 180;
		for (int i = 0; i < playButts.length; i++) {
			playButts[i] = new JButton(propLang.getProperty("persistence.boardframe.buttons"));
			playButts[i].setBounds(x, 45, 80, 30);
			playButts[i].setFont(button_font);
			playButts[i].setForeground(Color.BLACK);
			playButts[i].setVisible(true);
			add(playButts[i]);
			x += 80;
		}

		board = new JLabel[7][8];
		int xb = 180, yb = 75;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = new JLabel();
				board[i][j].setBounds(xb, yb, 80, 80);
				board[i][j].setVisible(true);
				board[i][j].setBorder(new LineBorder(Color.WHITE));
				add(board[i][j]);
				xb += 80;
			}
			yb += 80;
			xb = 180;
		}

		btn_back = new JButton();
		btn_back.setBounds(42, 572, 70, 70);
		try {
			BufferedImage bi2 = ImageIO.read(new File(propTheme.getProperty("persistence.btn_img")));
			Image resized = bi2.getScaledInstance(btn_back.getWidth(), btn_back.getHeight(), Image.SCALE_SMOOTH);
			btn_back.setIcon(new ImageIcon(resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		btn_back.setVisible(true);
		btn_back.setContentAreaFilled(false);

		add(turn);
		add(iconteam);
		add(name);
		add(btn_back);
	}
	/**
	 *  Metodo que cambia el icono y el nombre del turno
	 **/
	public void changeIconAndName(String newname, String url) {
		name.setText(newname);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.repaint();

		iconteam.setHorizontalAlignment(SwingConstants.CENTER);
		iconteam.setBounds(60, 337, 65, 65);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File(propTheme.getProperty(url)));
			Image resized = bi.getScaledInstance(iconteam.getWidth(), iconteam.getHeight(), Image.SCALE_SMOOTH);
			iconteam.setIcon(new ImageIcon(resized));
		} catch (Exception e) {
			e.printStackTrace();
		}
		iconteam.setVisible(true);
		iconteam.repaint();
	}
	/**
	 *  Metodo que pone el icono
	 **/
	public void putIcon(int row, int column, String url) {
		try {
			BufferedImage bi2 = ImageIO.read(new File(propTheme.getProperty(url)));
			Image resized = bi2.getScaledInstance(board[row][column].getWidth()-10, board[row][column].getHeight()-10, Image.SCALE_SMOOTH);
			board[row][column].setIcon(new ImageIcon(resized));
			board[row][column].setHorizontalAlignment(SwingConstants.CENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
		board[row][column].setVisible(true);
		board[row][column].repaint();
	}
	/**
	 * Metodo que rellena el tablero
	 **/
	public void fillBoard(int[][] auxboard) {

		for (int i = 0; i < auxboard.length; i++) {
			for (int j = 0; j < auxboard[i].length; j++) {
				if (auxboard[i][j] == 1) {
					putIcon(i, j, "persistence.imgautobots");
				} else if (auxboard[i][j] == 2) {
					putIcon(i, j, "persistence.imgdecepticons");
				}
			}
		}
	}
	/**
	 * 
	 **/
	public void showMessage(String mess) {
		JOptionPane.showMessageDialog(null, propLang.getProperty(mess), null, JOptionPane.INFORMATION_MESSAGE);
	}

	public int showMessageMenu(String mess) {
		return JOptionPane.showConfirmDialog(null, propLang.getProperty(mess), null, JOptionPane.YES_NO_OPTION);
	}

	/**
	 * @return the name
	 */
	public JLabel getLblName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(JLabel name) {
		this.name = name;
	}

	/**
	 * @return the playButts
	 */
	public JButton[] getPlayButts() {
		return playButts;
	}

	/**
	 * @param playButts the playButts to set
	 */
	public void setPlayButts(JButton[] playButts) {
		this.playButts = playButts;
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
}
