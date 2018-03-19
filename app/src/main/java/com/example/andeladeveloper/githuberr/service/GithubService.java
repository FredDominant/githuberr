package com.example.andeladeveloper.githuberr.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Fred Adewole on 12/03/2018.
 */

public class GithubService {
    /**
     *
     */
    final String baseUrl = "https://api.github.com/";
    /**
     *
     */
    private Retrofit retrofit = null;

    /**
     * @return GithubUsersAPI
     */
    public GithubUsersAPI getApi() {
        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(GithubUsersAPI.class);
    }
}
