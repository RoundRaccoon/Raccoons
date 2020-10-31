package com.example.raccoons;

public class Categorie {

    private String imagine,nume;

    public Categorie(){}

    public Categorie(String imagine, String nume) {
        this.imagine = imagine;
        this.nume = nume;
    }

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
}
