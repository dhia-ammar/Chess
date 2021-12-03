package com.example.javafxtest;

import javafx.scene.image.Image;
import javafx.util.Pair;

public abstract class Piece implements InterfacePiece{
    Couleur couleur=null;
    Pair<Integer,Integer> position=null;
    Image image;

    public Piece(Pair<Integer,Integer> position,Couleur couleur){
        this.position=position;
        this.couleur=couleur;
    }
    public Couleur getCouleur() {
        return couleur;
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
    
    public void setPosition(Pair<Integer, Integer> position) {
        this.position = position;
    }

    public void deplacer(Pair<Integer, Integer> position) {
        this.setPosition(position);
    }

    public Image getImage() {
        return image;
    }
}
