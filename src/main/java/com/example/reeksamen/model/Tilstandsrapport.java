package com.example.reeksamen.model;


import java.time.LocalDate;


public class Tilstandsrapport
{
    private int tilstandsrapportId;
    private int bilId;
    private int kontraktId;
    private LocalDate tilstandsrapportDato;
    private int medarbejderId;
    private boolean erSkadet;


    public Tilstandsrapport(){}

    public Tilstandsrapport (int tilstandsrapportId, int bilId, int kontraktId, LocalDate tilstandsrapportDato, int medarbejderId, Boolean erSkadet )
    {
        this.tilstandsrapportId = tilstandsrapportId;
        this.bilId = bilId;
        this.kontraktId = kontraktId;
        this.tilstandsrapportDato = tilstandsrapportDato;
        this.medarbejderId = medarbejderId;
        this.erSkadet = erSkadet;
    }


    public int getTilstandsrapportId() {
        return tilstandsrapportId;
    }
    public void setTilstandsrapportId(int tilstandsrapportId) {
        this.tilstandsrapportId = tilstandsrapportId;
    }
    public int getBilId() {
        return bilId;
    }
    public void setBilId(int bilId) {
        this.bilId = bilId;
    }
    public int getKontraktId() {
        return kontraktId;
    }
    public void setKontraktId(int kontraktId) {
        this.kontraktId = kontraktId;
    }
    public LocalDate getTilstandsrapportDato() {

        return tilstandsrapportDato;
    }
    public void setTilstandsrapportDato(LocalDate tilstandsrapportDato) {
        this.tilstandsrapportDato = tilstandsrapportDato;
    }
    public boolean isErSkadet() {
        return erSkadet;
    }
    public void setErSkadet(boolean erSkadet) {
        this.erSkadet = erSkadet;
    }

    public int getMedarbejderId() {
        return medarbejderId;
    }

    public void setMedarbejderId(int medarbejderId) {
        this.medarbejderId = medarbejderId;
    }

}
