package com.example.andeladeveloper.githuberr.service;

import com.example.andeladeveloper.githuberr.model.GithubUsersResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Fred Adewole on 12/03/2018.
 */

public interface GithubUsersAPI {
//    "search/users?q=location:"
    String LOCATION = "lagos";
    String LANGUAGE = "java";
    @GET("search/users?q=location:" + LOCATION + "+language:" + LANGUAGE)
    Call<GithubUsersResponse> getAllGithubJavaUsers();
}
