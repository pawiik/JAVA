module pl.edu.pwr.pdabrowski.spi {
    requires javafx.controls;
    requires javafx.fxml;
    requires opencsv;
    requires pl.edu.pwr.pdabrowski.api;


    opens pl.edu.pwr.pdabrowski.spi to javafx.fxml;
    exports pl.edu.pwr.pdabrowski.spi;
}