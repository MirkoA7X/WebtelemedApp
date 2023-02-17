package com.webtelemedapp.webtelemedapp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class UserTm {
    @Id @GeneratedValue
    private Long id;
    //0-Patient, 1-Admin
    int type = 0;

    public UserTm() {
    }

    private String ime;
    private String prezime;
    private String datumRodenja;
    private String brojMobitela;
    private String email;
    private String lozinka;
    private String mbo;

    @Override
    public String toString() {
        return "UserTm{" +
                "id=" + id +
                ", type=" + type +
                ", ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", datumRodenja='" + datumRodenja + '\'' +
                ", brojMobitela='" + brojMobitela + '\'' +
                ", email='" + email + '\'' +
                ", lozinka='" + lozinka + '\'' +
                ", mbo='" + mbo + '\'' +
                '}';
    }

    public UserTm(String ime, String prezime, String datumRodenja, String brojMobitela, String email, String lozinka, String mbo) {
        this.ime = ime;
        this.prezime = prezime;
        this.datumRodenja = datumRodenja;
        this.brojMobitela = brojMobitela;
        this.email = email;
        this.lozinka = lozinka;
        this.mbo = mbo;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getDatumRodenja() {
        return datumRodenja;
    }

    public void setDatumRodenja(String datumRodenja) {
        this.datumRodenja = datumRodenja;
    }

    public String getBrojMobitela() {
        return brojMobitela;
    }

    public void setBrojMobitela(String brojMobitela) {
        this.brojMobitela = brojMobitela;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getMbo() {
        return mbo;
    }

    public void setMbo(String mbo) {
        this.mbo = mbo;
    }

    public Long getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}
