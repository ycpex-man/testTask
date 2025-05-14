package com.example.testtaskhtc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;

public class SearchViewController {
    private MainController mainController;
    private DataFromDatabase d = new DataFromDatabase();

    @FXML
    ComboBox<String> searchBox;

    @FXML
    TextField textField;

    @FXML
    Button searchBtn;

    @FXML
    public void initialize() {
        searchBox.getItems().addAll("Коду", "Имени", "Штрих-коду", "Цене", "Модели", "Сорту", "Цвету", "Размеру");
        searchBox.setValue("Коду");
        searchBox.setOnAction(event -> textField.setPromptText("Введите для поиска по " + searchBox.getValue()));
    }

    @FXML
    public void onSearchButtonClick() {
        switch (searchBox.getValue()) {
            case ("Коду"):
                mainController.setData(d.searchBy("Code", textField.getText()));
                break;
            case ("Имени"):
                mainController.setData(d.searchBy("Name", textField.getText()));
                break;
            case ("Штрих-коду"):
                mainController.setData(d.searchBy("BarCode", textField.getText()));
                break;
            case ("Цене"):
                mainController.setData(d.searchBy("IdPrice", textField.getText()));
                break;
            case ("Модели"):
                mainController.setData(d.searchBy("Model", textField.getText()));
                break;
            case ("Сорту"):
                mainController.setData(d.searchBy("Sort", textField.getText()));
                break;
            case ("Цвету"):
                mainController.setData(d.searchBy("Color", textField.getText()));
                break;
            case ("Размеру"):
                mainController.setData(d.searchBy("Size", textField.getText()));
                break;
        }
        JOptionPane.showMessageDialog(null, "Готово");
        Stage stage = (Stage) searchBtn.getScene().getWindow();
        stage.close();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
