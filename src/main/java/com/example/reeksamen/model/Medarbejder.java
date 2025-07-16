package com.example.reeksamen.model;

public class Medarbejder {

    private int medarbejderId;
    private String navn;
    private String email;
    private String adgangskode;
    private Rolle rolle;



    public enum Rolle
    {
        DATAREGISTERING,
        FORRETNINGSUDVIKLER,
        SKADESMEDARBEJDER,
        FDM
    }

    public Medarbejder() {}

    public Medarbejder(Integer medarbejderId, String navn, String email, String adgangskode, Rolle rolle) {
        this.medarbejderId = medarbejderId;
        this.navn = navn;
        this.email = email;
        this.adgangskode = adgangskode;
        this.rolle = rolle;
    }


    public Integer getMedarbejderId() {
        return medarbejderId;
    }


    public void setMedarbejderId(Integer medarbejderId) {
        this.medarbejderId = medarbejderId;
    }


    public String getNavn() {
        return navn;
    }


    public void setNavn(String navn) {
        this.navn = navn;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getAdgangskode() {
        return adgangskode;
    }


    public void setAdgangskode(String adgangskode) {
        this.adgangskode = adgangskode;
    }


    public Rolle getRolle() {
        return rolle;
    }


    public void setRolle(Rolle rolle) {
        this.rolle = rolle;
    }
}

