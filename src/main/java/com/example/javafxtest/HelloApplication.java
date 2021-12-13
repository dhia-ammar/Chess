package com.example.javafxtest;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, CloneNotSupportedException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Joueur dhia=new Joueur("Ammar","Dhia");
        Joueur iyed= new Joueur("Ben Slimene","Iyed");
        Echequier ech = new Echequier(dhia,iyed);
        ech.remplire();
        Parent root = new Group(ech);
        Scene scene = new Scene(root);
        stage.setTitle("Chess");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws  IOException{
        launch();
    }
}