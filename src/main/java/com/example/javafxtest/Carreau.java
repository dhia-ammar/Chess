package com.example.javafxtest;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.util.Pair;


public class Carreau  extends StackPane{

    Pair<Integer,Integer> position=null;

    Piece piece;
    Couleur couleur;
    private static final int LONGUER=100;
    public static final int LARGEUR=100;
    //private final StackPane tile;
    ImageView imageView;

    public Carreau(int x,int y){
        Rectangle rect = new Rectangle(LONGUER,LARGEUR);
        if((x+y)%2==0){
            couleur=Couleur.Noir;
        }
        else{
            couleur= Couleur.Blanc;
        }
        this.getChildren().add(rect);
        this.color();
        this.setAlignment(Pos.CENTER);
        position=new Pair<>(x,y);
        piece= null;
        this.setStyle("-fx-background-color:white;");
        this.setStyle("-fx-border-color:black; ");
        this.setOnMouseClicked(t -> {
            Echequier e = (Echequier) this.getParent();
            if (this.getPiece()!=null){
                if(this.getPiece().getCouleur()==e.getTour().getCouleur()){
                    System.out.println(getPiece().toString());
                    e.colorBoxes(this.getPiece().deplacementsPossbiles(e.table));
                    e.setCarreauSelectionne(this);
                }
                else if (e.getCarreauSelectionne()!=null){
                    if(this.getPiece().getCouleur()!= e.getCarreauSelectionne().getPiece().getCouleur()){
                        e.attaquer(this);
                    }
                }
            }
            else{
                if (e.getCarreauSelectionne()!=null){
                    e.effectuerCoup(this);
                }
            }

        });
    }
    public void ajouterPiece(Piece p){
        this.piece=p;
        this.getChildren().add(p.getView());
    }
    public void enleverPiece(){
        this.piece=null;
        this.getChildren().remove(1);
    }
    public Pair<Integer, Integer> getPosition() {
        return position;
    }
    public void setPosition(Pair<Integer, Integer> position) {
        this.position = position;
    }
    public Piece getPiece() {
        return piece;
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
        Rectangle rect= (Rectangle) this.getChildren().get(0);
        rect.setFill(Color.GREEN);
    }
    public void color(){
        Rectangle rect= (Rectangle) this.getChildren().get(0);
        if(this.couleur.equals(couleur.Noir)){
            rect.setFill(Color.SADDLEBROWN);
        }
        else{
            rect.setFill(Color.BEIGE);
        }
    }

}
