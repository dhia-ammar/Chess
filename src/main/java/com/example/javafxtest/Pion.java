package com.example.javafxtest;

import javafx.util.Pair;

import java.util.ArrayList;

public class Pion extends Piece{
    @Override
    public void deplacer() {
        this.position = new Pair<>(position.getKey()+2, position.getValue());
    }
    @Override
    public ArrayList<Pair<Integer, Integer>> deplacementsPossbiles() {
        return null;
    }
    @Override
    public void detruire() {

    }
    public void promouvoir(){

    }

    @Override
    public String toString() {
        return "P";
    }
}
