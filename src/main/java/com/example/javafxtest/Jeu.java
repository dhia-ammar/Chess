package com.example.javafxtest;


public class Jeu {
    private Echequier echequier;
    private Joueur joueur_noir;
    private Joueur joueur_blanc;
    private Joueur tour;
    private float timer;
    public Jeu(Echequier echequier,Joueur joueur1,Joueur joueur2){
        this.echequier=echequier;
        this.joueur_blanc=joueur1;
        this.joueur_noir=joueur2;
        this.tour=joueur_blanc;
    }
    public void changerTour(){
        if (tour==null){
            tour=joueur_blanc;
        }
        else if(tour==joueur_blanc){
            tour=joueur_noir;
        }
        else{
            tour=joueur_blanc;
        }
    }

    public Echequier getEchequier() {
        return echequier;
    }

    public void setEchequier(Echequier echequier) {
        this.echequier = echequier;
    }

    public Joueur getJoueur_noir() {
        return joueur_noir;
    }

    public void setJoueur_noir(Joueur joueur_noir) {
        this.joueur_noir = joueur_noir;
    }

    public Joueur getJoueur_blanc() {
        return joueur_blanc;
    }

    public void setJoueur_blanc(Joueur joueur_blanc) {
        this.joueur_blanc = joueur_blanc;
    }

    public Joueur getTour() {
        return tour;
    }

    public void setTour(Joueur tour) {
        this.tour = tour;
    }

    public float getTimer() {
        return timer;
    }

    public void setTimer(float timer) {
        this.timer = timer;
    }
}
