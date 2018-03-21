package com.example.andeladeveloper.githuberr.presenter;

import android.util.Log;

import com.example.andeladeveloper.githuberr.model.GithubUser;
import com.example.andeladeveloper.githuberr.model.GithubUsersResponse;
import com.example.andeladeveloper.githuberr.service.GithubService;
import com.example.andeladeveloper.githuberr.view.MainActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by andeladeveloper on 12/03/2018.
 */
public class GithubUsersPresenter {
    /**
     * The Github service.
     */
    GithubService githubService;
    /**
     * The Context.
     */
    MainActivity activity;

    /**
     * Instantiates a new Github users presenter.
     *
     * @param activity the context
     */
    public GithubUsersPresenter(MainActivity activity) {
        this.activity = activity;
        if (githubService == null) {
            githubService = new GithubService();
        }
    }


    public void getGithubers() {
        githubService
                .getApi()
                .getAllGithubJavaUsers() // to access the Nairobi users api
                .enqueue(new Callback<GithubUsersResponse>() {
                    @Override
                    public void onResponse(Call<GithubUsersResponse> call,
                                           Response<GithubUsersResponse> response) {
                        GithubUsersResponse githubUsersResponse = response.body();
                        ArrayList<GithubUser> users = githubUsersResponse.getGithubUsers();
                        activity.setLoader();
                        activity.getUsersData(users);
                        activity.unsetLoader();
                        activity.displayResults(users, activity);
                    }

                    @Override
                    public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                        Log.w(t.toString(), "onFailure: ", t);
                    }
                });

    }
}
