package com.example.whackamole;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TitleController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private void startButtonPressed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("whackamolePlayScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void playButtonPressed(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("whackamoleGameScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

