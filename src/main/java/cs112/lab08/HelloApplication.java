package cs112.lab08;

import javafx.application.Application;
import javafx.event.ActionEvent;
//import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.control.ProgressBar;
import java.io.IOException;
import javafx.geometry.Pos;

public class HelloApplication extends Application {

    //CONSTANTS
    private Label titleLabel; //title label used to display welcome message
    private ImageView cardImageView; // used to display png
    private Label messageLabel; //Displays message to prompt button interaction, as well as updating to show current card name
    private Button drawCardButton; //actual button to draw random card
    private ProgressBar gameProgressBar; //progress bar to display progress(unused)

    //array of LoteriaCards to use for game:
    private static final LoteriaCard[] LOTERIA_CARDS = {
            new LoteriaCard("Las matematicas", "1.png", 1),
            new LoteriaCard("Las ciencias", "2.png", 2),
            new LoteriaCard("La Tecnología", "8.png", 8),
            new LoteriaCard("La ingeniería", "9.png", 9),
    };


    @Override
    public void start(Stage stage) throws IOException {
        //removed FXML code, fill this in with components, scene, stage, etc.
        //title
        titleLabel = new Label("Welcome to EChALE STEM Loteria!");
        LoteriaCard defaultCard = new LoteriaCard();

        //Image View
        cardImageView = new ImageView();
        cardImageView.setFitWidth(350);
        cardImageView.setFitHeight(350);
        cardImageView.setPreserveRatio(true);
        cardImageView.setImage(defaultCard.getImage());

        //Message label
        messageLabel = new Label("Click the button to draw random a card");

        //Button to draw card
        drawCardButton = new Button("Draw Random Card");

        //Progress Bar
        gameProgressBar = new ProgressBar(0);

        //vbox layout
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20;"); //Taken from last lab
        layout.getChildren().addAll(titleLabel, cardImageView, messageLabel, drawCardButton, gameProgressBar);

        //Button function
        drawCardButton.setOnAction(new javafx.event.EventHandler<>() {
            @Override
            public void handle(javafx.event.ActionEvent event) { //anonymous inner class used as directed
                //picks a random card
                int randomIndex = (int) (Math.random() * LOTERIA_CARDS.length);
                LoteriaCard randomCard = LOTERIA_CARDS[randomIndex];

                //updates the ImageView and messageLabel
            cardImageView.setImage(randomCard.getImage());
            messageLabel.setText(randomCard.getCardName());
            }
        });

        //Create and show the scene
        Scene scene = new Scene(layout, 350, 500); // 350x500 as specified in lab directions
        stage.setTitle("Jon Z lab 8 Loteria");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}