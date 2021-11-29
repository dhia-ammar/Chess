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
        int x;
        int y;
        x=currX+1;
        y=currY+1;
        deplacement=new Pair<>(x,y);
        deplacements.add(deplacement);
        if (jamaisDeplace){
            x=currX+2;
            y=currY+2;
            deplacement=new Pair<>(x,y);
            deplacements.add(deplacement);
        }
        return deplacements;
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
