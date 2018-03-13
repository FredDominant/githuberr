package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Fred Adewole on 12/03/2018.
 */

public class GithubUsers {

    @SerializedName("login")
    private String username;

    @SerializedName("avatar_url")
    private String avatar;

    public String getAvatar() {
        return avatar;
    }

    public String getUsername() {
        return username;
    }
}
