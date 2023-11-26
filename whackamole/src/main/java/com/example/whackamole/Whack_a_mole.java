package com.example.whackamole;

import javafx.application.Application;
import javafx.event.ActionEvent;
import com.example.whackamole.TitleController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Whack_a_mole extends Application {
    private TitleController titleController;
    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        titleController = new TitleController(stage);

        // Screen 1 of the game (title)
        FXMLLoader fxmlLoader1 = new FXMLLoader(Whack_a_mole.class.getResource("whackamoletitle.fxml"));
        fxmlLoader1.setController(titleController);
        //Scene scene1 = new Scene(fxmlLoader1.load());

        // Screen 2 of the game (playScreen)
        FXMLLoader fxmlLoader2 = new FXMLLoader(Whack_a_mole.class.getResource("whackamolePlayScreen.fxml"));
        fxmlLoader2.setController(new PlayScreenController(stage));
        Scene scene2 = new Scene(fxmlLoader2.load());

        // makes the stage for the screens
        // and adds a title to the top of the stage
        try {
            Scene scene1 = new Scene(fxmlLoader1.load());
            stage.setTitle("*Wack-a-Mole*");
            stage.setScene(scene1);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void whatButtonClick(ActionEvent event) {
        try{
            titleController.switchToPlayScreen(event);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {launch(args);}
}