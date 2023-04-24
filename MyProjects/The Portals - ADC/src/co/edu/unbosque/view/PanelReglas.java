package co.edu.unbosque.view;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * Panel principal de la ventana de reglas o instrucciones
 * @author Andr�s Espitia
 * @author Camilo Uribe
 * @author Diego Forero
 *
 */
public class PanelReglas extends JPanel{
	
	/**
	 * Tipo de fuente para los titulos
	 */
	private Font titlefont;
	/**
	 * Tipo de fuente para los subtitulos
	 */
	private Font subtitlefont;
	/**
	 * Etiqueta con el fondo
	 */
	private JLabel fondo;
	/**
	 * Panel contenedor de la etiqueta con el texto de las instrucciones
	 */
	private JPanel panel_texto;
	/**
	 * Etiqueta con el texto
	 */
	private JLabel texto;
	
	/**
	 * Metodo constructor
	 */
	public PanelReglas() {
		titlefont = new Font("Monaco", Font.BOLD, 50);
		subtitlefont = new Font("Monaco", 0, 35);
		
		setBounds(0, 0, 600, 800);
		setLayout(null);
		setVisible(true);
		init();
	}
	
	/**
	 * Metodo que inicializa todas las variables y en este caso cambia el fondo a color si no encuentra la imagen
	 */
	public void init() {
		fondo = new JLabel();
		fondo.setBounds(0, 0, 600, 800);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(new File("src/img/fondo.jpg"));
			Image redimensionado = bi.getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH);
			fondo.setIcon(new ImageIcon(redimensionado));
		} catch (IOException e) {
			e.printStackTrace();
		}
		fondo.setVisible(true);
		
		panel_texto = new JPanel();
		panel_texto.setBounds(100, 50, 400, 600);
		panel_texto.setVisible(true);
		
		texto = new JLabel();
		texto.setBounds(0, 0, 400, 600);
		BufferedImage txt = null;
		try {
			txt = ImageIO.read(new File ("src/img/instrucciones.png"));
			Image redimensionado2 = txt.getScaledInstance(texto.getWidth(), texto.getHeight(), Image.SCALE_SMOOTH);
			texto.setIcon(new ImageIcon(redimensionado2));		
		} catch (IOException e) {
			e.printStackTrace();
		}
		texto.setVisible(true);
		
		panel_texto.add(texto);
				
		
		add(fondo);
		fondo.add(panel_texto);
	}
}
