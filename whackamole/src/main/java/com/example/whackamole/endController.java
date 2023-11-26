/**
 *   @author Andrew Horstkamp
 *   @date: 11/26/2023
 *   @section: CSC 331-001
 *   @purpose Designed and built for a class assignment. This is the end screen for our whack a mole game. It displays
 *   the current high scores to the user in addition to hosting the start button that begins the game. It also tests
 *   if the user's score is better than any of the preset ones and displays it accordingly. I designed and programmed
 *   the high score features, the majority of which function identically to the score features in TitleController.java.
 */

package com.example.whackamole;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


import javafx.event.ActionEvent;

import javafx.scene.control.Button;

import javafx.stage.Stage;

import java.io.IOException;


public class endController {

    private Stage stage;
    private int playerScore;

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
    // but I felt this makes the code clearer
    private String line;
    private String line2;


    // Our initialize method handles display scores whenever the scene is loaded.
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

        // This if/else-if block tests where the player's score should fall on our high scores list and has it replace
        // any scores they have beaten and moves the preset scores down as necessary.
        if (playerScore > Integer.parseInt(highScores[2][1]) && playerScore <= Integer.parseInt(highScores[1][1])) {

            // The player's score replaces the third place score
            highScores[2][0] = "You";
            highScores[2][1] = String.valueOf(playerScore);
        } else if (playerScore > Integer.parseInt(highScores[1][1]) && playerScore <= Integer.parseInt(highScores[0][1])) {

            // The old second place is moved down to third
            highScores[2][0] = highScores[1][0];
            highScores[2][1] = highScores[1][1];

            // The player's score is saved in the second place spot
            highScores[1][0] = "You";
            highScores[1][1] = String.valueOf(playerScore);
        } else if (playerScore > Integer.parseInt(highScores[0][1])){
            // The old second place is moved down to third
            highScores[2][0] = highScores[1][0];
            highScores[2][1] = highScores[1][1];

            // The old first is moved to second
            highScores[1][0] = highScores[0][0];
            highScores[1][1] = highScores[0][1];

            // The player's score takes first place
            highScores[0][0] = "You";
            highScores[0][1] = String.valueOf(playerScore);
        }
        // The scores are displayed
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

    public endController(Stage stage, int score){this.stage = stage; this.playerScore = score;}

    @FXML
    private Button retryButt;

    @FXML
    private Button menu;

    // Starts the game over again and calls the game loop
    public void retry(ActionEvent event) throws IOException{
        gameLoop gameLoop = new gameLoop();
        gameLoop.start(stage,1000);
    }

    // Calls the opening file taking the user back to the main menu
    public void menu(ActionEvent event) throws IOException{
        Whack_a_mole menu = new Whack_a_mole();
        menu.start(stage);
    }
}
