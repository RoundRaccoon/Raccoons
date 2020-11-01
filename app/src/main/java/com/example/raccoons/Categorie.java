package com.example.raccoons;

public class Categorie {

    private String imagine,nume,imagine2;

    public Categorie(){}

    public Categorie(String imagine, String nume,String imagine2) {
        this.imagine = imagine;
        this.nume = nume;
        this.imagine2 = imagine2;
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

    public String getImagine2() {
        return imagine2;
    }

    public void setImagine2(String imagine2) {
        this.imagine2 = imagine2;
    }
}
