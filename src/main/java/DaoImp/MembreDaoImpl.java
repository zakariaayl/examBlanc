package DaoImp;

import Dao.MembreDao;
import models.Incident;
import models.Membre;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MembreDaoImpl implements MembreDao {

    @Override
    public void insere(Membre m) throws IOException {
        String url="jdbc:mysql://localhost:3306/gest";
        String name="root";
        String passwd="root";
        try {
            Connection conn = DriverManager.getConnection(url, name, passwd);
            String id= String.valueOf(UUID.randomUUID());
            String sql="INSERT INTO incident VALUES(?,?,?,?,?)";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,id);
            stmt.setString(2,m.getNom());
            stmt.setString(3,m.getPrenom());
            stmt.setString(4,m.getEmail());
            stmt.setString(5,m.getPhone());
            stmt.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Incident> list() {
        String url="jdbc:mysql://localhost:3306/gest";
        String name="root";
        String passwd="root";
        try {
            Connection conn = DriverManager.getConnection(url, name, passwd);
            String sql="SELECT * FROM incident";
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            List<Incident> li=new ArrayList<>();
            while(rs.next()){

                li.add(new Incident(rs.getString(1),rs.getString(2),rs.getTime(3)));
            }
            return li;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}