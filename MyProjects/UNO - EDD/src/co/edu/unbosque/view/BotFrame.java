package co.edu.unbosque.view;

import javax.swing.JFrame;

public class BotFrame extends JFrame{
	/**
	 * Panel con los elementos de la frame
	 */
	private BotPanel panel_bot;
	
	/**
	 * Metodo constructor
	 * @param text texto que va a mostrar
	 */
	public BotFrame(String text) {
		setSize(550, 320);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		init(text);
	}
	
	/**
	 * Metodo que inicializa los objetos
	 * @param text texto que va a mostrar
	 */
	public void init(String text) {
		panel_bot = new BotPanel(text);
		panel_bot.setVisible(true);
		add(panel_bot);
	}

	/**
	 * @return the panel_bot
	 */
	public BotPanel getPanel_bot() {
		return panel_bot;
	}

	/**
	 * @param panel_bot the panel_bot to set
	 */
	public void setPanel_bot(BotPanel panel_bot) {
		this.panel_bot = panel_bot;
	}

}
