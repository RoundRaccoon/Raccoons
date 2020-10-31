package com.example.raccoons;

public class Haina {

    private String imagine,nume,detalii;

    public Haina(){

    }

    public Haina(String imagine, String nume, String detalii){

        this.imagine = imagine;
        this.nume = nume;
        this.detalii = detalii;

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

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }
}
