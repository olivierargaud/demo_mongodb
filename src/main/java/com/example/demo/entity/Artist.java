package com.example.demo.entity;


import com.example.demo.pojo.Membre;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;

@Document(collection = "artists")
public class Artist {


    @Id
    private String id;

    @Field(value="art_nom")
    private String nom;

    @Field(value="art_typ")
    private String type;

    @Field(value="art_pays")
    private String pays;

    @Field(value="art_genre")
    private String genre;

    @Field(value="art_membres")
    private ArrayList<Membre> membres;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ArrayList<Membre> getMembres() {
        return membres;
    }

    public void setMembres(ArrayList<Membre> membres) {
        this.membres = membres;
    }
}

