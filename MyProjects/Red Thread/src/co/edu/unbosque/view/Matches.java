package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import co.edu.unbosque.model.UserDAOImpl;

/**
 * Panel para la ventana de Inicio de Sesion
 * @author Andres Espitia
 * @author Diego Forero
 * @author Camilo Uribe
 * @author Esteban Mejia
 *
 */
public class Matches extends JPanel{
	/**
	 * Arreglo de los diferentes matches
	 */
	private JPanel[] matches;
	private UserDAOImpl users;
	private Font font;
	
	
	/**
	 * Constructor
	 */
	public Matches(int cant, ArrayList<Integer> matches_arr) {
		users = new UserDAOImpl();
		setBackground(Color.BLACK);
		setLayout(null);
		initComponents(cant, matches_arr);
	}

	/**
	 * Metodo para inicializar componentes
	 */
	private void initComponents(int cant, ArrayList<Integer> matches_arr) {
		try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println(e);
        }
		font = new Font("Raleway", 0, 30);
		matches = new JPanel[cant];
		int x = 0;
		for (int i = 0; i < cant; i++) {
			matches[i] = new JPanel();
			matches[i].setBounds(x, 0, 200, 415);
			matches[i].setBackground(Color.BLACK);
			matches[i].setForeground(Color.WHITE);
			matches[i].setLayout(null);
			//Poner imagenes y texto
			JLabel img_aux = new JLabel();
			//cosas de la imagen
			//img_aux.setBounds(0,0,200,300);
			img_aux = new JLabel();
			img_aux.setBounds(0, 0, 200, 300);
			try {
				BufferedImage bi = ImageIO.read(new File(users.getUsers().get(matches_arr.get(i)).getUrl_photos().get(0)));
				Image title_resized = bi.getScaledInstance(img_aux.getWidth(), img_aux.getHeight(), Image.SCALE_SMOOTH);
				img_aux.setIcon(new ImageIcon(title_resized));
			} catch (Exception e) {
				e.printStackTrace();
			}
			img_aux.setVisible(true);
				
			JLabel name_aux = new JLabel(users.getUsers().get(matches_arr.get(i)).getName());
			name_aux.setBounds(0, 310, 200, 30);
			name_aux.setHorizontalAlignment(SwingConstants.CENTER);
			name_aux.setForeground(Color.WHITE);
			name_aux.setVisible(true);
			
			JLabel age_aux = new JLabel(users.getUsers().get(matches_arr.get(i)).getAge()+"");
			age_aux.setBounds(0, 340, 200, 30);
			age_aux.setForeground(Color.WHITE);
			age_aux.setHorizontalAlignment(SwingConstants.CENTER);
			age_aux.setVisible(true);
			
			JLabel num_aux = new JLabel(users.getUsers().get(matches_arr.get(i)).getContact());
			num_aux.setBounds(0, 370, 200, 30);
			num_aux.setForeground(Color.WHITE);
			num_aux.setHorizontalAlignment(SwingConstants.CENTER);
			num_aux.setVisible(true);
			
			matches[i].add(img_aux);
			matches[i].add(name_aux);
			matches[i].add(age_aux);
			matches[i].add(num_aux);
			
			add(matches[i]);
			x+=210;
		}
	}
	
	
}
