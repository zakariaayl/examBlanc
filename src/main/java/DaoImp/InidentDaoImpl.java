package DaoImp;

import Dao.IncidentDao;
import java.sql.Connection;

import models.Incident;
import  java.sql.DriverManager;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;
import java.util.UUID;

public class InidentDaoImpl implements IncidentDao {
    @Override
    public void inserer(Incident i) {
         String url="jdbc:mysql://localhost:3306/gest";
         String name="root";
         String passwd="root";
         try {
             Connection conn =DriverManager.getConnection(url, name, passwd);
             String ref= String.valueOf(UUID.randomUUID());
             String sql="INSERT INTO incident VALUES(?,?,?,?)";
             PreparedStatement stmt=conn.prepareStatement(sql);
             stmt.setString(1,ref);
             stmt.setString(2,i.getStatus());
             stmt.setDate(3,(java.sql.Date)i.getTime());
             stmt.setString(4,i.getIdmembre());
             stmt.executeUpdate();
         }catch(SQLException e){
             e.printStackTrace();
         }

    }

    @Override
    public void inser(Set<Incident> is) {
        for(Incident i : is ){
            inserer(i);
        }
    }
}
