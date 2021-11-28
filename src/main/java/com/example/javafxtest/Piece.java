package com.example.javafxtest;

import javafx.util.Pair;

public abstract class Piece implements InterfacePiece{
    Couleur couleur=null;
    Pair<Integer,Integer> position=null;

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
}
