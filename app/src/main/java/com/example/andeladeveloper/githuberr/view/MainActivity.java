package com.example.andeladeveloper.githuberr.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.andeladeveloper.githuberr.GithubAdapter;
import com.example.andeladeveloper.githuberr.R;
import com.example.andeladeveloper.githuberr.model.GithubUsers;
import com.example.andeladeveloper.githuberr.model.GithubUsersResponse;
import com.example.andeladeveloper.githuberr.service.GithubService;
import com.example.andeladeveloper.githuberr.service.GithubUsersAPI;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements GithubUsersAPI {

    private GithubService githubService = new GithubService();
    private ArrayList<GithubUsers> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);

        if (savedInstanceState != null) {
                mRecyclerView.setHasFixedSize(true);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
                mRecyclerView.setLayoutManager(mLayoutManager);
                users = savedInstanceState.getParcelableArrayList("USERS");
                GithubAdapter adapter = new GithubAdapter(users, MainActivity.this);
                mRecyclerView.setAdapter(adapter);
            } else {
                getAllGithubJavaUsers();
            }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("USERS", users);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        users = savedInstanceState.getParcelableArrayList("USERS");
        super.onRestoreInstanceState(savedInstanceState);
    }


    @Override
    public Call<GithubUsersResponse> getAllGithubJavaUsers() {
        githubService
                .getApi()
                .getAllGithubJavaUsers()
                .enqueue(new Callback<GithubUsersResponse>() {
                    @Override
                    public void onResponse(Call<GithubUsersResponse> call, Response<GithubUsersResponse> response) {
                        GithubUsersResponse githubUsersResponse = response.body();
                        if (response != null && githubUsersResponse.getGithubUsers() != null) {
                            users = githubUsersResponse.getGithubUsers();
                            RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
                            mRecyclerView.setHasFixedSize(true);
                            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
                            mRecyclerView.setLayoutManager(mLayoutManager);
                            GithubAdapter adapter = new GithubAdapter(users, MainActivity.this);
                            mRecyclerView.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong");

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
        return null;
    }

}
