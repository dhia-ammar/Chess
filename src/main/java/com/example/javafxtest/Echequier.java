package com.example.javafxtest;

import java.util.Arrays;

public class Echequier {
    Carreau[] table;
    int longuer=8;
    int largeur=8;

    public Echequier(){
        table=new Carreau[longuer*largeur];
        for (int i=0;i<longuer;i++){
            for (int j = 0; j < largeur; j++) {
                table[(i*8)+j]=new Carreau(i,j);
            }
        }
    }
    public void remplire(){

        for (Carreau c:table) {
            if (c.getPosition().getValue()<2 ){
                Couleur side  = Couleur.Blanc;
                if (c.getPosition().getValue()==0){
                    if(c.getPosition().getKey()==0 || c.getPosition().getKey()==7){
                        c.ajouterPiece(new Tour());
                    }
                    if(c.getPosition().getKey()==1 || c.getPosition().getKey()==6){
                        c.ajouterPiece(new Chavalier());
                    }
                    if(c.getPosition().getKey()==2 || c.getPosition().getKey()==5){
                        c.ajouterPiece(new Fou());
                    }
                    if(c.getPosition().getKey()==3){
                        c.ajouterPiece(new Roi());
                    }
                    if(c.getPosition().getKey()==4){
                        c.ajouterPiece(new Dame());
                    }
                }
                else{
                    c.ajouterPiece(new Pion());
                }
            }
            else if (c.getPosition().getValue()>5 ){
                Couleur side  = Couleur.Noir;
                if (c.getPosition().getValue()==7){
                    if(c.getPosition().getKey()==0 || c.getPosition().getKey()==7){
                        c.ajouterPiece(new Tour());
                    }
                    if(c.getPosition().getKey()==1 || c.getPosition().getKey()==6){
                        c.ajouterPiece(new Chavalier());
                    }
                    if(c.getPosition().getKey()==2 || c.getPosition().getKey()==5){
                        c.ajouterPiece(new Fou());
                    }
                    if(c.getPosition().getKey()==3){
                        c.ajouterPiece(new Roi());
                    }
                    if(c.getPosition().getKey()==4){
                        c.ajouterPiece(new Dame());
                    }
                }
                else{
                    c.ajouterPiece(new Pion());
                }
            }
        }
    }
    public void nulls(){

        /*int i=0;
        for (Carreau c:table
             ) {
            if (c == null){
                System.out.println(i);
            }
            i++;
        }*/
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
}