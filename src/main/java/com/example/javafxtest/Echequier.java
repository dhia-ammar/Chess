package com.example.javafxtest;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Pair;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Echequier extends TilePane{
    Carreau[] table;
    private int longuer=8;
    private int largeur=8;
    private Carreau carreauSelectionne=null;
    private Joueur joueur_noir;
    private Joueur joueur_blanc;
    private Joueur winner;
    Joueur tour;
    private boolean termine =false;
    public Echequier(Joueur j1,Joueur j2)throws CloneNotSupportedException{
        table=new Carreau[longuer*largeur];
        for(int row = 0; row < longuer ; row++){
            for(int col = 0; col < largeur; col++){
                Carreau c = new Carreau(col,7-row);
                this.addTile(c);
                table[(col*8)+row]=c;
            }
        }
        this.setOrientation(Orientation.HORIZONTAL);
        this.setPrefColumns(this.largeur);
        this.setTileAlignment(Pos.CENTER);
        this.joueur_blanc=j1;
        j1.setCouleur(Couleur.Blanc);
        this.joueur_noir=j2;
        j2.setCouleur(Couleur.Noir);
        tour =joueur_blanc;
    }

    void addTile(Node node){
        this.getChildren().add(node);
    }
    void changerTour(){
        if(tour == joueur_blanc){
            tour = joueur_noir;
        }
        else{
            tour = joueur_blanc;
        }
    }
    public void remplire(){
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
                    if(c.getPosition().getKey()==4){
                        c.ajouterPiece(new Roi(c.getPosition(),side));
                    }
                    if(c.getPosition().getKey()==3){
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
                    if(c.getPosition().getKey()==4){
                        c.ajouterPiece(new Roi(c.getPosition(),side));
                    }
                    if(c.getPosition().getKey()==3){
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
            if (testerMouvement(carreauSelectionne,c,carreauSelectionne.getPiece())){
                deplacerPiece(carreauSelectionne,c,carreauSelectionne.getPiece());
                for (Carreau car:table) {
                    car.color();
                }
                this.changerTour();
            }
            else{
                for (Carreau car:table){
                    if (car.getPiece()!=null){
                        if (car.getPiece() instanceof Roi && car.getPiece().getCouleur()==carreauSelectionne.getPiece().getCouleur()){
                            car.makeRed();
                        }
                        else{
                            car.color();
                        }
                    }
                }
            }
        }
        else{
            for (Carreau car:table){
                car.color();
            }
        }
        carreauSelectionne=null;
    }
    public void deplacerPiece(Carreau carreauDepart,Carreau carreauArrive,Piece piece){
        carreauDepart.enleverPiece();
        carreauArrive.ajouterPiece(piece);
        piece.deplacer(carreauArrive.getPosition());
        for (Carreau c:table) {
            c.color();
        }
        if (piece instanceof Pion){
            if (((Pion) piece).promouvoir()!=null){
                carreauArrive.enleverPiece();
                carreauArrive.ajouterPiece(((Pion) piece).promouvoir());
            }
        }
        //TODO: Nouveau syntaxe de switch
        boolean winner = switch (piece.getCouleur()){
            case Noir -> checkmate(Couleur.Blanc) ;
            case Blanc -> checkmate(Couleur.Noir);
        };
        if(winner){
            if (piece.getCouleur()==Couleur.Noir){
                this.winner = joueur_noir;
            }
            else{
                this.winner = joueur_blanc;
            }
            termine=true;
            System.out.println("Checkmate!"+piece.getCouleur()+" is The winner");
            Stage winnerWindow = new Stage();
            winnerWindow.setTitle("Checkmate!");
            Label checkmate = new Label("CheckMate!");
            checkmate.setFont(Font.font("Cambria", 48));
            checkmate.setAlignment(Pos.CENTER);
            Joueur gagnant=this.getWinner();
            Label gagnantLabel=new Label(gagnant.getPrenom()+" "+gagnant.getNom()+" a gagne le jeu!");
            gagnantLabel.setFont(Font.font("Cambria", 32));
            gagnantLabel.setAlignment(Pos.CENTER);
            /*Button button = new Button("Rejouer !");
            button.setAlignment(Pos.CENTER);
            button.setOnAction(event -> {
                reinitialiser();
            });*/
            VBox container = new VBox(checkmate,gagnantLabel);
            winnerWindow.setScene(new Scene(container));
            winnerWindow.show();
        }
    }

    private void reinitialiser() {

        for(int row = 0; row < longuer ; row++){
            for(int col = 0; col < largeur; col++){
                Carreau c = new Carreau(col,7-row);
                this.addTile(c);
                table[(col*8)+row]=c;
            }
        }
        remplire();
    }

    public Joueur getWinner() {
        return winner;
    }

    public boolean isTermine() {
        return termine;
    }

    public boolean testerMouvement(Carreau carreauDepart, Carreau carreauArrive, Piece piece){
        Carreau[] tableTest = new Carreau[longuer*largeur];
        int i=0;
        for (Carreau c: table) {
            tableTest[i]=new Carreau(c);
            i++;
        }
        for (Carreau c:tableTest) {
            if (c.getPosition().getKey()==carreauDepart.getPosition().getKey() && c.getPosition().getValue()==carreauDepart.getPosition().getValue()){
                c.setPiece(null);
            }
            else if (c.getPosition().getKey()==carreauArrive.getPosition().getKey() && c.getPosition().getValue()==carreauArrive.getPosition().getValue()){
                c.setPiece(piece);
            }
        }
        //TODO: Nouveau syntaxe de switch
        return switch(piece.getCouleur()){
            case Blanc -> !blancCheck(tableTest);
            case Noir -> !noirCheck(tableTest);
        };
    }
    public void attaquer(Carreau carreauAttaque){
        if (carreauSelectionne.getPiece().deplacementsPossbiles(this.table).contains(carreauAttaque.getPosition())){
            if (testerMouvement(carreauSelectionne,carreauAttaque,carreauSelectionne.getPiece())){
                carreauAttaque.enleverPiece();
                deplacerPiece(carreauSelectionne,carreauAttaque,carreauSelectionne.getPiece());
                for (Carreau car:table) {
                    car.color();
                }
                this.changerTour();
            }
            else{
                for (Carreau car:table){
                    if (car.getPiece()!=null){
                        if (car.getPiece() instanceof Roi && car.getPiece().getCouleur()==carreauSelectionne.getPiece().getCouleur()){
                            car.makeRed();
                        }
                        else{
                            car.color();
                        }
                    }
                }
            }
        }
        else{
            for (Carreau car:table){
                car.color();
            }
        }
        carreauSelectionne=null;
    }
    public boolean checkmate(Couleur couleur){
        //TODO:UTILISATION DES STREAMS et des Expressions Lambda
        List<Piece> pieces= Stream.of(table).filter(carreau -> carreau.getPiece()!=null).filter(carreau -> carreau.getPiece().getCouleur()==couleur).map(carreau -> carreau.getPiece()).collect(Collectors.toList());
        for (Piece p: pieces) {
            HashSet<Pair<Integer, Integer>> deplacements = p.deplacementsPossbiles(table);
            Carreau depart= Stream.of(table).filter(carreau -> carreau.getPosition()== p.position).findAny().get();
            List<Carreau> listeArrive=Stream.of(table).filter(carreau -> deplacements.contains(carreau.getPosition())).collect(Collectors.toList());
            for (Carreau arrive:listeArrive) {
                if (testerMouvement(depart,arrive,p)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean noirCheck(Carreau[] table){
        HashSet<Pair<Integer, Integer>> mouvements = new HashSet<>();
        Pair<Integer, Integer> roiPosition = null;
        for (Carreau c:table) {
            if (c.getPiece()!=null){
                if (c.getPiece() instanceof Roi && c.getPiece().getCouleur()==Couleur.Noir){
                    roiPosition = c.getPosition();
                }
                else if(c.getPiece().getCouleur()==Couleur.Blanc){
                    mouvements.addAll(c.getPiece().deplacementsPossbiles(table));
                }
            }
        }
        return mouvements.contains(roiPosition);
    }
    public boolean blancCheck(Carreau[] table){
        HashSet<Pair<Integer, Integer>> mouvements = new HashSet<>();
        Pair<Integer, Integer> roiPosition = null;
        for (Carreau c:table) {
            if (c.getPiece()!=null){
                if (c.getPiece() instanceof Roi && c.getPiece().getCouleur()==Couleur.Blanc){
                    roiPosition = c.getPosition();
                }
                else if(c.getPiece().getCouleur()==Couleur.Noir){
                    mouvements.addAll(c.getPiece().deplacementsPossbiles(table));
                }
            }
        }
        return mouvements.contains(roiPosition);
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

    public Carreau getCarreauSelectionne() {
        return carreauSelectionne;
    }

    public void setCarreauSelectionne(Carreau carreauSelectionne) {
        this.carreauSelectionne = carreauSelectionne;
    }
}
