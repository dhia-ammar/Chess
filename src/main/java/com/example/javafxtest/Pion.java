package com.example.javafxtest;

import javafx.util.Pair;
import java.util.ArrayList;

public class Pion extends Piece{
    private boolean jamaisDeplace;

    public Pion(Pair<Integer, Integer> position, Couleur couleur) {
        super(position, couleur);
        this.jamaisDeplace = true;
    }

    @Override
    public void deplacer() {

    }

    public void promouvoir(){

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
        return "P";
    }

    public boolean isJamaisDeplace() {
        return jamaisDeplace;
    }

    public void setJamaisDeplace(boolean jamaisDeplace) {
        this.jamaisDeplace = jamaisDeplace;
    }
}
