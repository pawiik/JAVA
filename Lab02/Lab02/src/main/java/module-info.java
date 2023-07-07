module pl.edu.pwr.pdabrowski.lab02 {
    requires javafx.controls;
    requires javafx.fxml;
    requires opencsv;


    opens pl.edu.pwr.pdabrowski.lab02 to javafx.fxml;
    exports pl.edu.pwr.pdabrowski.lab02;
}