package com.maryvone.gereformation.dao;

import com.maryvone.gereformation.model.Formation;
import com.maryvone.gereformation.model.Module;
import com.maryvone.gereformation.model.Personnel;
import com.maryvone.gereformation.model.Stagiaire;

import java.sql.*;
import java.text.Format;
import java.util.ArrayList;
import java.sql.Date;

public class StagiaireDAO {

    // ******* CREATE **********

    public static void create(Stagiaire stagiaire) throws Exception {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

            stm = c.prepareStatement("INSERT INTO stagiaire( nom,prenom, adresse,codePostal,ville, mail,telephone) VALUES (?,?,?,?,?,?,?) ");
            stm.setString(1,stagiaire.getNom());
            stm.setString(2,stagiaire.getPrenom());
            stm.setString(3,stagiaire.getAdresse());
            stm.setInt(4,stagiaire.getCodePostal());
            stm.setString(5,stagiaire.getVille());
            stm.setString(6,stagiaire.getTelephone());
            stm.setString(7,stagiaire.getMail());
            stm.execute();
            stm.close();


    }

    // **************************  READ **************************


    public static Stagiaire findOneById(int id){

        Stagiaire stagiaire = null;
        Connection c = DBConnect.getConnection();
        Statement stm;
        try {
            stm = c.createStatement();

            String sql = "select * from stagiaire WHERE id=" + id;
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {

                String nom = rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");
                int codePostal = rs.getInt("codePostal");
                String ville = rs.getString("ville");
                String mail = rs.getString("mail");
                String telephone = rs.getString("telephone");

                stagiaire = new Stagiaire(id, nom,prenom,adresse,codePostal,  ville,  mail,  telephone);


            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException();
        }



        return stagiaire;
    }
    public static ArrayList<Stagiaire> findAll() {
        ArrayList<Stagiaire> stagiaires = new ArrayList<>();
        Statement stm;
        Connection c = DBConnect.getConnection();
        String sql = "SELECT * FROM stagiaire";
        try {
            stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String nom= rs.getString("nom");
                String prenom= rs.getString("prenom");
                ArrayList<Formation> formations =getFormations(id);
                String adresse = rs.getString("adresse");
                int codePostal = rs.getInt("codePostal");
                String ville = rs.getString("ville");
                String mail = rs.getString("mail");
                String telephone = rs.getString("telephone");


                Stagiaire stagiaire = new Stagiaire(id,nom , prenom,formations,adresse,codePostal,ville,mail,telephone);
                stagiaires.add(stagiaire);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stagiaires;
    }

    public static ArrayList<Stagiaire> findByFormationId (int idFormation) throws SQLException {
       ArrayList<Stagiaire> stagiaires = new ArrayList<>();
        Connection c = DBConnect.getConnection();
        Statement stm;
        try {
            stm = c.createStatement();

            String sql = "select * from stagiaire WHERE idFormation" + idFormation;
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String nom= rs.getString("nom");
                String prenom = rs.getString("prenom");
                String adresse = rs.getString("adresse");
                int codePostal = rs.getInt("codePostal");
                String ville = rs.getString("ville");
                String mail = rs.getString("mail");
                String telephone = rs.getString("telephone");

                Stagiaire stagiaire = new Stagiaire(id,nom,prenom,adresse,codePostal,ville,mail,telephone);
                stagiaires.add(stagiaire);


            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return stagiaires;
    }

    public static ArrayList<Formation> getFormations(int stagiaireId) throws SQLException {
        ArrayList<Module> modules;
        ArrayList<Formation> formations = new ArrayList<>();
        Connection c =DBConnect.getConnection();
        Statement stm;
        String sql="SELECT * FROM formation INNER JOIN gestionFormation ON id=gestionFormation.idFormation WHERE idstagiaire ="+stagiaireId;
        stm= c.createStatement();
        ResultSet rs =stm.executeQuery(sql);

        while(rs.next()){
            int id=rs.getInt("id");
            String libelle= rs.getString("libelle");
            String description = rs.getString("description");
            int nbHeures = rs.getInt("nbHeures");
            String lieu = rs.getString("lieu");
            Date dateDebut = rs.getDate("dateDebut");
            Personnel formateur = PersonnelDAO.findById(rs.getInt("idFormateur"));
            int codeFormation = rs.getInt("codeFormation");
            modules=FormationDAO.getModules(id);


            Formation formation = new Formation(libelle, description, lieu, id, nbHeures, codeFormation, modules, formateur, dateDebut);
            formations.add(formation);
        }
        return formations;
    }


    //******************************** UPDATE *************************

    public static void updateContact(Stagiaire stagiaire){

        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        try {
            stm = c.prepareStatement("UPDATE stagiaire SET nom = ?, prenom = ?, adresse = ?, codePostal = ?, ville = ?, mail=?, telephone = ? WHERE id = ?");

            stm.setString(1, stagiaire.getNom());
            stm.setString(2, stagiaire.getPrenom());
            stm.setString(3, stagiaire.getAdresse());
            stm.setInt(4, stagiaire.getCodePostal());
            stm.setString(5, stagiaire.getVille());
            stm.setString(6,stagiaire.getMail());
            stm.setString(7,stagiaire.getTelephone());
            stm.setInt(8,stagiaire.getId());

            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //************************************* DELETE ************************

    public static void delete(Stagiaire stagiaire) {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        try {
            stm = c.prepareStatement("DELETE FROM stagiaire WHERE id = ?");

            stm.setInt(1, stagiaire.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
