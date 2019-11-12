package com.example.andeladeveloper.githuberr.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Fred Adewole on 12/03/2018.
 */
public class GithubUser implements Parcelable {

    @SerializedName("login")
    public String username;
    @SerializedName("avatar_url")
    public String avatar;
    @SerializedName("organizations_url")
    public String organisation;
    @SerializedName("repos_url")
    public String repos;

    private GithubUser(Parcel in) {
        username = in.readString();
        avatar = in.readString();
        organisation = in.readString();
        repos = in.readString();
    }

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

    /**
     * The constant CREATOR.
     */
    public static final Creator<GithubUser> CREATOR = new Creator<GithubUser>() {
        @Override
        public GithubUser createFromParcel(Parcel in) {
            return new GithubUser(in);
        }

        @Override
        public GithubUser[] newArray(int size) {
            return new GithubUser[size];
        }
    };
}
