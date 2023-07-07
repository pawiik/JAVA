package pl.edu.pwr.pdabrowski.lab09;

import jakarta.xml.bind.JAXBException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.edu.pwr.pdabrowski.lab09.XMLHandlers.JAXBHandler;
import pl.edu.pwr.pdabrowski.lab09.XMLHandlers.JAXPHandler;

import java.io.IOException;
import java.net.MalformedURLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, JAXBException, javax.xml.bind.JAXBException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        APIService apiService = new APIService("https://bip.poznan.pl/api-xml/bip/dane-o-srodowisku-i-ochronie/A/");
        System.out.println(apiService.sendGetRequest());
        JAXBHandler.resolveObjects(apiService.sendGetRequest());
        JAXPHandler.readData(apiService.sendGetRequest());
    }

    public static void main(String[] args) throws MalformedURLException {
        launch();
    }
}