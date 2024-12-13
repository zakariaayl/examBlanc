package Controller;
import DaoImp.MembreDaoImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import models.Membre;

import java.io.IOException;

public class ajoutController {
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField phone;
    int id=0;
    @FXML
    void ajouterMembre(javafx.event.ActionEvent actionEvent ) throws IOException {
        Membre m=new Membre(id,nom.getText(),prenom.getText(),email.getText(),phone.getText());
        MembreDaoImpl mem = new MembreDaoImpl();
        mem.insere(m);
    }
}
