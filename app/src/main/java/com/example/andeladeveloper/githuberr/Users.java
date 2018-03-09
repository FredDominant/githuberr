package com.example.andeladeveloper.githuberr;


/**
 * Created by andeladeveloper on 06/03/2018.
 */

public class Users {

    private String userName;
    private String workplace;
    private int repos;

    public Users (String userName, String workplace, int repos) {
        this.userName = userName;
        this.workplace = workplace;
        this.repos = repos;
    }

    public String getUserName () {
        return userName;
    }

    public String getUserWorkplace () {
        return workplace;
    }

    public int getRepos () { return repos; }
    public String toString () {
        String details = "Username: " + userName + ";\nWorkplace: " + workplace + ";\nRepos: " + repos;
        return details;
    }
}
