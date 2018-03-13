package com.example.andeladeveloper.githuberr;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import model.GithubUsers;

/**
 * Created by Fred Adewole on 07/03/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<GithubUsers> usersList; //list of github users
    private Context context;

    public MyAdapter(List<GithubUsers> usersList, Context context) {
        this.usersList = usersList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout view = (ConstraintLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, final int position) {
        holder.setValues(this.usersList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("USERNAME", usersList.get(position).getUsername());
                intent.putExtra("ORGANISATION", usersList.get(position).getUsername());
                intent.putExtra("REPOS", usersList.get(position).getUsername());
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

        public ViewHolder(View itemView) {
            super(itemView);
            userWork = itemView.findViewById(R.id.userWork);
            userName = itemView.findViewById(R.id.userName);
            // getAdapterPosition() returns position ;

        }
        public void setValues(@NonNull GithubUsers user){
            //users.getAVatar
            this.userWork.setText(user.getUsername());
            //users.getUsername()
            this.userName.setText(user.getUsername());
        }
    }
}
