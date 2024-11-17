package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;
import com.skilldistillery.cards.common.Card;

public class BlackjackHand extends AbstractHand{

	//NO FIELDS!!!
	
	@Override
	public int getHandValue() {
		int totalValue = 0;
		for (int i = 0; i < cardsInHand.size(); i++) {
			Card c = cardsInHand.get(i);
			totalValue += c.getValue();
		}
		return totalValue;
	}
	
	public void displayHand (boolean showCard) {
		if (showCard) {
			super.displayHand();
		}
		else {
			System.out.println(cardsInHand.get(0));
		}
	}

}
