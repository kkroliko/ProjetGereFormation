package com.maryvone.gereformation.model;

import com.maryvone.gereformation.dao.PersonnelDAO;

import java.util.Scanner;

public class Personnel {
    private int id;
    private String nom,prenom,utilisateur,motDePasse,email, role;

    public Personnel(String nom, String prenom, String utilisateur, String motDePasse, String email, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.utilisateur = utilisateur;
        this.motDePasse = motDePasse;
        this.email = email;
        this.role = role;
        this.id =-1;
    }

    public Personnel( int id, String nom, String prenom, String utilisateur, String motDePasse, String email, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.utilisateur = utilisateur;
        this.motDePasse = motDePasse;
        this.email = email;
        this.role = role;
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }


    public void affDesc (){
        System.out.println(this.getId()+" "+ this.getNom()+" "+this.getPrenom()+" "+this.getUtilisateur()+" "+this.getEmail());
    }

}
