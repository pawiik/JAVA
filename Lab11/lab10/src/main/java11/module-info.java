module pl.edu.pwr.pdabrowski.lab1011 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires CryptoLib;

    opens pl.edu.pwr.pdabrowski.lab1011 to javafx.fxml;
    exports pl.edu.pwr.pdabrowski.lab10;
}