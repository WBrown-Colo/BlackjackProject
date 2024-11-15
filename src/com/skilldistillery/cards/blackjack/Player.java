package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {
	
	//One field, and one field only
	private BlackjackHand hand;
	//NO List<Cards> !!!!
	
	public Player() {
		hand = new BlackjackHand();
	}
	
	public void addCardToHand(Card card) {
		hand.addCard(card);
		
	}
	
	//NO getHand()  !!!
}
