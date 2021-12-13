package com.example.javafxtest;

import javafx.scene.image.Image;
import javafx.util.Pair;

import java.util.*;

public final class Chavalier extends Piece{

    public Chavalier(Pair<Integer, Integer> position, Couleur couleur) {
        super(position, couleur);
        if (couleur==Couleur.Noir){
            this.image=new Image(getClass().getResource("/Assets/Black/chavalier-03.png").toExternalForm());
        }
        else{
            this.image=new Image(getClass().getResource("/Assets/White/chavalier-03.png").toExternalForm());
        }
    }
    @Override
    public HashSet<Pair<Integer, Integer>> deplacementsPossbiles(Carreau[] table) {
        HashSet<Pair<Integer, Integer>> deplacements=new HashSet<>();
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
        x=currX-1;
        y=currY-2;
        if (x>=0 && y>=0 && y<8 && x<8){
            deplacement =new Pair<>(x,y);
            deplacements.add(deplacement);
        }
        ArrayList<Pair<Integer, Integer>> aSupprimer=new ArrayList<Pair<Integer, Integer>>();
        for ( Pair<Integer, Integer> d:deplacements) {
            if (table[d.getKey()*8+7-d.getValue()].getPiece()!=null && table[d.getKey()*8+7-d.getValue()].getPiece().getCouleur()==this.getCouleur()){
                aSupprimer.add(d);
            }
        }
        deplacements.removeAll(aSupprimer);
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
