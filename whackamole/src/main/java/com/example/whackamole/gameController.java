/**
 * @author Dylan Johnson
 * @date 11/25/2023
 * @section CSC 331-002
 * @purpose This is the main game controller for a class assigment of creating whack-a-mole. This file handles creating
 * the buttons for the moles and keeping track of the users score. This file keeps track of which buttons are moles
 * If the user hits a button that is a mole it will add to the user score. This controller is mostly finished
 */

package com.example.whackamole;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class gameController {

    // Sets the user score to 0 to start the game
    private int score = 0;

    // Controls the game window
    private Scene scene;
    private Stage stage;
    public gameController(Stage stage){
        this.stage = stage;
    }


    // These variables set the button names
    // This is important for the game loop to change the text into "Mole"
    // In the future the game loop will change these to pictures of moles
    @FXML
    public Button mole_1;
    @FXML
    public Button mole_2;
    @FXML
    public Button mole_3;
    @FXML
    public Button mole_4;
    @FXML
    public Button mole_5;
    @FXML
    public Button mole_6;
    @FXML
    public Button mole_7;
    @FXML
    public Button mole_8;
    @FXML
    public Button mole_9;

    // This label shows the time left on screen
    @FXML
    public Label timeLeft;

    // This label shows the player score on screen
    // The user score is handled by the gameController entirely
    @FXML
    public Label playerScore;


    // These boolean values control which space is a mole
    public boolean isMole1;
    public boolean isMole2;
    public boolean isMole3;
    public boolean isMole4;
    public boolean isMole5;
    public boolean isMole6;
    public boolean isMole7;
    public boolean isMole8;
    public boolean isMole9;






    // These click functions run when the user clicks on a button
    // If the space is a mole
    // It will set that space back to an empty space
    // It will also change that space's boolean back to false
    // Raises the users score and changes the value shown on screen
    // (Default score value for each is 100)
    @FXML
    public void hit1(ActionEvent event) {
        if (isMole1){
            mole_1.setText("1");
            setMole1(false);
            score += 100;
            playerScore.setText("" + score);

        }
    }
    @FXML
    public void hit2(ActionEvent event) {
        if (isMole2){
            mole_2.setText("2");
            setMole2(false);
            score += 100;
            playerScore.setText("" + score);

        }
    }
    @FXML
    public void hit3(ActionEvent event) {
        if (isMole3){
            mole_3.setText("3");
            setMole3(false);
            score += 100;
            playerScore.setText("" + score);
        }
    }
    @FXML
    public void hit4(ActionEvent event) {
        if (isMole4){
            mole_4.setText("4");
            setMole4(false);
            score += 100;
            playerScore.setText("" + score);
        }
    }
    @FXML
    public void hit5(ActionEvent event) {
        if (isMole5){
            mole_5.setText("5");
            setMole5(false);
            score += 100;
            playerScore.setText("" + score);
        }
    }
    @FXML
    public void hit6(ActionEvent event) {
        if (isMole6){
            mole_6.setText("6");
            setMole6(false);
            score += 100;
            playerScore.setText("" + score);
        }
    }
    @FXML
    public void hit7(ActionEvent event) {
        if (isMole7){
            mole_7.setText("7");
            setMole7(false);
            score += 100;
            playerScore.setText("" + score);
        }
    }
    @FXML
    public void hit8(ActionEvent event) {
        if (isMole8){
            mole_8.setText("8");
            setMole8(false);
            score += 100;
            playerScore.setText("" + score);
        }
    }
    @FXML
    public void hit9(ActionEvent event) {
        if (isMole9){
            mole_9.setText("9");
            setMole9(false);
            score += 100;
            playerScore.setText("" + score);
        }
    }

    // These are the setter functions to control if a space is a mole or not
    // Used by Game Loop and this controller in the Hit functions
    public void setMole1(boolean mole1) {isMole1 = mole1;}
    public void setMole2(boolean mole2) {isMole2 = mole2;}
    public void setMole3(boolean mole3) {isMole3 = mole3;}
    public void setMole4(boolean mole4) {isMole4 = mole4;}
    public void setMole5(boolean mole5) {isMole5 = mole5;}
    public void setMole6(boolean mole6) {isMole6 = mole6;}
    public void setMole7(boolean mole7) {isMole7 = mole7;}
    public void setMole8(boolean mole8) {isMole8 = mole8;}
    public void setMole9(boolean mole9) {isMole9 = mole9;}
}
