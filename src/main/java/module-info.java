module no.ntnu.katarzsz.cardgame {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens no.ntnu.katarzsz.cardgame to javafx.fxml;
    exports no.ntnu.katarzsz.cardgame;
}