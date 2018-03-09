package com.example.andeladeveloper.githuberr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = this.getIntent();
        String name = intent.getExtras().getString("USERNAME");
        String repos = Integer.toString(intent.getExtras().getInt("REPOS"));
        String organisation = intent.getExtras().getString("ORGANISATION");

        TextView workplace = findViewById(R.id.workDetails);
        workplace.setText(organisation);

        TextView username = findViewById(R.id.userName);
        username.setText(name);

        TextView userRepos = findViewById(R.id.reposValue);
        userRepos.setText(repos);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
