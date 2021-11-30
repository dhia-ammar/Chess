package com.example.javafxtest;

import javafx.util.Pair;

import java.util.ArrayList;

public class Tour extends Piece{
    private boolean jamaisDeplace;

    public Tour(Pair<Integer, Integer> position, Couleur couleur) {
        super(position, couleur);
        this.jamaisDeplace=true;
    }


    @Override
    public void deplacer() {

    }
    @Override
    public ArrayList<Pair<Integer, Integer>> deplacementsPossbiles() {
        ArrayList<Pair<Integer, Integer>> deplacements=new ArrayList<Pair<Integer,Integer>>();
        Pair<Integer, Integer> deplacement=null;
        int currX = position.getKey();
        int currY = position.getValue();
        for (int i = 0; i < 8; i++) {
            if (i!=currX){
                deplacement=new Pair<>(i,currY);
                deplacements.add(deplacement);
            }
        }
        for (int j = 0; j < 8; j++) {
            if (j!=currY){
                deplacement=new Pair<>(currX,j);
                deplacements.add(deplacement);
            }
        }
        return deplacements;
    }
    @Override
    public void detruire() {

    }
    @Override
    public String toString() {
        String ch = "T "+couleur.name();
        return ch;
    }

    public boolean isJamaisDeplace() {
        return jamaisDeplace;
    }

    public void setJamaisDeplace(boolean jamaisDeplace) {
        this.jamaisDeplace = jamaisDeplace;
    }
}
