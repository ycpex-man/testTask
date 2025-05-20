package com.example.testtaskhtc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        Validation validation = new Validation();
        switch (searchBox.getValue()) {
            case ("Коду"):
                mainController.setData(d.searchBy("Code", textField.getText()));
                if (!(d.searchBy("Code", textField.getText()).isEmpty())) {
                    validation.showAlertInformation(null, "Готово");
                } else validation.showAlertInformation(null, "Товар не найден");
                break;
            case ("Имени"):
                mainController.setData(d.searchBy("Name", textField.getText()));
                if (!(d.searchBy("Name", textField.getText()).isEmpty())) {
                    validation.showAlertInformation(null, "Готово");
                } else validation.showAlertInformation(null, "Товар не найден");
                break;
            case ("Штрих-коду"):
                mainController.setData(d.searchBy("BarCode", textField.getText()));
                if (!(d.searchBy("BarCode", textField.getText()).isEmpty())) {
                    validation.showAlertInformation(null, "Готово");
                } else validation.showAlertInformation(null, "Товар не найден");
                break;
            case ("Цене"):
                mainController.setData(d.searchBy("IdPrice", textField.getText()));
                if (!(d.searchBy("IdPrice", textField.getText()).isEmpty())) {
                    validation.showAlertInformation(null, "Готово");
                } else validation.showAlertInformation(null, "Товар не найден");
                break;
            case ("Модели"):
                mainController.setData(d.searchBy("Model", textField.getText()));
                if (!(d.searchBy("Model", textField.getText()).isEmpty())) {
                    validation.showAlertInformation(null, "Готово");
                } else validation.showAlertInformation(null, "Товар не найден");
                break;
            case ("Сорту"):
                mainController.setData(d.searchBy("Sort", textField.getText()));
                if (!(d.searchBy("Sort", textField.getText()).isEmpty())) {
                    validation.showAlertInformation(null, "Готово");
                } else validation.showAlertInformation(null, "Товар не найден");
                break;
            case ("Цвету"):
                mainController.setData(d.searchBy("Color", textField.getText()));
                if (!(d.searchBy("Color", textField.getText()).isEmpty())) {
                    validation.showAlertInformation(null, "Готово");
                } else validation.showAlertInformation(null, "Товар не найден");
                break;
            case ("Размеру"):
                mainController.setData(d.searchBy("Size", textField.getText()));
                if (!(d.searchBy("Size", textField.getText()).isEmpty())) {
                    validation.showAlertInformation(null, "Готово");
                } else validation.showAlertInformation(null, "Товар не найден");
                break;
        }

        Stage stage = (Stage) searchBtn.getScene().getWindow();
        stage.close();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
