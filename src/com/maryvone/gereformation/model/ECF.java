package com.maryvone.gereformation.model;

import java.util.ArrayList;

public class ECF {

    private int id;
    private String nom;
    private Module idModule;

    public ECF( String nom, Module idModule) {
        this.id = -1;
        this.nom = nom;
        this.idModule = idModule;
    }

    public ECF(int id, String nom, Module idModule) {
        this.id = id;
        this.nom = nom;
        this.idModule = idModule;
    }

    public ECF(String nom) {
        this.nom = nom;
        this.idModule= null;
        this.id=-1;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Module getIdModule() {
        return idModule;
    }

    public void setIdModule(Module idModule) {
        this.idModule = idModule;
    }

    public int getId() {
        return id;
    }
}
