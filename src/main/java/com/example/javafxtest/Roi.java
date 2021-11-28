package com.example.javafxtest;

import javafx.util.Pair;

import java.util.ArrayList;

public class Roi extends Piece{

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

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j <2 ; j++) {
                if (!(i==0 && j==0)){
                    x=currX+i;
                    y=currY+j;
                    if (x>=0 && x<8 && y>=0 && y<8){
                        deplacement = new Pair<>(x,y);
                        deplacements.add(deplacement);
                    }
                }
            }
        }
        return deplacements;
    }
    @Override
    public void detruire() {

    }
    @Override
    public String toString() {
        return "R";
    }
}
