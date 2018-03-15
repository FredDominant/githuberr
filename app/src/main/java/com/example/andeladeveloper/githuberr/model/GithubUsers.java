package com.example.andeladeveloper.githuberr.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Fred Adewole on 12/03/2018.
 */

public class GithubUsers implements Parcelable {

    protected GithubUsers(Parcel in) {
        username = in.readString();
        avatar = in.readString();
        organisation = in.readString();
        repos = in.readString();
    }


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


    @Override
    public int describeContents() {
        return 0;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(avatar);
        dest.writeString(organisation);
        dest.writeString(repos);
    }

    public static final Creator<GithubUsers> CREATOR = new Creator<GithubUsers>() {
        @Override
        public GithubUsers createFromParcel(Parcel in) {
            return new GithubUsers(in);
        }

        @Override
        public GithubUsers[] newArray(int size) {
            return new GithubUsers[size];
        }
    };
}
