package project1_g9;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getValue() {
        int value = 0;
        int aces = 0;

        for (Card card : cards) {
            value += card.getValue();
            if (card.getRank().equals("Ace")) {
                aces++;
            }
        }

        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }

        return value;
    }

    public boolean isBusted() {
        return getValue() > 21;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
