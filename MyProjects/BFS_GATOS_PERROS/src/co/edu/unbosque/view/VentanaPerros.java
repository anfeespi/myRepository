package co.edu.unbosque.view;

import javax.swing.JFrame;

public class VentanaPerros extends JFrame {
	
	/**
	 * Espacio donde se agregan elementos a la ventana
	 */
	private PanelGuardarEliminar p_perros; 
	
	/**
	 * Metodo Constructor
	 */
	public VentanaPerros() {
		setSize(1000, 700);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		init();
	}
	
	/**
	 * Metodo donde se inicializa y se agrega el panel a la ventana
	 */
	public void init() {
		p_perros = new PanelGuardarEliminar();
		add(p_perros);
	}

	/**
	 * Metodo a partir del cual se optiene el panel de esta ventana
	 * @return Retorna el panel que esta dentro de esta ventana
	 */
	public PanelGuardarEliminar getPg() {
		return p_perros;
	}

	/**
	 * Metodo que permite remplazar el panel de esta ventana
	 * @param Como parametro se pasa un nuevo panel
	 */
	public void setPg(PanelGuardarEliminar pg) {
		this.p_perros = pg;
	}
}
