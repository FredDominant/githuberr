package com.example.andeladeveloper.githuberr.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andeladeveloper.githuberr.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = this.getIntent();
        final String name = intent.getExtras().getString("USERNAME");
        String repos = (intent.getExtras().getString("REPOS"));
        String imageUrl = intent.getExtras().getString("IMAGE");

        TextView username = findViewById(R.id.userName);
        username.setText(name);

        TextView userRepos = findViewById(R.id.reposValue);
        userRepos.setText(repos);

        ImageView userImage = findViewById(R.id.mainUserImage);
        Picasso.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.avatar)
                .error(R.drawable.avatar)
                .into(userImage);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Share " + name + "'s profile", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
