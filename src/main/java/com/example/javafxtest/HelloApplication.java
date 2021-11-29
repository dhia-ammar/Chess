package com.example.javafxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //Group g= new Group();
        Echequier ech = new Echequier();
        ech.remplire();
        ech.renderEchequier();
        Scene scene = new Scene(ech);
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Echequier ech = new Echequier();
        System.out.print(ech);
        ech.remplire();
        System.out.print(ech);
        launch();
    }
}