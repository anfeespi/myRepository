package co.edu.unbosque.view;

import javax.swing.JFrame;

public class MainFrame extends JFrame{
	
	private MainPanel mp;
	private Background bg;
	
	public MainFrame() {
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents();
	}
	
	public void initComponents() {
		mp = new MainPanel();
		mp.setVisible(true);
		bg = new Background();
		
		add(bg);
		bg.add(mp);
	}

	/**
	 * @return the mp
	 */
	public MainPanel getMp() {
		return mp;
	}

	/**
	 * @param mp the mp to set
	 */
	public void setMp(MainPanel mp) {
		this.mp = mp;
	}
	
	

}
