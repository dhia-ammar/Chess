package com.example.javafxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Echequier ech = new Echequier();
        ech.remplire();
        ech.renderEchequier();
        Parent root = new Group(ech);
        Scene scene = new Scene(root,800,800);
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws  IOException{
        Echequier ech = new Echequier();
        System.out.print(ech);
        ech.remplire();
        System.out.print(ech);
        launch();
    }
}