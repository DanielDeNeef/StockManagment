package stockManagementSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/menuSelection.fxml"));
        stage.setTitle("Article");
        Scene scene = new Scene(root,172,101);
        stage.setScene(scene);
        stage.show();
    }
}
