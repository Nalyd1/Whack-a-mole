package com.example.whackamole;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.*;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

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
    /**
     *   @purpose Designed and built for a class assignment. The program reads high scores from a text file and displays
     *   them on the end screen. This code should be implemented into the final version of our endScreen. By using a text
     *   file I have hopes that it will be relatively simple to allow the user to save any high scores that they earn, we
     *   just need to test their score against the other scores in the file in descending order and then have the user enter
     *   a name, and have the high score list file update as necessary. I will make these adjustments Sunday if I can when I
     *   get home from break, but I leave these notes in case any of y'all want to take a crack at it.
     *   @author Andrew Horstkamp
     *   @date: 11/22/2023
     *   @section: CSC 331-001
     */



        // The only adjustment made to whackamoleEndScreen.fxml in SceneBuilder was setting the names of these labels
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

        // Here we create our two-dimensional array of scores, the first dimension just groups the score values together,
        // while the second dimension is used to store the actual date, being the player's name in the first spot and their
        // high score in the second. This could perhaps be replaced with a score object with playerName and scoreValue as
        // object attributes if we are in need of more object-oriented programming but I felt the array was a simpler
        // solution that would make this code easier to modify
        private String[][] highScores = new String[3][2];

        // line stores the lines with names, line2 stores the lines with scores. These could both be stored in line,
        // but I felt this makes the code clearer
        private String line;
        private String line2;


        // Our initialize method handles display scores whenever the scene is loaded.
        public void initialize() {

            // The try/catch block here is just simple exception handling, I left the catch statement pretty simple
            // because I was unsure how exactly we wanted to handle exceptions throughout the program. Whenever I go back
            // over this file I will attempt to match our error handling style from the rest of the project.
            try {

                // Files were giving me some difficulty, for the sake of a class assignment I felt it would be better to
                // just ensure that the highScores file exists where it should. If I have time I would like to have the
                // program create and populate the file with some default scores if it cannot be found.
                File saveFile = new File("highScores.txt");
                Scanner input = new Scanner(saveFile);

                // The for loop populates our array with the names and scores from the file
                for (int i = 0; i < 3; i++) {
                    line = input.nextLine();
                    highScores[i][0] = line;
                    line2 = input.nextLine();
                    highScores[i][1] = line2;

                    // The switch statements determines which iteration of the loop we are on so scored
                    // can be assigned appropriately.
                    switch (i) {
                        case 0:
                            highestScoreName.setText(highScores[i][0]);
                            highestScore.setText(highScores[i][1]);
                            break;
                        case 1:
                            secondHighestScoreName.setText(highScores[i][0]);
                            secondHighestScore.setText(highScores[i][1]);
                            break;
                        case 2:
                            thirdHighestScoreName.setText(highScores[i][0]);
                            thirdHighestScore.setText(highScores[i][1]);
                    }
                }
            } catch (IOException ex) {
                System.out.println("Error! High scores could not be located!");
                ex.printStackTrace();
            } catch (Exception ex) {
                System.out.println("Different error");
                ex.printStackTrace();
            }
        }







}
