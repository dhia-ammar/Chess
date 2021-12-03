package com.example.javafxtest;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.TreeSet;

public class Dame extends Piece{


    public Dame(Pair<Integer, Integer> position, Couleur couleur) {
        super(position, couleur);
    }

    @Override
    public HashSet<Pair<Integer, Integer>> deplacementsPossbiles() {
        HashSet<Pair<Integer, Integer>> deplacements=new HashSet<Pair<Integer,Integer>>();
        Pair<Integer, Integer> deplacement=null;
        int currX = position.getKey();
        int currY = position.getValue();
        int x;
        int y;
        for (int i = -7; i < 8; i++) {
            if (i!=0){
                x=currX+i;
                y=currY+i;
                if (x>=0 && y>=0 && y<8 && x<8 ){
                    deplacement=new Pair<>(x,y);
                    deplacements.add(deplacement);
                }
                x=currX+i;
                y=currY-i;
                if (x>=0 && y>=0 && y<8 && x<8 ){
                    deplacement=new Pair<>(x,y);
                    deplacements.add(deplacement);
                }
            }
        }
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
        String ch = "D "+couleur.name();
        return ch;
    }
}
