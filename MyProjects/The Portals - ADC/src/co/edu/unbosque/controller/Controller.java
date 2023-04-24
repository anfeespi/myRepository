package co.edu.unbosque.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import co.edu.unbosque.model.Archivo;
import co.edu.unbosque.model.Cuestionario;
import co.edu.unbosque.model.Dado;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.Partida;
import co.edu.unbosque.model.PortalAvanzar;
import co.edu.unbosque.model.PortalRetroceder;
import co.edu.unbosque.view.Portales;
import co.edu.unbosque.view.Tablero;
import co.edu.unbosque.view.VentanaJugadoresTablero;
import co.edu.unbosque.view.VentanaMenu;
import co.edu.unbosque.view.VentanaPartidas;
import co.edu.unbosque.view.VentanaPersonajes;
import co.edu.unbosque.view.VentanaReglas;
import co.edu.unbosque.view.VentanaTablero;

/**
 * Controlador del programa
 * 
 * @author Andres Espitia
 * @author Camilo Uribe
 * @author Diego Forero
 * 
 */
public class Controller implements ActionListener {
	/**
	 * Ventana principal del menu
	 */
	private VentanaMenu vm;
	/**
	 * Ventana donde se elige el tamanio del tablero y los jugadores
	 */
	private VentanaJugadoresTablero vjt;
	/**
	 * Arreglo de ventanas donde se escogen los personajes
	 */
	private VentanaPersonajes[] vp;
	/**
	 * Ventana del tablero
	 */
	private VentanaTablero vt;
	/**
	 * Ventana de las reglas
	 */
	private VentanaReglas vreglas;
	/**
	 * Ventana donde aparecen las partidas guardadas
	 */
	private VentanaPartidas vpartidas;
	/**
	 * Arreglo de jugadores
	 */
	private Jugador[] jugadores;
	/**
	 * Vista de los portales
	 */
	private Portales port_view;
	/**
	 * Objeto de los portales para avanzar
	 */
	private PortalAvanzar por_avanzar;
	/**
	 * Objeto de los portales para retroceder
	 */
	private PortalRetroceder por_retro;
	/**
	 * Objeto del dado
	 */
	private Dado dado;
	/**
	 * Cuestionario de donde se sacan las preguntas
	 */
	private Cuestionario cuestionario;
	/**
	 * Objeto partida donde se guardan todos los datos
	 */
	private Partida partida;
	/**
	 * Archivo donde se guardan los datos
	 */
	private Archivo archivo_partidas;
	/**
	 * Arreglo de index para evitar que se repitan los personajes escogidos
	 */
	private boolean[] index_personajes;
	/**
	 * Variable que guarda los turnos totales de cada partida
	 */
	private int num_turnos_partida = 0;
	/**
	 * Variable donde se guarda la cantidad de respuestas correctas de cada partida
	 */
	private int respuestas_correctas = 0;
	/**
	 * Variable que indica la cantidad de jugadores
	 */
	private int jug = 0;
	/**
	 * Variable que guarda el turno en la partida
	 */
	private int turno;

	/**
	 * Metodo constructor
	 */
	public Controller() {
		vm = new VentanaMenu();
		vjt = new VentanaJugadoresTablero();
		vt = new VentanaTablero();
		vp = new VentanaPersonajes[4];
		turno = 0;
		index_personajes = new boolean[4];
		for (boolean b : index_personajes) {
			b = false;
		}
		dado = new Dado();
		vreglas = new VentanaReglas();
		vpartidas = new VentanaPartidas();
		initVentanasPersonajes();
		init();
	}

	/**
	 * Metodo que inicializa la ventana principal, el archivo, los listeners y los
	 * comandos
	 */
	public void init() {
		vm.setVisible(true);
		archivo_partidas = new Archivo();
		initJugadores();
		listeners();
		comands();
	}

	/**
	 * Metodo que inicializa las ventanas de los personajes
	 */
	public void initVentanasPersonajes() {
		for (int i = 0; i < vp.length; i++) {
			vp[i] = new VentanaPersonajes();
		}
	}

	/**
	 * Metodo que asigna los oyentes
	 */
	public void listeners() {
		vm.getPr().getButt_jugar().addActionListener(this);
		vm.getPr().getButt_reglas().addActionListener(this);
		vm.getPr().getbutt_partidas().addActionListener(this);
		vjt.getPanelJT().getNext().addActionListener(this);
		vjt.getPanelJT().getBack().addActionListener(this);
		vt.getPt().getHome().addActionListener(this);
		vt.getPt().getReglas().addActionListener(this);
		vt.getPt().getLanzar_dado().addActionListener(this);
	}

	/**
	 * Metodo que asigna los comandos
	 */
	public void comands() {
		vm.getPr().getButt_jugar().setActionCommand("JUGAR");
		vm.getPr().getButt_reglas().setActionCommand("REGLAS");
		vm.getPr().getbutt_partidas().setActionCommand("PARTIDAS");
		vjt.getPanelJT().getNext().setActionCommand("NEXT");
		vjt.getPanelJT().getBack().setActionCommand("BACK");
		vt.getPt().getHome().setActionCommand("HOME");
		vt.getPt().getReglas().setActionCommand("REGLAS_TABLERO");
		vt.getPt().getLanzar_dado().setActionCommand("LANZAR_DADO");
	}

	/**
	 * Metodo que da funcionalidad a los botones de las ventanas de los personajes,
	 * recibe como parametro el numero de jugadores
	 * 
	 * @param num personajes
	 */
	public void initVentanasPersonajesBotones(int num) {
		jug = num - 1;
		for (int i = 0; i < vp.length; i++) {
			vp[i].getPp().getNum_jugador().setText("Jugador " + (i + 1));
			String aux = "NEXT_PLAYER" + i;
			String aux2 = "BACK_PLAYER" + i;
			if (i == 0) {
				aux2 = "BACK_PLAYER_FINAL";
			}
			if (i == num - 1) {
				aux = "NEXT_PLAYER_FINAL";
			}
			vp[i].getPp().getNext().addActionListener(this);
			vp[i].getPp().getBack().addActionListener(this);
			vp[i].getPp().getNext().setActionCommand(aux);
			vp[i].getPp().getBack().setActionCommand(aux2);
		}
	}

	/**
	 * Guarda el index de los personajes para evitar que se pueda escoger el mismo
	 * personaje que otro jugador, recibe el index del jugador y la ventana
	 * 
	 * @param index   jugador
	 * @param ventana actual
	 */
	public void guardarIndexPersonajes(int index, int ventana) {
		if (index_personajes[index] == true) {
			JOptionPane.showMessageDialog(null, "Este personaje ya fue seleccionado!", "Error!",
					JOptionPane.ERROR_MESSAGE);
		} else if (index_personajes[index] == false) {
			index_personajes[index] = true;
			if (ventana == jug) {
				vp[ventana].setVisible(false);
				vt.setVisible(true);
			} else {
				vp[ventana].setVisible(false);
				vp[ventana + 1].setVisible(true);
			}
		}
	}

	/**
	 * Inicializa todo de nuevo para poder jugar nuevamente
	 * 
	 * @param ventana actual
	 */
	public void eliminarIndexPersonajes(int ventana) {
		index_personajes = new boolean[4];
		for (int i = 0; i < index_personajes.length; i++) {
			index_personajes[i] = false;
		}
		vm.setVisible(true);
		vp[ventana].setVisible(false);
		initJugadores();
		vjt = new VentanaJugadoresTablero();
		vt = new VentanaTablero();
		vp = new VentanaPersonajes[4];
		initVentanasPersonajes();
		listeners();
		comands();
		num_turnos_partida = 0;
		respuestas_correctas = 0;
	}

	/**
	 * Inicializa el arreglo de jugadores
	 */
	public void initJugadores() {
		jugadores = new Jugador[4];
		for (int i = 0; i < jugadores.length; i++) {
			jugadores[i] = new Jugador();
		}
	}

	/**
	 * Asigna y guarda los datos del personaje
	 * 
	 * @param index_jugador del jugador
	 * @param nombre        del jugador
	 * @param index         seleccion
	 */
	public void initDatosJugador(int index_jugador, String nombre, int index) {
		String aux = "";
		switch (index) {
		case 0:
			aux = "alien";
			break;
		case 1:
			aux = "robot";
			break;
		case 2:
			aux = "astronauta";
			break;
		case 3:
			aux = "fantasma";
			break;
		}
		jugadores[index_jugador].setNombre(nombre);
		jugadores[index_jugador].getFicha().setPersonaje(aux);
		switch (index) {
		case 0:
			moverJugadorAlien(index_jugador, 0);
			break;
		case 1:
			moverJugadorRobot(index_jugador, 0);
			break;
		case 2:
			moverJugadorAstronauta(index_jugador, 0);
			break;
		case 3:
			moverJugadorFantasma(index_jugador, 0);
			break;
		}
	}

	/**
	 * Metodo para mover la ficha del Astronauta
	 * 
	 * @param turno_jugador del jugador
	 * @param num_dado      obtenido
	 */
	public void moverJugadorAstronauta(int turno_jugador, int num_dado) {
		vt.getPt().getTablero().getCasillas()[jugadores[turno_jugador].getFicha().getMt()
				.getI()][jugadores[turno_jugador].getFicha().getMt().getJ()]
						.remove(vt.getPt().getTablero().getAstronauta());
		jugadores[turno_jugador].getFicha().getMt().moverFicha(num_dado);
		if (jugadores[turno_jugador].getFicha().getMt().isFinal_tablero() == true) {
			vt.getPt().getLanzar_dado().setEnabled(false);
			JOptionPane.showMessageDialog(null,
					"Juego terminado!! El ganador es " + jugadores[turno_jugador].getNombre() + ". Total de turnos: "
							+ num_turnos_partida + ", Total aciertos: " + respuestas_correctas);
			archivo_partidas.guardarNuevaPartida(jugadores[turno_jugador].getNombre(), partida.getFilas(),
					partida.getFilas(), partida.getNjugadores());
		}
		vt.getPt().getTablero().getCasillas()[jugadores[turno_jugador].getFicha().getMt()
				.getI()][jugadores[turno_jugador].getFicha().getMt().getJ()]
						.add(vt.getPt().getTablero().getAstronauta());
		vt.repaint();
		if (jugadores[turno_jugador].getFicha().getMt().getI() < vt.getPt().getTablero().getFilas() - 1
				&& jugadores[turno_jugador].getFicha().getMt()
						.getJ() == por_avanzar.getPortal_entrada()[jugadores[turno_jugador].getFicha().getMt().getI()]
								.getColumna()) {
			if (mostrarPreguntas()) {
				JOptionPane.showMessageDialog(null, "Respuesta correcta!! Logras pasar el portal!!");
				int aux = jugadores[turno_jugador].getFicha().getMt().getI();
				vt.getPt().getTablero().getCasillas()[por_avanzar.getPortal_salida()[aux]
						.getFila()][por_avanzar.getPortal_salida()[aux].getColumna()]
								.add(vt.getPt().getTablero().getAstronauta());
				jugadores[turno_jugador].getFicha().getMt().setI(por_avanzar.getPortal_salida()[aux].getFila());
				jugadores[turno_jugador].getFicha().getMt().setJ(por_avanzar.getPortal_salida()[aux].getColumna());
				vt.repaint();
				respuestas_correctas++;
			} else {
				JOptionPane.showMessageDialog(null, "Respuesta incorrecta!! No logras pasar el portal!!", "Error!",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (jugadores[turno_jugador].getFicha().getMt().getI() > 0 && jugadores[turno_jugador].getFicha().getMt()
				.getJ() == por_retro.getPortal_entrada()[jugadores[turno_jugador].getFicha().getMt().getI() - 1]
						.getColumna()) {
			JOptionPane.showMessageDialog(null, "Ups, caiste en un portal rojo!! Retrocedes en el tiempo!!");
			int aux = jugadores[turno_jugador].getFicha().getMt().getI() - 1;
			vt.getPt().getTablero().getCasillas()[por_retro.getPortal_salida()[aux]
					.getFila()][por_retro.getPortal_salida()[aux].getColumna()]
							.add(vt.getPt().getTablero().getAstronauta());
			jugadores[turno_jugador].getFicha().getMt().setI(por_retro.getPortal_salida()[aux].getFila());
			jugadores[turno_jugador].getFicha().getMt().setJ(por_retro.getPortal_salida()[aux].getColumna());
			vt.repaint();
		}
	}

	/**
	 * Metodo para mover la ficha del Alien
	 * 
	 * @param turno_jugador del jugador
	 * @param num_dado      obtenido
	 */
	public void moverJugadorAlien(int turno_jugador, int num_dado) {
		vt.getPt().getTablero().getCasillas()[jugadores[turno_jugador].getFicha().getMt()
				.getI()][jugadores[turno_jugador].getFicha().getMt().getJ()].remove(vt.getPt().getTablero().getAlien());
		jugadores[turno_jugador].getFicha().getMt().moverFicha(num_dado);
		if (jugadores[turno_jugador].getFicha().getMt().isFinal_tablero() == true) {
			vt.getPt().getLanzar_dado().setEnabled(false);
			JOptionPane.showMessageDialog(null,
					"Juego terminado!! El ganador es " + jugadores[turno_jugador].getNombre() + ". Total de turnos: "
							+ num_turnos_partida + ", Total aciertos: " + respuestas_correctas);
			archivo_partidas.guardarNuevaPartida(jugadores[turno_jugador].getNombre(), partida.getFilas(),
					partida.getFilas(), partida.getNjugadores());
		}
		vt.getPt().getTablero().getCasillas()[jugadores[turno_jugador].getFicha().getMt()
				.getI()][jugadores[turno_jugador].getFicha().getMt().getJ()].add(vt.getPt().getTablero().getAlien());
		vt.repaint();
		if (jugadores[turno_jugador].getFicha().getMt().getI() < vt.getPt().getTablero().getFilas() - 1
				&& jugadores[turno_jugador].getFicha().getMt()
						.getJ() == por_avanzar.getPortal_entrada()[jugadores[turno_jugador].getFicha().getMt().getI()]
								.getColumna()) {
			if (mostrarPreguntas()) {
				JOptionPane.showMessageDialog(null, "Respuesta correcta!! Logras pasar el portal!!");
				int aux = jugadores[turno_jugador].getFicha().getMt().getI();
				vt.getPt().getTablero().getCasillas()[por_avanzar.getPortal_salida()[aux]
						.getFila()][por_avanzar.getPortal_salida()[aux].getColumna()]
								.add(vt.getPt().getTablero().getAlien());
				jugadores[turno_jugador].getFicha().getMt().setI(por_avanzar.getPortal_salida()[aux].getFila());
				jugadores[turno_jugador].getFicha().getMt().setJ(por_avanzar.getPortal_salida()[aux].getColumna());
				vt.repaint();
				respuestas_correctas++;
			} else {
				JOptionPane.showMessageDialog(null, "Respuesta incorrecta!! No logras pasar el portal!!", "Error!",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (jugadores[turno_jugador].getFicha().getMt().getI() > 0 && jugadores[turno_jugador].getFicha().getMt()
				.getJ() == por_retro.getPortal_entrada()[jugadores[turno_jugador].getFicha().getMt().getI() - 1]
						.getColumna()) {
			JOptionPane.showMessageDialog(null, "Ups, caiste en un portal rojo!! Retrocedes en el tiempo!!");
			int aux = jugadores[turno_jugador].getFicha().getMt().getI() - 1;
			vt.getPt().getTablero().getCasillas()[por_retro.getPortal_salida()[aux]
					.getFila()][por_retro.getPortal_salida()[aux].getColumna()].add(vt.getPt().getTablero().getAlien());
			jugadores[turno_jugador].getFicha().getMt().setI(por_retro.getPortal_salida()[aux].getFila());
			jugadores[turno_jugador].getFicha().getMt().setJ(por_retro.getPortal_salida()[aux].getColumna());
			vt.repaint();
		}
	}

	/**
	 * Metodo para mover la ficha del Fantasma
	 * 
	 * @param turno_jugador del jugador
	 * @param num_dado      obtenido
	 */
	public void moverJugadorFantasma(int turno_jugador, int num_dado) {
		vt.getPt().getTablero().getCasillas()[jugadores[turno_jugador].getFicha().getMt()
				.getI()][jugadores[turno_jugador].getFicha().getMt().getJ()]
						.remove(vt.getPt().getTablero().getFantasma());
		jugadores[turno_jugador].getFicha().getMt().moverFicha(num_dado);
		if (jugadores[turno_jugador].getFicha().getMt().isFinal_tablero() == true) {
			vt.getPt().getLanzar_dado().setEnabled(false);
			JOptionPane.showMessageDialog(null,
					"Juego terminado!! El ganador es " + jugadores[turno_jugador].getNombre() + ". Total de turnos: "
							+ num_turnos_partida + ", Total aciertos: " + respuestas_correctas);
			archivo_partidas.guardarNuevaPartida(jugadores[turno_jugador].getNombre(), partida.getFilas(),
					partida.getFilas(), partida.getNjugadores());
		}
		vt.getPt().getTablero().getCasillas()[jugadores[turno_jugador].getFicha().getMt()
				.getI()][jugadores[turno_jugador].getFicha().getMt().getJ()].add(vt.getPt().getTablero().getFantasma());
		vt.repaint();
		if (jugadores[turno_jugador].getFicha().getMt().getI() < vt.getPt().getTablero().getFilas() - 1
				&& jugadores[turno_jugador].getFicha().getMt()
						.getJ() == por_avanzar.getPortal_entrada()[jugadores[turno_jugador].getFicha().getMt().getI()]
								.getColumna()) {
			if (mostrarPreguntas()) {
				JOptionPane.showMessageDialog(null, "Respuesta correcta!! Logras pasar el portal!!");
				int aux = jugadores[turno_jugador].getFicha().getMt().getI();
				vt.getPt().getTablero().getCasillas()[por_avanzar.getPortal_salida()[aux]
						.getFila()][por_avanzar.getPortal_salida()[aux].getColumna()]
								.add(vt.getPt().getTablero().getFantasma());
				jugadores[turno_jugador].getFicha().getMt().setI(por_avanzar.getPortal_salida()[aux].getFila());
				jugadores[turno_jugador].getFicha().getMt().setJ(por_avanzar.getPortal_salida()[aux].getColumna());
				vt.repaint();
				respuestas_correctas++;
			} else {
				JOptionPane.showMessageDialog(null, "Respuesta incorrecta!! No logras pasar el portal!!", "Error!",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (jugadores[turno_jugador].getFicha().getMt().getI() > 0 && jugadores[turno_jugador].getFicha().getMt()
				.getJ() == por_retro.getPortal_entrada()[jugadores[turno_jugador].getFicha().getMt().getI() - 1]
						.getColumna()) {
			JOptionPane.showMessageDialog(null, "Ups, caiste en un portal rojo!! Retrocedes en el tiempo!!");
			int aux = jugadores[turno_jugador].getFicha().getMt().getI() - 1;
			vt.getPt().getTablero().getCasillas()[por_retro.getPortal_salida()[aux]
					.getFila()][por_retro.getPortal_salida()[aux].getColumna()]
							.add(vt.getPt().getTablero().getFantasma());
			jugadores[turno_jugador].getFicha().getMt().setI(por_retro.getPortal_salida()[aux].getFila());
			jugadores[turno_jugador].getFicha().getMt().setJ(por_retro.getPortal_salida()[aux].getColumna());
			vt.repaint();
		}
	}

	/**
	 * Metodo para mover la ficha del Robot
	 * 
	 * @param turno_jugador del jugador
	 * @param num_dado      obtenido
	 */
	public void moverJugadorRobot(int turno_jugador, int num_dado) {
		vt.getPt().getTablero().getCasillas()[jugadores[turno_jugador].getFicha().getMt()
				.getI()][jugadores[turno_jugador].getFicha().getMt().getJ()].remove(vt.getPt().getTablero().getRobot());
		jugadores[turno_jugador].getFicha().getMt().moverFicha(num_dado);
		if (jugadores[turno_jugador].getFicha().getMt().isFinal_tablero() == true) {
			vt.getPt().getLanzar_dado().setEnabled(false);
			JOptionPane.showMessageDialog(null,
					"Juego terminado!! El ganador es " + jugadores[turno_jugador].getNombre() + ". Total de turnos: "
							+ num_turnos_partida + ", Total aciertos: " + respuestas_correctas);
			archivo_partidas.guardarNuevaPartida(jugadores[turno_jugador].getNombre(), partida.getFilas(),
					partida.getFilas(), partida.getNjugadores());
		}
		vt.getPt().getTablero().getCasillas()[jugadores[turno_jugador].getFicha().getMt()
				.getI()][jugadores[turno_jugador].getFicha().getMt().getJ()].add(vt.getPt().getTablero().getRobot());
		vt.repaint();
		if (jugadores[turno_jugador].getFicha().getMt().getI() < vt.getPt().getTablero().getFilas() - 1
				&& jugadores[turno_jugador].getFicha().getMt()
						.getJ() == por_avanzar.getPortal_entrada()[jugadores[turno_jugador].getFicha().getMt().getI()]
								.getColumna()) {
			if (mostrarPreguntas()) {
				JOptionPane.showMessageDialog(null, "Respuesta correcta!! Logras pasar el portal!!");
				int aux = jugadores[turno_jugador].getFicha().getMt().getI();
				vt.getPt().getTablero().getCasillas()[por_avanzar.getPortal_salida()[aux]
						.getFila()][por_avanzar.getPortal_salida()[aux].getColumna()]
								.add(vt.getPt().getTablero().getRobot());
				jugadores[turno_jugador].getFicha().getMt().setI(por_avanzar.getPortal_salida()[aux].getFila());
				jugadores[turno_jugador].getFicha().getMt().setJ(por_avanzar.getPortal_salida()[aux].getColumna());
				vt.repaint();
				respuestas_correctas++;
			} else {
				JOptionPane.showMessageDialog(null, "Respuesta incorrecta!! No logras pasar el portal!!", "Error!",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (jugadores[turno_jugador].getFicha().getMt().getI() > 0 && jugadores[turno_jugador].getFicha().getMt()
				.getJ() == por_retro.getPortal_entrada()[jugadores[turno_jugador].getFicha().getMt().getI() - 1]
						.getColumna()) {
			JOptionPane.showMessageDialog(null, "Ups, caiste en un portal rojo!! Retrocedes en el tiempo!!");
			int aux = jugadores[turno_jugador].getFicha().getMt().getI() - 1;
			vt.getPt().getTablero().getCasillas()[por_retro.getPortal_salida()[aux]
					.getFila()][por_retro.getPortal_salida()[aux].getColumna()].add(vt.getPt().getTablero().getRobot());
			jugadores[turno_jugador].getFicha().getMt().setI(por_retro.getPortal_salida()[aux].getFila());
			jugadores[turno_jugador].getFicha().getMt().setJ(por_retro.getPortal_salida()[aux].getColumna());
			vt.repaint();
		}
	}

	/**
	 * Inicializa los portales
	 * 
	 * @param filas    tablero
	 * @param columnas tablero
	 */
	public void initPortales(int filas, int columnas) {
		por_avanzar = new PortalAvanzar(filas, columnas);
		por_retro = new PortalRetroceder(filas, columnas, por_avanzar);
	}

	/**
	 * Metodo para mostrar los portales de avanzar en el tablero
	 */
	public void mostrarPortalesAvanzar() {
		for (int i = 0; i < por_avanzar.getPortal_entrada().length; i++) {
			port_view = new Portales("azul-entrada");
			vt.getPt().getTablero().getCasillas()[por_avanzar.getPortal_entrada()[i]
					.getFila()][por_avanzar.getPortal_entrada()[i].getColumna()].add(port_view);
			port_view = new Portales("azul-salida");
			vt.getPt().getTablero().getCasillas()[por_avanzar.getPortal_salida()[i]
					.getFila()][por_avanzar.getPortal_salida()[i].getColumna()].add(port_view);
		}
	}

	/**
	 * Metodo para mostrar los portales de retroceder en el tablero
	 */
	public void mostrarPortalesRetroceder() {
		for (int i = 0; i < por_retro.getPortal_entrada().length; i++) {
			port_view = new Portales("rojo-entrada");
			vt.getPt().getTablero().getCasillas()[por_retro.getPortal_entrada()[i]
					.getFila()][por_retro.getPortal_entrada()[i].getColumna()].add(port_view);
			port_view = new Portales("rojo-salida");
			vt.getPt().getTablero().getCasillas()[por_retro.getPortal_salida()[i]
					.getFila()][por_retro.getPortal_salida()[i].getColumna()].add(port_view);

		}
	}

	/**
	 * Metodo para que aparezcan las preguntas al caer en un portal
	 * 
	 * @return si la respuesta es correcta
	 */
	public boolean mostrarPreguntas() {
		cuestionario = new Cuestionario();
		Random random = new Random();
		int valor = random.nextInt(14);
		String[] aux = { cuestionario.getPreguntas()[valor].getRespuesta1(),
				cuestionario.getPreguntas()[valor].getRespuesta2(), cuestionario.getPreguntas()[valor].getRespuesta3(),
				cuestionario.getPreguntas()[valor].getRespuesta4() };
		String indexres = (String) JOptionPane.showInputDialog(null, cuestionario.mostrarPregunta(valor), "Pregunta...",
				JOptionPane.QUESTION_MESSAGE, null, aux, aux[0]);
		return cuestionario.verificarRespuestas(valor, indexres);
	}

	/**
	 * Metodo para mostrar las partidas guardadas dentro de la ventana
	 */
	public void mostrarPartidas() {
		vpartidas.getPpartidas().getPanel_texto().removeAll();
		vpartidas.getPpartidas().getPanel_texto().add(vpartidas.getPpartidas().getTitulo());
		int distancia = 50;
		for (int i = 0; i < archivo_partidas.getPast_partidas().size(); i++) {
			String datos = archivo_partidas.getPast_partidas().get(i);
			JLabel aux = new JLabel(datos);
			aux.setBounds(10, distancia, 560, 30);
			aux.setFont(vpartidas.getPpartidas().getSubtitlefont());
			aux.setVisible(true);
			vpartidas.getPpartidas().getPanel_texto().add(aux);
			distancia += 30;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("JUGAR")) {
			vm.setVisible(false);
			vjt.setVisible(true);
			partida = new Partida();
		} else if (e.getActionCommand().equals("REGLAS")) {
			vreglas.setVisible(true);
		} else if (e.getActionCommand().equals("PARTIDAS")) {
			vpartidas.setVisible(true);
			mostrarPartidas();
		} else if (e.getActionCommand().equals("NEXT")) {
			try {
				int columnas = Integer.parseInt(vjt.getPanelJT().getColumnas_tablero().getText());
				int filas = Integer.parseInt(vjt.getPanelJT().getFilas_tablero().getText());
				partida.setColumnas(columnas);
				partida.setFilas(filas);
				if (columnas <= 20 && filas <= 20 && columnas >= 5 && filas >= 5) {
					vjt.setVisible(false);
					initPortales(filas, columnas);
					vt.getPt().initTablero(columnas, filas);
					vt.getPt().getTablero().setPreferredSize(new Dimension(columnas * 300, filas * 200));
					int index = vjt.getPanelJT().getSelector_jugadores().getSelectedIndex();
					int numjug = index + 2;
					partida.setNjugadores(numjug);
					for (int i = 0; i < numjug; i++) {
						jugadores[i].getFicha().crearTablero(columnas, filas);
					}
					initVentanasPersonajesBotones(numjug);
					mostrarPortalesAvanzar();
					mostrarPortalesRetroceder();
					vp[0].setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Tablero no valido, minimo 5x5 y maximo 20x20!", "Error!",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NullPointerException x) {
				JOptionPane.showMessageDialog(null, "Debes ingresar el valor de las filas y columnas!", "Error!",
						JOptionPane.ERROR_MESSAGE);
			} catch (NumberFormatException x) {
				JOptionPane.showMessageDialog(null, "Debes ingresar valores numericos!", "Error!",
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getActionCommand().equals("BACK")) {
			vjt.setVisible(false);
			vm.setVisible(true);
		} else if (e.getActionCommand().equals("NEXT_PLAYER0")) {
			int index = vp[0].getPp().getSelector_personaje().getSelectedIndex();
			initDatosJugador(0, vp[0].getPp().getNombre_jugador().getText(), index);
			guardarIndexPersonajes(index, 0);
		} else if (e.getActionCommand().equals("NEXT_PLAYER1")) {
			int index = vp[1].getPp().getSelector_personaje().getSelectedIndex();
			initDatosJugador(1, vp[1].getPp().getNombre_jugador().getText(), index);
			guardarIndexPersonajes(index, 1);
		} else if (e.getActionCommand().equals("NEXT_PLAYER2")) {
			int index = vp[2].getPp().getSelector_personaje().getSelectedIndex();
			initDatosJugador(2, vp[2].getPp().getNombre_jugador().getText(), index);
			guardarIndexPersonajes(index, 2);
		} else if (e.getActionCommand().equals("NEXT_PLAYER_FINAL")) {
			int index = vp[jug].getPp().getSelector_personaje().getSelectedIndex();
			initDatosJugador(jug, vp[jug].getPp().getNombre_jugador().getText(), index);
			guardarIndexPersonajes(index, jug);
			vt.getPt().getTurno().setText("Turno de: " + jugadores[0].getNombre());
		} else if (e.getActionCommand().equals("BACK_PLAYER_FINAL")) {
			eliminarIndexPersonajes(0);
		} else if (e.getActionCommand().equals("BACK_PLAYER1")) {
			eliminarIndexPersonajes(1);
		} else if (e.getActionCommand().equals("BACK_PLAYER2")) {
			eliminarIndexPersonajes(2);
		} else if (e.getActionCommand().equals("BACK_PLAYER3")) {
			eliminarIndexPersonajes(3);
		} else if (e.getActionCommand().equals("HOME")) {
			vt.setVisible(false);
			eliminarIndexPersonajes(jug);
			vm.setVisible(true);
		} else if (e.getActionCommand().equals("REGLAS_TABLERO")) {
			vreglas.setVisible(true);
		} else if (e.getActionCommand().equals("LANZAR_DADO")) {
			dado.generarAleatorio();
			int num = dado.getValor();
			String cara = "src/img/dado" + num + ".png";
			vt.getPt().getImg_dado().setIcon(new ImageIcon(cara));
			vt.getPt().getImg_dado().repaint();
			switch (jugadores[turno].getFicha().getPersonaje()) {
			case "alien":
				dado.generarAleatorio();
				moverJugadorAlien(turno, num);
				break;
			case "astronauta":
				moverJugadorAstronauta(turno, num);
				break;
			case "robot":
				moverJugadorRobot(turno, num);
				break;
			case "fantasma":
				moverJugadorFantasma(turno, num);
				break;
			}
			if (turno < jug) {
				turno++;
			} else {
				turno = 0;
			}
			num_turnos_partida++;
			vt.getPt().getTurno().setText("Turno de: " + jugadores[turno].getNombre());

		}
	}
}
