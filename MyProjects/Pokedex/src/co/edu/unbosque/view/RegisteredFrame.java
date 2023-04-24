package co.edu.unbosque.view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class RegisteredFrame extends JFrame{
	
	private Background bg;
	private RegisteredPanel rp;
	private BackButton back;
	
	public RegisteredFrame(ArrayList<String> names) {
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents(names);
	}
	
	public void initComponents(ArrayList<String> names) {
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		bg = new Background();
		rp = new RegisteredPanel(names);
		back = new BackButton();
		
		add(back);
		add(bg);
		bg.add(rp);
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

	/**
	 * @return the rp
	 */
	public RegisteredPanel getRp() {
		return rp;
	}

	/**
	 * @param rp the rp to set
	 */
	public void setRp(RegisteredPanel rp) {
		this.rp = rp;
	}
	
	
}
