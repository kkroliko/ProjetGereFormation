package src.com.maryvone.gereformation.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.Class;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBConnect {


    private static Connection conn = null;
    final static String URL = "jdbc:mysql://localhost:3306/GereFormation";

    public static Connection getConnection() {

        if (conn == null) {

            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(URL, "root", "Wowzillah");
            } catch (SQLException sqlE) {
                System.out.println("Sql Erreur " + sqlE.getMessage());
                throw new RuntimeException();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return conn;
    }
}
