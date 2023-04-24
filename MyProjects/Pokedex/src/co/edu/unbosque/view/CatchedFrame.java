package co.edu.unbosque.view;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class CatchedFrame extends JFrame{

	private CatchedPanel cp;
	private Background bg;
	private BackButton back;

	public CatchedFrame() {
		setSize(1000, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		initComponents();
	}

	public void initComponents() {
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		cp = new CatchedPanel();
		back = new BackButton();
		bg = new Background();

		add(back);
		add(bg);
		bg.add(cp);
	}

	/**
	 * @return the cp
	 */
	public CatchedPanel getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(CatchedPanel cp) {
		this.cp = cp;
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

