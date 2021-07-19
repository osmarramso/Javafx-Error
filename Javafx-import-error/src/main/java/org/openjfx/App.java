package org.openjfx;

import java.awt.Dimension;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.Objects;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        //var scene = new Scene(new StackPane(label), 500, 500);

        stage.setTitle("Aplicacion cliente");

        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/userPanelScene.fxml")));

        stage.setScene(new Scene(root, 300, 250));

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

