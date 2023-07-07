module pl.edu.pwr.pdabrowski.lab04 {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.edu.pwr.pdabrowski.lab04 to javafx.fxml;
    exports pl.edu.pwr.pdabrowski.lab04;
}