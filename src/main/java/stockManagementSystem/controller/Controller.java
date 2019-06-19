package stockManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import stockManagementSystem.connectDB.ConnectDB;
import stockManagementSystem.model.Article;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Controller {
private ConnectDB connectDB = new ConnectDB();

    @FXML
    private TextField nameTag;

    @FXML
    private TextField priceTag;

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


}
