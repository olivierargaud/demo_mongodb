package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Commande")
public class Commande {


    @Id
    private String id;

    @Field(value="resistance")
    private String resistance;

    @Field(value="traitement")
    private String traitement;

    @Field(value="nomEntreprise")
    private String nomEntreprise;

    @Field(value="prenomContact")
    private String prenomContact;

    @Field(value="nomContact")
    private String nomContact;

    @Field(value="telContact")
    private String telContact;

    @Field(value="mailContact")
    private String mailContact;

    @Field(value="idFabriquant")
    private String idFabriquant;

    @Field(value="prenomFabriquant")
    private String prenomFabriquant;

    @Field(value="nomFabriquant")
    private String nomFabriquant;

    public Commande() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResistance() {
        return resistance;
    }

    public void setResistance(String resistance) {
        this.resistance = resistance;
    }

    public String getTraitement() {
        return traitement;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }

    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getPrenomContact() {
        return prenomContact;
    }

    public void setPrenomContact(String prenomContact) {
        this.prenomContact = prenomContact;
    }

    public String getNomContact() {
        return nomContact;
    }

    public void setNomContact(String nomContact) {
        this.nomContact = nomContact;
    }

    public String getTelContact() {
        return telContact;
    }

    public void setTelContact(String telContact) {
        this.telContact = telContact;
    }

    public String getMailContact() {
        return mailContact;
    }

    public void setMailContact(String mailContact) {
        this.mailContact = mailContact;
    }

    public String getIdFabriquant() {
        return idFabriquant;
    }

    public void setIdFabriquant(String idFabriquant) {
        this.idFabriquant = idFabriquant;
    }

    public String getPrenomFabriquant() {
        return prenomFabriquant;
    }

    public void setPrenomFabriquant(String prenomFabriquant) {
        this.prenomFabriquant = prenomFabriquant;
    }

    public String getNomFabriquant() {
        return nomFabriquant;
    }

    public void setNomFabriquant(String nomFabriquant) {
        this.nomFabriquant = nomFabriquant;
    }
}
