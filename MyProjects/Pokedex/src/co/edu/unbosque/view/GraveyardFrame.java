package co.edu.unbosque.view;

import java.util.ArrayList;

import javax.swing.JFrame;

public class GraveyardFrame extends JFrame{
	private Background bg;
	private GraveyardPanel gp;
	private BackButton back;
	
	public GraveyardFrame(ArrayList<String> names){
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents(names);
	}
	
	public void initComponents(ArrayList<String> names) {
		bg = new Background();
		gp = new GraveyardPanel(names);
		back = new BackButton();
		
		
		add(back);
		add(bg);
		bg.add(gp);
	}

	/**
	 * @return the gp
	 */
	public GraveyardPanel getGp() {
		return gp;
	}

	/**
	 * @param gp the gp to set
	 */
	public void setGp(GraveyardPanel gp) {
		this.gp = gp;
	}

	/**
	 * @return the back
	 */
	public BackButton getBack() {
		return back;
	}

	/**
	 * @param back the back to set
	 */
	public void setBack(BackButton back) {
		this.back = back;
	}
	
	
}
