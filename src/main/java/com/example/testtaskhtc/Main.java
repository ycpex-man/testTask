package com.example.testtaskhtc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 533);
        stage.setTitle("НТС");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        DataFromDatabase d = new DataFromDatabase();
        //d.autoLoadDataToProducts();
        //d.deleteAllFromProducts();
    }

    public static void main(String[] args) {
        launch();
    }


}


