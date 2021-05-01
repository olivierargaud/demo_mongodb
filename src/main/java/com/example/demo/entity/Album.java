package com.example.demo.entity;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "albums")
public class Album {


    @Id
    private String id;

    @Field(value="alb_art")
    private String artist;

    @Field(value="alb_img")
    private Binary image;

    @Field(value="alb_nom")
    private String nom;

    @Field(value="alb_prix")
    private Float prix;

    @Field(value="alb_annee")
    private Integer anneeDeSortie;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Integer getAnneeDeSortie() {
        return anneeDeSortie;
    }

    public void setAnneeDeSortie(Integer anneeDeSortie) {
        this.anneeDeSortie = anneeDeSortie;
    }
}
