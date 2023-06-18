package co.edu.unbosque.model;

public class List {
	private CardsDTO[] cards;
	private CardsDTO[] auxcards;

	public List() {
		this.cards = new CardsDTO[0];
		this.auxcards = new CardsDTO[0];
	}

	public void add(CardsDTO c) {
		if (this.cards.length != 0) {
			for (int i = 0; i < this.cards.length; i++) {
				this.auxcards[i] = this.cards[i];
			}
			this.cards = new CardsDTO[this.cards.length + 1];
			for (int i = 0; i < this.auxcards.length; i++) {
				this.cards[i] = this.auxcards[i];
			}
			this.cards[this.cards.length - 1] = c;
			this.auxcards = new CardsDTO[this.cards.length];
		} else {
			this.cards = new CardsDTO[1];
			this.auxcards = new CardsDTO[1];
			this.cards[this.cards.length - 1] = c;
		}
	}

	public void remove(int pos) {
		if(this.cards.length >= pos+1) {
			this.auxcards = new CardsDTO[this.cards.length-1];
			for(int i=0; i<pos; i++) {
				this.auxcards[i] = this.cards[i];
			}
			for(int i=pos+1; i<this.cards.length; i++) {
				this.auxcards[i-1] = this.cards[i];
			}
			this.cards = this.auxcards;
		}
	}

	public CardsDTO get(int i) {
		return cards[i];
	}

	public CardsDTO[] getCards() {
		return cards;
	}

	public void setCards(CardsDTO[] cards) {
		this.cards = cards;
	}

	public CardsDTO[] getAuxcards() {
		return auxcards;
	}

	public void setAuxcards(CardsDTO[] auxcards) {
		this.auxcards = auxcards;
	}

}
