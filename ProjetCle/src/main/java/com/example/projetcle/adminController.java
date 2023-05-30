package com.example.projetcle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class adminController implements Initializable {
    @FXML
    private TextField login;
    @FXML
    private TextField mdp;
    @FXML
    private ComboBox droit;
    @FXML
    private TextField numCle;
    @FXML
    private TextField coulCle;
    @FXML
    private TextField useCle;
    @FXML
    private ListView<Cle> afficherlist;

    @FXML
    protected void onAddUserClick() throws IOException {

        Stage newWindow = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 308, 246);
        newWindow.setScene(scene);
        // Specifies the modality for new window.
        newWindow.initModality(Modality.APPLICATION_MODAL);
        newWindow.show();
    }

        final ObservableList<Cle> listItems =
                FXCollections.observableArrayList();

        @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {
            String URL = "jdbc:mysql://172.19.0.25:3306/ProjetCle";
            String LOGIN = "phpmyadmin";
            String PASSWORD = "0550002D";

            Connection connexion = null;
            try {
                connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
                Statement stmt = connexion.createStatement();

                ResultSet req1 = stmt.executeQuery("SELECT * FROM Cle;");

                while(req1.next()) {

                    // Construit un objet clé !
                    Cle laCle = new Cle();
                    laCle.setNumero(req1.getInt(1));
                    laCle.setCouleur(req1.getString(2));
                    laCle.setOuverture(req1.getString(3));

                    // J'ajoute la clé dans la liste
                    listItems.add(laCle);

                }
                afficherlist.setItems(listItems);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }

        @FXML
        protected void onModifier() throws IOException {

            Stage newWindow = new Stage();
            FXMLLoader fxmlLoader = new
                    FXMLLoader(HelloApplication.class.getResource("modifier-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 416, 362);
            newWindow.setScene(scene);
            // Specifies the modality for new window.
            newWindow.initModality(Modality.APPLICATION_MODAL);
            newWindow.show();

        }

        public void onAjouter() throws IOException, SQLException {
            int num;
            String  coul, use;
            num = Integer.parseInt(numCle.getText());
            coul = coulCle.getText();
            use = useCle.getText();


            if(num != 0 && !Objects.equals(coul, "") && !Objects.equals(use, "")) {

                String URL = "jdbc:mysql://172.19.0.25:3306/ProjetCle";
                String LOGIN = "phpmyadmin";
                String PASSWORD = "0550002D";


                Connection connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
                Statement stmt = connexion.createStatement();

                ResultSet req2 = stmt.executeQuery("select COUNT(numero) from Cle where numero = '"+num+"';");

                req2.next();

                int resultat = req2.getInt("COUNT(numero)");


                if(resultat == 0){
                    Cle instance = new Cle();
                    instance.Ajouter(num,coul, use);
                    System.out.println("Clé ajouter");
                }
                else {
                    System.out.println("La clé est déjà utiliser");
                }


            }
            else{
                System.out.println("Veuillez remplir tout les champs pour ajouter une clé");
            }
        }
        public void onSup() throws IOException {
            String num;
            num = afficherlist.getSelectionModel().getSelectedItems().toString().split(" - ")[0];

            String numero = num;
            numero = numero.replaceAll("\\[|\\]", "");


            Cle instance = new Cle();
            instance.Supprimer(numero);


        }

}
