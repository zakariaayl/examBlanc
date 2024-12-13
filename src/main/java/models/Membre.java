package models;

import java.util.List;

public class Membre {
    int id;
    String nom,prenom,email,phone;
    List<Incident> listi=null;
    public Membre(int id, String nom, String prenom, String email, String phone){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.phone=phone;
        this.email=email;
    }
    public Membre(String nom, String prenom, String email, String phone){
        this.nom=nom;
        this.prenom=prenom;
        this.phone=phone;
        this.email=email;
    }

    public Membre(String valeur, String valeur1, String valeur2, String valeur3, String valeur4) {

    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!( o instanceof Membre ) ||o==null) return false;
        Membre m=(Membre) o;
        return this.id==m.id;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public int hashCode(){
        Integer id=this.id;
        return id.hashCode() ;
    }
}
