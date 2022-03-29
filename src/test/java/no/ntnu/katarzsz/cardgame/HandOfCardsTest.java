package no.ntnu.katarzsz.cardgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HandOfCardsTest {
    @Test
    public void checkthisfuckingthing() throws Exception {
        DeckOfCards deckOfCards = DeckOfCards.getInstance();
        deckOfCards.dealHand(5);

        deckOfCards.getHandOfCards().getHearts();

    }
}
