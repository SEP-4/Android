package com.example.sep.model;

public class Gym {
    private int gym_ID;
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

    public String getPassword() {
        return password;
    }

}
