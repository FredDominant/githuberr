package com.example.andeladeveloper.githuberr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.andeladeveloper.githuberr.model.GithubUser;

import java.util.ArrayList;

/**
 * Created by Fred Adewole on 07/03/2018.
 */
public class GithubAdapter extends RecyclerView.Adapter<GithubUsersViewHolder> {

    private ArrayList<GithubUser> usersList = new ArrayList<>();
    private final  GithubUserListener listener;

    public GithubAdapter(GithubUserListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public GithubUsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new GithubUsersViewHolder(view, this.listener);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubUsersViewHolder holder, final int position) {
        holder.bindValues(this.usersList.get(position));
    }

    public void updateUser(final ArrayList<GithubUser> users) {
        this.usersList = users;
        this.notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return this.usersList.size();
    }
}
