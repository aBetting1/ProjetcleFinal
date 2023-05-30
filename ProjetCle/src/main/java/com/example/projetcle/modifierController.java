package com.example.projetcle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class modifierController implements Initializable {

    @FXML
    private ComboBox nomcoul;
    @FXML
    private TextField nouvcoul;
    @FXML
    private TextField nouvouv;

    @Override
    public void initialize(URL url, ResourceBundle rb) {


        String URL = "jdbc:mysql://172.19.0.25:3306/ProjetCle";
        String LOGIN = "phpmyadmin";
        String PASSWORD = "0550002D";

        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            Statement stmt = connexion.createStatement();

            ResultSet req2 = stmt.executeQuery("select numero from Cle;");

            while (req2.next())
            {
                int resultat = req2.getInt("numero");

                nomcoul.getItems().add(resultat);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void onValiderModCleClick(){
        int num;
        String  coul, use;
        num = Integer.parseInt(nomcoul.getSelectionModel().getSelectedItem().toString());
        coul = nouvcoul.getText();
        use = nouvouv.getText();


        if(!Objects.equals(coul, " ") && !Objects.equals(use, "")) {
            Cle instance = new Cle();
            instance.Modifier(num, coul, use);
            System.out.println("Vous avez bien modifier votre clé");

        }
        else{
            System.out.println("Veuillez remplir tout les champs pour ajouter une clé");
        }
    }


}
