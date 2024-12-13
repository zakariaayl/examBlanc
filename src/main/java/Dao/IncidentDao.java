package Dao;

import models.Incident;

import java.util.Set;

public interface IncidentDao {
    void inserer(Incident i);
    void inser(Set<Incident> is);
}
