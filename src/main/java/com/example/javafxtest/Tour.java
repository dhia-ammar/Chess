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
        int x;
        int y;
        for (int i=1;i<8;i++){
            x=currX+i;
            y=currY;
            if (x>=0 && x<8 ){
                deplacement=new Pair<>(x,y);
                if (table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece()!=null){
                    break;
                }
                deplacements.add(deplacement);
            }
        }
        for (int i=1;i<8;i++){
            x=currX-i;
            y=currY;
            if (x>=0 && x<8 ){
                deplacement=new Pair<>(x,y);
                if (table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece()!=null){
                    break;
                }
                deplacements.add(deplacement);
            }
        }
        for (int i=1;i<8;i++){
            x=currX;
            y=currY-i;
            if (x>=0 && y>=0 && y<8 && x<8 ){
                deplacement=new Pair<>(x,y);
                if (table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece()!=null){
                    break;
                }
                deplacements.add(deplacement);
            }
        }
        for (int i=1;i<8;i++){
            x=currX;
            y=currY+i;
            if (y>=0 && y<8){
                deplacement=new Pair<>(x,y);
                if (table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece()!=null && table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece().getCouleur()==this.getCouleur()){
                    break;
                }
                deplacements.add(deplacement);
                if (table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece()!=null){
                    break;
                }
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
