package com.example.demo.pojo;

public class Membre {


    private String nom;

    private String pays;

    private String instrument;

    private Integer dateDebut;

    private Integer dateFin;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    public Integer getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Integer dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Integer getDateFin() {
        return dateFin;
    }

    public void setDateFin(Integer dateFin) {
        this.dateFin = dateFin;
    }
}
