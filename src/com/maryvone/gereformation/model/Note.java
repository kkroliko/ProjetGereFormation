package com.maryvone.gereformation.model;

public class Note {

    private Stagiaire stagiaire;
    private ECF ecf;
    private int note;

    public Note(int note) {
        this.note = note;
        this.stagiaire = null;
        this.ecf=null;
    }

    public Note (int note,  Stagiaire stagiaire, ECF ecf){
        this.note =note;
        this.stagiaire=stagiaire;
        this.ecf=ecf;


    }

    public Stagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }

    public ECF getEcf() {
        return ecf;
    }

    public void setEcf(ECF ecf) {
        this.ecf = ecf;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
