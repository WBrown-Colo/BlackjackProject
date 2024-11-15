package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> cardsInDeck;

	public Deck() {
		cardsInDeck = new ArrayList<>(52);
		for(Suit s : Suit.values()) {
			for(Rank r : Rank.values()) {
				cardsInDeck.add(new Card(r, s));
			}
	
		}
		
	}
	
	public int checkDeckSize() {
		return cardsInDeck.size();
	}
	
	public Card dealCard() {
		return cardsInDeck.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(cardsInDeck);
	}
	
}	
