package project1_g9;

import java.util.Scanner;

public class Game {
    private final Deck deck;
    private final Hand playerHand;
    private final Hand dealerHand;

    public Game() {
        this.deck = new Deck();
        this.playerHand = new Hand();
        this.dealerHand = new Hand();
    }

    public void start() {
        // Initial deal
        playerHand.addCard(deck.draw());
        playerHand.addCard(deck.draw());
        dealerHand.addCard(deck.draw());
        dealerHand.addCard(deck.draw());

        System.out.println("Player's hand: " + playerHand + " (value: " + playerHand.getValue() + ")");
        System.out.println("Dealer's visible card: " + dealerHand + " (value: " + dealerHand.getValue() + ")");

        // Player's turn
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to (H)it or (S)tand? ");
            String action = scanner.nextLine().toUpperCase();

            if (action.equals("H")) {
                playerHand.addCard(deck.draw());
                System.out.println("Player's hand: " + playerHand + " (value: " + playerHand.getValue() + ")");
                if (playerHand.isBusted()) {
                    System.out.println("Player busted! Dealer wins.");
                    return;
                }
            } else if (action.equals("S")) {
                break;
            } else {
                System.out.println("Invalid action. Please choose (H)it or (S)tand.");
            }
        }

        // Dealer's turn
        System.out.println("Dealer's hand: " + dealerHand + " (value: " + dealerHand.getValue() + ")");
        while (dealerHand.getValue() < 17) {
            dealerHand.addCard(deck.draw());
            System.out.println("Dealer's hand: " + dealerHand + " (value: " + dealerHand.getValue() + ")");
        }

        if (dealerHand.isBusted()) {
            System.out.println("Dealer busted! Player wins.");
        } else {
            determineWinner();
        }
    }

    private void determineWinner() {
        int playerValue = playerHand.getValue();
        int dealerValue = dealerHand.getValue();

        System.out.println("Player's hand value: " + playerValue);
        System.out.println("Dealer's hand value: " + dealerValue);

        if (playerValue > dealerValue) {
            System.out.println("Player wins!");
        } else if (playerValue < dealerValue) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}
