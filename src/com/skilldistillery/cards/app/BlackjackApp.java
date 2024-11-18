package com.skilldistillery.cards.app;

import java.util.Scanner;

import com.skilldistillery.cards.blackjack.Dealer;
import com.skilldistillery.cards.blackjack.Player;

public class BlackjackApp {
	
	private Dealer dealer;
	private Player player;
	private Scanner kb;
	
	private BlackjackApp() {
		dealer = new Dealer();
		player = new Player();
		kb = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		BlackjackApp app = new BlackjackApp();
		app.playGame();
	}
	
	public void playGame() {
		//INTRO
		System.out.println("Let's play BLACKJACK!");
		System.out.println();
		//DEALER SHUFFLING
		System.out.println("The dealer is shuffling the cards.");
		dealer.shuffle();
		//PLAYER 1ST CARD
		player.addCardToHand(dealer.dealCard());
		System.out.println("Your first card is a: ");
		player.displayHand();
		System.out.println();
		//DEALER HIDDEN CARD
		System.out.println("The dealer's first card is hidden.");
		dealer.addCardToHand(dealer.dealCard());
		System.out.println();
		//PLAYER 2ND CARD
		player.addCardToHand(dealer.dealCard());
		System.out.println("Your two cards are the: ");
		player.displayHand();
		System.out.println();
		//DEALER HAND
		System.out.println("The dealer's cards are the: ");
		dealer.addCardToHand(dealer.dealCard());
		dealer.displayHand();
		//PLAYER HAND VALUE
		System.out.println("Your hand value is " + player.getHandValue());
		System.out.println();
		
		if (player.getHandValue() == 21) {
			System.out.println("YOU HIT BLACKJACK!!!");
		}
		if (dealer.getHandValue() == 21) {
			System.out.println("SORRY, THE DEALER HIT BLACKJACK.");
		}
		else {
			hitOrStand();
		}
		
	}
	
	public boolean hitOrStand() {
		System.out.println(" ================== ");
		System.out.println("| Select your move |");
		System.out.println("|      * * * *     |");
		System.out.println("| 1. Hit           |");
		System.out.println("| 2. Stand         |");
		System.out.println("| 3. Quit          |");
		System.out.println(" ================== ");
		
		int choice = 0;
		boolean userHits = false;
		while (true) {
			try {
				choice = kb.nextInt();
				if (choice == 1) {
					player.addCardToHand(dealer.dealCard());
					player.displayHand();
					System.out.println("Your hand is " + player.getHandValue());
					userHits = true;
					validateWin();


				} else if (choice == 2) {
					userHits = false;
					dealerHitStand();
					validateWin();

					break;

				} else if (choice == 3) {
					userHits = false;
					break;
				} else {
					throw new IllegalArgumentException();
				}

			} catch (IllegalArgumentException e) {
				System.err.println("Enter 1, 2, or 3.");
			}
		}
		return userHits;

	}
	
	public void dealerHitStand() {
		if (dealer.getHandValue() >= 17) {
			System.out.println("The dealer decided not to hit.");
			dealer.displayHand(true);
		}
		else {
			while (dealer.getHandValue() < 17 && dealer.getHandValue() < player.getHandValue()) {
				System.out.println("The card drawn by the dealer is: ");
				dealer.addCardToHand(dealer.dealCard());

				dealer.displayHand();
				System.out.println("Dealer's hand is  " + dealer.getHandValue());

			}
		}
		validateWin();
	}	
	
	public void validateWin() {
		if (player.getHandValue() == 21) {
			System.out.println("YOU HIT BLACKJACK!!!");
			System.out.println("Your hand is " + player.getHandValue());

		}
		
		if (dealer.getHandValue() == 21) {
			System.out.println("SORRY, THE DEALER HIT BLACKJACK!");
			System.out.println("Dealer's hand is  " + dealer.getHandValue());
		}

		if (player.getHandValue() > 21) {
			System.out.println("Sorry, you busted. The dealer wins.");

		} else if (dealer.getHandValue() > 21) {
			System.out.println("The dealer busted. YOU WIN!!!");
		} else if (dealer.getHandValue() > player.getHandValue()) {
			System.out.println("Sorry, the Dealer wins.");
		} else if (dealer.getHandValue() < player.getHandValue()) {
			System.out.println("YOU WIN!!!");
		} else {
			System.out.println("Tie game.");
		}
	}
	
	//TODO: Create a printMenu(), move menu
	//TODO: Why wont cards shuffle?

}
