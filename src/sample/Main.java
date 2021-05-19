package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private static Stage lava;

    @Override
    public void start(Stage primaryStage) throws Exception{

        lava =primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Loterii");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }



    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        lava.getScene().setRoot(pane);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
