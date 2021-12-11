package com.example.javafxtest;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class Echequier extends TilePane{
    Carreau[] table;
    int longuer=8;
    int largeur=8;
    Carreau carreauSelectionne=null;

    public Echequier(){
        table=new Carreau[longuer*largeur];
        for(int row = 0; row < longuer ; row++){
            for(int col = 0; col < largeur; col++){
                Carreau c = new Carreau(col,7-row);
                this.addTile(c);
                table[(row*8)+col]=c;
            }
        }
        this.setOrientation(Orientation.HORIZONTAL);
        this.setPrefColumns(this.largeur);
        this.setTileAlignment(Pos.CENTER);
    }

    public void renderEchequier(){
        /*for (Carreau c:table) {
            this.getChildren().add(new PaneCarreau(c));
        }*/

    }
    void addTile(Node node){
        this.getChildren().add(node);
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

    public Carreau getCarreauSelectionne() {
        return carreauSelectionne;
    }

    public void setCarreauSelectionne(Carreau carreauSelectionne) {
        this.carreauSelectionne = carreauSelectionne;
    }

    public void colorBoxes(HashSet<Pair<Integer, Integer>> deplacementsPossbiles) {
        for (Carreau c:table) {
            c.color();
            if (deplacementsPossbiles.contains(c.getPosition())){
                c.changeColor();
            }
        }
    }

    public void effectuerCoup(Carreau c){
        if (carreauSelectionne.getPiece().deplacementsPossbiles(this.table).contains(c.getPosition())){
            deplacerPiece(carreauSelectionne,c,carreauSelectionne.getPiece());
        }
        carreauSelectionne=null;
        for (Carreau car:table) {
            car.color();
        }
    }
    public void deplacerPiece(Carreau carreauDepart,Carreau carreauArrive,Piece piece) {
        carreauDepart.enleverPiece();
        carreauArrive.ajouterPiece(piece);
        piece.deplacer(carreauArrive.getPosition());
        for (Carreau c:table) {
            c.color();
        }
    }
}
