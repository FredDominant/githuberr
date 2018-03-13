package com.example.andeladeveloper.githuberr.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Fred Adewole on 12/03/2018.
 */

public class GithubUsers {

    @SerializedName("login")
    private String username;

    @SerializedName("avatar_url")
    private String avatar;

    @SerializedName("organizations_url")
    private String organisation;

    @SerializedName("repos_url")
    private String repos;

    public String getAvatar() { return avatar; }

    public String getUsername() {
        return username;
    }

    public String getOrganisaton() { return organisation; }

    public String getRepos() { return repos; }
}
