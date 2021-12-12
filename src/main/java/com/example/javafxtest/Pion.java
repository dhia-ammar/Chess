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

    public Piece promouvoir(){
        if ((position.getValue()==7 && couleur==Couleur.Blanc) || (position.getValue()==0 && couleur==Couleur.Noir)){
            Piece promoted = new Dame(this.position,this.couleur);
            return promoted;
        }
        return null;
    }

    @Override
    public HashSet<Pair<Integer, Integer>> deplacementsPossbiles(Carreau[] table) {
        HashSet<Pair<Integer, Integer>> deplacements=new HashSet<Pair<Integer,Integer>>();
        Pair<Integer, Integer> deplacement=null;
        int currX = position.getKey();
        int currY = position.getValue();
        int x;
        int y;
        if (this.couleur == Couleur.Blanc){
            for (int i=1;i<3;i++){
                y=currY+i;
                if (y>=0 && y<8){
                    deplacement=new Pair<>(currX,y);
                    if (table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece()!=null){
                        break;
                    }
                    deplacements.add(deplacement);
                    if (!jamaisDeplace){
                        break;
                    }
                }
            }
            y=currY+1;
            x=currX+1;
            if (y>=0 && y<8 && x>=0 && x<8){
            deplacement=new Pair<>(x,y);
                if (table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece()!=null && table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece().getCouleur()!=this.getCouleur()){
                    deplacements.add(deplacement);
                }
            }
            x=currX-1;
            if (y>=0 && y<8 && x>=0 && x<8){
            deplacement=new Pair<>(x,y);
                if (table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece()!=null && table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece().getCouleur()!=this.getCouleur()){
                    deplacements.add(deplacement);
                }
            }
        }
        else{
            for (int i=1;i<3;i++){
                y=currY-i;
                if (y>=0 && y<8){
                    deplacement=new Pair<>(currX,y);
                    if (table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece()!=null){
                        break;
                    }
                    deplacements.add(deplacement);
                    if (!jamaisDeplace){
                        break;
                    }
                }
            }
            y=currY-1;
            x=currX+1;
            if (y>=0 && y<8 && x>=0 && x<8){
                deplacement=new Pair<>(x,y);
                if (table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece()!=null && table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece().getCouleur()!=this.getCouleur()){
                    deplacements.add(deplacement);
                }
            }
            x=currX-1;
            if (y>=0 && y<8 && x>=0 && x<8){
                deplacement=new Pair<>(x,y);
                if (table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece()!=null && table[deplacement.getKey()*8+7-deplacement.getValue()].getPiece().getCouleur()!=this.getCouleur()){
                    deplacements.add(deplacement);
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
