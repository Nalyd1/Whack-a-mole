package com.example.whackamole;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.util.ResourceBundle;

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
        PlayScreenController playScreenController = new PlayScreenController();
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
}
