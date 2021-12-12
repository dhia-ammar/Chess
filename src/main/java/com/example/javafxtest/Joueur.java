package com.example.javafxtest;

public class Joueur {
    private String nom;
    private String prenom;
    private int nbre_matches_gagnes;
    private Couleur couleur;

    public Joueur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getNbre_matches_gagnes() {
        return nbre_matches_gagnes;
    }

    public void setNbre_matches_gagnes(int nbre_matches_gagnes) {
        this.nbre_matches_gagnes = nbre_matches_gagnes;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
}
