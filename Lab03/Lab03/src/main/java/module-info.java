module pl.edu.pwr.pdabrowski.lab03 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens pl.edu.pwr.pdabrowski.lab03 to javafx.fxml;
    exports pl.edu.pwr.pdabrowski.lab03;
}