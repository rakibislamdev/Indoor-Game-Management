module com.mycompany.indoorgamemangement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.indoorgamemangement to javafx.fxml;
    exports com.mycompany.indoorgamemangement;
}
