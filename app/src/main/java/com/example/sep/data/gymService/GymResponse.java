package com.example.sep.data.gymService;

import com.example.sep.model.Gym;

public class GymResponse {
    private int gym_ID;
    private String address;
    private String contact;
    private int postCode;
    private String city;
    private String email;
    private String password;

    public Gym getGym(){
        return new Gym(gym_ID, address, contact, postCode, city, email, password);
    }
}
