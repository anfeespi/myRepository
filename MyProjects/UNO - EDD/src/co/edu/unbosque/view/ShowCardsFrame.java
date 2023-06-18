package co.edu.unbosque.view;

import javax.swing.JFrame;

public class ShowCardsFrame extends JFrame{
	/**
	 * Panel con los elementos de la frame
	 */
	private ShowCardsPanel panel_show;
	
	/**
	 * Metodo constructor
	 * @param text texto que va a mostrar
	 */
	public ShowCardsFrame(String[] cards, String text) {
		setSize(550, 320);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		init(cards, text);
		setVisible(true);
	}
	
	/**
	 * Metodo que inicializa los objetos
	 * @param text texto que va a mostrar
	 */
	public void init(String[] cards, String text) {
		panel_show = new ShowCardsPanel(cards, text);
		panel_show.setVisible(true);
		add(panel_show);
	}

	/**
	 * @return the panel_bot
	 */
	public ShowCardsPanel getPanel_show() {
		return panel_show;
	}

	/**
	 * @param panel_bot the panel_bot to set
	 */
	public void setPanel_show(ShowCardsPanel panel_show) {
		this.panel_show = panel_show;
	}
}
