package co.edu.unbosque.controller;

import co.edu.unbosque.model.BoardDTO;
import co.edu.unbosque.model.PlayerCPUDAOImpl;
import co.edu.unbosque.model.PlayerPersonDAOImpl;
import co.edu.unbosque.model.RoundDAOImpl;
import co.edu.unbosque.model.persistence.FileHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import co.edu.unbosque.view.BattlesFrame;
import co.edu.unbosque.view.BoardFrame;
import co.edu.unbosque.view.ChooseFrame;
import co.edu.unbosque.view.MainFrame;
import co.edu.unbosque.view.ModeFrame;
import co.edu.unbosque.view.TeamFrame;
import co.edu.unbosque.view.TutorialFrame;

/**
 * Clase principal del controlador
 * @author Andrés Espitia
 * @author Diego Forero
 * @author Esteban Mejia
 * @author Camilo Uribe
 *
 */
public class Controller implements ActionListener{
	/**
	 * Ventana principal
	 */
	private MainFrame mf;
	/**
	 * Ventana que contiene el juego principal y el tablero
	 */
	private BoardFrame bf;
	/**
	 * Ventana que contiene las partidas guardadas
	 */
	private BattlesFrame baf;
	/**
	 * Ventana que permite elegir el modo de juego
	 */
	private ModeFrame mof;
	/**
	 * Ventanas que permiten al jugador elegir su equipo y nombre
	 */
	private TeamFrame tf1, tf2;
	/**
	 * Ventana con el tutorial
	 */
	private TutorialFrame tuf;
	/**
	 * DTO de la clase Board que contiene el tablero global usado por todo el proyecto
	 */
	private BoardDTO b;
	/**
	 * Objeto que permite que la maquina juegue
	 */
	private PlayerCPUDAOImpl pCPU;
	/**
	 * Objeto que permite que los jugadores jueguen
	 */
	private PlayerPersonDAOImpl players;
	/**
	 * Ventana que permite elegir las preferencias del programa
	 */
	private ChooseFrame cf;
	/**
	 * Objeto que guarda las partidas finalizadas
	 */
	private RoundDAOImpl rDAO;
	/**
	 * Variables que permiten conocer el lenguaje y el tema que usará el programa
	 */
	private int language, theme;
	/**
	 * Turno con el que inicia el juego
	 */
	private int turnaux = 1;
	/**
	 * Booleano que nos permite conocer si es 1v1 o vsCPU
	 */
	private boolean vsCpu = false;
	/**
	 * Cantidad de fichas en juego
	 */
	private int pieces;
	
	/**
	 * Metodo constructor
	 */
	public Controller() {
		checkInit();
	}
	
	/**
	 * Metodo de ejecucion que permite cargar las preferencias especificadas
	 */
	public void checkInit() {
		int languageInit=readInit()[0];
		int themeInit= readInit()[1];
		if(languageInit==0 && themeInit==0){
			cf= new ChooseFrame();
			cf.setVisible(true);
			cf.getCp().getBtnSave().setActionCommand("SAVE");
			cf.getCp().getBtnSave().addActionListener(this);
			cf.getCp().getChcTheme().addActionListener(this);
			cf.getCp().getChcLanguage().addActionListener(this);
		}else{
			int[] sel = readInit();
			language = sel[0];
			theme = sel[1];
			init();
			mf.setVisible(true);
		}
		
	}
	
	/**
	 * Metodo que devuelve las preferencias
	 * @return preferencias
	 */
	public int[] readInit() {
		String content= FileHandler.loadFile("config.ini");
		int[] inits = {Integer.parseInt(content.split("\n")[0]), Integer.parseInt(content.split("\n")[1])};
		return inits;
	}
	
	/**
	 * Metodo que define el idioma que se usará
	 * @return idioma
	 */
	public int checkLanguage() {
		int sel=0;
		if(cf.getCp().getChcLanguage().getSelectedItem().equals("English")) {
			sel=2;
		}else if(cf.getCp().getChcLanguage().getSelectedItem().equals("Spanish")) {
			sel=1;
		}
		return sel;
	}
	
	/**
	 * Metodo que define el tema que se usará
	 * @return tema
	 */
	public int checkTheme() {
		int sel=0;
		if(cf.getCp().getChcTheme().getSelectedItem().equals("Dark")) {
			sel=1;
		}else if(cf.getCp().getChcTheme().getSelectedItem().equals("Light")) {
			sel=2;
		}
		return sel;
	}
	
	/**
	 * Metodo que añade oyentes a cada objeto con interacción en las ventanas
	 */
	public void addListeners(){
		mf.getMp().getPlay().addActionListener(this);
		mf.getMp().getTutorial().addActionListener(this);
		mf.getMp().getMatches().addActionListener(this);
		mf.getMp().getBtnOptions().addActionListener(this);
		for(int i=0; i<bf.getBp().getPlayButts().length; i++){
			bf.getBp().getPlayButts()[i].addActionListener(this);
		}
		bf.getBp().getBtn_back().addActionListener(this);
		baf.getBp().getBtn_back().addActionListener(this);
		mof.getMop().getBtn1vs1().addActionListener(this);
		mof.getMop().getBtnVsCpu().addActionListener(this);
		tf1.getTp().getBtnFight().addActionListener(this);
		tf1.getTp().getChcAutobots().addActionListener(this);
		tf1.getTp().getChcDecepticons().addActionListener(this);
		tf2.getTp().getBtnFight().addActionListener(this);
		tf2.getTp().getChcAutobots().addActionListener(this);
		tf2.getTp().getChcDecepticons().addActionListener(this);
	}
	
	/**
	 * Metodo que define las acciones que realizará cada objeto con interacción
	 */
	public void addActionEvents(){
		mf.getMp().getPlay().setActionCommand("INIT");
		mf.getMp().getTutorial().setActionCommand("TUTORIAL");;
		mf.getMp().getMatches().setActionCommand("MATCHES");
		mf.getMp().getBtnOptions().setActionCommand("OPTIONS");
		for(int i=0; i<bf.getBp().getPlayButts().length; i++){
			bf.getBp().getPlayButts()[i].setActionCommand("PLAY"+i);;
		}
		bf.getBp().getBtn_back().setActionCommand("BACK");
		baf.getBp().getBtn_back().setActionCommand("BACK");
		mof.getMop().getBtn1vs1().setActionCommand("1V1");
		mof.getMop().getBtnVsCpu().setActionCommand("VSCPU");
		tf1.getTp().getBtnFight().setActionCommand("FIGHT1");
		tf2.getTp().getBtnFight().setActionCommand("FIGHT2");
	}
	
	/**
	 * Metodo que inicializa todos los atributos de la clase controlador
	 */
	public void init() {
		mf = new MainFrame(language,theme);
		bf = new BoardFrame(language,theme);
		baf = new BattlesFrame(language,theme);
		mof = new ModeFrame(language,theme);
		tf1 = new TeamFrame(language,theme);
		tf2 = new TeamFrame(language,theme);
		tuf = new TutorialFrame(language, theme);
		players = new PlayerPersonDAOImpl();
		pCPU = new PlayerCPUDAOImpl();
		rDAO = new RoundDAOImpl();
		rDAO.loadSerializable();
		cf= new ChooseFrame();
		pieces = 0;
		
		addActionEvents();
		addListeners();
		cf.getCp().getBtnSave().setActionCommand("SAVE");
		cf.getCp().getBtnSave().addActionListener(this);
		cf.getCp().getChcTheme().addActionListener(this);
		cf.getCp().getChcLanguage().addActionListener(this);
	}
	
	/**
	 * Metodo que vuelve a activar los botones de la ventana de juego
	 */
	public void enableButtons() {
		for(int i=0; i<bf.getBp().getPlayButts().length; i++){
			bf.getBp().getPlayButts()[i].setEnabled(true);
		}
	}
	
	/**
	 * Metodo que desactiva los botones de la ventana de juego
	 */
	public void unableButtons() {
		for(int i=0; i<bf.getBp().getPlayButts().length; i++){
			bf.getBp().getPlayButts()[i].setEnabled(false);
		}
	}
	
	/**
	 * Metodo que hace que la cpu juegue
	 * @return siguiente turno
	 */
	public int playCPU () {
		boolean[] conds = null;
		if (PlayerPersonDAOImpl.getPlyr_list().get(0).getTeam() == "Autobots") {
			pCPU.createPlayer("CPU", "Decepticons");
			bf.getBp().changeIconAndName(PlayerPersonDAOImpl.getPlyr_list().get(0).getName(), "persistence.imgautobots");
		} else {
			pCPU.createPlayer("CPU", "Autobots");
			bf.getBp().changeIconAndName(PlayerPersonDAOImpl.getPlyr_list().get(0).getName(), "persistence.imgdecepticons");			
		}
		conds = pCPU.compare();
		if (conds[1] == true && PlayerPersonDAOImpl.getPlyr_list().get(0).getTeam() == "Autobots") {
			bf.getBp().showMessage("persistence.boardframe.win.decepticons");
			rDAO.createRound("CPU", pieces, LocalDateTime.now()+"", "Decepticons");
			vsCpu = false;
			if (bf.getBp().showMessageMenu("persistence.boardframe.backmenu") == 0) {						
				bf.setVisible(false);
				init();
				mf.setVisible(true);
			}
			mf.setVisible(true);
		} else if (conds[1] == true && PlayerPersonDAOImpl.getPlyr_list().get(0).getTeam() == "Decepticons") {
			bf.getBp().showMessage("persistence.boardframe.win.autobots");
			rDAO.createRound("CPU", pieces, LocalDateTime.now()+"", "Autobots");
			vsCpu = false;
			unableButtons();
			if (bf.getBp().showMessageMenu("persistence.boardframe.backmenu") == 0) {						
				bf.setVisible(false);
				init();
				mf.setVisible(true);
			}
		}
		if (conds[0] == false) {
			bf.getBp().showMessage("persistence.boardframe.error");
			return 2;
		} else {
			bf.getBp().fillBoard(BoardDTO.matrix);
		}
		return 1;
	}
	
	/**
	 * Metodo que permite lanzar una ficha al tablero
	 * @param turn
	 * @param column
	 * @return siguiente turno
	 */
	public int throwPiece(int turn, int column) {
		boolean[] conds = null;
		int newturn = 0;
		if (turn == 1) {
			conds = players.play(column, PlayerPersonDAOImpl.getPlyr_list().get(0).getName());
			if (PlayerPersonDAOImpl.getPlyr_list().get(0).getTeam() == "Autobots") {
				if (vsCpu) {
					bf.getBp().changeIconAndName("CPU", "persistence.imgdecepticons");
				} else {					
					bf.getBp().changeIconAndName(PlayerPersonDAOImpl.getPlyr_list().get(1).getName(), "persistence.imgdecepticons");
				}
			} else {
				if (vsCpu) {
					bf.getBp().changeIconAndName("CPU", "persistence.imgautobots");
				} else {
					bf.getBp().changeIconAndName(PlayerPersonDAOImpl.getPlyr_list().get(1).getName(), "persistence.imgautobots");				
				}
			}
			if (conds[1] == true && PlayerPersonDAOImpl.getPlyr_list().get(0).getTeam() == "Autobots") {
				bf.getBp().showMessage("persistence.boardframe.win.autobots");
				rDAO.createRound(PlayerPersonDAOImpl.getPlyr_list().get(0).getName(), pieces, LocalDateTime.now()+"", PlayerPersonDAOImpl.getPlyr_list().get(0).getTeam());
				unableButtons();
				vsCpu = false;
				if (bf.getBp().showMessageMenu("persistence.boardframe.backmenu") == 0) {						
					bf.setVisible(false);
					init();
					mf.setVisible(true);
				}
			} else if (conds[1] == true && PlayerPersonDAOImpl.getPlyr_list().get(0).getTeam() == "Decepticons") {
				bf.getBp().showMessage("persistence.boardframe.win.decepticons");
				rDAO.createRound(PlayerPersonDAOImpl.getPlyr_list().get(0).getName(), pieces, LocalDateTime.now()+"", PlayerPersonDAOImpl.getPlyr_list().get(0).getTeam());
				unableButtons();
				vsCpu = false;
				if (bf.getBp().showMessageMenu("persistence.boardframe.backmenu") == 0) {						
					bf.setVisible(false);
					init();
					mf.setVisible(true);
				}
			}
			newturn = 2;
			if (conds[0] == false) {
				bf.getBp().showMessage("persistence.boardframe.error");
				if (turn == 1) {
					newturn = 2;
				} else {
					newturn = 1;
				}
			} else {
				bf.getBp().fillBoard(BoardDTO.matrix);
			}
		} else if (turn == 2) {
			if (PlayerPersonDAOImpl.getPlyr_list().size() == 2) {
				if (PlayerPersonDAOImpl.getPlyr_list().get(1).getTeam() == "Autobots") {				
					bf.getBp().changeIconAndName(PlayerPersonDAOImpl.getPlyr_list().get(0).getName(), "persistence.imgdecepticons");
				} else {
					bf.getBp().changeIconAndName(PlayerPersonDAOImpl.getPlyr_list().get(0).getName(), "persistence.imgautobots");				
				}
				conds = players.play(column, PlayerPersonDAOImpl.getPlyr_list().get(1).getName());
				if (conds[1] == true && PlayerPersonDAOImpl.getPlyr_list().get(1).getTeam() == "Autobots") {
					bf.getBp().showMessage("persistence.boardframe.win.autobots");
					rDAO.createRound(PlayerPersonDAOImpl.getPlyr_list().get(1).getName(), pieces, LocalDateTime.now()+"", PlayerPersonDAOImpl.getPlyr_list().get(1).getTeam());
					unableButtons();
					if (bf.getBp().showMessageMenu("persistence.boardframe.backmenu") == 0) {						
						bf.setVisible(false);
						init();
						mf.setVisible(true);
					}
				} else if (conds[1] == true && PlayerPersonDAOImpl.getPlyr_list().get(1).getTeam() == "Decepticons") {
					bf.getBp().showMessage("persistence.boardframe.win.decepticons");
					rDAO.createRound(PlayerPersonDAOImpl.getPlyr_list().get(1).getName(), pieces, LocalDateTime.now()+"", PlayerPersonDAOImpl.getPlyr_list().get(1).getTeam());
					unableButtons();
					if (bf.getBp().showMessageMenu("persistence.boardframe.backmenu") == 0) {						
						bf.setVisible(false);
						init();
						mf.setVisible(true);
					}
				}
				newturn = 1;
				if (conds[0] == false) {
					bf.getBp().showMessage("persistence.boardframe.error");
					if (turn == 1) {
						newturn = 2;
					} else {
						newturn = 1;
					}
				} else {
					bf.getBp().fillBoard(BoardDTO.matrix);
				}
			}
		}
		return newturn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("SAVE")){
			language = checkLanguage();
			theme = checkTheme();
			String content = language+"\n"+theme;
			FileHandler.writeFile("config.ini", content);
			init();
			cf.setVisible(false);
			mf.setVisible(true);
			
		}
		if(e.getActionCommand().equals("INIT")){
			mf.setVisible(false);
			mof.setVisible(true);
		}
		if(e.getActionCommand().equals("TUTORIAL")){
			tuf.setVisible(true);
		}
		if(e.getActionCommand().equals("MATCHES")){
			mf.setVisible(false);
			baf.getBp().initBattles(rDAO.getRounds());
			baf.setVisible(true);
		}
		if(e.getActionCommand().equals("OPTIONS")){
			mf.setVisible(false);
			cf.setVisible(true);
		}
		if(e.getActionCommand().equals("BACK")){
			bf.setVisible(false);
			baf.setVisible(false);
			init();
			mf.setVisible(true);
		}
		if(e.getActionCommand().equals("1V1")){
			mof.setVisible(false);
			tf2.setVisible(true);
			tf1.setVisible(true);
		}
		if(e.getActionCommand().equals("VSCPU")){
			mof.setVisible(false);
			tf2.setVisible(true);
			vsCpu = true;
		}
		if(e.getActionCommand().equals("FIGHT1")){
			String team = "";
			if (tf1.getTp().getChcAutobots().isSelected()) {
				team = "Autobots";
			} else if (tf1.getTp().getChcDecepticons().isSelected()) {
				team = "Decepticons";
			}
			if (tf1.getTp().getChcAutobots().isSelected() && tf1.getTp().getChcDecepticons().isSelected()) {
				tf1.getTp().showError("persistence.teamframe.error");
			} else if (!tf1.getTp().getChcAutobots().isSelected() && !tf1.getTp().getChcDecepticons().isSelected()) {
				tf1.getTp().showError("persistence.teamframe.error");
			}else {				
				players.createPlayer(tf1.getTp().getTxtwarrior().getText(), team);
				tf1.setVisible(false);
			}
		}
		if(e.getActionCommand().equals("FIGHT2")){
			String team = "";
			if (tf2.getTp().getChcAutobots().isSelected()) {
				team = "Autobots";
			} else if (tf2.getTp().getChcDecepticons().isSelected()) {
				team = "Decepticons";
			}
			if (tf2.getTp().getChcAutobots().isSelected() && tf2.getTp().getChcDecepticons().isSelected()) {
				tf2.getTp().showError("persistence.teamframe.error");
			} else if (!tf2.getTp().getChcAutobots().isSelected() && !tf2.getTp().getChcDecepticons().isSelected()) {
				tf2.getTp().showError("persistence.teamframe.error");
			} else {	
				if (!PlayerPersonDAOImpl.getPlyr_list().isEmpty() && team.equals(PlayerPersonDAOImpl.getPlyr_list().get(0).getTeam())) {
					tf2.getTp().showError("persistence.teamframe.error2");
				} else {					
					players.createPlayer(tf2.getTp().getTxtwarrior().getText(), team);
					tf2.setVisible(false);
					bf.setVisible(true);
				}
			}
			enableButtons();
		}
		if (e.getActionCommand().contains("PLAY")) {
			pieces++;
			turnaux = throwPiece(turnaux, Integer.parseInt(e.getActionCommand().split("Y")[1]));
		}
		while (vsCpu && turnaux == 2) {			
			turnaux = playCPU();
			pieces++;
		}
	}
}