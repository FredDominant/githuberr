package com.example.andeladeveloper.githuberr;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Fred Adewole on 07/03/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Users> usersList;
    private Context context;

    public MyAdapter(List<Users> usersList, Context context) {
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
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        holder.setValues(this.usersList.get(position));
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

        }
        public void setValues(@NonNull Users user){
            this.userWork.setText(user.getUserWorkplace());
            this.userName.setText(user.getUserName());
        }
    }
}
