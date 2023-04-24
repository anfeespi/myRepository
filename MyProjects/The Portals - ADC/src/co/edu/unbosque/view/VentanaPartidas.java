package co.edu.unbosque.view;

import javax.swing.JFrame;

/**
 * 
 * Ventana que muestra las partidas guardadas
 * @author Andr�s Espitia
 * @author Camilo Uribe
 * @author Diego Forero
 *
 */
public class VentanaPartidas extends JFrame{
	
	/**
	 * Panel principal de las partidas 'PanelPartidas'
	 */
	private PanelPartidas ppartidas;
	
	/**
	 * Metodo constructor
	 */
	public VentanaPartidas() {
		setSize(600, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		init();
	}
	
	/**
	 * Metodo que inicializa las variables
	 */
	private void init() {
		ppartidas = new PanelPartidas();
		add(ppartidas);
	}

	public PanelPartidas getPpartidas() {
		return ppartidas;
	}

	public void setPpartidas(PanelPartidas ppartidas) {
		this.ppartidas = ppartidas;
	}
}
