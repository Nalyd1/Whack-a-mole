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
        FXMLLoader fxmlLoader = new FXMLLoader(Whack_a_mole.class.getResource("whackamolePlayScreen.fxml"));
        PlayScreenController playScreenController = new PlayScreenController();
        fxmlLoader.setController(playScreenController);
        Scene scene = new Scene(fxmlLoader.load());
        Parent root = FXMLLoader.load(getClass().getResource("whackamolePlayScreen.fxml"));
        stage.setScene(scene);
        stage.show();
    }
    public void switchToTitleSceen(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("whackamoletitle.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
