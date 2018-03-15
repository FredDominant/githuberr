package model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Fred Adewole on 12/03/2018.
 */

public class GithubUsersResponse {
    @SerializedName("items")
    List<GithubUsers> users;

    @SerializedName("total_count")
    private int count;

    @SerializedName("incomplete_results")
    private boolean completeResults;

    public List<GithubUsers> getGithubUsers () {
        return users;
    }

    public int getCount() {
        return count;
    }

    public boolean getCompleteResults () {
        return completeResults;
    }
}
