package com.example.whackamole;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayScreenController implements Initializable {
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
}
