package com.example.projetcle;

import java.util.ArrayList;
import java.sql.*;

public class Cle {



    private int numero;
    private String couleur;

    private String ouverture;

    public Cle(){

    }

    public Cle(int lenumero,String laCouleur, String Louverture) throws SQLException {
        this.numero = lenumero;
        this.couleur = laCouleur;
        this.ouverture = Louverture;
    }

    public String getCouleur(){
        return couleur;
    }
    public String getOverture(){
        return ouverture;
    }

    public void setNumero(int lenumero){
        this.numero = lenumero;
    }
    public void setCouleur(String laCouleur){
        this.couleur = laCouleur;
    }
    public void setOuverture(String lOuverture){
        this.ouverture = lOuverture;
    }

    public String toString(){
        return this.numero + " - " + this.couleur + " - " + this.ouverture;
    }





    public void Ajouter(int numero,String couleur, String ouverture){

        Connection connexion;
        try {
            String URL = "jdbc:mysql://172.19.0.25:3306/ProjetCle";
            // login et mdp de la base
            String LOGIN = "phpmyadmin";
            String PASSWORD = "0550002D";

            connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);


            Cle laCle = new Cle(numero,couleur,ouverture);

            PreparedStatement requ = connexion.prepareStatement("INSERT INTO Cle(Numero,couleur,Ouverture) values (?,?,?)");
            requ.setInt(1,numero);
            requ.setString(2, couleur);
            requ.setString(3, ouverture);
            requ.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        // Objet statement : représente une instruction SQL


    }
    public void Supprimer(String num){

        String URL = "jdbc:mysql://172.19.0.25:3306/ProjetCle";
        String LOGIN = "phpmyadmin";
        String PASSWORD = "0550002D";


        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            Statement stmt = connexion.createStatement();

            PreparedStatement req = connexion.prepareStatement("DELETE FROM Cle WHERE numero = ?");
            req.setString(1, num);
            req.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public ResultSet Modifier(int num,String couleur, String ouverture) {

        String URL = "jdbc:mysql://172.19.0.25:3306/ProjetCle";
        String LOGIN = "phpmyadmin";
        String PASSWORD = "0550002D";


        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);


            PreparedStatement req1 = connexion.prepareStatement("UPDATE Cle SET couleur = ?, Ouverture = ? WHERE Numero = ?;");
            req1.setString(1, couleur);
            req1.setString(2, ouverture);
            req1.setInt(3, num);
            req1.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    //modifier
    //supprimer

}