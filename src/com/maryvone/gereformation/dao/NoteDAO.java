package com.maryvone.gereformation.dao;

import src.com.maryvone.gereformation.dao.DBConnect;
import com.maryvone.gereformation.model.ECF;
import com.maryvone.gereformation.model.Note;
import com.maryvone.gereformation.model.Stagiaire;

import java.sql.*;
import java.util.ArrayList;

public class NoteDAO {

    // ***********************Create******************

    public static void create(int note, ECF ecf, Stagiaire stagiaire) throws SQLException {


            Connection c = DBConnect.getConnection();
            PreparedStatement stm;

            stm = c.prepareStatement("INSERT INTO gestionECF ( idStagiaire,idECF, note) VALUES (?,?,?) ");
            stm.setInt(1,stagiaire.getId());
            stm.setInt(2,ecf.getId());
            stm.setInt(3,note);
            stm.execute();
            stm.close();

    }

    //*************TOUS LES NOTES DE TOUS LES STAGIAIRES
    public static ArrayList<Note> findall() throws SQLException {
            ECF ecf;
            Stagiaire stagiaire;
            ArrayList<Note> notes = new ArrayList<>();
            Connection c = DBConnect.getConnection();
            Statement stm;
            String sql = " SELECT note,stagiaire.nom,ECF.nom FROM gestionECF INNER JOIN ECF ON idECF = ECF.id INNER JOIN stagiaire ON idStagiaire=stagiaire.id";
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {

                stagiaire = StagiaireDAO.findOneById(rs.getInt("idStagiaire"));
                ecf = ECFDAO.findonebyID(rs.getInt("idECF"));
                int noteecf =rs.getInt("note");
                Note note = new Note(noteecf,stagiaire,ecf);
                notes.add(note);
            }
            return notes;


    }
    //************TOUTES LES NOTES D'UN STAGIAIRE

    public static ArrayList<Note> findAllByStagiaireId(int idStagiaire) throws SQLException {
        ECF ecf;
        ArrayList<Note> notes = new ArrayList<>();
        Stagiaire stagiaire = StagiaireDAO.findOneById(idStagiaire);
        Connection c = DBConnect.getConnection();
        Statement stm;
        String sql = "SELECT note,stagiaire.nom,ECF.nom FROM gestionECF INNER JOIN ECF ON idECF = ECF.id INNER JOIN stagiaire ON idStagiaire=stagiaire.id WHERE idStagiaire="+idStagiaire;
        stm = c.createStatement();
        ResultSet rs = stm.executeQuery(sql);


        while (rs.next()) {


            ecf = ECFDAO.findonebyID(rs.getInt("idECF"));
            int noteecf =rs.getInt("note");
            Note note = new Note(noteecf,stagiaire,ecf);
            notes.add(note);
        }
        return notes;

    }

    //************TOUTES LES NOTES D'UN ECF

    public static ArrayList<Note> findAllByECFId(int idECF) throws SQLException {
        ECF ecf = ECFDAO.findonebyID(idECF);
        Stagiaire stagiaire;
        ArrayList<Note> notes = new ArrayList<>();
        Connection c = DBConnect.getConnection();
        Statement stm;
        String sql = "SELECT note,stagiaire.nom,ECF.nom FROM gestionECF INNER JOIN ECF ON idECF = ECF.id INNER JOIN stagiaire ON idStagiaire=stagiaire.id WHERE idECF="+idECF;
        stm = c.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {

            stagiaire = StagiaireDAO.findOneById(rs.getInt("idStagiaire"));
            int noteecf =rs.getInt("note");
            Note note = new Note(noteecf,stagiaire,ecf);
            notes.add(note);
        }
        return notes;


    }

    //************LA NOTE D'UN STAGIAIRE POUR UN ECF


    public static Note findOne(Stagiaire stagiaireobj, ECF ecfobj){

        Connection c = DBConnect.getConnection();
        PreparedStatement stm;
        Note note=null;

        try {
            stm = c.prepareStatement("SELECT note,stagiaire.nom,ECF.nom FROM gestionECF INNER JOIN ECF ON idECF = ECF.id INNER JOIN stagiaire ON idStagiaire=stagiaire.id WHERE idStagiaire=? AND idECF=?");
            stm.setInt(1, stagiaireobj.getId());
            stm.setInt(2,ecfobj.getId());

            ResultSet rs=stm.executeQuery();
            if (rs.next()) {

                int notation = rs.getInt("note");
                note = new Note(notation,stagiaireobj,ecfobj);



            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return note;
    }
}
