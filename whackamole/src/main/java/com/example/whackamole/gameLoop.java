/**
 * @author Dylan Johnson
 * @date 11/25/2023
 * @section CSC 331-002
 * @purpose This is the main game loop for a class assigment of creating whack-a-mole. This file handles the game board
 * and spawning the moles. This File is also responsible for the timer that runs during the game. Uses a TimerTask to
 * run the main loop to allow the user to make input while the game is spawning moles and changing the time.
 */

/*                  *** To DO LIST ***
       Important must be finished to complete game
If you work one of these please take it off the list and texts the group chat since were running a little behind
   1. Link file with the main file that runs the start screen
   2. Complete the Game over function
   3. Change the buttons to the mole images
   4. Link the End screen and allow the user to retry or quit out
   5. Finish the score controller and have it check the users score

       Quality of life (not important finish other tasks first)
   1. Implement difficulty to change the time moles stay on screen
   2. Polish the Graphics for the game (change background etc..)
   3. Allow the user to put a name in for their score


 */
package com.example.whackamole;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class gameLoop extends Application {
    private gameController gameController;
    private Stage stage;

    // Sets variable for the time game runs
    // Base time (30 seconds)
    private int timeLeft = 30;

public void start(Stage stage) throws IOException {this.start(stage, 1000);}


    public void start(Stage stage, int difficulty) throws IOException {
        gameController = new gameController(stage);


        // Loads the scene into a Fxml loader
        FXMLLoader fxmlLoader1 = new FXMLLoader(Whack_a_mole.class.getResource("whackamoleGameScreen.fxml"));
        fxmlLoader1.setController(gameController);

        // Sets the stage with the FXML loader
        try {
            Scene scene1 = new Scene(fxmlLoader1.load());
            stage.setTitle("*Wack-a-Mole*");
            stage.setScene(scene1);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }


        // Sets the global stage variable
        this.stage = stage;

        // Runs the first instance of the game board
        // Clears the board and then spawns the first mole
        clearBoard();
        randomMole();

        // Creates a timer that runs every second
        // The period changes the time in between each run
        // In the future we can hook this up to the difficulty with a variable and control how long the moles stay on screen
        Timer timer = new Timer();
        timer.schedule(countdown,0,difficulty);
    }

    // Main method ignore
    public static void main(String[] args) {launch(args);}


    // Function for spawning a random mole
    public void randomMole(){

        // Gets a random integer up to 9
        // Runs a switch case with that integer and sets that block to a mole and sets a boolean for that button
        // All the variables being set can be found in the gameController
        // In the future we can change it from text and buttons to an image of a mole and a hole
        Random rnd = new Random(System.currentTimeMillis());
        int moleNum = rnd.nextInt(9);

        switch (moleNum){

            case 1:
                gameController.mole_1.setText("mole");
                gameController.setMole1(true);
                break;

            case 2:
                gameController.mole_2.setText("mole");
                gameController.setMole2(true);
                break;

            case 3:
                gameController.mole_3.setText("mole");
                gameController.setMole3(true);
                break;

            case 4:
                gameController.mole_4.setText("mole");
                gameController.setMole4(true);
                break;

            case 5:
                gameController.mole_5.setText("mole");
                gameController.setMole5(true);
                break;

            case 6:
                gameController.mole_6.setText("mole");
                gameController.setMole6(true);
                break;

            case 7:
                gameController.mole_7.setText("mole");
                gameController.setMole7(true);
                break;

            case 8:
                gameController.mole_8.setText("mole");
                gameController.setMole8(true);
                break;

            case 9:
                gameController.mole_9.setText("mole");
                gameController.setMole9(true);
                break;
        }

    }

    // Function that clears the board of all moles
    // This function also sets the booleans for all moles to false
    public void clearBoard(){
        gameController.mole_1.setText("1");
        gameController.mole_2.setText("2");
        gameController.mole_3.setText("3");
        gameController.mole_4.setText("4");
        gameController.mole_5.setText("5");
        gameController.mole_6.setText("6");
        gameController.mole_7.setText("7");
        gameController.mole_8.setText("8");
        gameController.mole_9.setText("9");
        gameController.setMole1(false);
        gameController.setMole2(false);
        gameController.setMole3(false);
        gameController.setMole4(false);
        gameController.setMole5(false);
        gameController.setMole6(false);
        gameController.setMole7(false);
        gameController.setMole8(false);
        gameController.setMole9(false);
    }


    // Main Timer function
    // This function controls the main game loop after the first instance of the board
    // Everything in here is needed to play the game correct
    TimerTask countdown = new TimerTask() {
        @Override
        public void run() {


            // This call needs to be here
            // If this call is removed and the Timer task is ran without it the GUI will crash everytime
            // This allows for the GUI and the game backend to run on different threads at the same time
            Platform.runLater(new Runnable() {
                @Override
                public void run() {

                    // Lowers the time down by a second
                    timeLeft--;

                    // An if statement checks the time left is over 0 seconds
                    if (timeLeft >= 0){

                        // Updates the timer for the game
                        // The program then runs another instance of ClearBoard and randomMole
                        gameController.timeLeft.setText("" + timeLeft);
                        clearBoard();
                        randomMole();
                    }

                    // Timer has reached 0 seconds
                    else {

                        // This cancels out the timer and stops running everything in the Timer Task
                        cancel();

                        // This runs the gameOver functions
                        // This function changes the window to the end screen and displays the high scores
                        try{
                            gameOver();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    };

    // Gameover function
    // This function changes screens to the end screen
    public void gameOver() throws IOException {

        // Opens the end screen FXML and sets the controller to the endController
        FXMLLoader fxmlLoader = new FXMLLoader(Whack_a_mole.class.getResource("whackamoleEndScreen.fxml"));
        endController endController = new endController(this.stage);
        fxmlLoader.setController(endController);
        Parent root = fxmlLoader.load();
        System.out.println("FXML Loaded");
        Scene scene = new Scene(root);

        this.stage.setScene(scene);
        this.stage.show();
    }

}
