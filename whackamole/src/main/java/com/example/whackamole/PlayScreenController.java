package com.example.whackamole;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class PlayScreenController implements Initializable {
    public PlayScreenController(Stage stage){
        this.stage = stage;
    }
    private Stage stage;
    private int difficulty;

    /**
     * @author Sinclair DeYoung
     * @date: 11/22/2023
     * @section: CSC 331-001
     * @purpose initialize builds the hard medium and easy
     * buttons for picking how the game will run
     */
    @FXML
    private Label label;
    @FXML
    private VBox theVbox;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){


        // makes 3 radio buttons uses to pick the users difficulty
        RadioButton button1 = new RadioButton("Hard");
        RadioButton button2 = new RadioButton("Medium");
        RadioButton button3 = new RadioButton("Easy");

        // add a user name
        TextField text = new TextField();
        text.setMaxWidth(100);

        // making a group
        group = new ToggleGroup();

        // adds the buttons to a group so only one could be picked
        button1.setToggleGroup(group);
        button2.setToggleGroup(group);
        button3.setToggleGroup(group);

        // the vbox holds the buttons
        theVbox.getChildren().addAll(button1, button2, button3);


    }
    private ToggleGroup group;
    public void switchGameScreen(ActionEvent event) throws IOException { System.out.println("switchingToGameScreen");
        gameLoop gameLoop = new gameLoop();
        RadioButton Toggled = (RadioButton) group.getSelectedToggle();
        int difficulty=1000;
        if (Toggled==null) {difficulty = 1000;}
        else if (Toggled.getText().equals("Easy")) {difficulty = 2000;}
        else if (Toggled.getText().equals("Medium")) {difficulty = 1000;}
        else if (Toggled.getText().equals("Hard")) {difficulty = 500;}
        gameLoop.start(stage, difficulty);




    }
}
