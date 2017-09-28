package com.maryvone.gereformation.model;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Sequence  {
    private int id;
    private String nom,description;

    public Sequence(String nom, String description) {
        this.nom = nom;
        this.description = description;
        this.id = -1;
    }


    public Sequence(int id, String nom, String description) {
        this.id = id;
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }



}

