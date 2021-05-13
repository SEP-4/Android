package com.example.sep.model;

public class Gym {
    private int gym_ID;
    //private int climateSettingId;
    private String address;
    private String contact;
    private int postCode;
    private String city;
    private String email;
    private String password;

    public Gym() {
    }

    public Gym(int gym_ID, String address, String contact, int postCode, String city, String email, String password) {
        this.gym_ID = gym_ID;
        this.address = address;
        this.contact = contact;
        this.postCode = postCode;
        this.city = city;
        this.email = email;
        this.password = password;
    }


//    public int getClimateSettingId() {
//        return climateSettingId;
//    }
//
//    public void setClimateSettingId(int climateSettingId) {
//        this.climateSettingId = climateSettingId;
//    }

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

    public int getGym_ID() {
        return gym_ID;
    }

    public void setGym_ID(int gym_ID) {
        this.gym_ID = gym_ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
