package com.mvvm.model;

public class Employee {
    private int id;
    private int gymId;
    private String name;
    private String password;
    private String address;
    private String email;

    public Employee() {
    }

    public Employee(int id, int gymId, String name, String password, String address, String email) {
        this.id = id;
        this.gymId = gymId;
        this.name = name;
        this.password = password;
        this.address = address;
        this.email = email;
    }
    public Employee getEmployee(){
        return new Employee(id, gymId,name,password,address,email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGymId() {
        return gymId;
    }

    public void setGymId(int gymId) {
        this.gymId = gymId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
