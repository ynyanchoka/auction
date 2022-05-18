package com.group.models;

public class Users {


    private int id;
    private String email;
    private String fullName;
    private String password;

    public  Users(String email,String fullName, String password){
        this.email = email;
        this.fullName = fullName;
        this.password= password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }
}
