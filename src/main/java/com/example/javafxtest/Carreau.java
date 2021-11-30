package com.example.javafxtest;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;


public class Carreau extends Rectangle {

    Pair<Integer,Integer> position=null;
    boolean contientPiece;
    Piece piece;
    Couleur couleur;
    private static final int LONGUER=100;
    public static final int LARGEUR=100;

    public Carreau(int x,int y){
        super(100*x,700-100*y,LONGUER,LARGEUR);
        position=new Pair<>(x,y);
        contientPiece=false;
        piece= null;
        if((x+y)%2==0){
            couleur=Couleur.Noir;
        }
        else{
            couleur= Couleur.Blanc;
        }
        this.color();
        this.setOnMouseClicked(t -> {System.out.println(getPiece().toString());
        Echequier e = (Echequier) this.getParent();
        e.colorBoxes(this.getPiece().deplacementsPossbiles());
        });
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

    public void changeColor() {
        this.setFill(Color.GREEN);
    }
    public void color(){
        if(this.couleur.equals(couleur.Noir)){
            this.setFill(Color.SADDLEBROWN);
        }
        else{
            couleur= Couleur.Blanc;
            this.setFill(Color.BEIGE);
        }
    }
}
