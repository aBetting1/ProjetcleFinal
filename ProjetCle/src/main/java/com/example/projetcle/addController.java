package com.example.projetcle;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class addController implements Initializable {
    @FXML
    private ComboBox droit;
    @FXML
    private TextField login;
    @FXML
    private TextField mdp;

    public void initialize(URL url, ResourceBundle rb) {
        droit.getItems().addAll("utilisateur", "admin");
    }

    @FXML
    protected void onAddUserBDDClick() throws IOException {
        String stat, log, mdps;
        stat = droit.getSelectionModel().getSelectedItem().toString();
        log = login.getText();
        mdps = mdp.getText();

        Hasher hasher = Hashing.sha256().newHasher();

        hasher.putString(mdps, Charsets.UTF_8);
        HashCode sha256 = hasher.hash();


        String URL = "jdbc:mysql://172.19.0.25:3306/ProjetCle";
        String LOGIN = "phpmyadmin";
        String PASSWORD = "0550002D";


        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            Statement stmt = connexion.createStatement();

            PreparedStatement req = connexion.prepareStatement("INSERT INTO Utilisateur (Pseudo, Mdp, Droit) VALUES (?, ?, ?)");
            req.setString(1, log);
            req.setString(2, sha256.toString());
            req.setString(3, stat);
            req.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
