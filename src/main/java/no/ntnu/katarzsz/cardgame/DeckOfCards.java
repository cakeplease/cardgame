package no.ntnu.katarzsz.cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * Represents a full deck of cards which consists of 52 cards.
 */
public class DeckOfCards {
    private final char[] suit = { 'S', 'H', 'D', 'C' };
    private ArrayList<PlayingCard> cardDeck = new ArrayList<PlayingCard>(51);
    private HandOfCards handOfCards;

    private static DeckOfCards deckOfCards = new DeckOfCards();

    public DeckOfCards() {
        PlayingCard playingCard;
        for (char suit : suit) {
            for (int i = 1; i <= 13; i++) {
                playingCard = new PlayingCard(suit, i);
                cardDeck.add(playingCard);
            }
        }
    }

    public void resetDeck() {
        this.cardDeck = new ArrayList<PlayingCard>(51);
        PlayingCard playingCard;
        for (char suit : suit) {
            for (int i = 1; i <= 13; i++) {
                playingCard = new PlayingCard(suit, i);
                this.cardDeck.add(playingCard);
            }
        }
    }

    public static DeckOfCards getInstance() {
        return deckOfCards;
    }

    public ArrayList<PlayingCard> getCardDeck() {
        return this.cardDeck;
    }

    public HandOfCards getHandOfCards() {
        return this.handOfCards;
    }

    public boolean isValidIndex(ArrayList<PlayingCard> deckOfCards, int index) {
        try {
            deckOfCards.get(index);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public ArrayList<PlayingCard> dealHand(int n) throws Exception {

        ArrayList<PlayingCard> handOfCards = new ArrayList<PlayingCard>(n);
        Random random = new Random();
        int randomNumber;

        while (handOfCards.size() < n) {
            randomNumber = random.nextInt(51);
            if (isValidIndex(cardDeck, randomNumber)) {
                handOfCards.add(this.cardDeck.get(randomNumber));
                this.cardDeck.remove(randomNumber);
            }
        }

        this.handOfCards = new HandOfCards(handOfCards);
        this.resetDeck();
        return handOfCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeckOfCards that = (DeckOfCards) o;
        return Arrays.equals(suit, that.suit) && Objects.equals(cardDeck, that.cardDeck) && Objects.equals(handOfCards, that.handOfCards);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(cardDeck, handOfCards);
        result = 31 * result + Arrays.hashCode(suit);
        return result;
    }

    @Override
    public String toString() {
        return "DeckOfCards{" +
                "suit=" + Arrays.toString(suit) +
                ", cardDeck=" + cardDeck +
                ", handOfCards=" + handOfCards +
                '}';
    }
}
