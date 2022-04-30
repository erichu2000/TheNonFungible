package com.example.thenonfungible.Model;

import android.media.Image;

public class User {
    public String userID;
    public String userName;
    public String password;
    public String email;

    public User() {

    }

    public User(String userID, String userName, String password, String email) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

}
