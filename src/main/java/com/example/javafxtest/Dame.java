package com.example.javafxtest;

import javafx.scene.image.Image;
import javafx.util.Pair;

import java.util.HashSet;
import java.util.TreeSet;

public class Dame extends Piece{


    public Dame(Pair<Integer, Integer> position, Couleur couleur) {
        super(position, couleur);
        if (couleur==Couleur.Noir){
            this.image=new Image(getClass().getResource("/Assets/Black/dame-03.png").toExternalForm());
        }
        else{
            this.image=new Image(getClass().getResource("/Assets/White/dame-03.png").toExternalForm());
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
            y=currY+i;
            if (x>=0 && y>=0 && y<8 && x<8 ){
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
        for (int i=1;i<8;i++){
            x=currX+i;
            y=currY-i;
            if (x>=0 && y>=0 && y<8 && x<8 ){
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
        for (int i=1;i<8;i++){
            x=currX-i;
            y=currY-i;
            if (x>=0 && y>=0 && y<8 && x<8 ){
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
        for (int i=1;i<8;i++){
            x=currX-i;
            y=currY+i;
            if (x>=0 && y>=0 && y<8 && x<8 ){
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
        for (int i=1;i<8;i++){
            x=currX+i;
            y=currY;
            if (x>=0 && x<8 ){
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
        for (int i=1;i<8;i++){
            x=currX-i;
            y=currY;
            if (x>=0 && x<8 ){
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
        for (int i=1;i<8;i++){
            x=currX;
            y=currY-i;
            if (x>=0 && y>=0 && y<8 && x<8 ){
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
        /*for (int i = -7; i < 8; i++) {
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
        }*/
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
