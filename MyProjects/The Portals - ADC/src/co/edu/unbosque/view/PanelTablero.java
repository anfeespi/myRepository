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
import javax.swing.JScrollPane;

/**
 * 
 * Panel principal de la ventana que contiene el tablero y el juego en general
 * @author Andr�s Espitia
 * @author Camilo Uribe
 * @author Diego Forero
 *
 */
public class PanelTablero extends JPanel {
	
	/**
	 * Tipo de fuente para los titulos
	 */
	private Font titlefont;
	/**
	 * Tipo de fuente para los botones
	 */
	private Font buttonfont;
	/**
	 * Color principal del panel
	 */
	private Color maincolor;
	/**
	 * Imagen de fondo dentro de una etiqueta
	 */
	private JLabel fondo;
	/**
	 * El tablero de juego
	 */
	private Tablero tablero;
	/**
	 * Boton para lanzar el dado
	 */
	private JButton lanzar_dado;
	/**
	 * Etiqueta con el gif o imagen que represente el dado
	 */
	private JLabel img_dado;
	/**
	 * Etiqueta que ilustra el turno del jugador
	 */
	private JLabel turno;
	private JButton home;
	private JButton reglas;
	private JScrollPane contenedor_tablero;
	
	/**
	 * Metodo constructor
	 */
	public PanelTablero() {
		titlefont = new Font("Monaco", Font.BOLD, 50);
		buttonfont = new Font("Monaco", 0, 30);
		maincolor = new Color(15, 40, 76);
		
		setBounds(0, 0, 1200, 800);
		setLayout(null);
		setVisible(true);
		init();
	}
	
	/**
	 * Metodo que inicializa todas las variables y partes graficas, y en caso de no encontrar imagenes trabaja con colores
	 */
	public void init() {
		fondo = new JLabel();
		fondo.setBounds(0, 0, 1200, 800);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File("src/img/fondo.jpg"));
			Image redimensionado = bi.getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH);
			fondo.setIcon(new ImageIcon(redimensionado));
		} catch (Exception e) {
			e.printStackTrace();
			fondo.setBackground(maincolor);
		}
		fondo.setVisible(true);
		
		lanzar_dado = new JButton("Lanzar dado");
		lanzar_dado.setFont(buttonfont);
		lanzar_dado.setBounds(180, 690, 250, 60);
		lanzar_dado.setVisible(true);
		
		img_dado = new JLabel();
		img_dado.setBounds(455, 690, 60, 60);
		img_dado.setIcon(new javax.swing.ImageIcon("src/img/dado.gif"));
		img_dado.setBackground(Color.WHITE);
		img_dado.setVisible(true);
		
		turno = new JLabel("Turno de: ");
		turno.setBounds(630, 690, 400, 60);
		turno.setFont(buttonfont);
		turno.setForeground(Color.WHITE);
		turno.setVisible(true);
		
		home = new JButton();
		home.setBounds(50, 690, 60, 60);
		BufferedImage bi1 = null;
		try {
			bi1 = ImageIO.read(new File("src/img/home.png"));
			Image redimensionado1 = bi1.getScaledInstance(home.getWidth(), home.getHeight(), Image.SCALE_SMOOTH);
			home.setIcon(new ImageIcon(redimensionado1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		home.setVisible(true);
		
		reglas = new JButton();
		reglas.setBounds(1090, 690, 60, 60);
		BufferedImage bi2 = null;
		try {
			bi2 = ImageIO.read(new File("src/img/question_mark.png"));
			Image redimensionado2 = bi2.getScaledInstance(reglas.getWidth(), reglas.getHeight(), Image.SCALE_SMOOTH);
			reglas.setIcon(new ImageIcon(redimensionado2));
		} catch (Exception e) {
			e.printStackTrace();
		}
		reglas.setVisible(true);
		
		add(fondo);
		fondo.add(lanzar_dado);
		fondo.add(img_dado);
		fondo.add(home);
		fondo.add(reglas);
		fondo.add(turno);
	}
	
	public void initTablero(int filas, int columnas) {
		tablero = new Tablero(filas, columnas);
		tablero.setLocation(50, 30);
		
		contenedor_tablero = new JScrollPane();
		contenedor_tablero.setViewportView(tablero);
		contenedor_tablero.setBounds(50, 30, 1100, 650);
		contenedor_tablero.setVisible(true);
		
		fondo.add(contenedor_tablero);
	}

	/**
	 * Metodo que devuelve el tablero
	 */
	public Tablero getTablero() {
		return tablero;
	}

	/**
	 * Metodo que cambia el tablero
	 */
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

	/**
	 * Metodo que devuelve el boton de lanzar el dado
	 */
	public JButton getLanzar_dado() {
		return lanzar_dado;
	}

	/**
	 * Metodo que cambia el boton de lanzar el dado
	 */
	public void setLanzar_dado(JButton lanzar_dado) {
		this.lanzar_dado = lanzar_dado;
	}

	/**
	 * Metodo que devuelve la etiqueta con la imagen del dado
	 */
	public JLabel getImg_dado() {
		return img_dado;
	}

	/**
	 * Metodo que cambia la etiqueta con la imagen del dado
	 */
	public void setImg_dado(JLabel img_dado) {
		this.img_dado = img_dado;
	}

	/**
	 * Metodo que devuelve la etiqueta del turno
	 */
	public JLabel getTurno() {
		return turno;
	}

	/**
	 * Metodo que cambia la etiqueta del turno
	 */
	public void setTurno(JLabel turno) {
		this.turno = turno;
	}

	public JButton getHome() {
		return home;
	}

	public void setHome(JButton home) {
		this.home = home;
	}

	public JButton getReglas() {
		return reglas;
	}

	public void setReglas(JButton reglas) {
		this.reglas = reglas;
	}
	
}
