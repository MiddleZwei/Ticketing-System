package com.s15920;

/**
 * Hello world!
 *
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {

    public static Stage firstStage;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            firstStage = stage;
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("menu.fxml"));
            System.out.println(root);

            stage.setTitle("Main menu FXML");
            stage.setScene(new Scene(root, 800, 500));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }

}
