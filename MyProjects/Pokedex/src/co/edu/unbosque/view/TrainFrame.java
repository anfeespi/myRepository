package co.edu.unbosque.view;

import java.util.ArrayList;

import javax.swing.*;

public class TrainFrame extends JFrame{
	
	private TrainPanel tp;
	private Background bg;
	private BackButton back;

	public TrainFrame() {
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);
		initComponents();
	}

	public void initComponents() {
		bg = new Background();
		back = new BackButton();

		add(back);
		add(bg);
		
	}
	
	public void initPanel(String name, int id, ArrayList<String> C1, ArrayList<String> C2, ArrayList<String> C3, ArrayList<String> C4) {
		tp = new TrainPanel(name, id, C1, C2, C3, C4);
		bg.add(tp);
		repaint();
	}
	
	public void removePanel(){
		bg.remove(tp);
	}

	/**
	 * @return the tp
	 */
	public TrainPanel getTp() {
		return tp;
	}

	/**
	 * @param tp the tp to set
	 */
	public void setTp(TrainPanel tp) {
		this.tp = tp;
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
