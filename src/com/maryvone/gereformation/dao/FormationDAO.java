package com.maryvone.gereformation.dao;

import src.com.maryvone.gereformation.dao.DBConnect;
import com.maryvone.gereformation.model.*;

import java.sql.*;
import java.util.ArrayList;

public class FormationDAO {

    //******************** CREATE ***************************

    public static void create(Formation formation) throws Exception {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        stm = c.prepareStatement("INSERT INTO formation( libelle,description, nbHeures,lieu,dateDebut, codeFormation) VALUES (?,?,?,?,?,?) ");
        stm.setString(1,formation.getLibelle());
        stm.setString(2,formation.getDescription());
        stm.setInt(3,formation.getNbheures());
        stm.setString(4,formation.getLieu());
        stm.setDate(5,formation.getDateDebut());
        stm.setInt(6,formation.getCodeFormation());
        stm.execute();
        stm.close();


    }

    // **************************  READ **************************

    public static Formation findonebyID (int id) throws SQLException {
        Formation formation = null;
        Connection c = DBConnect.getConnection();
        Statement stm;
        try {
            stm = c.createStatement();

            String sql = "select * from formation WHERE id=" + id;
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                String nom= rs.getString("nom");
                String description = rs.getString("description");

               formation = new Formation(id, nom , description);


            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return formation;
    }

    public static ArrayList<Formation> findAll () throws SQLException {
        ArrayList<Formation> formations = new ArrayList<>();
        Connection c = DBConnect.getConnection();
        Statement stm;
        String sql = "SELECT * FROM formation";
        stm = c.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {

            int id = rs.getInt("id");
            String libelle= rs.getString("libelle");
            String description= rs.getString("description");
            int nbheures = rs.getInt("nbHeures");
            String lieu= rs.getString("lieu");
            Date dateDebut= rs.getDate("dateDebut");
            ArrayList<Module> modules = getModules(id);
            Personnel formateur = PersonnelDAO.findById(rs.getInt("idFormateur"));
            int codeFormation = rs.getInt("codeFormation");


            Formation formation = new Formation(libelle,description,lieu,id,nbheures,codeFormation,modules,formateur,dateDebut);
            formations.add(formation);
        }
        return formations;
    }
    public static ArrayList<Module> getModules(int formationid) throws SQLException {

        ArrayList<Module> modules = new ArrayList<>();
        Connection c =DBConnect.getConnection();
        Statement stm;
        String sql="SELECT * FROM Module INNER JOIN gestionModule ON id=gestionModule.idmodule WHERE idformation ="+formationid;
        stm= c.createStatement();
        ResultSet rs =stm.executeQuery(sql);

        while(rs.next()){
            int id=rs.getInt("id");
            String libelle= rs.getString("libelle");
            String description = rs.getString("description");
            int duree = rs.getInt("duree");
            ArrayList<Sequence> idSequences = ModuleDAO.getSequences(id);

           Module module = new Module(id,duree,libelle,description,idSequences);
            modules.add(module);
        }
      return modules;
    }

    //******************************** UPDATE *************************

    public static void update(Formation formation) {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        try {
            stm = c.prepareStatement("UPDATE formation SET libelle = ?, description = ?, nbHeures = ?, lieu = ?, dateDebut = ?, codeFormation = ? WHERE id = ?");

            stm.setString(1, formation.getLibelle());
            stm.setString(2, formation.getDescription());
            stm.setInt(3, formation.getNbheures());
            stm.setString(4, formation.getLieu());
            stm.setDate(5, formation.getDateDebut());
            stm.setInt(6, formation.getCodeFormation());
            stm.setInt(7, formation.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //************************************* DELETE ************************

    public static void delete(Formation formation) {
        Connection c = DBConnect.getConnection();
        PreparedStatement stm;

        try {
            stm = c.prepareStatement("DELETE FROM formation WHERE id = ?");
            stm.setInt(1, formation.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
