package com.mvvm.model;

public class Gym {
    private int id;
    private int climateSettingId;
    private String address;
    private String contact;
    private int postCode;
    private String city;

    public Gym() {
    }

    public Gym(int id, int climateSettingId, String address, String contact, int postCode, String city) {
        this.id = id;
        this.climateSettingId = climateSettingId;
        this.address = address;
        this.contact = contact;
        this.postCode = postCode;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClimateSettingId() {
        return climateSettingId;
    }

    public void setClimateSettingId(int climateSettingId) {
        this.climateSettingId = climateSettingId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
