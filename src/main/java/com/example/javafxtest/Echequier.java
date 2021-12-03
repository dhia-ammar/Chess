package com.example.javafxtest;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class Echequier extends Group{
    Carreau[] table;
    int longuer=8;
    int largeur=8;
    Piece pieceSelectionne=null;

    public Echequier(){
        table=new Carreau[longuer*largeur];
        for (int i=0;i<longuer;i++){
            for (int j = 0; j < largeur; j++) {
                table[(i*8)+j]=new Carreau(i,j);
            }
        }
    }

    public void renderEchequier(){

        for (Carreau c:table) {
            this.getChildren().add(c);
        }
    }
    public void remplire() throws IOException {

        for (Carreau c:table) {
            if (c.getPosition().getValue()<2 ){
                Couleur side  = Couleur.Blanc;
                if (c.getPosition().getValue()==0){
                    if(c.getPosition().getKey()==0 || c.getPosition().getKey()==7){
                        c.ajouterPiece(new Tour(c.getPosition(),side));
                    }
                    if(c.getPosition().getKey()==1 || c.getPosition().getKey()==6){
                        c.ajouterPiece(new Chavalier(c.getPosition(),side));
                    }
                    if(c.getPosition().getKey()==2 || c.getPosition().getKey()==5){
                        c.ajouterPiece(new Fou(c.getPosition(),side));
                    }
                    if(c.getPosition().getKey()==3){
                        c.ajouterPiece(new Roi(c.getPosition(),side));
                    }
                    if(c.getPosition().getKey()==4){
                        c.ajouterPiece(new Dame(c.getPosition(),side));
                    }
                }
                else{
                    c.ajouterPiece(new Pion(c.getPosition(),side));
                }
            }
            else if (c.getPosition().getValue()>5 ){
                Couleur side  = Couleur.Noir;
                if (c.getPosition().getValue()==7){
                    if(c.getPosition().getKey()==0 || c.getPosition().getKey()==7){
                        c.ajouterPiece(new Tour(c.getPosition(),side));
                    }
                    if(c.getPosition().getKey()==1 || c.getPosition().getKey()==6){
                        c.ajouterPiece(new Chavalier(c.getPosition(),side));
                    }
                    if(c.getPosition().getKey()==2 || c.getPosition().getKey()==5){
                        c.ajouterPiece(new Fou(c.getPosition(),side));
                    }
                    if(c.getPosition().getKey()==3){
                        c.ajouterPiece(new Roi(c.getPosition(),side));
                    }
                    if(c.getPosition().getKey()==4){
                        c.ajouterPiece(new Dame(c.getPosition(),side));
                    }
                }
                else{
                    c.ajouterPiece(new Pion(c.getPosition(),side));
                }
            }
        }
    }

    @Override
    public String toString() {
        String ch="";
        for (int i = 0; i < longuer; i++) {
            for (int j = 0; j < largeur; j++) {
                ch+=table[(i*8)+j].toString();
            }
            ch+="\n";
        }
        return ch;
    }

    public Piece getPieceSelectionne() {
        return pieceSelectionne;
    }

    public void setPieceSelectionne(Piece pieceSelectionne) {
        this.pieceSelectionne = pieceSelectionne;
    }

    public void colorBoxes(HashSet<Pair<Integer, Integer>> deplacementsPossbiles) {
        for (Carreau c:table) {
            c.color();
            if (deplacementsPossbiles.contains(c.getPosition())){
                c.changeColor();
            }

        }
    }
    public void addToMid(Piece P){
        table[27].ajouterPiece(P);
        table[27].color(Color.RED);
    }

    public void deplacerPiece(Carreau carreau) {
        if (pieceSelectionne.deplacementsPossbiles().contains(carreau.getPosition())){
            for (Carreau c:table) {
                if (c.getPosition()==pieceSelectionne.getPosition()){
                    c.setPiece(null);
                    break;
                }
            }
            pieceSelectionne.deplacer(carreau.getPosition());
            carreau.setPiece(pieceSelectionne);
        }
        else {
            pieceSelectionne=null;
        }
        for (Carreau c:table) {
            c.color();
        }
    }
}
