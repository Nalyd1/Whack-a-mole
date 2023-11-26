/**
 *   @author Andrew Horstkamp
 *   @date: 11/26/2023
 *   @section: CSC 331-001
 *   @purpose Designed and built for a class assignment. This is the title screen for our whack a mole game. It displays
 *   the current high scores to the user in addition to hosting the start button that begins the game. I designed and
 *   programmed the high score features.
 */

package com.example.whackamole;


import javafx.fxml.FXML;
import javafx.scene.control.Label;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TitleController{
    private Scene scene;
    private Stage stage;

    @FXML
    private Label titleLab1;
    @FXML
    private Button startButton;
    @FXML
    private GridPane scoreBoardGridPane;

    public TitleController(Stage stage){
        this.stage = stage;
    }

    public void switchToPlayScreen(ActionEvent event) throws IOException{
        System.out.println("Switching to Play Screen");
        FXMLLoader fxmlLoader = new FXMLLoader(Whack_a_mole.class.getResource("whackamolePlayScreen.fxml"));
        PlayScreenController playScreenController = new PlayScreenController(stage);
        fxmlLoader.setController(playScreenController);
        Parent root = fxmlLoader.load();
        System.out.println("FXML Loaded");
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        System.out.println("Scene set");
    }
    public void switchToTitleScreen(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("whackamoletitle.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // We initialize our Labels from our FXML file here so that we may change their text to display scores
        @FXML
        private Label highestScoreName;


        @FXML
        private Label highestScore;

        @FXML
        private Label secondHighestScoreName;

        @FXML
        private Label secondHighestScore;

        @FXML
        private Label thirdHighestScoreName;

        @FXML
        private Label thirdHighestScore;

        // Here we create our two-dimensional array of scores, the second dimension hosts the names and scores and the
        // first dimension is only used to designate which score place we are using
        private String[][] highScores = new String[3][2];

        // line stores the lines with names, line2 stores the lines with scores. These could both be stored in line,
        // but this makes the code slightly easier to read
        private String line;
        private String line2;


        // Our initialize method handles displaying scores whenever the scene is loaded.
        public void initialize() {

                // Since we are using preset high scores, these are simply set to the appropriate places in our array,
                // however if in future implementation we wanted high-scores to remains static between iterations of
                // the game than it would be possible through file input and output.
                highScores[0][0] = "Rick";
                highScores[0][1] = "2800";
                highScores[1][0] = "Lori";
                highScores[1][1] = "2400";
                highScores[2][0] = "Carl";
                highScores[2][1] = "1800";

                // Our display method is called to display the high scores.
                displayScores(highScores);
        }


        // This method sets each array item to the appropriate label text for display purposes
    public void displayScores(String[][] highScores) {
        highestScoreName.setText(highScores[0][0]);
        highestScore.setText(highScores[0][1]);
        secondHighestScoreName.setText(highScores[1][0]);
        secondHighestScore.setText(highScores[1][1]);
        thirdHighestScoreName.setText(highScores[2][0]);
        thirdHighestScore.setText(highScores[2][1]);
    }




}
