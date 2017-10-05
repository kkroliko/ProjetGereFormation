package com.maryvone.gereformation.dao;

import src.com.maryvone.gereformation.dao.DBConnect;
import com.maryvone.gereformation.model.Personnel;

import java.sql.*;
import java.util.ArrayList;

public class PersonnelDAO {

    public static void create(Personnel personnel) throws Exception {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;
        try {
            stm = c.prepareStatement("INSERT INTO personnel( nom,prenom,utilisateur,motDePasse,role,email) VALUES (?,?,?,?,?,?) ");
            stm.setString(1,personnel.getNom());
            stm.setString(2,personnel.getPrenom());
            stm.setString(3,personnel.getUtilisateur());
            stm.setString(4,personnel.getMotDePasse());
            stm.setString(5,personnel.getRole());
            stm.setString(6,personnel.getEmail());
            stm.execute();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static ArrayList<Personnel> findAll() {
        ArrayList <Personnel> personnels = new ArrayList<>();
        Statement stm;
        Connection c = DBConnect.getConnection();
        String sql = "SELECT * FROM personnel";
        try {
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String nom= rs.getString("nom");
                String prenom= rs.getString("prenom");
                String utilisateur = rs.getString("utilisateur");
                String motDePasse = rs.getString("motDePasse");
                String role = rs.getString("role");
                String email = rs.getString("email");

                Personnel personnel = new Personnel(id,nom , prenom , utilisateur , motDePasse , role , email);
                personnels.add(personnel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return personnels;
    }
    public static Personnel findById (int id) throws SQLException {
        Personnel personnel = null;
        Connection c = DBConnect.getConnection();
        Statement stm;
        try {
            stm = c.createStatement();

            String sql = "select * from personnel WHERE id=" + id;
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                String nom= rs.getString("nom");
                String prenom= rs.getString("prenom");
                String utilisateur = rs.getString("utilisateur");
                String motDePasse = rs.getString("motDePasse");
                String role = rs.getString("role");
                String email = rs.getString("email");

                personnel = new Personnel(id,nom , prenom , utilisateur , motDePasse , role , email);


            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return personnel;
    }

    public static void update(Personnel personnel) {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        try {
            stm = c.prepareStatement("UPDATE personnel SET nom = ?, prenom = ?, utilisateur = ?, motDePasse = ?, role = ?, email = ? WHERE id = ?");

            stm.setString(1, personnel.getNom());
            stm.setString(2, personnel.getPrenom());
            stm.setString(3, personnel.getUtilisateur());
            stm.setString(4, personnel.getMotDePasse());
            stm.setString(5, personnel.getRole());
            stm.setString(6, personnel.getEmail());
            stm.setInt(7, personnel.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void delete(Personnel personnel) {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        try {
            stm = c.prepareStatement("DELETE FROM personnel WHERE id = ?");

            stm.setInt(1, personnel.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
