package com.example.andeladeveloper.githuberr.service;

import com.example.andeladeveloper.githuberr.model.GithubUsersResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Fred Adewole on 12/03/2018.
 */

public interface GithubUsersAPI {
    String location = "nairobi";
    String language = "java";
    @GET("search/users?q=location:" + location + "+language:" + language)
    Call<GithubUsersResponse> getAllGithubJavaUsers();
    // to be called after this interface has been implemented
}
