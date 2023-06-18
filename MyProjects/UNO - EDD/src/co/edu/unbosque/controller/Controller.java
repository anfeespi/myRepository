package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import co.edu.unbosque.model.CardsDTO;
import co.edu.unbosque.model.DeckDAO;
import co.edu.unbosque.model.PlayerDAO;
import co.edu.unbosque.view.BoardGameFrame;
import co.edu.unbosque.view.BotFrame;
import co.edu.unbosque.view.MainFrame;
import co.edu.unbosque.view.ShowCardsFrame;

//Cambiar todo lo que diga JOptionPane por un panel donde salga el bot y el mensaje del pane :p

public class Controller implements ActionListener{

	private MainFrame mf;
	private BoardGameFrame bf;
	private BotFrame botf;
	private DeckDAO deck;
	private PlayerDAO players;
	private ShowCardsFrame scf;
	private int index_sected_card = -1;
	private int turn;
	private int next_turn;
	private String color;
	private String type;
	private String[] str_colors = {"red", "blue", "yellow", "green"};
	private Boolean sayOne;

	public Controller() {
		mf =  new MainFrame();
		bf = new BoardGameFrame();
		deck = new DeckDAO();
		deck.shuffle();
		players = new PlayerDAO();
		turn = 0;
		next_turn = 1;
		color = "";
		type = "";
		sayOne = false;
		setActionCommands();
		addListeners();
		init();
	}

	public void init() {
		mf.setVisible(true);
		dealCards();
	}

	public void dealCards() {
		for (int i = 0; i < 7; i++) {
			players.getPlayers()[0].getHand().add(deck.getDeck().get(i));
			deck.getDeck().remove(i);
		}
		for (int i = 0; i < 7; i++) {
			players.getPlayers()[1].getHand().add(deck.getDeck().get(i));
			deck.getDeck().remove(i);
		}
		for (int i = 0; i < 7; i++) {
			players.getPlayers()[2].getHand().add(deck.getDeck().get(i));
			deck.getDeck().remove(i);
		}
		for (int i = 0; i <deck.getDeck().getCards().length; i++) {
			if(!(deck.getDeck().get(i).getType().equals("+2") || deck.getDeck().get(i).getType().equals("+4") ||
					deck.getDeck().get(i).getType().equals("wildcard") || 
					deck.getDeck().get(i).getType().equals("block") || 
					deck.getDeck().get(i).getType().equals("switch"))) {
				deck.getDiscard().push(deck.getDeck().get(i));
				deck.getDeck().remove(i);
				break;
			}
		}
	}
	public void activateButtons() {
		for (int i = 0; i < players.getPlayers()[0].getHand().getCards().length; i++) {
			bf.getBp().getPlayer_cardbtn()[i].setActionCommand("CARD"+i);
			bf.getBp().getPlayer_cardbtn()[i].addActionListener(this);
		}
	}

	public void showPlayerCards() {
		String[] namecards = new String[players.getPlayers()[0].getHand().getCards().length];
		for (int i = 0; i < namecards.length; i++) {
			namecards[i] = players.getPlayers()[0].getHand().getCards()[i].getType()+"_"+players.getPlayers()[0].getHand().getCards()[i].getColor();
		}

		bf.getBp().changePlayerCards(namecards);
	}
	
	public String[] showCards(CardsDTO[] c) {
		String[] namecards = new String[c.length];
		
		for (int i = 0; i < namecards.length; i++) {
			namecards[i] = c[i].getType()+"_"+c[i].getColor();
		}
		
		return namecards;
	}

	public void showFirstDiscard() {
		bf.getBp().changeDiscard(deck.getDiscard().peek());
		color = deck.getDiscard().peek().split("_")[1];
		type = deck.getDiscard().peek().split("_")[0];
	}

	public void setActionCommands() {
		mf.getMp().getPlaybtn().setActionCommand("PLAY");
		mf.getMp().getExitbtn().setActionCommand("EXIT");
		bf.getBp().getThrow_cardbtn().setActionCommand("THROWCARD");
		bf.getBp().getSay_onebtn().setActionCommand("SAYONE");
		bf.getBp().getPick_cardbtn().setActionCommand("PICKCARD");
		bf.getBp().getBot_cards_onebtn().setActionCommand("BOT1CARDS");
		bf.getBp().getBot_cards_twobtn().setActionCommand("BOT2CARDS");
		bf.getBp().getShow_cardbtn().setActionCommand("SHOWDISCARD");
		bf.getBp().getShow_steal_cards().setActionCommand("SHOWSTEAL");
	}

	public void addListeners() {
		mf.getMp().getPlaybtn().addActionListener(this);
		mf.getMp().getExitbtn().addActionListener(this);
		bf.getBp().getThrow_cardbtn().addActionListener(this);
		bf.getBp().getSay_onebtn().addActionListener(this);
		bf.getBp().getPick_cardbtn().addActionListener(this);
		bf.getBp().getBot_cards_onebtn().addActionListener(this);
		bf.getBp().getBot_cards_twobtn().addActionListener(this);
		bf.getBp().getShow_cardbtn().addActionListener(this);
		bf.getBp().getShow_steal_cards().addActionListener(this);
	}

	public void activateButtonsBot() {
		botf.getPanel_bot().getAccept().setActionCommand("ACCEPT");
		botf.getPanel_bot().getAccept().addActionListener(this);
	}

	public void play() {
		if(deck.getDiscard().size()<=10) {
			reShuflleDeck();
		}
		deck.getDiscard().push(players.getPlayers()[0].getHand().get(index_sected_card));
		players.playCard(0, index_sected_card);
		if(players.getPlayers()[0].getHand().getCards().length==1) {
			botf = new BotFrame("Recuerda decir UNO para notificar que te falta una carta");
			botf.setVisible(true);
			activateButtonsBot();
		}
		showPlayerCards();
		showFirstDiscard();
		activateButtons();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("PLAY")) {
			mf.setVisible(false);
			showPlayerCards();
			showFirstDiscard();
			bf.setVisible(true);
			activateButtons();
			botf = new BotFrame("Hola! Soy D.o.S, el robot que te ayudara a aprender a jugar UNO, empecemos!!!");
			botf.setVisible(true);
			activateButtonsBot();
		}
		if(e.getActionCommand().equals("ACCEPT")) {
			botf.setVisible(false);
		}
		if(e.getActionCommand().equals("EXIT")) {
			mf.setVisible(false);
			mf.dispose();
		}
		for (int i = 0; i < players.getPlayers()[0].getHand().getCards().length; i++) {
			if(e.getActionCommand().equals("CARD"+i)) {
				bf.getBp().changeSelectedCard(players.getPlayers()[0].getHand().get(i).toString());
				index_sected_card = i;
			}
		}
		if(e.getActionCommand().equals("THROWCARD")) {
			if (turn != 0) {
				bf.getBp().getThrow_cardbtn().setEnabled(false);
				playCPU(turn);
				calculateNextTurn();
				if (turn != 0) {					
					playCPU(turn);
					calculateNextTurn();
				}
				bf.getBp().getThrow_cardbtn().setEnabled(true);
			} else {

				if (color.equals(players.getPlayers()[0].getHand().get(index_sected_card).getColor()) || type.equals(players.getPlayers()[0].getHand().get(index_sected_card).getType()) || players.getPlayers()[0].getHand().get(index_sected_card).getColor().equals("multi")) {
					bf.getBp().getThrow_cardbtn().setEnabled(false);
					if (players.getPlayers()[0].getHand().get(index_sected_card).getType().equals("+2")) {
						play();
						calculateNextTurn();
						for (int i = 0; i < 2; i++) {
							players.stealCard((turn), deck.getDeck().get(0));
							deck.getDeck().remove(0);
						}
						playCPU(turn);
						calculateNextTurn();
						if (turn != 0) {						
							playCPU(turn);
							calculateNextTurn();
						}
					} else if (players.getPlayers()[0].getHand().get(index_sected_card).getType().equals("+4")) {
						play();
						calculateNextTurn();
						for (int i = 0; i < 4; i++) {
							players.stealCard((turn), deck.getDeck().get(0));
							deck.getDeck().remove(0);
						}
						color = (String) JOptionPane.showInputDialog(null, "Selecciona el color al que deseas cambiar:", "Elige!", JOptionPane.QUESTION_MESSAGE, null, str_colors, str_colors[0]);
						playCPU(turn);
						calculateNextTurn();
						if (turn != 0) {						
							playCPU(turn);
							calculateNextTurn();
						}
					} else if (players.getPlayers()[0].getHand().get(index_sected_card).getType().equals("wildcard")) {
						play();
						color = (String) JOptionPane.showInputDialog(null, "Selecciona el color al que deseas cambiar:", "Elige!", JOptionPane.QUESTION_MESSAGE, null, str_colors, str_colors[0]);
						calculateNextTurn();
						playCPU(turn);
						calculateNextTurn();
						if (turn != 0) {						
							playCPU(turn);
							calculateNextTurn();
						}
					} else if (players.getPlayers()[0].getHand().get(index_sected_card).getType().equals("block")) {
						play();
						calculateNextTurn();
						calculateNextTurn();
						playCPU(turn);
						calculateNextTurn();
					} else if (players.getPlayers()[0].getHand().get(index_sected_card).getType().equals("switch")) {
						play();
						next_turn = -next_turn;

						bf.getBp().changeDirection(next_turn);

						calculateNextTurn();
						playCPU(turn);
						calculateNextTurn();
						if (turn != 0) {						
							playCPU(turn);
							calculateNextTurn();
						}
					} else {
						play();
						calculateNextTurn();
						playCPU(turn);
						calculateNextTurn();
						if (turn != 0) {						
							playCPU(turn);
							calculateNextTurn();
						}
					}

					bf.getBp().getThrow_cardbtn().setEnabled(true);

					if(players.getPlayers()[0].getHand().getCards().length == 0 && sayOne) {
						botf = new BotFrame("Ganaste la partida, muy bien hecho!");
						botf.setVisible(true);
						activateButtonsBot();
						bf.getBp().getThrow_cardbtn().setEnabled(false);
						bf.getBp().getPick_cardbtn().setEnabled(false);
					}else if(players.getPlayers()[0].getHand().getCards().length == 0 && !sayOne) {
						botf = new BotFrame("Se te ha olvidado decir UNO!!, comes dos cartas");
						botf.setVisible(true);
						activateButtonsBot();
						for (int i = 0; i < 2; i++) {
							players.stealCard(0, deck.getDeck().get(0));
							deck.getDeck().remove(0);
						}
						showPlayerCards();
					}

					bf.getBp().changeSelectedCard("back_multi");

				} else {
					botf = new BotFrame("No puedes lanzar esta carta ya que no coincide ni con el color ni con el tipo actual!!");
					botf.setVisible(true);
					activateButtonsBot();
				}

			}
		}
		if(e.getActionCommand().equals("PICKCARD")) {
			if (deck.getDeck().get(0)!=null) {				
				players.stealCard(0, deck.getDeck().get(0));
				deck.getDeck().remove(0);
				showPlayerCards();
				showFirstDiscard();
				activateButtons();
			} else {
				botf = new BotFrame("No puedes robar mas cartas, ya no hay cartas en la cola!!");
				botf.setVisible(true);
				activateButtonsBot();
			}
		}
		if(e.getActionCommand().equals("SAYONE")) {
			if(players.getPlayers()[0].getHand().getCards().length != 1) {
				botf = new BotFrame("No debes decir UNO si no te queda una sola carta, como penintencia toma 2 cartas");
				botf.setVisible(true);
				activateButtonsBot();
				for (int i = 0; i < 2; i++) {
					players.stealCard(0, deck.getDeck().get(0));
					deck.getDeck().remove(0);
				}
				showPlayerCards();
			}else {
				sayOne = true;
			}
		}
		if(e.getActionCommand().equals("BOT1CARDS")) {
			scf = new ShowCardsFrame( showCards(players.getPlayers()[1].getHand().getCards()) , "El Bot 1 tiene las siguientes cartas:");
			scf.getPanel_show().getAccept().addActionListener(this);
			scf.getPanel_show().getAccept().setActionCommand("ACEPTAR");
		}
		if(e.getActionCommand().equals("BOT2CARDS")) {
			scf = new ShowCardsFrame( showCards(players.getPlayers()[2].getHand().getCards()) , "El Bot 2 tiene las siguientes cartas");
			scf.getPanel_show().getAccept().addActionListener(this);
			scf.getPanel_show().getAccept().setActionCommand("ACEPTAR");
		}
		if(e.getActionCommand().equals("SHOWDISCARD")) {
			scf = new ShowCardsFrame( deck.getDiscard().showAll() , "La pila de descarte tiene las siguientes cartas");
			scf.getPanel_show().getAccept().addActionListener(this);
			scf.getPanel_show().getAccept().setActionCommand("ACEPTAR");
		}
		if(e.getActionCommand().equals("SHOWSTEAL")) {
			scf = new ShowCardsFrame( showCards(deck.getDeck().getCards()) , "La pila de descarte tiene las siguientes cartas");
			scf.getPanel_show().getAccept().addActionListener(this);
			scf.getPanel_show().getAccept().setActionCommand("ACEPTAR");
		}
		if(e.getActionCommand().equals("ACEPTAR")) {
			scf.setVisible(false);
		}
		
	}

	public void playCPU(int pos) {
		if (pos == 0) return;
		if(players.getPlayers()[pos].getHand().getCards().length==1) {
			String bot = "";
			if(pos==1) {
				bot = "Juan";
			}else {
				bot = "Maria";
			}
			botf = new BotFrame("A "+bot+" le hace falta una carta y ha dicho UNO!");
			botf.setVisible(true);
			activateButtonsBot();
		}
		System.out.println("Player "+pos+" "+players.getPlayers()[pos].getHand().getCards().length);
		bf.getBp().changeCardsBot(pos, players.getPlayers()[pos].getHand().getCards().length);
		boolean found = false;
		for(int i=0; i<players.getPlayers()[pos].getHand().getCards().length; i++) {
			if(color.equals(players.getPlayers()[pos].getHand().get(i).getColor()) || type.equals(players.getPlayers()[pos].getHand().get(i).getType()) || players.getPlayers()[pos].getHand().get(i).getColor().equals("multi")) {

				if (players.getPlayers()[pos].getHand().get(i).getType().equals("+2")) {
					System.out.println("Bot "+(pos)+" jugó con: "+players.getPlayers()[pos].getHand().get(i));
					deck.getDiscard().push(players.getPlayers()[pos].getHand().get(i));
					players.playCard(pos, i);
					showFirstDiscard();
					
					if(turn+next_turn > 2 || turn+next_turn == 0 ) {
						botf = new BotFrame("Oh, no!, el jugador que jugo antes que tu te ha tirado un +2 te ha hecho comer 2 cartas");
						botf.setVisible(true);
						activateButtonsBot();
					}
					
					if(turn+next_turn > 2) {
						for (int j = 0; j < 2; j++) {
							players.stealCard((0), deck.getDeck().get(0));
							deck.getDeck().remove(0);
						}
					} else if(turn+next_turn == 0){
						for (int j = 0; j < 2; j++) {
							players.stealCard((2), deck.getDeck().get(0));
							deck.getDeck().remove(0);
						}
					} else {
						for (int j = 0; j < 2; j++) {
							players.stealCard((turn+next_turn), deck.getDeck().get(0));
							deck.getDeck().remove(0);
						}
					}
					showPlayerCards();
					activateButtons();
					found = true;
				} else if (players.getPlayers()[pos].getHand().get(i).getType().equals("+4")) {
					System.out.println("Bot "+(pos)+" jugó con: "+players.getPlayers()[pos].getHand().get(i));
					deck.getDiscard().push(players.getPlayers()[pos].getHand().get(i));
					players.playCard(pos, i);
					showFirstDiscard();
					if(turn+next_turn > 2 || turn+next_turn == 0 ) {
						botf = new BotFrame("Oh, no!, el jugador que jugo antes que tu te ha tirado un +4 te ha hecho comer 4 cartas");
						botf.setVisible(true);
						activateButtonsBot();
					}
					if(turn+next_turn > 2) {
						for (int j = 0; j < 4; j++) {
							players.stealCard((0), deck.getDeck().get(0));
							deck.getDeck().remove(0);
						}
					} else if(turn+next_turn == 0){
						for (int j = 0; j < 4; j++) {
							players.stealCard((2), deck.getDeck().get(0));
							deck.getDeck().remove(0);
						}
					} else {
						for (int j = 0; j < 4; j++) {
							players.stealCard((turn+next_turn), deck.getDeck().get(0));
							deck.getDeck().remove(0);
						}
					}
					found = true;
					showPlayerCards();
					activateButtons();
					color = str_colors[(int)(Math.random()*4)];
					if(turn+next_turn > 2 || turn+next_turn == 0) {
						botf = new BotFrame("Parece que el jugador que esta antes que tu ha cambiado el color, el nuevo color del juego es:  "+color);
						botf.setVisible(true);
						activateButtonsBot();
					}
				} else if (players.getPlayers()[pos].getHand().get(i).getType().equals("wildcard")) {
					System.out.println("Bot "+(pos)+" jugó con: "+players.getPlayers()[pos].getHand().get(i));
					deck.getDiscard().push(players.getPlayers()[pos].getHand().get(i));
					players.playCard(pos, i);
					showFirstDiscard();
					color = str_colors[(int)(Math.random()*4)];
					System.out.println(color);
					if(turn+next_turn > 2 || turn+next_turn ==0) {
						botf = new BotFrame("Parece que el jugador que esta antes que tu ha cambiado el color, el nuevo color del juego es:  "+color);
						botf.setVisible(true);
						activateButtonsBot();
					}
					found = true;
				} else if (players.getPlayers()[pos].getHand().get(i).getType().equals("block")) {
					System.out.println("Bot "+(pos)+" jugó con: "+players.getPlayers()[pos].getHand().get(i));
					deck.getDiscard().push(players.getPlayers()[pos].getHand().get(i));
					players.playCard(pos, i);
					showFirstDiscard();
					calculateNextTurn();
					if (turn == 0) {
						botf = new BotFrame("Te acaban de bloquear!!, Perdiste un turno :(");
						botf.setVisible(true);
						activateButtonsBot();
						calculateNextTurn();
						playCPU(turn);
						calculateNextTurn();
						playCPU(turn);
					}
					turn = 0;
					found = true;
				} else if (players.getPlayers()[pos].getHand().get(i).getType().equals("switch")) {
					System.out.println("Bot "+(pos)+" jugó con: "+players.getPlayers()[pos].getHand().get(i));
					deck.getDiscard().push(players.getPlayers()[pos].getHand().get(i));
					players.playCard(pos, i);
					next_turn = -next_turn;
					bf.getBp().changeDirection(next_turn);
					showFirstDiscard();
					if (turn+next_turn > 2 || turn+next_turn == 0) {
						botf = new BotFrame("Cambiaron el sentido antes de que pudieras jugar!! Dale al boton de lanzar carta para que el juego siga...");
						botf.setVisible(true);
						activateButtonsBot();
					}
					found = true;
				} else {					
					System.out.println("Bot "+(pos)+" jugó con: "+players.getPlayers()[pos].getHand().get(i));
					deck.getDiscard().push(players.getPlayers()[pos].getHand().get(i));
					players.playCard(pos, i);
					showFirstDiscard();
					found = true;
				}

				if(players.getPlayers()[pos].getHand().getCards().length == 0) {
					botf = new BotFrame("Ganó el bot número: "+(pos)+ ", no te rindas, la proxima partida sera mejor!");
					botf.setVisible(true);
					activateButtonsBot();
					bf.getBp().getThrow_cardbtn().setEnabled(false);
					bf.getBp().getPick_cardbtn().setEnabled(false);
				}
				break;
			}
		}
		if(!found) {
			//Si tiene de donde robar
			if(deck.getDeck().get(0) != null) {
				players.stealCard(pos, deck.getDeck().get(0));
				deck.getDeck().remove(0);
				System.out.println("Player "+pos+" "+players.getPlayers()[pos].getHand().getCards().length);
				playCPU(pos);
			}else {
				botf = new BotFrame("El bot no pudo robar mas cartas, ya no hay cartas en la cola!!");
				botf.setVisible(true);
				activateButtonsBot();
			}
		}

	}
	public void reShuflleDeck() {
		deck = new DeckDAO();
		deck.shuffle();
	}

	public void changeLabelTurn() {
		//Cambiar lable
		if (turn == 1) {						
			bf.getBp().changeTurn("Juan");
		} else if (turn == 2) {
			bf.getBp().changeTurn("Mia");						
		} else {
			bf.getBp().changeTurn("Jugador");									
		}
		//
	}

	public void calculateNextTurn() {
		if(turn+next_turn > 2) {
			turn = 0;
			changeLabelTurn();
			return;
		}else if(turn+next_turn < 0){
			turn = 2;
			changeLabelTurn();
			return;
		}
		turn+=next_turn;
		changeLabelTurn();
	}
}
