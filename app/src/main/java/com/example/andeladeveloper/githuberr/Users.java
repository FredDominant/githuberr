package com.example.andeladeveloper.githuberr;


/**
 * Created by andeladeveloper on 06/03/2018.
 */

public class Users {

    private String userName;
    private String userImage;

    public void User () {
        userName = "GitHub User";
        userImage = "@drawable/avatar";

    }

    public String getUserName () {
        return userName;
    }

    public String getuserImage () {
        return userImage;
    }
}
