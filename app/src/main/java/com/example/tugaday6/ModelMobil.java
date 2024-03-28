package com.example.tugaday6;

public class ModelMobil {
    private String namaMobil;
    private int gambarMobil;
    private String deskripsiMobil;
    private double hargaMobil;

    public ModelMobil(String namaMobil, int gambarMobil, String deskripsiMobil, double hargaMobil) {
        this.namaMobil = namaMobil;
        this.gambarMobil = gambarMobil;
        this.deskripsiMobil = deskripsiMobil;
        this.hargaMobil = hargaMobil;
    }


    public String getDeskripsiMobil() {
        return deskripsiMobil;
    }

    public void setDeskripsiMobil(String deskripsiMobil) {
        this.deskripsiMobil = deskripsiMobil;
    }

    public double getHargaMobil() {
        return hargaMobil;
    }

    public void setHargaMobil(double hargaMobil) {
        this.hargaMobil = hargaMobil;
    }


    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public int getGambarMobil() {
        return gambarMobil;
    }

    public void setGambarMobil(int gambarMobil) {
        this.gambarMobil = gambarMobil;
    }
}