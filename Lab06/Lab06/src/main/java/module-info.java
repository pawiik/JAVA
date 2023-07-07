module pl.edu.pwr.pdabrowski.lab06 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;

    opens pl.edu.pwr.pdabrowski.lab06 to javafx.fxml;
    opens pl.edu.pwr.pdabrowski.lab06.entities to org.hibernate.orm.core;
    exports pl.edu.pwr.pdabrowski.lab06;
}