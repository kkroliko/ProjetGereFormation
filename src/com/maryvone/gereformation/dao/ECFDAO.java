
package com.maryvone.gereformation.dao;

import com.maryvone.gereformation.model.*;

import java.sql.*;
import java.util.ArrayList;

public class ECFDAO {

   //**************** CREATE *******************************

    public static void create(ECF ecf) throws Exception {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        stm = c.prepareStatement("INSERT INTO ECF ( nom) VALUES (?) ");
        stm.setString(1,ecf.getNom());

        stm.execute();
        stm.close();


    }

    //**************** READ ********************

    public static ArrayList<ECF> findAll () throws SQLException {
        Module module;
        ArrayList<ECF> ecfs = new ArrayList<>();
        Connection c = DBConnect.getConnection();
        Statement stm;
        String sql = "SELECT * FROM ECF";
        stm = c.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {

            int id = rs.getInt("id");
            String nom= rs.getString("nom");
            int moduleid =rs.getInt("idModule");
            module = ModuleDAO.findonebyID (moduleid);
            ECF ecf = new ECF(id,nom,module);
            ecfs.add(ecf);
        }
        return ecfs;
    }

    public static ECF findonebyID (int id) throws SQLException {
        ECF ecf = null;
        Module module = null;
        Connection c = DBConnect.getConnection();
        Statement stm;
        try {
            stm = c.createStatement();

            String sql = "select * from ECF WHERE id=" + id;
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {

                String nom = rs.getString("nom");
                int idModule = rs.getInt("idModule");
                module = ModuleDAO.findonebyID (idModule);

                ecf = new ECF(id, nom, module);


            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return ecf;
    }

    //******************************** UPDATE *************************

    public static void update(ECF ecf) {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        try {
            stm = c.prepareStatement("UPDATE ECF SET nom = ?, WHERE id = ?");

            stm.setString(1, ecf.getNom());

            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //************************************* DELETE ************************

    public static void delete(ECF ecf) {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        try {
            stm = c.prepareStatement("DELETE FROM ECF WHERE id = ?");
            stm.setInt(1, ecf.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // ********************* Method for Notes **************************






}
