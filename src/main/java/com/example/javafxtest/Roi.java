package com.example.javafxtest;

import javafx.scene.image.Image;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Roi extends Piece{
    private boolean jamaisDeplace;

    public Roi(Pair<Integer, Integer> position, Couleur couleur) {
        super(position, couleur);
        this.jamaisDeplace=true;
        if (couleur==Couleur.Noir){
            this.image=new Image(getClass().getResource("/Assets/Black/roi-03.png").toExternalForm());
        }
        else{
            this.image=new Image(getClass().getResource("/Assets/White/roi-03.png").toExternalForm());
        }
    }

    @Override
    public HashSet<Pair<Integer, Integer>> deplacementsPossbiles(Carreau[] table) {
        HashSet<Pair<Integer, Integer>> deplacements= new HashSet<Pair<Integer, Integer>>();
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
    public void deplacer(Pair<Integer, Integer> position) {
        super.deplacer(position);
        this.jamaisDeplace=false;
    }

    @Override
    public String toString() {
        String ch = "R "+couleur.name();
        return ch;
    }

    public boolean isJamaisDeplace() {
        return jamaisDeplace;
    }

    public void setJamaisDeplace(boolean jamaisDeplace) {
        this.jamaisDeplace = jamaisDeplace;
    }
}
