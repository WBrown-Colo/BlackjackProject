package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer extends Player {
	
	//FIELDS
	private Deck deck;
	
	public Dealer() {
		deck = new Deck();
	}

	//NO getDeck()  !!!
	public Card dealCard() {
		return deck.dealCard();
	}
}
