package com.example.thenonfungible.Model;

public class User {
    private int userID;
    private String userName;
    private String password;
    private String gender;
    private String nickName;
    //private image profilePhoto;

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setUserName(String uname) {
        this.userName = uname;
    }

    public void setPassWord(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getUserID() {
        return this.userID;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassWord() {
        return this.password;
    }

    public String getGender() {
        return this.gender;
    }

    public String getNickName() {
        return this.nickName;
    }

}
