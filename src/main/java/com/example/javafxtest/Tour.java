package com.example.javafxtest;

import javafx.scene.image.Image;
import javafx.util.Pair;

import java.util.HashSet;
import java.util.TreeSet;

public class Tour extends Piece{
    private boolean jamaisDeplace;

    public Tour(Pair<Integer, Integer> position, Couleur couleur) {
        super(position, couleur);
        this.jamaisDeplace=true;
        if (couleur==Couleur.Noir){
            this.image=new Image(getClass().getResource("/Assets/Black/tour-03.png").toExternalForm());
        }
        else{
            this.image=new Image(getClass().getResource("/Assets/White/tour-03.png").toExternalForm());
        }
    }
    @Override
    public HashSet<Pair<Integer, Integer>> deplacementsPossbiles(Carreau[] table) {
        HashSet<Pair<Integer, Integer>> deplacements=new HashSet<Pair<Integer,Integer>>();
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
    public void deplacer(Pair<Integer, Integer> position) {
        super.deplacer(position);
        this.jamaisDeplace=false;
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
