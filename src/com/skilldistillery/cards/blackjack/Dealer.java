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
	
	public void shuffle() {
		return;
	}
	
	@Override
	public void addCardToHand(Card card) {
		super.addCardToHand(card);
	}
	
	public void displayHand() {
		super.displayHand();
		System.out.println();
	}
	
	public void displayHand(boolean showCard) {
		hand.displayHand(showCard);
		System.out.println();
	}
	
	@Override
	public int getHandValue() {
		return super.getHandValue();
	}
}
