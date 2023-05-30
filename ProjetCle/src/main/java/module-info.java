module com.example.projetcle {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.common;

    opens com.example.projetcle to javafx.fxml;
    exports com.example.projetcle;
}