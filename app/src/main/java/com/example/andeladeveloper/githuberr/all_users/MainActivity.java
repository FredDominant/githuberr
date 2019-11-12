package com.example.andeladeveloper.githuberr.all_users;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.andeladeveloper.githuberr.R;
import com.example.andeladeveloper.githuberr.utils.CoordinatorUtil;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //change content with network change

        CoordinatorUtil.Companion.switchFragmentScreens(this, GitHubUsersFragment.newInstance(), R.id.fragmentContainer);
    }

}
