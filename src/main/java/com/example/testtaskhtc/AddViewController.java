package com.example.testtaskhtc;

import javax.swing.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private Button addBtn;

    @FXML
    private void onAddButtonClick() throws IOException {
        d.loadDataToProducts(idPriceField, codeField, nameField, barCodeField, quantityField,
                modelField, sortField, colorField, sizeField, weightField);
        JOptionPane.showMessageDialog(null, "Добавлен");
        Stage stage = (Stage) addBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void handleKeyTyped(KeyEvent keyEvent) {
        if (barCodeField.getText().length() >= 13) {
            keyEvent.consume();
        }
    }
}
