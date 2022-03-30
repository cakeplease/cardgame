package no.ntnu.katarzsz.cardgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckOfCardsTest {
    /**
     * dealHand() method return n random cards from the deck. Therefore, the only thing we'll test is the size of the returned array
     * @throws Exception
     */
    @Test
    void dealHand() throws Exception {
        DeckOfCards deck = DeckOfCards.getInstance();
        assertEquals(deck.dealHand(5).size(), 5);
    }
}