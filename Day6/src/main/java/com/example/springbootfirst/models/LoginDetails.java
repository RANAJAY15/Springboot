package com.example.springbootfirst.models;

import lombok.Data;

@Data
public class LoginDetails {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }
}
