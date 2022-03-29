package no.ntnu.katarzsz.cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Represents a full deck of cards which consists of 52 cards.
 */
public class DeckOfCards {
    private final char[] suit = { 'S', 'H', 'D', 'C' };
    private ArrayList<PlayingCard> cardDeck = new ArrayList<PlayingCard>(51);

    public DeckOfCards() {
        PlayingCard playingCard;
        for (char suit : suit) {
            for (int i = 1; i <= 13; i++) {
                playingCard = new PlayingCard(suit, i);
                cardDeck.add(playingCard);
            }
        }
    }
    public ArrayList<PlayingCard> getCardDeck() {
        return this.cardDeck;
    }

    public boolean isValidIndex(ArrayList<PlayingCard> deckOfCards, int index) {
        try {
            PlayingCard card = deckOfCards.get(index);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public ArrayList<PlayingCard> dealHand(int n) {
        ArrayList<PlayingCard> handOfCards = new ArrayList<PlayingCard>(n);
        Random random = new Random();
        int randomNumber;

        while (handOfCards.size() < n) {
            randomNumber = random.nextInt(51);
            if (isValidIndex(cardDeck, randomNumber)) {
                handOfCards.add(cardDeck.get(randomNumber));
                cardDeck.remove(randomNumber);
            }
        }

        return handOfCards;
    }

    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();
        ArrayList<PlayingCard> deck = deckOfCards.getCardDeck();

        System.out.println("Before dealing cards");
        for (PlayingCard card : deck) {
            System.out.println(card.getAsString());
        }

        System.out.println("Hand of cards:");
        ArrayList<PlayingCard> handOfCards = deckOfCards.dealHand(5);

        for (PlayingCard card : handOfCards) {
            System.out.println(card.getAsString());
        }

        System.out.println("Card deck after dealing hand of cards:");
        for (PlayingCard card : deck) {
            System.out.println(card.getAsString());
        }
    }
}
