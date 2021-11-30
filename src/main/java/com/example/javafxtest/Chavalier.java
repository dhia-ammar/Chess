package com.example.javafxtest;

import javafx.util.Pair;

import java.util.ArrayList;

public class Chavalier extends Piece{

    public Chavalier(Pair<Integer, Integer> position, Couleur couleur) {
        super(position, couleur);
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
        int x;
        int y;
        x=currX+2;
        y=currY+1;
        if (x>=0 && y>=0 && y<8 && x<8){
            deplacement =new Pair<>(x,y);
            deplacements.add(deplacement);
        }
        x=currX+2;
        y=currY-1;
        if (x>=0 && y>=0 && y<8 && x<8){
            deplacement =new Pair<>(x,y);
            deplacements.add(deplacement);
        }
        x=currX+1;
        y=currY+2;
        if (x>=0 && y>=0 && y<8 && x<8){
            deplacement =new Pair<>(x,y);
            deplacements.add(deplacement);
        }
        x=currX-1;
        y=currY+2;
        if (x>=0 && y>=0 && y<8 && x<8){
            deplacement =new Pair<>(x,y);
            deplacements.add(deplacement);
        }
        x=currX-2;
        y=currY+1;
        if (x>=0 && y>=0 && y<8 && x<8){
            deplacement =new Pair<>(x,y);
            deplacements.add(deplacement);
        }
        x=currX-2;
        y=currY-1;
        if (x>=0 && y>=0 && y<8 && x<8){
            deplacement =new Pair<>(x,y);
            deplacements.add(deplacement);
        }
        x=currX+1;
        y=currY-2;
        if (x>=0 && y>=0 && y<8 && x<8){
            deplacement =new Pair<>(x,y);
            deplacements.add(deplacement);
        }
        x=currX-2;
        y=currY-1;
        if (x>=0 && y>=0 && y<8 && x<8){
            deplacement =new Pair<>(x,y);
            deplacements.add(deplacement);
        }

        return deplacements;
    }
    @Override
    public void detruire() {

    }

    @Override
    public String toString() {
        String ch = "C "+couleur.name();
        return ch;
    }


}
