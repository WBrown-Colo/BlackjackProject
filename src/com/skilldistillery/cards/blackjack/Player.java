package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
	
	//One field, and one field only
	protected BlackjackHand hand;
	//NO List<Cards> !!!!
	
	public Player() {
		hand = new BlackjackHand();
	}
	
	public void addCardToHand(Card card) {
		hand.addCard(card);
		
	}
	
	public int getHandValue() {
		return hand.getHandValue();
	}
	
	public void displayHand() {
		hand.displayHand();
	}
	
	//NO getHand()  !!!
}
