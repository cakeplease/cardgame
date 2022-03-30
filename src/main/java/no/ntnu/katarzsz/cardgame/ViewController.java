package no.ntnu.katarzsz.cardgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ViewController {

    public static ArrayList<PlayingCard> dealHand() throws Exception {
        DeckOfCards deck = DeckOfCards.getInstance();
        return deck.dealHand(10);
    }

    public static int checkSumOfFaces() throws Exception {
        DeckOfCards deck = DeckOfCards.getInstance();
        HandOfCards handOfCards = deck.getHandOfCards();
        Optional<HandOfCards> checkNull = Optional.ofNullable(handOfCards);

        if (checkNull.isPresent()) {
            return handOfCards.getSumOfFaces();
        } else {
            throw new Exception("No hand of cards found.");
        }
    }

   public static List<PlayingCard> checkHearts() throws Exception{
        DeckOfCards deck = DeckOfCards.getInstance();
        HandOfCards handOfCards = deck.getHandOfCards();

        return handOfCards.getHearts();
    }

    public static boolean checkForQueenOfSpades() throws Exception {
        DeckOfCards deck = DeckOfCards.getInstance();
        HandOfCards handOfCards = deck.getHandOfCards();
        return handOfCards.checkForQueenOfSpades();
    }

    public static boolean isFlush() throws Exception {
        DeckOfCards deck = DeckOfCards.getInstance();
        HandOfCards handOfCards = deck.getHandOfCards();
        return handOfCards.isFlush();
    }
}
