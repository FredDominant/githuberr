package com.example.andeladeveloper.githuberr.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Fred Adewole on 12/03/2018.
 */

public class GithubUsersResponse {

    @SerializedName("items")
    ArrayList<GithubUsers> users;

    public ArrayList<GithubUsers> getGithubUsers () {
        return users;
    }

}
