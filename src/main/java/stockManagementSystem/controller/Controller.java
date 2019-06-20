package stockManagementSystem.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import stockManagementSystem.connectDB.ConnectDB;
import stockManagementSystem.model.Article;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;
import java.util.ResourceBundle;

public class Controller{
private ConnectDB connectDB = new ConnectDB();

//Fields from the Article.fxml file
    @FXML private TextField nameTag;
    @FXML private TextField priceTag;

//Fields From the ShowArticle.fxml file
    @FXML private TableView<Article> table;
    @FXML private TableColumn<Article,Integer> tableID;
    @FXML private TableColumn<Article,String> tableName;
    @FXML private TableColumn<Article,BigDecimal> TablePrice;
    @FXML private TextField searchTag;

    public ObservableList<Article> list = FXCollections.observableArrayList();

    public void showResult(){
        list.clear();
        try {
            PreparedStatement prep = connectDB.getConnection().prepareStatement("Select * From article WHERE name like ? ");
            prep.setString(1,"%"+searchTag.getText()+"%");
            prep.executeQuery();
            ResultSet resultSet =  prep.getResultSet();

            while (resultSet.next()){
                list.add(new Article(resultSet.getInt("id"),
                        resultSet.getString("name"),resultSet.getBigDecimal("price")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        tableID.setCellValueFactory(new PropertyValueFactory<Article,Integer>("id"));
        tableName.setCellValueFactory(new PropertyValueFactory<Article,String>("name"));
        TablePrice.setCellValueFactory(new PropertyValueFactory<Article, BigDecimal>("price"));
        table.setItems(list);
    }


    public void createArticle(ActionEvent event){
        if (!nameTag.getText().equals("")) {
            Article article = new Article();
            article.setName(nameTag.getText());
            if (!priceTag.getText().equals("")){
                article.setPrice(new BigDecimal(priceTag.getText()));
            }else {
                article.setPrice(new BigDecimal(0));
            }

            try {
                PreparedStatement prep = connectDB.getConnection().prepareStatement(
                        "INSERT INTO article (name,price) VALUE (?,?)"
                );
                prep.setString(1, article.getName());
                prep.setBigDecimal(2, article.getPrice());

                prep.executeUpdate();

            }catch (SQLException se){
                se.printStackTrace();
            }

            nameTag.clear();
            priceTag.clear();

        }
    }

    public void backHome(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/view/menuSelection.fxml"));
        Scene scene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
}
