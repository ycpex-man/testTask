package com.example.testtaskhtc;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

import java.io.IOException;

public class AddViewController {

    DataFromDatabase d = new DataFromDatabase();

    @FXML
    private TextField idPriceField;
    @FXML
    private TextField codeField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField barCodeField;
    @FXML
    private TextField quantityField;
    @FXML
    private TextField modelField;
    @FXML
    private TextField sortField;
    @FXML
    private TextField colorField;
    @FXML
    private TextField sizeField;
    @FXML
    private TextField weightField;
    @FXML
    private Label idLabel;
    @FXML
    private Label nameLabel;
    @FXML
    private Label codeLabel;
    @FXML
    private Label barCodeLabel;
    @FXML
    private Label quantityLabel;
    @FXML
    private Label modelLabel;
    @FXML
    private Label sortLabel;
    @FXML
    private Label colorLabel;
    @FXML
    private Label sizeLabel;
    @FXML
    private Label weightLabel;
    @FXML
    private Button addBtn;

    @FXML
    private void onAddButtonClick() {
        Validation validation = new Validation();
        int check = d.loadDataToProducts(idPriceField, idLabel, codeField, codeLabel, nameField, nameLabel,
                barCodeField, barCodeLabel, quantityField, quantityLabel, modelField, modelLabel, sortField,
                sortLabel, colorField, colorLabel, sizeField, sizeLabel, weightField, weightLabel);
        if (check > 0) {
            validation.showAlertInformation("Успех", "Товар добавлен");
            Stage stage = (Stage) addBtn.getScene().getWindow();
            stage.close();
        } else validation.showAlertWarning("Ошибка", "Проверьте введённые данные");
    }

    @FXML
    public void handleKeyTyped(KeyEvent keyEvent) {
        if (barCodeField.getText().length() >= 13) {
            keyEvent.consume();
        }
    }
}
