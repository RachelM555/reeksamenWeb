package com.example.reeksamen.model;

public class Login {

    private String email;
    private String adgangskode;

    public Login() {
    }

    public Login(String email, String adgangskode) {
        this.email = email;
        this.adgangskode = adgangskode;
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
}
