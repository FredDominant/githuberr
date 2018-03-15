package com.example.andeladeveloper.githuberr.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.andeladeveloper.githuberr.GithubAdapter;

import java.util.List;

import com.example.andeladeveloper.githuberr.model.GithubUsers;
import com.example.andeladeveloper.githuberr.model.GithubUsersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.andeladeveloper.githuberr.service.GithubService;

/**
 * Created by andeladeveloper on 12/03/2018.
 */

public class GithubUsersPresenter {
    GithubService githubService;
    Context context;
    public GithubUsersPresenter (Context context) {
        this.context = context;
        if (githubService == null) {
            githubService = new GithubService();
        }
    }

    public void getGithubers(final RecyclerView recyclerView) {
        githubService
                .getApi()
                .getAllGithubJavaUsers() // to access the Nairobi users api
                .enqueue(new Callback<GithubUsersResponse>() {
                    @Override
                    public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                        GithubUsersResponse githubUsersResponse = response.body();

                        if (githubUsersResponse != null && githubUsersResponse.getGithubUsers() != null) {
                            List<GithubUsers> users = githubUsersResponse.getGithubUsers();

                            recyclerView.setHasFixedSize(true);
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
                            recyclerView.setLayoutManager(mLayoutManager);
                            GithubAdapter adapter = new GithubAdapter(users, context);
                            recyclerView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong");
                            // Do other stuff here
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                            // Do other stuff
                        }
                    }
                });
    }
}
