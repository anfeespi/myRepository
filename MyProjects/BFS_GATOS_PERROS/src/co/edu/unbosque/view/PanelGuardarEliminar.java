package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelGuardarEliminar extends JPanel {
	/**
	 * Etiqueta con el titulo "Guardar y Eliminar"
	 */
	private JLabel titulo;
	/**
	 * Etiqueta con el texto "Nombre:"
	 */
	private JLabel nombre;
	/**
	 * Etiqueta con el texto "Edad:"
	 */
	private JLabel edad;
	/**
	 * Etiqueta con el texto "Raza:"
	 */
	private JLabel raza;
	/**
	 * Etiqueta con el texto "Nombre Mascota a Eliminar:"
	 */
	private JLabel nombre_eliminar;
	/**
	 * Campo de texto en el que el usuario digita el nombre de la mascota
	 */
	private JTextField in_nom;
	/**
	 * Campo de texto en el que el usuario digita la edad de la mascota
	 */
	private JTextField in_edad;
	/**
	 * Campo de texto en el que el usuario digita la raza de la mascota
	 */
	private JTextField in_raza;
	/**
	 * Campo de texto en el que el usuario digita el nombre de la mascota que desea
	 * eliminar de la base de datos
	 */
	private JTextField in_nom_eliminar;
	/**
	 * Boton que ejecuta la accion de guardar los datos que el usuario ingreso
	 */
	private JButton b_guardar;
	/**
	 * Boton que ejecuta la accion de eliminar de la base de datos el animal que el
	 * usuario desea
	 */
	private JButton b_eliminar;
	/**
	 * Boton para volver a la pagina principal
	 */
	private JButton b_volver;
	/**
	 * Fuente utilizada en los titulos principales
	 */
	private Font f = new Font("Arial", Font.BOLD, 30);
	/**
	 * Fuente utilizada en los textos que no son titulos
	 */
	private Font f2 = new Font("Arial", Font.ITALIC, 25);
	
	/**
	 * Metodo Constructor
	 */
	public PanelGuardarEliminar() {
		setBounds(0, 0, 1000, 700);
		setLayout(null);
		init();
		setVisible(true);
	}
	
	/**
	 * Metodo para agregar e inicializar los componentes dentro del panel
	 */
	public void init() {
		setBackground(new Color(193, 239, 255));
		titulo = new JLabel("Guardar y Eliminar");
		titulo.setFont(f);
		titulo.setBounds(365, 100, 300, 35);
		titulo.setVisible(true);
		
		nombre = new JLabel("Nombre:");
		nombre.setFont(f2);
		nombre.setBounds(150, 250, 100, 25);
		nombre.setVisible(true);

		edad = new JLabel("Edad:");
		edad.setFont(f2);
		edad.setBounds(150, 300, 100, 25);
		edad.setVisible(true);

		raza = new JLabel("Raza:");
		raza.setFont(f2);
		raza.setBounds(150, 350, 100, 25);
		raza.setVisible(true);
		
		in_nom = new JTextField();
		in_nom.setFont(f2);
		in_nom.setBounds(250, 250, 200, 25);
		in_nom.setVisible(true);
		
		in_edad = new JTextField();
		in_edad.setFont(f2);
		in_edad.setBounds(250, 300, 200, 25);
		in_edad.setVisible(true);
		
		in_raza = new JTextField();
		in_raza.setFont(f2);
		in_raza.setBounds(250, 350, 200, 25);
		in_raza.setVisible(true);
		
		b_guardar = new JButton("GUARDAR");
		b_guardar.setFont(f2);
		b_guardar.setBackground(new Color(255, 233, 174));
		b_guardar.setBounds(210, 420, 200, 35);
		b_guardar.setVisible(true);
		
		nombre_eliminar = new JLabel("Nombre Mascota a Eliminar:");
		nombre_eliminar.setFont(f2);
		nombre_eliminar.setBounds(550, 275, 400, 25);
		nombre_eliminar.setVisible(true);
		
		in_nom_eliminar = new JTextField();
		in_nom_eliminar.setFont(f2);
		in_nom_eliminar.setBounds(560, 325, 300, 25);
		in_nom_eliminar.setVisible(true);
		
		b_eliminar = new JButton("ELIMINAR");
		b_eliminar.setFont(f2);
		b_eliminar.setBackground(new Color(255, 233, 174));
		b_eliminar.setBounds(600, 420, 200, 35);
		b_eliminar.setVisible(true);
		
		b_volver = new JButton("VOLVER");
		b_volver.setFont(f2);
		b_volver.setBackground(new Color(255, 233, 174));
		b_volver.setBounds(400, 550, 200, 35);
		b_volver.setVisible(true);
		
		add(titulo);
		add(nombre);
		add(edad);
		add(raza);
		add(in_nom);
		add(in_edad);
		add(in_raza);
		add(b_guardar);
		add(nombre_eliminar);
		add(in_nom_eliminar);
		add(b_eliminar);
		add(b_volver);
	}

	/**
	 * Metodo que devuelve el campo del nombre de la mascota
	 * @return campo que contiene un nombre
	 */
	public JTextField getIn_nom() {
		return in_nom;
	}

	/**
	 * Metodo para remplazar el campo de texto donde se guarda el nombre
	 * @param Como parametro se pasa un nuevo campo de texto
	 */
	public void setIn_nom(JTextField in_nom) {
		this.in_nom = in_nom;
	}

	/**
	 * Metodo que devuelve el campo de la edad de la mascota
	 * @return campo que contiene una edad
	 */
	public JTextField getIn_edad() {
		return in_edad;
	}

	/**
	 * Metodo para remplazar el campo de texto donde se guarda la edad
	 * @param Como parametro se pasa un nuevo campo de texto
	 */
	public void setIn_edad(JTextField in_edad) {
		this.in_edad = in_edad;
	}

	/**
	 * Metodo que devuelve el campo de la raza de la mascota
	 * @return campo que contiene una raza
	 */
	public JTextField getIn_raza() {
		return in_raza;
	}

	/**
	 * Metodo para remplazar el campo de texto donde se guarda la raza
	 * @param Como parametro se pasa un nuevo campo de texto
	 */
	public void setIn_raza(JTextField in_raza) {
		this.in_raza = in_raza;
	}

	/**
	 * Metodo que devuelve el campo del nombre de la mascota que se desea eliminar de
	 * la base de datos
	 * @return campo que contiene un nombre
	 */
	public JTextField getIn_nom_eliminar() {
		return in_nom_eliminar;
	}

	/**
	 * Metodo para remplazar el campo de texto donde se guarda el nombre de la
	 * mascota que se desea eliminar
	 * @param Como parametro se pasa un nuevo campo de texto
	 */
	public void setIn_nom_eliminar(JTextField in_nom_eliminar) {
		this.in_nom_eliminar = in_nom_eliminar;
	}

	/**
	 * Metodo que devuelve el boton guardar
	 * @return el boton que llama la funcion de guardar
	 */
	public JButton getB_guardar() {
		return b_guardar;
	}

	/**
	 * Metodo que devuelve el boton eliminar
	 * @return el boton que llama la funcion de eliminar
	 */
	public JButton getB_eliminar() {
		return b_eliminar;
	}

	/**
	 * Metodo que devuelve el boton volver
	 * @return el boton que llama la funcion de volver a la ventana principal
	 */
	public JButton getB_volver() {
		return b_volver;
	}
}
