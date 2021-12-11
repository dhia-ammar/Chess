package com.example.javafxtest;

import javafx.geometry.Insets;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PaneCarreau extends Pane {
    Carreau carreau;
    ImageView piece=new ImageView();

    public PaneCarreau(Carreau carreau){
        this.setPrefSize(100,100);
        this.setTranslateX(carreau.getPosition().getKey()*10);
        this.setTranslateY(carreau.getPosition().getValue()*10);
        this.carreau=carreau;
        this.getChildren().add(carreau);
        if (carreau.getPiece() instanceof Pion){
            this.piece.setImage(carreau.getPiece().getImage());
            this.piece.setOpacity(0.2);
            this.getChildren().add(piece);
            this.piece.setFitHeight(100);
            this.piece.setFitWidth(100);
        }
    }
}
