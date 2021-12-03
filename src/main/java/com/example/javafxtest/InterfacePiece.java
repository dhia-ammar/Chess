package com.example.javafxtest;

import javafx.util.Pair;

import java.util.HashSet;

public interface InterfacePiece {

    public void deplacer();
    public void detruire();
    public HashSet<Pair<Integer,Integer>> deplacementsPossbiles();
    public void deplacer(Pair<Integer, Integer> position);
}
