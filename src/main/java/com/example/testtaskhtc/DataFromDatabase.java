package com.example.testtaskhtc;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataFromDatabase {
    private final String URL = "jdbc:mysql://localhost:3306/ntsdb";
    private final String USER = "root";
    private final String PASSWORD = "147596311520260Leha";
    private final String[] NAME_ARRAY = {"CashMaster Pro", "SmartRegister", "QuickCash 3000", "EcoTill", "FlexiPOS",
            "EasyCheckout", "Totalizer 500", "SwiftSale", "SecurCart", "PointPlus"};
    private final String[] MODEL_ARRAY = {"Model A", "Model B", "Model C", "Model D", "Model E", "Model Z",
            "Model Y", "Model X", "Model T1000", "Model Q7"};
    private final String[] COLOR_ARRAY = {"Чёрный", "Белый", "Красный", "Синий", "Зелёный", "Жёлтый"};
    private final String[] SIZE_ARRAY = {"XS", "S", "XM", "M", "L", "XL", "XXL"};
    private int id;
    private double price;
    private int idPrice;
    private int code;
    private String name;
    private String barCode;
    private double quantity;
    private String model;
    private String sort;
    private String color;
    private String size;
    private String weight;
    private String dateChanges;

    public DataFromDatabase() {

    }

    public DataFromDatabase(int id, double price) {
        this.id = id;
        this.price = price;
    }

    public DataFromDatabase(int id, int idPrice, int code, String name, String barCode, double quantity, String model,
                            String sort, String color, String size, String weight, String dateChanges) {
        this.id = id;
        this.idPrice = idPrice;
        this.code = code;
        this.name = name;
        this.barCode = barCode;
        this.quantity = quantity;
        this.model = model;
        this.sort = sort;
        this.color = color;
        this.size = size;
        this.weight = weight;
        this.dateChanges = dateChanges;
    }


    //ALL METHODS!!
    protected void loadDataFromTable(TableView<DataFromDatabase> tableView, String table) {
        String query = "SELECT * FROM " + table;
        if (table.equals("Products")) {
            List<DataFromDatabase> productList = new ArrayList<>();
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("Id");
                    int idPrice = resultSet.getInt("IdPrice");
                    int code = resultSet.getInt("Code");
                    String name = resultSet.getString("Name");
                    String barCode = resultSet.getString("BarCode");
                    double quantity = resultSet.getDouble("Quantity");
                    String model = resultSet.getString("Model");
                    String sort = resultSet.getString("Sort");
                    String color = resultSet.getString("Color");
                    String size = resultSet.getString("Size");
                    String weight = resultSet.getString("weight");
                    String dateChanges = resultSet.getString("DateChanges");

                    productList.add(new DataFromDatabase(id, idPrice, code, name, barCode, quantity, model,
                            sort, color, size, weight, dateChanges));
                }
                tableView.getItems().addAll(productList);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else if (table.equals("Price")) {
            List<DataFromDatabase> priceList = new ArrayList<>();
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("Id");
                    double price = resultSet.getDouble("Price");
                    priceList.add(new DataFromDatabase(id, price));
                }
                tableView.getItems().addAll(priceList);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void loadDataToProducts(TextField idPriceField, TextField codeField, TextField nameField,
                                      TextField barCodeField, TextField quantityField, TextField modelField,
                                      TextField sortField, TextField colorField, TextField sizeField, TextField weightField) {
        String query = "INSERT INTO Products (IdPrice, Code, Name, BarCode, Quantity, Model, Sort, Color, Size, Weight, DateChanges)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW());";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, Integer.parseInt(idPriceField.getText()));
            preparedStatement.setInt(2, Integer.parseInt(codeField.getText()));
            preparedStatement.setString(3, nameField.getText());
            preparedStatement.setString(4, barCodeField.getText());
            preparedStatement.setBigDecimal(5, new BigDecimal(quantityField.getText()));
            preparedStatement.setString(6, modelField.getText());
            preparedStatement.setString(7, sortField.getText());
            preparedStatement.setString(8, colorField.getText());
            preparedStatement.setString(9, sizeField.getText());
            preparedStatement.setString(10, weightField.getText());
            int rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void delete(int id) {
        String query = "DELETE FROM Products WHERE Id = " + id + ";";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void updateDataProducts(TableView<DataFromDatabase> tableView) {
        DataFromDatabase dataFromDatabase = tableView.getSelectionModel().getSelectedItem();
        String query = "UPDATE Products SET idPrice = ?, code = ?, name = ?, barCode = ?, quantity = ?, " +
                "model = ?, sort = ?, color = ?, size = ?, weight = ?, dateChanges =  NOW() WHERE id = ?;";
        if (dataFromDatabase.getIdPrice() <= 0 || dataFromDatabase.getCode() < 1000 ||
                dataFromDatabase.getName() == null || dataFromDatabase.getName().isEmpty() ||
                (dataFromDatabase.getBarCode().length() != 13) || dataFromDatabase.getQuantity() < 0 ||
                dataFromDatabase.getModel() == null || dataFromDatabase.getModel().isEmpty() ||
                dataFromDatabase.getSort() == null || dataFromDatabase.getSort().isEmpty() ||
                dataFromDatabase.getColor() == null || dataFromDatabase.getColor().isEmpty() ||
                dataFromDatabase.getSize() == null || dataFromDatabase.getSize().isEmpty() ||
                dataFromDatabase.getWeight() == null || dataFromDatabase.getWeight().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Проверьте введённые данные!");
        } else {
            try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, dataFromDatabase.getIdPrice());
                preparedStatement.setInt(2, dataFromDatabase.getCode());
                preparedStatement.setString(3, dataFromDatabase.getName());
                preparedStatement.setString(4, dataFromDatabase.getBarCode());
                preparedStatement.setBigDecimal(5, new BigDecimal(dataFromDatabase.getQuantity()));
                preparedStatement.setString(6, dataFromDatabase.getModel());
                preparedStatement.setString(7, dataFromDatabase.getSort());
                preparedStatement.setString(8, dataFromDatabase.getColor());
                preparedStatement.setString(9, dataFromDatabase.getSize());
                preparedStatement.setString(10, dataFromDatabase.getWeight());
                preparedStatement.setInt(11, dataFromDatabase.getId());
                int rows = preparedStatement.executeUpdate();
                if (rows >= 1) {
                    JOptionPane.showMessageDialog(null, "Сохранено");
                } else
                    JOptionPane.showMessageDialog(null, "Ошибка");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void autoLoadDataToProducts() {
        Random r = new Random();
        String query = "INSERT INTO Products (IdPrice, Code, Name, BarCode, Quantity, Model, Sort, Color, Size, Weight, DateChanges)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW());";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            for (int i = 0; i < 1000; i++) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, r.nextInt(3) + 1);
                preparedStatement.setInt(2, r.nextInt(2000) + 1000);
                preparedStatement.setString(3, NAME_ARRAY[r.nextInt(10)]);
                long min = 1_000_000_000_000L;
                long max = 9_999_999_999_999L;
                preparedStatement.setString(4, r.nextLong(min, max) + "");
                preparedStatement.setBigDecimal(5, new BigDecimal(r.nextDouble(100) + 1));
                preparedStatement.setString(6, MODEL_ARRAY[r.nextInt(10)]);
                preparedStatement.setString(7, "Type " + r.nextInt(10) + 1);
                preparedStatement.setString(8, COLOR_ARRAY[r.nextInt(6)]);
                preparedStatement.setString(9, SIZE_ARRAY[r.nextInt(7)]);
                preparedStatement.setString(10, (r.nextInt(100) + 1) + "кг");
                int rows = preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void deleteAllFromProducts() {
        String query = "DELETE FROM Products;";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ошибка");
            ;
        }
    }

    protected List<DataFromDatabase> searchBy(String field, String value) {
        String query = "SELECT * FROM Products WHERE " + field + " = " + "'" + value + "'";
        List<DataFromDatabase> productList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("Id");
                int idPrice = resultSet.getInt("IdPrice");
                int code = resultSet.getInt("Code");
                String name = resultSet.getString("Name");
                String barCode = resultSet.getString("BarCode");
                double quantity = resultSet.getDouble("Quantity");
                String model = resultSet.getString("Model");
                String sort = resultSet.getString("Sort");
                String color = resultSet.getString("Color");
                String size = resultSet.getString("Size");
                String weight = resultSet.getString("weight");
                String dateChanges = resultSet.getString("DateChanges");
                productList.add(new DataFromDatabase(id, idPrice, code, name, barCode, quantity, model,
                        sort, color, size, weight, dateChanges));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public String toString() {
        return "{IdPrice=" + idPrice +
                ", Code=" + code +
                ", Name=" + name +
                ", BarCode=" + barCode +
                ", Quantity=" + quantity +
                ", Model=" + model +
                ", Sort=" + sort +
                ", Color=" + color +
                ", Size=" + size +
                ", Weight=" + weight +
                ", DateChanges=" + dateChanges + "}";
    }

    //GETTERS!
    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public int getIdPrice() {
        return idPrice;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getBarCode() {
        return barCode;
    }

    public double getQuantity() {
        return quantity;
    }

    public String getModel() {
        return model;
    }

    public String getSort() {
        return sort;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public String getWeight() {
        return weight;
    }

    public String getDateChanges() {
        return dateChanges;
    }

    //SETTERS!
    public void setId(int id) {
        this.id = id;
    }

    public void setIdPrice(int idPrice) {
        this.idPrice = idPrice;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDateChanges(String dateChanges) {
        this.dateChanges = dateChanges;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
