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
    boolean contientPiece;
    Piece piece;
    Couleur couleur;
    private static final int LONGUER=100;
    public static final int LARGEUR=100;
    //private final StackPane tile;
    ImageView imageView;

    public Carreau(int x,int y){
        //super(100*x,700-100*y,LONGUER,LARGEUR);

        Rectangle rect = new Rectangle(LONGUER,LARGEUR);
        String colorName;
        if((x+y)%2==0){
            couleur=Couleur.Noir;
            rect.setFill(Color.SADDLEBROWN);
        }
        else{
            couleur= Couleur.Blanc;
            rect.setFill(Color.BEIGE);
        }

        this.getChildren().add(rect);
        this.setAlignment(Pos.CENTER);
        position=new Pair<>(x,y);
        contientPiece=false;
        piece= null;
        this.setStyle("-fx-background-color:white;");
        this.setStyle("-fx-border-color:green; ");
        //
        //this.color();

        this.setOnMouseClicked(t -> {
            Echequier e = (Echequier) this.getParent();
            System.out.println(getPiece().toString());
            if(this.getPiece()!=null){
                System.out.println(getPiece().toString());
                e.colorBoxes(this.getPiece().deplacementsPossbiles(((Echequier) this.getParent()).table));
                e.setPieceSelectionne(this.getPiece());
            }
            else{
                if (e.getPieceSelectionne()!=null){
                    e.deplacerPiece(this);
                    e.setPieceSelectionne(null);
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
