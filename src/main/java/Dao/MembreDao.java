package Dao;

import models.Incident;
import models.Membre;

import java.io.IOException;
import java.util.List;

public interface MembreDao {
    void insere(Membre m) throws IOException;
    List<Incident> list();

}
