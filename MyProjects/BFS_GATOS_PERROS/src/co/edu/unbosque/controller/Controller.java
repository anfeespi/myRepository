package co.edu.unbosque.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.Gato;
import co.edu.unbosque.model.Mascota;
import co.edu.unbosque.model.Perro;
import co.edu.unbosque.view.VentanaGatos;
import co.edu.unbosque.view.VentanaMostrar;
import co.edu.unbosque.view.VentanaPerros;
import co.edu.unbosque.view.VentanaPrincipal;


/**
 * Clase principal que hace las operaciones entre vista y modelo
 * @author Andrés Espitia
 * @author Diego Forero
 *
 */
public class Controller implements ActionListener{
	/**
	 * Ventana principal que contiene el menú inicial
	 */
	private VentanaPrincipal vp;
	/**
	 * Ventana de gatos que contiene el menu al seleccionar los gatos
	 */
	private VentanaGatos vg;
	/**
	 * Ventana de perros que contiene el menu al seleccionar los perros
	 */
	private VentanaPerros vpe;
	/**
	 * Ventana que contiene un menu de botones para mostrar las bases de datos guardadas
	 */
	private VentanaMostrar vm;
	/**
	 * Mascotas que se van a guardar en la base de datos
	 */
	private Mascota listasM;
	
	/**
	 * Metodo Constructor
	 */
	public Controller() {
		vp = new VentanaPrincipal();
		vpe = new VentanaPerros();
		vg = new VentanaGatos();
		vm = new VentanaMostrar();
		listasM = new Mascota();
		asignarOyentes();
		eventos();
	}
	/**
	 * Metodo que permite asignar los oyentes para cada botón
	 */
	public void asignarOyentes() {
		vp.getPp().getB_gato().addActionListener(this);
		vp.getPp().getB_perro().addActionListener(this);
		vp.getPp().getB_mostrar().addActionListener(this);
		vpe.getPg().getB_guardar().addActionListener(this); 
		vpe.getPg().getB_eliminar().addActionListener(this); 
		vpe.getPg().getB_volver().addActionListener(this); 
		vg.getPg().getB_guardar().addActionListener(this); 
		vg.getPg().getB_eliminar().addActionListener(this); 
		vg.getPg().getB_volver().addActionListener(this);
		vm.getPm().getB_gatos().addActionListener(this);
		vm.getPm().getB_perros().addActionListener(this);
		vm.getPm().getB_todos().addActionListener(this);
		vm.getPm().getB_volver().addActionListener(this);
	}
	
	/**
	 * Metodo que permite hacer que los botones generen un comando al ser utilizados
	 */
	public void eventos() {
		vp.getPp().getB_gato().setActionCommand("GATO");
		vp.getPp().getB_perro().setActionCommand("PERRO");
		vp.getPp().getB_mostrar().setActionCommand("MOSTRAR");
		vpe.getPg().getB_guardar().setActionCommand("GUARDAR_P");
		vpe.getPg().getB_eliminar().setActionCommand("ELIMINAR_P");
		vpe.getPg().getB_volver().setActionCommand("VOLVER");
		vg.getPg().getB_guardar().setActionCommand("GUARDAR_G");
		vg.getPg().getB_eliminar().setActionCommand("ELIMINAR_G");
		vg.getPg().getB_volver().setActionCommand("VOLVER");
		vm.getPm().getB_gatos().setActionCommand("M_GATOS");
		vm.getPm().getB_perros().setActionCommand("M_PERROS");
		vm.getPm().getB_todos().setActionCommand("M_TODOS");
		vm.getPm().getB_volver().setActionCommand("VOLVER");
	}

	/**
	 * Metodo que hace la funcion principal de escuchar las acciones de los botones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("PERRO")) {
			vp.setVisible(false);
			vpe.setVisible(true);
		}
		if(e.getActionCommand().equals("GATO")) {
			vp.setVisible(false);
			vg.setVisible(true);
		}
		if(e.getActionCommand().equals("MOSTRAR")) {
			vp.setVisible(false);
			vm.setVisible(true);
		}
		if(e.getActionCommand().equals("GUARDAR_P")) {
			try {
				int edad = Integer.parseInt(vpe.getPg().getIn_edad().getText());
				listasM.anadirPerro(new Perro(edad, vpe.getPg().getIn_nom().getText(), vpe.getPg().getIn_raza().getText()));
				JOptionPane.showMessageDialog(null, "Guardado con exito.");
				vpe.getPg().getIn_edad().setText("");
				vpe.getPg().getIn_nom().setText("");
				vpe.getPg().getIn_raza().setText("");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "La edad debe ser un numero entero.");
			}
		}
		if(e.getActionCommand().equals("ELIMINAR_P")) {
			String aux = vpe.getPg().getIn_nom_eliminar().getText();
			for(int i=0; i<listasM.getPerro().size(); i++) {
				if(listasM.getPerro().get(i).getNombre().equals(aux)) {
					listasM.getPerro().remove(i);
					JOptionPane.showMessageDialog(null, "Eliminado con éxito.");
					break;
				}
			}
		}
		if(e.getActionCommand().equals("VOLVER")) {
			vpe.setVisible(false);
			vg.setVisible(false);
			vp.setVisible(true);
		}
		if(e.getActionCommand().equals("GUARDAR_G")) {
			try {
				int edad = Integer.parseInt(vg.getPg().getIn_edad().getText());
				listasM.anadirGato(new Gato(edad, vg.getPg().getIn_nom().getText(), vg.getPg().getIn_raza().getText()));
				JOptionPane.showMessageDialog(null, "Guardado con exito.");
				vg.getPg().getIn_edad().setText("");
				vg.getPg().getIn_nom().setText("");
				vg.getPg().getIn_raza().setText("");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "La edad debe ser un numero entero.");
			}
		}
		if(e.getActionCommand().equals("ELIMINAR_G")) {
			String aux = vg.getPg().getIn_nom_eliminar().getText();
			for(int i=0; i<listasM.getGato().size(); i++) {
				if(listasM.getGato().get(i).getNombre().equals(aux)) {
					listasM.getGato().remove(i);
					JOptionPane.showMessageDialog(null, "Eliminado con éxito.");
					break;
				}
			}
		}
		
		if(e.getActionCommand().equals("M_GATOS")) {
			vm.getPm().ponerEnBlanco();
			
			if(listasM.getGato().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay nada que listar", "Ojito!", JOptionPane.WARNING_MESSAGE);;
			}
			else {	
				crearAuxiliarTitulo("Nombre  -  Edad  -  Raza", 180, 10);
				int pos = 50;
				for(int i=0; i<listasM.getGato().size(); i++) {
					crearAuxiliar(listasM.getGato().get(i).getNombre()+"  -  "+listasM.getGato().get(i).getEdad()+"  -  "+listasM.getGato().get(i).getRaza(), 180, pos);
					pos+=30;
				}
			}
			
			vm.repaint();
		}
		
		if(e.getActionCommand().equals("M_PERROS")) {
			vm.getPm().ponerEnBlanco();
			
			if(listasM.getPerro().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay nada que listar", "Ojito!", JOptionPane.WARNING_MESSAGE);;
			}
			else {	
				crearAuxiliarTitulo("Nombre  -  Edad  -  Raza", 180, 10);
				int pos = 50;
				for(int i=0; i<listasM.getPerro().size(); i++) {
					crearAuxiliar(listasM.getPerro().get(i).getNombre()+"  -  "+listasM.getPerro().get(i).getEdad()+"  -  "+listasM.getPerro().get(i).getRaza(), 180, pos);
					pos+=30;
				}
			}
			vm.repaint();	
		}
		
		if(e.getActionCommand().equals("M_TODOS")) {
			vm.getPm().ponerEnBlanco();
			if(listasM.getPerro().isEmpty() && listasM.getGato().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No hay nada que listar", "Ojito!", JOptionPane.WARNING_MESSAGE);;
			}
			else {	
				
				crearAuxiliarTitulo("Nombre  -  Edad  -  Raza  -  Tipo", 160, 10);
				int pos = 50;
				for(int i=0; i<listasM.getPerro().size(); i++) {
					crearAuxiliar(listasM.getPerro().get(i).getNombre()+"  -  "+listasM.getPerro().get(i).getEdad()+"  -  "+listasM.getPerro().get(i).getRaza()+"  -  Perro", 160, pos);
					pos+=30;
				}
				for(int i=0; i<listasM.getGato().size(); i++) {
					crearAuxiliar(listasM.getGato().get(i).getNombre()+"  -  "+listasM.getGato().get(i).getEdad()+"  -  "+listasM.getGato().get(i).getRaza()+"  -  Gato", 160, pos);
					pos+=30;
				}
			}
			vm.repaint();
		}
		
	}
	
	/**
	 * Metodo para crear un titulo en la ventana mostrar
	 * @param m mensaje a mostrar en el titulo
	 * @param x posicion x en el panel del titulo
	 * @param y posicion y en el panel del titulo
	 */
	public void crearAuxiliarTitulo(String m, int x, int y) {
		JLabel aux;
		aux = new JLabel(m);
		aux.setFont(new Font("Arial", Font.BOLD, 20));
		aux.setBounds(x, y, 300, 25);
		aux.setVisible(true);
		vm.getPm().getBox().add(aux);
	}
	
	/**
	 * Metodo para crear un texto en la ventana mostrar
	 * @param m mensaje a mostrar
	 * @param x posicion en x
	 * @param y posicion en y
	 */
	public void crearAuxiliar(String m, int x, int y) {
		JLabel aux;
		aux = new JLabel(m);
		aux.setFont(new Font("Arial", Font.ITALIC, 20));
		aux.setBounds(x, y, 300, 25);
		aux.setVisible(true);
		vm.getPm().getBox().add(aux);
	}
}
