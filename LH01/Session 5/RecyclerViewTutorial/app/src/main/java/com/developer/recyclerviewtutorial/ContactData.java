package com.developer.recyclerviewtutorial;

public class ContactData {
    private String nama;
    private String noHP;
    private int gambar;

    public ContactData(int gambar, String nama, String noHP){
        this.nama = nama;
        this.noHP = noHP;
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
