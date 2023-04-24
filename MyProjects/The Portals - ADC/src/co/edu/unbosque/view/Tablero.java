package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * 
 * Tablero que se usa dinamicamente
 * @author Andres Espitia
 * @author Camilo Uribe
 * @author Diego Forero
 *
 */
public class Tablero extends JPanel {
	/**
	 * Columnas del tablero
	 */
	private int columnas;
	/**
	 * Filas del tablero
	 */
	private int filas;
	/**
	 * Matriz de JPanels que es el tablero
	 */
	private JPanel[][] casillas;
	/**
	 * Numero de la casilla
	 */
	private JLabel numero_casilla;
	/**
	 * Imagen del astronauta
	 */
	private JLabel astronauta;
	/**
	 * Imagen del alien
	 */
	private JLabel alien;
	/**
	 * Imagen del robot
	 */
	private JLabel robot;
	/**
	 * Imagen del fantasma
	 */
	private JLabel fantasma;
	/**
	 * Arreglo de portales
	 */
	private Portales[] portales;
	/**
	 * Borde
	 */
	private Border border;
	
	/**
	 * Metodo constructor
	 */
	public Tablero(int columnas, int filas) {
		this.columnas = columnas;
		this.filas = filas;
		setLayout(null);
		setVisible(true);
		init();
	}
	
	/**
	 * Metodo para inicializar todas las variables
	 */
	public void init() {
		
		astronauta = new JLabel();
		astronauta.setBounds(40, 25, 123, 58);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File("src/img/astronauta.png"));
			Image redimensionado = bi.getScaledInstance(astronauta.getWidth(), astronauta.getHeight(), Image.SCALE_SMOOTH);
			astronauta.setIcon(new ImageIcon(redimensionado));
		} catch (IOException e) {
			e.printStackTrace();
		}
		astronauta.setVisible(true);
		
		alien = new JLabel();
		alien.setBounds(32, 75, 49, 93);
		BufferedImage bi2 = null;
		try {
			bi2 = ImageIO.read(new File("src/img/alien.png"));
			Image redimensionado2 = bi2.getScaledInstance(alien.getWidth(), alien.getHeight(), Image.SCALE_SMOOTH);
			alien.setIcon(new ImageIcon(redimensionado2));
		} catch (IOException e) {
			e.printStackTrace();
		}
		alien.setVisible(true);
		
		fantasma = new JLabel();
		fantasma.setBounds(87, 90, 57, 78);
		BufferedImage bi3 = null;
		try {
			bi3 = ImageIO.read(new File("src/img/fantasma.png"));
			Image redimensionado3 = bi3.getScaledInstance(fantasma.getWidth(), fantasma.getHeight(), Image.SCALE_SMOOTH);
			fantasma.setIcon(new ImageIcon(redimensionado3));
		} catch (IOException e) {
			e.printStackTrace();
		}
		fantasma.setVisible(true);
		
		robot = new JLabel();
		robot.setBounds(150, 85, 52, 83);
		BufferedImage bi4 = null;
		try {
			bi4 = ImageIO.read(new File("src/img/robot.png"));
			Image redimensionado4 = bi4.getScaledInstance(robot.getWidth(), robot.getHeight(), Image.SCALE_SMOOTH);
			robot.setIcon(new ImageIcon(redimensionado4));
		} catch (IOException e) {
			e.printStackTrace();
		}
		robot.setVisible(true);
		
		border = BorderFactory.createLineBorder(Color.BLACK, 2);
		casillas = new JPanel[filas][columnas];
		int x = 0, y = 0, num = 1;
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				casillas[i][j] = new JPanel();
				casillas[i][j].setLayout(null);
				casillas[i][j].setBounds(x, y, 300, 200);
				numero_casilla = new JLabel(num+"");
				numero_casilla.setBounds(10, 10, 40, 40);
				numero_casilla.setFont(new Font("Arial", 0, 20));
				numero_casilla.setVisible(true);
				casillas[i][j].add(numero_casilla);
				casillas[i][j].setBorder(border);
				casillas[i][j].setVisible(true);
				
				add(casillas[i][j]);
				num++;
				x += 300;
			}
			y += 200;
			x = 0;
		}
//		casillas[0][0].add(astronauta);
//		casillas[0][0].add(alien);
//		casillas[0][0].add(fantasma);
//		casillas[0][0].add(robot);
	}

	/**
	 * Metodo que devuelve la matriz de casillas
	 */
	public JPanel[][] getCasillas() {
		return casillas;
	}

	/**
	 * Metodo para cambiar la matriz de casillas
	 */
	public void setCasillas(JPanel[][] casillas) {
		this.casillas = casillas;
	}

	/**
	 * Metodo para devolver el astronauta
	 */
	public JLabel getAstronauta() {
		return astronauta;
	}

	/**
	 * Metodo para cambiar el astronauta
	 */
	public void setAstronauta(JLabel astronauta) {
		this.astronauta = astronauta;
	}

	/**
	 * Metodo para devolver el alien
	 */
	public JLabel getAlien() {
		return alien;
	}

	/**
	 * Metodo para cambiar el alien
	 */
	public void setAlien(JLabel alien) {
		this.alien = alien;
	}

	/**
	 * Metodo para devolver el robot
	 */
	public JLabel getRobot() {
		return robot;
	}

	/**
	 * Metodo para cambiar el robot
	 */
	public void setRobot(JLabel robot) {
		this.robot = robot;
	}

	/**
	 * Metodo para devolver el fantasma
	 */
	public JLabel getFantasma() {
		return fantasma;
	}

	/**
	 * Metodo para cambiar el fantasma
	 */
	public void setFantasma(JLabel fantasma) {
		this.fantasma = fantasma;
	}

	/**
	 * Metodo para devolver las columnas
	 */
	public int getColumnas() {
		return columnas;
	}

	/**
	 * Metodo para cambiar las columnas
	 */
	public void setColumnas(int columnas) {
		this.columnas = columnas;
	}

	/**
	 * Metodo para devolver las filas
	 */
	public int getFilas() {
		return filas;
	}

	/**
	 * Metodo para cambiar las filas
	 */
	public void setFilas(int filas) {
		this.filas = filas;
	}
	
}