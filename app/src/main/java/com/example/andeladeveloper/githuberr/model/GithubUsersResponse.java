package com.example.andeladeveloper.githuberr.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Fred Adewole on 12/03/2018.
 */

public class GithubUsersResponse {

    /**
     *
     */
    @SerializedName("items")
    private
    ArrayList<GithubUser> users;

    /**
     * @return users
     */
    public ArrayList<GithubUser> getGithubUsers() {

        return users;
    }

}
