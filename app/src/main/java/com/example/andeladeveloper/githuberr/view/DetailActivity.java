package com.example.andeladeveloper.githuberr.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.andeladeveloper.githuberr.R;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = this.getIntent();
        final String name = intent.getExtras().getString("USERNAME");
        final String repos = intent.getExtras().getString("REPOS");
        String imageUrl = intent.getExtras().getString("IMAGE");

        TextView userRepos = findViewById(R.id.reposValue);
        userRepos.setText(repos);

        final String userProfileLink = "https://github.com/" + name;
        final String sharedMessage =
                "Check out this Awesome Java Developer " + name + ", " + userProfileLink;

        ImageView userImage = findViewById(R.id.mainUserImage);
        Picasso.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.avatar)
                .error(R.drawable.avatar)
                .into(userImage);

        collapsingToolbarLayout = findViewById(R.id.collapsingToolbar);
        collapsingToolbarLayout.setTitle(name);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareProfileIntent = new Intent(Intent.ACTION_SEND);
                shareProfileIntent.putExtra(Intent.EXTRA_TEXT, sharedMessage);
                shareProfileIntent.setType("text/plain");
                startActivity(shareProfileIntent);
            }
        });
    }

}
