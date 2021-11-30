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
        ArrayList<Pair<Integer, Integer>> deplacements=new ArrayList<Pair<Integer,Integer>>();
        Pair<Integer, Integer> deplacement=null;
        int currX = position.getKey();
        int currY = position.getValue();
        int y;
        y=currY+1;
        deplacement=new Pair<>(currX,y);
        deplacements.add(deplacement);
        if (jamaisDeplace){

            y=currY+2;
            deplacement=new Pair<>(currX,y);
            deplacements.add(deplacement);
        }
        return deplacements;
    }

    @Override
    public void detruire() {

    }

    @Override
    public String toString() {
        String ch = "P "+couleur.name();
        return ch;
    }

    public boolean estJamaisDeplace() {
        return jamaisDeplace;
    }

    public void setJamaisDeplace(boolean jamaisDeplace) {
        this.jamaisDeplace = jamaisDeplace;
    }
}
