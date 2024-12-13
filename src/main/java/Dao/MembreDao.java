package Dao;

import models.Incident;
import models.Membre;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface MembreDao {
    void insere(Membre m) throws IOException;
    List<Incident> chargerlistIncident();
    Set<Membre> chargerListeMembre(String nomFichier) throws IOException;


}
