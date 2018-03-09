package com.example.andeladeveloper.githuberr;


/**
 * Created by andeladeveloper on 06/03/2018.
 */

public class Users {

    private String userName;
    private String workplace;

    public Users (String userName, String workplace) {
        this.userName = userName;
        this.workplace = workplace;
    }

    public String getUserName () {
        return userName;
    }

    public String getUserWorkplace () {
        return workplace;
    }

}
