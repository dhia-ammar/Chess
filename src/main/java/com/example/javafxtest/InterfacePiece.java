package com.example.javafxtest;

import javafx.util.Pair;

import java.util.ArrayList;

public interface InterfacePiece {

    public void deplacer();
    public void detruire();
    public ArrayList<Pair<Integer,Integer>> deplacementsPossbiles();
}
