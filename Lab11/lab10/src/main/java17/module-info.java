module pl.edu.pwr.pdabrowski.lab10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires CryptoLib;

    opens pl.edu.pwr.pdabrowski.lab10 to javafx.fxml;
    exports pl.edu.pwr.pdabrowski.lab10;
}