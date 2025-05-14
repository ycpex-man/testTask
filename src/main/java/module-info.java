module com.example.testtaskhtc {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires jdk.compiler;


    opens com.example.testtaskhtc to javafx.fxml;
    exports com.example.testtaskhtc;
}