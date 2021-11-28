package com.example.javafxtest;

import javafx.util.Pair;


public class Carreau {
    Pair<Integer,Integer> position=null;
    boolean contientPiece;
    Piece piece;
    Couleur couleur;

    public Carreau(int x,int y){
        position=new Pair<>(x,y);
        contientPiece=false;
        piece= null;
        if((x+y)%2==0){
            couleur=Couleur.Noir;
        }
        else{
            couleur= Couleur.Blanc;
        }
    }
    public void ajouterPiece(Piece p){
        this.piece=p;
    }
    public void enleverPiece(){
        this.piece=null;
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    public void setPosition(Pair<Integer, Integer> position) {
        this.position = position;
    }

    public boolean isContientPiece() {
        return contientPiece;
    }

    public void setContientPiece(boolean contientPiece) {
        this.contientPiece = contientPiece;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        if (piece==null){
            if(this.getCouleur()==Couleur.Noir){
                return "N";
            }
            return "W";
        }
        else{
            return piece.toString();
        }
    }
}
