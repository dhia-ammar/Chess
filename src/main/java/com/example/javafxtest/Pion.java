package com.example.javafxtest;

import javafx.scene.image.Image;
import javafx.util.Pair;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Pion extends Piece{
    private boolean jamaisDeplace;

    public Pion(Pair<Integer, Integer> position, Couleur couleur) throws IOException {
        super(position, couleur);
        this.jamaisDeplace = true;
        if (couleur==Couleur.Noir){
            this.image=new Image(getClass().getResource("/Assets/Black/pion-03.png").toExternalForm());
        }
        else{
            this.image=new Image(getClass().getResource("/Assets/White/pion-03.png").toExternalForm());
        }
    }

    @Override
    public void deplacer(Pair<Integer, Integer> position) {
        super.deplacer(position);
        jamaisDeplace=false;
    }

    public void promouvoir(){

    }

    @Override
    public HashSet<Pair<Integer, Integer>> deplacementsPossbiles(Carreau[] table) {
        HashSet<Pair<Integer, Integer>> deplacements=new HashSet<Pair<Integer,Integer>>();
        Pair<Integer, Integer> deplacement=null;
        int currX = position.getKey();
        int currY = position.getValue();
        int y;
        if (this.couleur == Couleur.Blanc){
            y=currY+1;
            deplacement=new Pair<>(currX,y);
            deplacements.add(deplacement);
            if (jamaisDeplace){
                y=currY+2;
                deplacement=new Pair<>(currX,y);
                deplacements.add(deplacement);
            }
        }
        else{
            y=currY-1;
            deplacement=new Pair<>(currX,y);
            deplacements.add(deplacement);
            if (jamaisDeplace){

                y=currY-2;
                deplacement=new Pair<>(currX,y);
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
