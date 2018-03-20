package com.example.andeladeveloper.githuberr.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.andeladeveloper.githuberr.GithubAdapter;
import com.example.andeladeveloper.githuberr.R;
import com.example.andeladeveloper.githuberr.model.GithubUsers;
import com.example.andeladeveloper.githuberr.presenter.GithubUsersPresenter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private final GithubUsersPresenter githubUsersPresenter =
            new GithubUsersPresenter(MainActivity.this);
    private ArrayList<GithubUsers> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            users = savedInstanceState.getParcelableArrayList("USERS");
            displayResults(users, this);
            } else {
                githubUsersPresenter.getGithubers();
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

    public void displayResults(ArrayList<GithubUsers> usersList, Context context) {
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mlayoutManager =
                new GridLayoutManager(context, 2);
        mRecyclerView.setLayoutManager(mlayoutManager);
        GithubAdapter githubAdapter = new GithubAdapter(usersList, context);
        mRecyclerView.setAdapter(githubAdapter);

    }

    public void getUsersData(ArrayList<GithubUsers> users) {
        this.users = users;
    }

}
