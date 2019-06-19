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
        Parent root = FXMLLoader.load(getClass().getResource("/view/ShowArticles.fxml"));
        stage.setTitle("Article");
        Scene scene = new Scene(root,450,220);
        stage.setScene(scene);
        stage.show();
    }
}
