package com.maryvone.gereformation.model;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Module  {

    private int id,duree;
    private String libelle, description;
    private ArrayList<Sequence> sequences;

  public Module(int duree, String libelle, String description, ArrayList<Sequence> sequences) {
       this.duree = duree;
       this.libelle = libelle;
      this.description = description;
      this.sequences = sequences;
       this.id = -1;
   }



    public Module(int id, int duree, String libelle, String description, ArrayList<Sequence> sequences) {
        this.id = id;
        this.duree = duree;
        this.libelle = libelle;
        this.description = description;
        this.sequences = sequences;
    }

    public Module(int duree, String libelle, String description) {
        this.duree = duree;
        this.libelle = libelle;
        this.description = description;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
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


    public ArrayList<Sequence> getSequences() {
        return sequences;
    }

    public void setSequences(ArrayList<Sequence> sequences) {
        this.sequences = sequences;
    }

    public int getId() {
        return id;
    }


}
