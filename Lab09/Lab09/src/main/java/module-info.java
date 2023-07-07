module pl.edu.pwr.pdabrowski.lab09 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.xml.bind;
    requires java.xml;
    requires jaxb.api;
    requires org.eclipse.persistence.moxy;
    requires java.sql;
    opens pl.edu.pwr.pdabrowski.lab09;
    opens pl.edu.pwr.pdabrowski.lab09.model;
//    opens pl.edu.pwr.pdabrowski.lab09 to javafx.fxml;
//    opens pl.edu.pwr.pdabrowski.lab09.model to org.eclipse.persistence.moxy;
    exports pl.edu.pwr.pdabrowski.lab09;
    exports pl.edu.pwr.pdabrowski.lab09.model;
}