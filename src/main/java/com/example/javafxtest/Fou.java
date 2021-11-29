package com.example.javafxtest;

import javafx.util.Pair;

import java.util.ArrayList;

public class Fou extends Piece{

    public Fou(Pair<Integer, Integer> position, Couleur couleur) {
        super(position, couleur);
    }

    @Override
    public void deplacer() {

    }
    @Override
    public ArrayList<Pair<Integer, Integer>> deplacementsPossbiles() {
        return null;
    }
    @Override
    public void detruire() {

    }
    @Override
    public String toString() {
        return "F";
    }
}
