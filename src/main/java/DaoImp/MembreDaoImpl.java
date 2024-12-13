package DaoImp;

import Dao.MembreDao;
import models.Incident;
import models.Membre;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class MembreDaoImpl implements MembreDao {

    @Override
    public void insere(Membre m) throws IOException {
        String url = "jdbc:mysql://localhost:3306/gest";
        String name = "root";
        String passwd = "root";
        try {
            Connection conn = DriverManager.getConnection(url, name, passwd);
            String id = String.valueOf(UUID.randomUUID());
            String sql = "INSERT INTO membre VALUES(?,?,?,?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, id);
            stmt.setString(2, m.getNom());
            stmt.setString(3, m.getPrenom());
            stmt.setString(4, m.getEmail());
            stmt.setString(5, m.getPhone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Incident> chargerlistIncident() {
        String url = "jdbc:mysql://localhost:3306/gest";
        String name = "root";
        String passwd = "root";
        try {
            Connection conn = DriverManager.getConnection(url, name, passwd);
            String sql = "SELECT * FROM incident ";//si on veut charger tout les incidents correspon a membre on doit ajouter WHERE idMem=? et travailer avec preparedstatement
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            List<Incident> li = new ArrayList<>();
            while (rs.next()) {

                li.add(new Incident(rs.getString(1), rs.getString(2), rs.getTime(3)));
            }
            return li;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Set<Membre> chargerListeMembre(String nomFichier) {
        Set<Membre> membres=new HashSet<>();
        String line;
        try (BufferedReader br=new BufferedReader(new FileReader(nomFichier))) {
            br.readLine();
            while ((line=br.readLine())!=null) {
                String[] valeurs=line.split(",");
                if (valeurs.length==5) {
                    Membre membre=new Membre(valeurs[1], valeurs[2], valeurs[3], valeurs[4]);
                    membres.add(membre);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur :  " + e.getMessage());
        }
        return membres;
    }
}