package com.amoa.studentsdb;

public class Etudiant {
    // attr
    private long id;
    private String nom;
    private String prenom;
    private String filiere;
    private String phone;
    private  String email;
    //constructors

    public Etudiant(String nom,String prenom,String filiere,String phone,String email){
        this.nom=nom;
        this.prenom=prenom;
        this.filiere=filiere;
        this.phone = phone;
        this.email = email;
    }
    public Etudiant(long id,String nom,String prenom,String filiere){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.filiere=filiere;


    }
    // getters & setters
    public long getId(){return id;}
    public void setId(long id){this.id = id;}
    //******************************************
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    //******************************************
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    //*****************************************
    public String getFiliere() {
        return filiere;
    }
    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    //*****************************************
    public String getPhone() { return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    //*****************************************
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email;}
    //*****************************************
    public String toString(){
        return id+" "+" "+nom+" "+prenom+" "+filiere;
    }
}
