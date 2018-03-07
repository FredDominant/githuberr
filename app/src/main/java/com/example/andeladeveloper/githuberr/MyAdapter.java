package com.example.andeladeveloper.githuberr;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by andeladeveloper on 07/03/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Users> usersList;
    private Context context;

    public MyAdapter(List<Users> usersList, Context context) {
        this.usersList = usersList;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView userImage;
        public TextView userName;
        public ViewHolder(View itemView) {
            super(itemView);

            ImageView userImage =  itemView.findViewById(R.id.userImage);
            TextView usrName = itemView.findViewById(R.id.userName);
        }
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView view = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        Users users = usersList.get(position);
        holder.userImage.setImageURI(Uri.parse("../../res/drawable/avatar.png"));
        holder.userName.setText(users.getUserName());
    }


    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
