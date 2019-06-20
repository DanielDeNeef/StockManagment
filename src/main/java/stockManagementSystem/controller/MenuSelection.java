package stockManagementSystem.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuSelection {

    @FXML
    private Button Create;
    @FXML
    private Button Search;

    public void goToCreate(ActionEvent event) throws IOException {
        changeScene(event,"/view/Article.fxml");
    }

    public void goToSearch(ActionEvent event) throws IOException {
        changeScene(event,"/view/ShowArticles.fxml");
    }

    public void changeScene(ActionEvent event,String fxml) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(fxml));
        Scene scene = new Scene(tableViewParent);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(scene);
        window.show();
    }
}
