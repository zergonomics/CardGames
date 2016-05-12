package cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Deck {
	// is deck of cards
	// has no error checking
	private LinkedList<String> cards;
	
	public Deck() {
		cards = new LinkedList<String>();
	}
	public Deck(List<String> data) {
		cards = new LinkedList<String> (data);
	}
	public void addIndividualCards(String... newCards) {
		for(int i = 0; i < newCards.length; i++) {
			cards.add(newCards[i]);
		}
	}
	public void addListOfCards(List<String> newCards) {
		cards.addAll(newCards);
	}
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public String draw() {
		return this.drawMultiple(1).get(0);
	}
	public List<String> drawMultiple(int numCards) {
		List<String> drawn = new ArrayList<String>();
		for(int i = 0; i < numCards; i++) {
			drawn.add(cards.removeFirst());
		}
		return drawn;
	}
	public int getSize() {
		return cards.size();
	}
	
}
