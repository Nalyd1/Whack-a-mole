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
        ToggleGroup group = new ToggleGroup();

        // adds the buttons to a group so only one could be picked
        button1.setToggleGroup(group);
        button2.setToggleGroup(group);
        button3.setToggleGroup(group);

        // the vbox holds the buttons
        theVbox.getChildren().addAll(button1, button2, button3);


    }
    public void switchGameScreen(ActionEvent event) throws IOException { System.out.println("switchingToGameScreen");
        gameLoop gameLoop = new gameLoop();
        gameLoop.start(stage);



        /*FXMLLoader fxmlLoader = new FXMLLoader(Whack_a_mole.class.getResource("whackamoleGameScreen.fxml"));
        gameController gameController = new gameController(stage);
        fxmlLoader.setController(gameController);
        Parent root = fxmlLoader.load();
        System.out.println("FXML Loaded");
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        System.out.println("Scene set");*/


    }
}
