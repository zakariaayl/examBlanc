module com.example.etudiant {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires com.almasb.fxgl.all;

    opens com.example.etudiant to javafx.fxml;
    exports com.example.etudiant;
    exports Controller;
    exports models;
    exports Dao;
    exports DaoImp;
    opens Controller;
    opens models;
    opens Dao;
    opens DaoImp;

}