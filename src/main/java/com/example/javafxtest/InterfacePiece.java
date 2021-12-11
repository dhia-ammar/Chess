package com.example.javafxtest;

import javafx.util.Pair;

import java.util.HashSet;

public interface InterfacePiece {

    public void detruire();
    public HashSet<Pair<Integer,Integer>> deplacementsPossbiles(Carreau[] table);
    public void deplacer(Pair<Integer, Integer> position);
}
