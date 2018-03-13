package com.example.andeladeveloper.githuberr.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Fred Adewole on 12/03/2018.
 */

public class GithubUsersResponse {

    @SerializedName("items")
    List<GithubUsers> users;

    public List<GithubUsers> getGithubUsers () {
        return users;
    }

}
