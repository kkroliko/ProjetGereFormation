package com.maryvone.gereformation.model;

import java.util.ArrayList;
import java.sql.Date;


public class Formation  {
private String libelle, description,lieu;
private int id, nbheures,codeFormation;
private ArrayList<Module> modules;
private Personnel formateur;
private Date dateDebut;

    public Formation(String libelle, String description, String lieu, int nbheures, int codeFormation, ArrayList<Module> modules, Personnel formateur, Date dateDebut) {
        this.libelle = libelle;
        this.description = description;
        this.lieu = lieu;
        this.nbheures = nbheures;
        this.codeFormation = codeFormation;
        this.modules = modules;
        this.formateur = formateur;
        this.dateDebut = dateDebut;
        this.id=-1;
    }

    public Formation(String libelle, String description, String lieu, int id, int nbheures, int codeFormation, ArrayList<Module> modules, Personnel formateur, Date dateDebut) {
        this.libelle = libelle;
        this.description = description;
        this.lieu = lieu;
        this.id = id;
        this.nbheures = nbheures;
        this.codeFormation = codeFormation;
        this.modules = modules;
        this.formateur = formateur;
        this.dateDebut = dateDebut;

    }

    public Formation(String libelle, String description, String lieu, int nbheures, int codeFormation, Date dateDebut) {
        this.libelle = libelle;
        this.description = description;
        this.lieu = lieu;
        this.nbheures = nbheures;
        this.codeFormation = codeFormation;
        this.dateDebut = dateDebut;
    }

    public Formation(int id, String nom, String description) {
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public int getNbheures() {
        return nbheures;
    }

    public void setNbheures(int nbheures) {
        this.nbheures = nbheures;
    }

    public int getCodeFormation() {
        return codeFormation;
    }

    public void setCodeFormation(int codeFormation) {
        this.codeFormation = codeFormation;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public Personnel getFormateur() {
        return formateur;
    }

    public void setFormateur(Personnel formateur) {
        this.formateur = formateur;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getId() {
        return id;
    }


}
