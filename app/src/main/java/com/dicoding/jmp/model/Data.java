package com.dicoding.jmp.model;

public class Data {
    private String id;
    private String name;
    private String hp;
    private String gender;
    private String tanggal;
    private String address;

    public Data() {
    }

    public Data(String id, String name, String hp, String gender, String tanggal, String address) {
        this.name = name;
        this.hp = hp;
        this.gender = gender;
        this.tanggal = tanggal;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
