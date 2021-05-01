package com.example.demo.entity;


import com.example.demo.pojo.Client;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "artists")
public class Vente {


    @Id
    private String id;

    @Field(value="ven_alb_nom")
    private String nom;

    @Field(value="ven_prix")
    private Float image;

    @Field(value="ven_date")
    private Date dateVente;

    @Field(value="ven_client")
    private Client client;

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

    public Float getImage() {
        return image;
    }

    public void setImage(Float image) {
        this.image = image;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
