package com.example.andeladeveloper.githuberr;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.andeladeveloper.githuberr.model.GithubUsers;
import com.example.andeladeveloper.githuberr.view.DetailActivity;
import com.squareup.picasso.Picasso;

/**
 * Created by Fred Adewole on 07/03/2018.
 */

public class GithubAdapter extends RecyclerView.Adapter<GithubAdapter.ViewHolder> {

    private ArrayList<GithubUsers> usersList;
    private Context context;

    public GithubAdapter(ArrayList<GithubUsers> usersList, Context context) {
        this.usersList = usersList;
        this.context = context;
    }

    @NonNull
    @Override
    public GithubAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout view = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new GithubAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubAdapter.ViewHolder holder, final int position) {
        holder.setValues(this.usersList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when a com.example.andeladeveloper.githuberr.view has been clicked.
             *
             * @param v The com.example.andeladeveloper.githuberr.view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("USERNAME", usersList.get(position).getUsername());
                intent.putExtra("IMAGE", usersList.get(position).getAvatar());
                intent.putExtra("REPOS", usersList.get(position).getRepos());
                v.getContext().startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return this.usersList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView userWork;
        TextView userName;
        ImageView userImage;

        public ViewHolder(View itemView) {
            super(itemView);
            userWork = itemView.findViewById(R.id.userWork);
            userName = itemView.findViewById(R.id.userName);
            userImage = itemView.findViewById(R.id.userImage);

        }
        public void setValues(@NonNull GithubUsers user){
            this.userWork.setText(user.getUsername());
            this.userName.setText(user.getUsername());
            Picasso.with(itemView.getContext())
                    .load(user.getAvatar())
                    .placeholder(R.drawable.avatar)
                    .error(R.drawable.avatar)
                    .into(userImage);
        }
    }
}
