package no.ntnu.katarzsz.cardgame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class View extends Application {
    private GridPane pane;
    private ArrayList<Text> texts = new ArrayList<Text>();

    /**
     * Setup main stage and scene
     * @param stage
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        pane = new GridPane();
        Scene scene = new Scene(pane,800, 600);
        stage.setTitle("Card Game");
        stage.setScene(scene);
        stage.show();

        this.setup();
    }

    /**
     * Setup up of all elements in the application
     */
    public void setup() {
        //Info - text
        Text infoText = new Text();
        texts.add(infoText);
        pane.add(infoText, 1, 7);

        //Hand of cards - text
        Text handOfCardsText = new Text();
        texts.add(handOfCardsText);
        StackPane stack = new StackPane();
        stack.setStyle("-fx-background-color: #e6e6e6; -fx-min-width: 300; -fx-min-height: 200;");
        stack.getChildren().add(handOfCardsText);
        pane.add(stack, 1,1);

        //Sum of faces - text
        Text sumOfFaces = new Text("0");
        texts.add(sumOfFaces);
        Label sumOfFacesLabel = new Label("Sum of faces: ", sumOfFaces);
        sumOfFacesLabel.setContentDisplay(ContentDisplay.RIGHT);
        pane.add(sumOfFacesLabel, 1, 5);

        //Cards with hearts - text
        Text hearts = new Text("");
        texts.add(hearts);
        Label heartsLabel = new Label("Cards of hearts: ", hearts);
        heartsLabel.setContentDisplay(ContentDisplay.RIGHT);
        pane.add(heartsLabel, 1, 6);

        //Queen of Spades - text
        Text queenOfSpades = new Text("");
        texts.add(queenOfSpades);
        Label queenOfSpadesLabel = new Label("Queen of Spades: ", queenOfSpades);
        queenOfSpadesLabel.setContentDisplay(ContentDisplay.RIGHT);
        pane.add(queenOfSpadesLabel, 2, 5);

        //Deal cards - button
        Button dealHandButton = new Button();
        dealHandButton.setText("Deal hand");

        //Resets all texts and deals cards on click
        dealHandButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resetTexts();
                try {
                    ArrayList<PlayingCard> handOfCards = ViewController.dealHand();
                    handOfCardsText.setText(handOfCards.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        pane.add(dealHandButton, 1, 2);

        //Button for analysing hand of cards
        Button checkHandButton = new Button();
        checkHandButton.setText("Check hand");

        //Does various checks on the hand of cards and prints in on the screen on the click
        checkHandButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //Check sum of the faces
                try {
                    int sum = ViewController.checkSumOfFaces();
                    sumOfFaces.setText(String.valueOf(sum));
                } catch(Exception e) {
                    infoText.setText(e.getMessage());
                }

                //Check for heart cards
                try {
                    List heartCards = ViewController.checkHearts();
                    if (!heartCards.isEmpty()) {
                        hearts.setText(heartCards.toString());
                    } else {
                        hearts.setText("No hearts");
                    }
                } catch(Exception e) {
                    infoText.setText(e.getMessage());
                }

                //Checks for Queen of Spades
                try {

                } catch (Exception e) {

                }

                //Checks for flush

            }
        });
        pane.add(checkHandButton, 1, 3);

    }

    /**
     * Starts the application
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Resets all texts
     */
    public void resetTexts() {
        if (!this.texts.isEmpty()) {
            for (Text text : texts) {
                text.setText("");
            }
        }
    }
}
