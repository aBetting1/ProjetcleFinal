import com.example.projetcle.Cle;
import org.junit.jupiter.api.AfterEach;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class Test {
    String URL = "jdbc:mysql://172.19.0.25:3306/ProjetCle";
    String LOGIN = "phpmyadmin";
    String PASSWORD = "0550002D";

    @org.junit.jupiter.api.Test
    void testAjouterCle() throws SQLException {
        Connection connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        // Objet statement : représente une instruction SQL
        System.out.println("Test d'ajout de clé");

        Cle instance = new Cle();
        instance.Ajouter(9999,"rouge", "maison de Remy");

        String req = "SELECT couleur FROM Cle WHERE Numero = 9999;";
        Statement stmt = connexion.createStatement();
        ResultSet resultat = stmt.executeQuery(req);
        resultat.next();

        assertEquals( "rouge" , resultat.getString("couleur") );

    }


    @org.junit.jupiter.api.Test
    void testSupCle() throws SQLException {
        Connection connexion = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        // Objet statement : représente une instruction SQL
        System.out.println("Test de suppression de clé");

        Cle instance = new Cle(55555, "rouge", "maison de Remy");
        instance.Ajouter(55555,"rouge", "maison de Remy");
        instance.Supprimer("55555");

        String req = "SELECT couleur FROM Cle WHERE Ouverture = 'maison de Remy' AND couleur = 'rouge';";
        Statement stmt = connexion.createStatement();
        ResultSet resultat = stmt.executeQuery(req);

        assertTrue(resultat.next());
    }

    @AfterEach
    void tearDown() {
    }
}