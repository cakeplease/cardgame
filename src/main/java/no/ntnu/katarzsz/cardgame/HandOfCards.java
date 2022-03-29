package no.ntnu.katarzsz.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HandOfCards {

    private ArrayList<PlayingCard> handOfCards;

    public HandOfCards(ArrayList<PlayingCard> handOfCards) throws Exception {
        if (!handOfCards.isEmpty()) {
            this.handOfCards = handOfCards;
        } else {
            throw new Exception("Empty hand of cards");
        }
    }

    public ArrayList<PlayingCard> getHandOfCards() {
        return this.handOfCards;
    }

    public int getSumOfFaces() {
        int sum = 0;
        for(PlayingCard card : this.handOfCards) {
            sum += card.getFace();
        }
        return sum;
    }

    public List<PlayingCard> getHearts() throws Exception {
        if (!handOfCards.isEmpty()) {
            return this.handOfCards.stream().filter(c -> String.valueOf(c.getSuit()).equals("H")).collect(Collectors.toList());
        } else {
            throw new Exception("Empty hand of cards");
        }
    }

    /*public boolean checkForQueenOfSpades() throws Exception {
        if (!handOfCards.isEmpty()) {
            List queenOfSpades = this.handOfCards.stream().filter(c -> String.valueOf(c.getSuit()).equals("H")).collect(Collectors.toList());
        }
    }*/

    @Override
    public String toString() {
        return "HandOfCards{" +
                "handOfCards=" + handOfCards +
                '}';
    }
}
