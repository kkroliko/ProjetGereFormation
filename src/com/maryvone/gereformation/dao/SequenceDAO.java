package com.maryvone.gereformation.dao;

import com.maryvone.gereformation.model.Personnel;
import com.maryvone.gereformation.model.Sequence;

import java.sql.*;
import java.util.ArrayList;

public class SequenceDAO {

    public static void create(Sequence sequence) throws Exception {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;
        try {
            stm = c.prepareStatement("INSERT INTO sequence( nom,description) VALUES (?,?) ");
            stm.setString(1,sequence.getNom());
            stm.setString(2,sequence.getDescription());
            stm.execute();
            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Sequence> findAll() {
        ArrayList <Sequence> sequences = new ArrayList<>();
        Statement stm;
        Connection c = DBConnect.getConnection();
        String sql = "SELECT * FROM sequence";
        try {
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String nom= rs.getString("nom");
                String description= rs.getString("description");


                Sequence sequence = new Sequence(id,nom , description);
                sequences.add(sequence);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return sequences;
    }
    public static Sequence findById (int id) throws SQLException {
        Sequence sequence = null;
        Connection c = DBConnect.getConnection();
        Statement stm;
        try {
            stm = c.createStatement();

            String sql = "select * from sequence WHERE id=" + id;
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                String nom= rs.getString("nom");
                String description = rs.getString("description");

                sequence = new Sequence(id, nom , description);


            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return sequence;
    }
    public static void update(Sequence sequence) {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        try {
            stm = c.prepareStatement("UPDATE sequence SET nom = ?, description = ? WHERE id = ?");

            stm.setString(1, sequence.getNom());
            stm.setString(2, sequence.getDescription());
            stm.setInt(3, sequence.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void delete(Sequence sequence) {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        try {
            stm = c.prepareStatement("DELETE FROM sequence WHERE id = ?");

            stm.setInt(1, sequence.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
