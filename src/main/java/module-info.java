module com.mycompany.indoorgamemangement {
//    requires java.logging;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.indoorgamemangement to javafx.fxml;
    exports com.mycompany.indoorgamemangement;
}
