package com.example.andeladeveloper.githuberr.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fred Adewole on 12/03/2018.
 */

public class GithubService {
    private Retrofit retrofit = null;

    public GithubUsersAPI getApi() {
        String BASE_URl = "https://api.github.com/";
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(GithubUsersAPI.class);
    }
}
