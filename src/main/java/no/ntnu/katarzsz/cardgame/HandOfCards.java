package no.ntnu.katarzsz.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HandOfCards {

    private ArrayList<PlayingCard> handOfCards;

    public HandOfCards(ArrayList<PlayingCard> handOfCards) throws Exception {
        if (!handOfCards.isEmpty() && handOfCards.size() >= 5) {
            this.handOfCards = handOfCards;
        } else {
            throw new Exception("Empty hand of cards or too few cards. A hand of cards must consist of minimum 5 cards.");
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
            return this.handOfCards.stream().filter(c -> c.getSuit()=='H').collect(Collectors.toList());
        } else {
            throw new Exception("Empty hand of cards");
        }
    }

    public boolean checkForQueenOfSpades() throws Exception {
        if (!handOfCards.isEmpty()) {
            List queenOfSpades = this.handOfCards.stream().filter(c -> c.getSuit()=='S' && c.getFace()==12).collect(Collectors.toList());
            if (!queenOfSpades.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new Exception("Empty hand of cards");

        }
    }

    public boolean isFlush() throws Exception {
        if (!handOfCards.isEmpty()) {
            List flushSpades = this.handOfCards.stream().filter(c -> c.getSuit()=='S').collect(Collectors.toList());
            List flushHearts = this.handOfCards.stream().filter(c -> c.getSuit()=='H').collect(Collectors.toList());
            List flushDiamonds = this.handOfCards.stream().filter(c -> c.getSuit()=='D').collect(Collectors.toList());
            List flushClubs = this.handOfCards.stream().filter(c -> c.getSuit()=='C').collect(Collectors.toList());

            if (flushSpades.size() == 5 || flushHearts.size() == 5 || flushDiamonds.size() == 5 || flushClubs.size() == 5) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new Exception("Empty hand of cards");
        }
    }

    @Override
    public String toString() {
        return "HandOfCards{" +
                "handOfCards=" + handOfCards +
                '}';
    }
}
