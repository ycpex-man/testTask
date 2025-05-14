package com.example.testtaskhtc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class MainController {
    TableColumn<DataFromDatabase, Integer> idColumn = new TableColumn<>("Id");
    TableColumn<DataFromDatabase, Integer> idPriceColumn = new TableColumn<>("Id Цены");
    TableColumn<DataFromDatabase, Integer> codeColumn = new TableColumn<>("Код");
    TableColumn<DataFromDatabase, String> nameColumn = new TableColumn<>("Название");
    TableColumn<DataFromDatabase, String> barCodeColumn = new TableColumn<>("Штрих-код");
    TableColumn<DataFromDatabase, Double> quantityColumn = new TableColumn<>("Количество");
    TableColumn<DataFromDatabase, String> modelColumn = new TableColumn<>("Модель");
    TableColumn<DataFromDatabase, String> sortColumn = new TableColumn<>("Сорт");
    TableColumn<DataFromDatabase, String> colorColumn = new TableColumn<>("Цвет");
    TableColumn<DataFromDatabase, String> sizeColumn = new TableColumn<>("Размер");
    TableColumn<DataFromDatabase, String> weightColumn = new TableColumn<>("Вес");
    TableColumn<DataFromDatabase, String> dateChangesColumn = new TableColumn<>("Время изменений");
    DataFromDatabase d = new DataFromDatabase();

    @FXML
    private TableView<DataFromDatabase> tableView;

    @FXML
    private Label globalLabel;

    @FXML
    private Button searchBtn;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idPriceColumn.setCellValueFactory(new PropertyValueFactory<>("idPrice"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        barCodeColumn.setCellValueFactory(new PropertyValueFactory<>("barCode"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        sortColumn.setCellValueFactory(new PropertyValueFactory<>("sort"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        dateChangesColumn.setCellValueFactory(new PropertyValueFactory<>("dateChanges"));
        tableView.getColumns().add(idColumn);
        tableView.getColumns().add(idPriceColumn);
        tableView.getColumns().add(codeColumn);
        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(barCodeColumn);
        tableView.getColumns().add(quantityColumn);
        tableView.getColumns().add(modelColumn);
        tableView.getColumns().add(sortColumn);
        tableView.getColumns().add(colorColumn);
        tableView.getColumns().add(sizeColumn);
        tableView.getColumns().add(weightColumn);
        tableView.getColumns().add(dateChangesColumn);
        d.loadDataFromTable(tableView, "Products");
        idPriceColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        idPriceColumn.setOnEditCommit(evt -> evt.getRowValue().setIdPrice(evt.getNewValue()));
        codeColumn.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        codeColumn.setOnEditCommit(evt -> evt.getRowValue().setCode(evt.getNewValue()));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(evt -> evt.getRowValue().setName(evt.getNewValue()));
        barCodeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        barCodeColumn.setOnEditCommit(evt -> evt.getRowValue().setBarCode(evt.getNewValue()));
        quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        quantityColumn.setOnEditCommit(evt -> evt.getRowValue().setQuantity(evt.getNewValue()));
        modelColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        modelColumn.setOnEditCommit(evt -> evt.getRowValue().setModel(evt.getNewValue()));
        sortColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        sortColumn.setOnEditCommit(evt -> evt.getRowValue().setSort(evt.getNewValue()));
        colorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        colorColumn.setOnEditCommit(evt -> evt.getRowValue().setColor(evt.getNewValue()));
        sizeColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        sizeColumn.setOnEditCommit(evt -> evt.getRowValue().setSize(evt.getNewValue()));
        weightColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        weightColumn.setOnEditCommit(evt -> evt.getRowValue().setWeight(evt.getNewValue()));
    }

    @FXML
    private void onPriceButtonClick() {
        globalLabel.setText("ЦЕНЫ");
        TableColumn<DataFromDatabase, Integer> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn<DataFromDatabase, Double> priceColumn = new TableColumn<>("Цена");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableView.getItems().clear();
        tableView.getColumns().clear();
        tableView.getColumns().add(idColumn);
        tableView.getColumns().add(priceColumn);
        d.loadDataFromTable(tableView, "Price");
    }

    @FXML
    private void onProductButtonClick() {
        globalLabel.setText("ТОВАРЫ");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idPriceColumn.setCellValueFactory(new PropertyValueFactory<>("idPrice"));
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        barCodeColumn.setCellValueFactory(new PropertyValueFactory<>("barCode"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        sortColumn.setCellValueFactory(new PropertyValueFactory<>("sort"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));
        sizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        dateChangesColumn.setCellValueFactory(new PropertyValueFactory<>("dateChanges"));
        tableView.getItems().clear();
        tableView.getColumns().clear();
        tableView.getColumns().add(idColumn);
        tableView.getColumns().add(idPriceColumn);
        tableView.getColumns().add(codeColumn);
        tableView.getColumns().add(nameColumn);
        tableView.getColumns().add(barCodeColumn);
        tableView.getColumns().add(quantityColumn);
        tableView.getColumns().add(modelColumn);
        tableView.getColumns().add(sortColumn);
        tableView.getColumns().add(colorColumn);
        tableView.getColumns().add(sizeColumn);
        tableView.getColumns().add(weightColumn);
        tableView.getColumns().add(dateChangesColumn);
        d.loadDataFromTable(tableView, "Products");
    }

    @FXML
    private void onAddButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("add-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 200, 466);
        Stage stage = new Stage();
        stage.setTitle("Добавление товара");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onDeleteButtonClick() {
        d = tableView.getSelectionModel().getSelectedItem();
        if (tableView.getColumns().size() > 2) {
            d.delete(d.getId());
            tableView.getItems().remove(d);
        } else
            JOptionPane.showMessageDialog(null, "Нельзя удалить цену");
    }

    @FXML
    public void onSaveButtonClick() {
        d.updateDataProducts(tableView);
        tableView.getItems().clear();
        d.loadDataFromTable(tableView, "Products");
    }

    @FXML
    public void onSearchButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 287, 169);
        SearchViewController searchViewController = fxmlLoader.getController();
        searchViewController.setMainController(this);
        Stage stage = new Stage();
        stage.setTitle("Поиск товара");
        stage.setScene(scene);
        stage.show();

    }

    public void setData(List<DataFromDatabase> data) {
        tableView.getItems().clear();
        tableView.getItems().addAll(data);
    }


}

