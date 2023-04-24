package co.edu.unbosque.view;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * Panel principal de la ventana de partidas
 * @author Andr�s Espitia
 * @author Camilo Uribe
 * @author Diego Forero
 *
 */

public class PanelPartidas extends JPanel{
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
	 * Panel contenedor de la etiqueta con los datos de la partida
	 */
	private JPanel panel_texto;
	/**
	 * Etiqueta con el texto
	 */
	private JLabel titulo;
	
	/**
	 * Metodo constructor
	 */
	public PanelPartidas() {
		titlefont = new Font("Monaco", Font.BOLD, 35);
		subtitlefont = new Font("Monaco", 0, 15);
		
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
		panel_texto.setBounds(25, 50, 550, 600);
		panel_texto.setVisible(true);
		
		titulo = new JLabel("PARTIDAS GUARDADAS");
		titulo.setFont(titlefont);
		titulo.setBounds(150, 0, 300, 40);
		titulo.setVisible(true);
		
		add(fondo);
		fondo.add(panel_texto);
		panel_texto.add(titulo);
	}

	public JPanel getPanel_texto() {
		return panel_texto;
	}

	public void setPanel_texto(JPanel panel_texto) {
		this.panel_texto = panel_texto;
	}

	public JLabel getTitulo() {
		return titulo;
	}

	public void setTitulo(JLabel titulo) {
		this.titulo = titulo;
	}

	public Font getSubtitlefont() {
		return subtitlefont;
	}

	public void setSubtitlefont(Font subtitlefont) {
		this.subtitlefont = subtitlefont;
	}
	
}
