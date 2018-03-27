package com.example.andeladeveloper.githuberr.view;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.andeladeveloper.githuberr.GithubAdapter;
import com.example.andeladeveloper.githuberr.R;
import com.example.andeladeveloper.githuberr.model.GithubUser;
import com.example.andeladeveloper.githuberr.presenter.GithubUsersPresenter;
import com.example.andeladeveloper.githuberr.utils.NetworkJobScheduler;
import com.example.andeladeveloper.githuberr.utils.NetworkUtility;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar loadingSpinner;
    private NetworkUtility networkUtility;
    private final GithubUsersPresenter githubUsersPresenter =
            new GithubUsersPresenter(MainActivity.this);
    private ArrayList<GithubUser> users;
    private static final int JOB_ID = 101;
    private JobScheduler jobScheduler;
    private JobInfo jobInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //change content with network change

        ComponentName componentName = new ComponentName(this, NetworkJobScheduler.class);

        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, componentName);
        builder.setPeriodic(5000);
        builder.setPersisted(true);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);

        jobInfo = builder.build();
        jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int result = jobScheduler.schedule(jobInfo);

        Log.i(Integer.toString(result), "onCreate: Job has been scheduled");

        constraintLayout = findViewById(R.id.constraintLayout_main);

//        MainActivity.this.registerReceiver(new NetworkBroadcast(), new IntentFilter());

        if (networkUtility == null) {
            networkUtility = new NetworkUtility(getApplicationContext());
        }

        loadingSpinner = findViewById(R.id.loader);

        swipeRefreshLayout = findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (swipeRefreshLayout.isRefreshing()) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                githubUsersPresenter.getGithubers();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        if (savedInstanceState != null) {
            onRestoreInstanceState(savedInstanceState);
            displayResults(users, this);
            } else {
                if (networkUtility.isConnected()) {
                    showLoader();
                    githubUsersPresenter.getGithubers();
                } else {
                    displayNoNetwork();
                }
            }
    }

    private void displayNoNetwork() {
        Snackbar.make(constraintLayout, "This guy, no network!", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        githubUsersPresenter.getGithubers();
                    }
                })
                .show();
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

    public void displayResults(ArrayList<GithubUser> usersList, Context context) {
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager mlayoutManager =
                new GridLayoutManager(context, 2);
        mRecyclerView.setLayoutManager(mlayoutManager);
        GithubAdapter githubAdapter = new GithubAdapter(usersList, context);
        mRecyclerView.setAdapter(githubAdapter);

    }
    public void showLoader() {
        loadingSpinner.setVisibility(View.VISIBLE);
    }

    public void hideLoader() {
        loadingSpinner.setVisibility(View.GONE);
    }

    public void getUsersData(ArrayList<GithubUser> users) {
        this.users = users;
    }
}
