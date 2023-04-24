package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.PokemonAnotherGenDTO;
import co.edu.unbosque.model.PokemonDAO;
import co.edu.unbosque.model.PokemonDTO;
import co.edu.unbosque.model.PokemonGenVDTO;
import co.edu.unbosque.model.ReadAndUpdateFile;
import co.edu.unbosque.view.CatchedFrame;
import co.edu.unbosque.view.GraveyardFrame;
import co.edu.unbosque.view.MainFrame;
import co.edu.unbosque.view.PokeCard;
import co.edu.unbosque.view.RegisteredFrame;
import co.edu.unbosque.view.TrainFrame;

public class Controller implements ActionListener {

	private MainFrame mf;
	private GraveyardFrame gf;
	private RegisteredFrame rf;
	private CatchedFrame cf;
	private TrainFrame tf;
	private PokeCard card;
	private PokemonDAO pokeDAO;
	private ArrayList<String> pokenames;
	private ArrayList<ArrayList<String>>[] all_abilities;
	private ReadAndUpdateFile ruf;

	public Controller() {
		pokeDAO = new PokemonDAO();
		ruf = new ReadAndUpdateFile();
		savePokemons();
		getNamesPokemons();
		mf = new MainFrame();
		rf = new RegisteredFrame(pokenames);
		gf = new GraveyardFrame(pokenames);
		cf = new CatchedFrame();
		tf = new TrainFrame();
		init();
		initListeners();
		initCommands();
	}

	public void init() {
		mf.setVisible(true);
	}

	public void initListeners() {
		mf.getMp().getRegistered_button().addActionListener(this);
		mf.getMp().getNew_pokemon_button().addActionListener(this);
		mf.getMp().getDelete_button().addActionListener(this);
		rf.getBack().addActionListener(this);
		gf.getBack().addActionListener(this);
		cf.getBack().addActionListener(this);
		cf.getCp().getBtnAtrapado().addActionListener(this);
		rf.getRp().getTrain_butt().addActionListener(this);
		rf.getRp().getDetails_butt().addActionListener(this);
		for (int i = 0; i < rf.getRp().getPokpa().getBoxes().length; i++) {
			for (int j = 0; j < rf.getRp().getPokpa().getBoxes()[i].length; j++) {
				rf.getRp().getPokpa().getBoxes()[i][j].addActionListener(this);
			}
		}
		for (int i = 0; i < gf.getGp().getPokpa().getBoxes().length; i++) {
			for (int j = 0; j < gf.getGp().getPokpa().getBoxes()[i].length; j++) {
				gf.getGp().getPokpa().getBoxes()[i][j].addActionListener(this);
			}
		}
		gf.getGp().getDelete_button().addActionListener(this);
	}

	public void initCommands() {
		mf.getMp().getRegistered_button().setActionCommand("REGISTERED");
		mf.getMp().getNew_pokemon_button().setActionCommand("POKENEW");
		mf.getMp().getDelete_button().setActionCommand("DELETE");
		rf.getBack().setActionCommand("BACK");
		gf.getBack().setActionCommand("BACK");
		cf.getBack().setActionCommand("BACK");
		cf.getCp().getBtnAtrapado().setActionCommand("CATCHED");
		rf.getRp().getTrain_butt().setActionCommand("TRAIN");
		rf.getRp().getDetails_butt().setActionCommand("DETAILS");
		int n = 0;
		for (int i = 0; i < rf.getRp().getPokpa().getBoxes().length; i++) {
			for (int j = 0; j < rf.getRp().getPokpa().getBoxes()[i].length; j++) {
				try {
					rf.getRp().getPokpa().getBoxes()[i][j].setActionCommand(pokenames.get(n).toUpperCase());						
					n++;
				} catch (Exception e2) {
					rf.getRp().getPokpa().getBoxes()[i][j].setActionCommand(" ");
				}
			}
		}
		n = 0;
		for (int i = 0; i < gf.getGp().getPokpa().getBoxes().length; i++) {
			for (int j = 0; j < gf.getGp().getPokpa().getBoxes()[i].length; j++) {
				try {						
					gf.getGp().getPokpa().getBoxes()[i][j].setActionCommand(pokenames.get(n).toUpperCase());
					n++;
				} catch (Exception e2) {
					gf.getGp().getPokpa().getBoxes()[i][j].setActionCommand(" ");
				}
			}
		}
		gf.getGp().getDelete_button().setActionCommand("DELETE_POK");
	}

	public void getNamesPokemons() {
		pokenames = new ArrayList<>();
		for (PokemonDTO pok : pokeDAO.getPokemons()) {
			if (pok instanceof PokemonGenVDTO) {				
				pokenames.add(pok.getName());
			} else {
				PokemonAnotherGenDTO auxpok = (PokemonAnotherGenDTO) pok;
				pokenames.add(auxpok.getName()+"-"+auxpok.getUrl_pokeball());
			}
		}
	}

	public void savePokemons() {
		for (String pokGenV : ruf.getPokemons()) {
			String[] aux = pokGenV.split(";");
			pokeDAO.createPokemonGenV(aux[0], Integer.parseInt(aux[1]), aux[2], aux[3], aux[4], aux[5].split("_"));
		}
		for (String pokAnotherGen : ruf.getPokemons_anothergen()) {
			String[] aux = pokAnotherGen.split(";");
			pokeDAO.createPokemonAnotherGen(aux[0], Integer.parseInt(aux[1]), aux[2], aux[3], aux[4], aux[5].split("_"),
					aux[6], aux[7], aux[8]);
		}
	}

	public void listenersAndComandsTrainFrame() {
		tf.getBack().addActionListener(this);
		tf.getBack().setActionCommand("BACK_TRAIN");
	}

	public void repaintAll() {
		getNamesPokemons();
		rf = new RegisteredFrame(pokenames);
		rf.getBack().addActionListener(this);
		rf.getRp().getTrain_butt().addActionListener(this);
		rf.getRp().getDetails_butt().addActionListener(this);
		for (int i = 0; i < rf.getRp().getPokpa().getBoxes().length; i++) {
			for (int j = 0; j < rf.getRp().getPokpa().getBoxes()[i].length; j++) {
				rf.getRp().getPokpa().getBoxes()[i][j].addActionListener(this);
			}
		}
		rf.getBack().setActionCommand("BACK");
		rf.getRp().getTrain_butt().setActionCommand("TRAIN");
		rf.getRp().getDetails_butt().setActionCommand("DETAILS");
		int n = 0;
		for (int i = 0; i < rf.getRp().getPokpa().getBoxes().length; i++) {
			for (int j = 0; j < rf.getRp().getPokpa().getBoxes()[i].length; j++) {
				try {
					rf.getRp().getPokpa().getBoxes()[i][j].setActionCommand(pokenames.get(n).toUpperCase());						
					n++;
				} catch (Exception e2) {
					rf.getRp().getPokpa().getBoxes()[i][j].setActionCommand(" ");
				}
			}
		}
		
		gf = new GraveyardFrame(pokenames);
		gf.getBack().addActionListener(this);
		for (int i = 0; i < gf.getGp().getPokpa().getBoxes().length; i++) {
			for (int j = 0; j < gf.getGp().getPokpa().getBoxes()[i].length; j++) {
				gf.getGp().getPokpa().getBoxes()[i][j].addActionListener(this);
			}
		}
		gf.getGp().getDelete_button().addActionListener(this);
		gf.getBack().setActionCommand("BACK");
		n = 0;
		for (int i = 0; i < gf.getGp().getPokpa().getBoxes().length; i++) {
			for (int j = 0; j < gf.getGp().getPokpa().getBoxes()[i].length; j++) {
				try {						
					gf.getGp().getPokpa().getBoxes()[i][j].setActionCommand(pokenames.get(n).toUpperCase());
					n++;
				} catch (Exception e2) {
					gf.getGp().getPokpa().getBoxes()[i][j].setActionCommand(" ");
				}
			}
		}
		gf.getGp().getDelete_button().setActionCommand("DELETE_POK");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("REGISTERED")) {
			mf.setVisible(false);
			rf.setVisible(true);
		} else if (e.getActionCommand().equals("POKENEW")) {
			mf.setVisible(false);
			cf.setVisible(true);
		} else if (e.getActionCommand().equals("DELETE")) {
			mf.setVisible(false);
			gf.setVisible(true);
		}
		if (e.getActionCommand().equals("TRAIN")) {
			tf = new TrainFrame();
			listenersAndComandsTrainFrame();
			rf.setVisible(false);
			String aux = rf.getRp().getName_pok();
			ArrayList<String> c1 = new ArrayList<>();
			ArrayList<String> c2 = new ArrayList<>();
			ArrayList<String> c3 = new ArrayList<>();
			ArrayList<String> c4 = new ArrayList<>();
			String name = aux;
			if (aux.contains("-")) {
				aux = aux.split("-")[0];
			}
			for (PokemonDTO pok : pokeDAO.getPokemons()) {
				if (pok.getName().equals(aux)) {
					c1.add(pok.getHabilities()[0]);
					if (pok.getHabilities().length == 2) {
						c2.add(pok.getHabilities()[1]);
					} else {
						c2.add(" ");
					}
					if (pok.getHabilities().length == 3) {
						c3.add(pok.getHabilities()[2]);
					} else {
						c3.add(" ");
					}
					if (pok.getHabilities().length == 4) {
						c4.add(pok.getHabilities()[3]);
					} else {
						c4.add(" ");
					}
					if (pok.getTypes().contains("-")) {
						for (String type : pok.getTypes().split("-")) {
							for (int i = 0; i < ruf.getTypes().length; i++) {
								if (type.toLowerCase().equals(ruf.getTypes()[i])) {
									for (ArrayList<String> arr_ability : ruf.getHabilities()[i]) {
										for (String ability : arr_ability) {
											c1.add(ability);
											c2.add(ability);
											c3.add(ability);
											c4.add(ability);
										}
									}
								}
							}
						}
					} else {
						for (int i = 0; i < ruf.getTypes().length; i++) {
							if (pok.getTypes().toLowerCase().equals(ruf.getTypes()[i])) {
								for (ArrayList<String> arr_ability : ruf.getHabilities()[i]) {
									for (String ability : arr_ability) {
										c1.add(ability);
										c2.add(ability);
										c3.add(ability);
										c4.add(ability);
									}
								}
							}
						}
					}
					tf.initPanel(name, pok.getId(), c1, c2, c3, c4);
					tf.getTp().getHab1().setSelectedItem(pok.getHabilities()[0]);
					if (pok.getHabilities().length > 1) {
						tf.getTp().getHab2().setSelectedItem(pok.getHabilities()[1]);
						tf.getTp().getHab3().setSelectedItem(pok.getHabilities()[2]);
						tf.getTp().getHab4().setSelectedItem(pok.getHabilities()[3]);
					} else {
						tf.getTp().getHab2().setSelectedItem(" ");
						tf.getTp().getHab3().setSelectedItem(" ");
						tf.getTp().getHab4().setSelectedItem(" ");
					}
					tf.getTp().getTrain_Butt().addActionListener(this);
					tf.getTp().getTrain_Butt().setActionCommand("TRAIN_POK");
				}
				tf.setVisible(true);
			}
		}

		if (e.getActionCommand().equals("TRAIN_POK")) {
			String[] new_abilities = { tf.getTp().getHab1().getSelectedItem().toString(),
					tf.getTp().getHab2().getSelectedItem().toString(),
					tf.getTp().getHab3().getSelectedItem().toString(),
					tf.getTp().getHab4().getSelectedItem().toString() };
			String aux = rf.getRp().getName_pok();
			if (aux.contains("-")) {
				aux = aux.split("-")[0];
			}
			for (PokemonDTO pok : pokeDAO.getPokemons()) {
				if (aux.equals(pok.getName())) {					
					pokeDAO.trainPokemon(pok.getName(), new_abilities);
					ruf.updatePokemons(pok);
					break;
				}
			}
			ruf.updateFile();
			tf.setVisible(false);
			rf.setVisible(true);
		}

		if (e.getActionCommand().equals("DETAILS")) {
			String aux = rf.getRp().getName_pok();
			for (PokemonDTO pok : pokeDAO.getPokemons()) {
				if (aux.contains("-")) {
					if (pok.getName().equals(aux.split("-")[0])) {
						card = new PokeCard(aux, pok.getId(), pok.getTypes().split("-").length, pok.getHeight(),
								pok.getWeight(), pok.getGender(), pok.getHabilities()[0], pok.getTypes());
						card.getGeneration_Butt().addActionListener(this);
						card.getGeneration_Butt().setActionCommand("GENERATION");
					}
				} else {	
					if (pok.getName().equals(aux)) {
						card = new PokeCard(pok.getName(), pok.getId(), pok.getTypes().split("-").length, pok.getHeight(),
								pok.getWeight(), pok.getGender(), pok.getHabilities()[0], pok.getTypes());
						card.getGeneration_Butt().addActionListener(this);
						card.getGeneration_Butt().setActionCommand("GENERATION");
					}
				}
			}
			card.setVisible(true);
		}
		
		if(e.getActionCommand().equals("GENERATION")) {
			String aux = rf.getRp().getName_pok();
			for (PokemonDTO pok : pokeDAO.getPokemons()) {
				if (aux.contains("-") && pok.getName().equals(aux.split("-")[0])) {
					PokemonAnotherGenDTO auxpok = (PokemonAnotherGenDTO) pok;
					JOptionPane.showMessageDialog(null, "Este pokemon es de "+auxpok.getGeneration(), "Profesor Oak:",
							JOptionPane.INFORMATION_MESSAGE);
				} else if(pok.getName().equals(aux)){	
					JOptionPane.showMessageDialog(null, "Este pokemon es de Generacion V", "Profesor Oak:",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

		if (e.getActionCommand().equals("BACK")) {
			mf.setVisible(true);
			rf.setVisible(false);
			cf.setVisible(false);
			gf.setVisible(false);
		}

		if (e.getActionCommand().equals("BACK_TRAIN")) {
			rf.setVisible(true);
			tf.setVisible(false);
		}

		for (String name : pokenames) {
			if (e.getActionCommand().equals(name.toUpperCase())) {
				if (name.contains("-")) {					
					rf.getRp().setVisibleAnotherPok(name);
					gf.getGp().setVisibleAnotherPok(name);
				} else {									
					rf.getRp().setVisibleAnotherPok(name);
					gf.getGp().setVisibleAnotherPok(name);
				}
			}
		}

		if (e.getActionCommand().equals("DELETE_POK")) {
			String aux = gf.getGp().getNamepok();
			for (PokemonDTO pok : pokeDAO.getPokemons()) {
				if (pok.getName().equals(aux)) {
					if (pok instanceof PokemonGenVDTO) {
						JOptionPane.showMessageDialog(null, "No se puede eliminar un pokemon de la quinta generacion!", "Error!",
								JOptionPane.ERROR_MESSAGE);
					} else if (pok instanceof PokemonAnotherGenDTO) {
						pokeDAO.deletePokemon(pok);
						ruf.deletePokemons(pok.getName());
						gf.getGp().pokeDie();
						gf.setVisible(false);
						JOptionPane.showMessageDialog(null, "Eliminando......", "Nooooooooo!",
								JOptionPane.INFORMATION_MESSAGE);
						ruf.updateFile();
						repaintAll();
						gf.setVisible(true);
						break;
					}
				}
			}
		}
		
		if(e.getActionCommand().equals("CATCHED")){
			String nomcatch = cf.getCp().getTxtName().getText();
			int idcatch = 0;
			try {
				idcatch = Integer.parseInt(cf.getCp().getTxtIndex().getText());			
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "El Id debe ser un valor numerico!", "Error!",
					JOptionPane.ERROR_MESSAGE);
			}
			String weightcatch = cf.getCp().getTxtWeight().getText();
			String heightcatch = cf.getCp().getTxtHeight().getText();
			
			String typescatch = typesOfPokemon();
			
			String[] abilitiescatch = {cf.getCp().getTxtHability().getText()," ", " ", " "};
			String gendercatch = cf.getCp().getTxtSex().getText();
			String generationcatch = cf.getCp().getGeneration().getSelectedItem().toString();
			
			
			String pokeballcatch = pokeballSelected();
			
			if(typesOfPokemon().equals("ERROR")) {
				JOptionPane.showMessageDialog(null, "Recuerda que los Pokemon tienen minimo 1 tipo y maximo 2", "Profesor Oak:",
						JOptionPane.OK_OPTION);
			}else {
				if (ruf.addPokemons(pokeDAO.createPokemonAnotherGen(nomcatch, idcatch, weightcatch, heightcatch, typescatch, abilitiescatch, gendercatch, generationcatch, pokeballcatch))) {
					JOptionPane.showMessageDialog(null, "Pokemon Atrapado!", "Siuuu!",
							JOptionPane.OK_OPTION);
				}
				ruf.updateFile();
				repaintAll();
			}
			cf.getCp().getTxtName().setText("");
			cf.getCp().getTxtHability().setText("");
			cf.getCp().getTxtHeight().setText("");
			cf.getCp().getTxtIndex().setText("");
			cf.getCp().getTxtSex().setText("");
			cf.getCp().getTxtWeight().setText("");
			cf.getCp().getChcBug().setSelected(false);
			cf.getCp().getChcDark().setSelected(false);
			cf.getCp().getChcDragon().setSelected(false);
			cf.getCp().getChcElectric().setSelected(false);
			cf.getCp().getChcFairy().setSelected(false);
			cf.getCp().getChcFighting().setSelected(false);
			cf.getCp().getChcFire().setSelected(false);
			cf.getCp().getChcFlying().setSelected(false);
			cf.getCp().getChcGhost().setSelected(false);
			cf.getCp().getChcGrass().setSelected(false);
			cf.getCp().getChcGround().setSelected(false);
			cf.getCp().getChcIce().setSelected(false);
			cf.getCp().getChcMasterball().setSelected(false);
			cf.getCp().getChcNormal().setSelected(false);
			cf.getCp().getChcPoison().setSelected(false);
			cf.getCp().getChcPokeball().setSelected(false);
			cf.getCp().getChcPsychic().setSelected(false);
			cf.getCp().getChcRock().setSelected(false);
			cf.getCp().getChcSteel().setSelected(false);
			cf.getCp().getChcSuperball().setSelected(false);
			cf.getCp().getChcWater().setSelected(false);
		}
	}
	
	public String typesOfPokemon(){
		StringBuilder sb = new StringBuilder();
		int controlVar = 0;
		if(cf.getCp().getChcBug().isSelected()){
			sb.append("Bicho-");
			controlVar++;
		}
		if(cf.getCp().getChcDark().isSelected()){
			sb.append("Siniestro-");
			controlVar++;
		}
		if(cf.getCp().getChcDragon().isSelected()){
			sb.append("Dragon-");
			controlVar++;
		}
		if(cf.getCp().getChcElectric().isSelected()){
			sb.append("Electrico-");
			controlVar++;
		}
		if(cf.getCp().getChcFairy().isSelected()){
			sb.append("Hada-");
			controlVar++;
		}
		if(cf.getCp().getChcFighting().isSelected()){
			sb.append("Lucha-");
			controlVar++;
		}
		if(cf.getCp().getChcFire().isSelected()){
			sb.append("Fuego-");
			controlVar++;
		}
		if(cf.getCp().getChcFlying().isSelected()){
			sb.append("Volador-");
			controlVar++;
		}
		if(cf.getCp().getChcGhost().isSelected()){
			sb.append("Fantasma-");
			controlVar++;
		}
		if(cf.getCp().getChcGrass().isSelected()){
			sb.append("Planta-");
			controlVar++;
		}
		if(cf.getCp().getChcGround().isSelected()){
			sb.append("Tierra-");
			controlVar++;
		}
		if(cf.getCp().getChcIce().isSelected()){
			sb.append("Hielo-");
			controlVar++;
		}
		if(cf.getCp().getChcNormal().isSelected()){
			sb.append("Normal-");
			controlVar++;
		}
		if(cf.getCp().getChcPoison().isSelected()){
			sb.append("Veneno-");
			controlVar++;
		}
		if(cf.getCp().getChcPsychic().isSelected()){
			sb.append("Psiquico-");
			controlVar++;
		}
		if(cf.getCp().getChcRock().isSelected()){
			sb.append("Roca-");
			controlVar++;
		}
		if(cf.getCp().getChcSteel().isSelected()){
			sb.append("Acero-");
			controlVar++;
		}
		if(cf.getCp().getChcWater().isSelected()){
			sb.append("Agua-");
			controlVar++;
		}
		if(controlVar>2 || controlVar==0) {
			return "ERROR";
		}
		
		sb.delete(sb.length()-1, sb.length());
		return sb.toString();
	}
	
	public String pokeballSelected(){
		if(cf.getCp().getChcMasterball().isSelected()){
			return "masterball";
		}
		if(cf.getCp().getChcSuperball().isSelected()){
			return "superball";
		}
		return "pokeball";
	}
}