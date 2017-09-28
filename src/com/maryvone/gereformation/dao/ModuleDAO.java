package com.maryvone.gereformation.dao;

import com.maryvone.gereformation.model.*;

import java.sql.*;
import java.util.ArrayList;

public class ModuleDAO {

    //******************** CREATE ***************************

    public static void create(Module module) throws Exception {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        stm = c.prepareStatement("INSERT INTO module(libelle,description,duree) VALUES (?,?,?) ");

        stm.setString(1,module.getLibelle());
        stm.setString(2,module.getDescription());
        stm.setInt(3,module.getDuree());

        stm.execute();
        stm.close();


    }

    // **************************  READ **************************

    public static Module findonebyID (int id) throws SQLException {
        Module module = null;
        Connection c = DBConnect.getConnection();
        Statement stm;
        try {
            stm = c.createStatement();

            String sql = "select * from module WHERE id=" + id;
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                String libelle= rs.getString("libelle");
                String description = rs.getString("description");
                int duree = rs.getInt("duree");
                ArrayList<Sequence> idSequences = getSequences(id);

                module = new Module(id,duree,libelle,description,idSequences);


            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return module;
    }

    public static ArrayList<Module> findAll () throws SQLException {
        ArrayList<Module> modules = new ArrayList<>();
        Connection c = DBConnect.getConnection();
        Statement stm;
        String sql = "SELECT * FROM module";
        stm = c.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {

            int id = rs.getInt("id");
            String libelle= rs.getString("libelle");
            String description= rs.getString("description");
            ArrayList<Sequence> idSequences = getSequences(id);
            int duree = rs.getInt("duree");


            Module module = new Module(id , duree , libelle,description,idSequences);
            modules.add(module);
        }
        return modules;
    }

    public static ArrayList<Sequence> getSequences(int moduleid) throws SQLException {

        ArrayList<Sequence> sequences = new ArrayList<>();
        Connection c =DBConnect.getConnection();
        Statement stm;
        String sql="SELECT * FROM sequence INNER JOIN gestionSequence ON id=gestionSequence.idSequence WHERE idmodule ="+moduleid;
        stm= c.createStatement();
        ResultSet rs =stm.executeQuery(sql);

        while(rs.next()){
            int id=rs.getInt("id");
            String nom= rs.getString("nom");
            String description = rs.getString("description");

            Sequence sequence = new Sequence(id,nom,description);
            sequences.add(sequence);
        }
        return sequences;
    }


    //******************************** UPDATE *************************

    public static void update(Module module) {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        try {
            stm = c.prepareStatement("UPDATE module SET libelle = ?, description = ?, SET duree = ? WHERE id = ?");

            stm.setString(1, module.getLibelle());
            stm.setString(2, module.getDescription());
            stm.setInt(3, module.getDuree());
            stm.setInt(4, module.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //************************************* DELETE ************************

    public static void delete(Module module) {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        try {
            stm = c.prepareStatement("DELETE FROM module WHERE id = ?");
            stm.setInt(1, module.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
