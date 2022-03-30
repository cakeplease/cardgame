package no.ntnu.katarzsz.cardgame;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class HandOfCardsTest {

    ArrayList<PlayingCard> listOfCards;

    /**
     * Test data to avoid duplicate content and potential flaws.
     * -Sum of faces: 42
     * -5 heart cards
     * -Queen of Spades: yes
     * -Flush: yes (hearts)
     * @return HandOfCards a custom array of cards added manually instead of dealt randomly
     * @throws Exception when handOfCards is empty or there are too few cards, constructor throws custom Exception in HandOfCards class
     */
    public HandOfCards positiveTestData() throws Exception {
        listOfCards = new ArrayList<>();
        //flush + hearts
        listOfCards.add(new PlayingCard('H', 1));
        listOfCards.add(new PlayingCard('H', 2));
        listOfCards.add(new PlayingCard('H', 3));
        listOfCards.add(new PlayingCard('H', 4));
        listOfCards.add(new PlayingCard('H', 5));

        //queen of spades
        listOfCards.add(new PlayingCard('S', 12));

        //some other cards
        listOfCards.add(new PlayingCard('D', 7));
        listOfCards.add(new PlayingCard('C', 8));

        return new HandOfCards(listOfCards);

    }

    /**
     * Negative test data without Queen of Spades, hearts and flush
     * @return HandOfCards a custom array of cards added manually instead of dealt randomly
     * @throws Exception
     */
    public HandOfCards negativeTestData() throws Exception {
        listOfCards = new ArrayList<>();
        listOfCards.add(new PlayingCard('S', 1));
        listOfCards.add(new PlayingCard('S', 2));
        listOfCards.add(new PlayingCard('D', 3));
        listOfCards.add(new PlayingCard('S', 4));
        listOfCards.add(new PlayingCard('C', 5));
        return new HandOfCards(listOfCards);

    }

    /**
     * Check if the sum of faces is 42 in custom array of cards
     * @throws Exception
     */
    @Test
    public void checkForSumOfFaces() throws Exception {
        HandOfCards handOfCards = this.positiveTestData();
        int sum = handOfCards.getSumOfFaces();

        assertEquals(sum, 42);
    }

    /**
     * Check if there are indeed hearts in the array with hearts
     * @throws Exception
     */
    @Test
    public void checkForHeartsTrue() throws Exception {
        HandOfCards handOfCards = this.positiveTestData();
        assertFalse(handOfCards.getHearts().isEmpty());
    }

    /**
     * Check if there are no hearts in array with no hearts
     * @throws Exception
     */
    @Test
    public void checkForHeartsFalse() throws Exception {
        HandOfCards handOfCards = this.negativeTestData();
        assertTrue(handOfCards.getHearts().isEmpty());
    }

    /**
     * Check if there is a queen of spades in array with queen of spades
     * @throws Exception
     */
    @Test
    public void checkIfQueenOfSpadesIsTrue() throws Exception {
        HandOfCards handOfCards = this.positiveTestData();
        assertTrue(handOfCards.checkForQueenOfSpades());
    }

    /**
     * Check if there is no queen of spades in array with no queen of spades
     * @throws Exception
     */
    @Test
    public void checkIfQueenOfSpadesIsFalse() throws Exception {
        HandOfCards handOfCards = this.negativeTestData();
        assertFalse(handOfCards.checkForQueenOfSpades());
    }

    /**
     * Check if there is a flush in array with 5 cards of the same type (flush)
     * @throws Exception
     */
    @Test
    public void checkIfFlushIsTrue() throws Exception {
        HandOfCards handOfCards = this.positiveTestData();
        assertTrue(handOfCards.isFlush());
    }

    /**
     * Check for no flush
     * @throws Exception
     */
    @Test
    public void checkIfFlushIsFalse() throws Exception {
        HandOfCards handOfCards = this.negativeTestData();
        assertFalse(handOfCards.isFlush());
    }
}
