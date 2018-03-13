package com.example.andeladeveloper.githuberr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static List<Users> usersList = new ArrayList<>();

    static {
        usersList.add(new Users("Fred Adewole", "Andela", 60));
        usersList.add(new Users("Cristiano Ronaldo", "Real Madrid", 12));
        usersList.add(new Users("DeMar DeRozan", "Raptors", 1));
        usersList.add(new Users("Steph Curry", "Warriors", 3));
        usersList.add(new Users("Klay Thomspson", "Warriors", 14));
        usersList.add(new Users("Kyle Lowry", "Raptors", 30));
        usersList.add(new Users("Russell Westbrook", "Thunders", 4));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        MyAdapter adapter = new MyAdapter(usersList, this);
        mRecyclerView.setAdapter(adapter);
    }
}
