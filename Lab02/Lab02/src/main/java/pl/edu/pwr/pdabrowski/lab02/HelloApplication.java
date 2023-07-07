package pl.edu.pwr.pdabrowski.lab02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1033, 699);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        ExploreFiles exploreFiles = new ExploreFiles();
        exploreFiles.updateFileList();
        List<String> files = exploreFiles.getFileList();



    }

    public static void main(String[] args) {
        launch();
    }
}