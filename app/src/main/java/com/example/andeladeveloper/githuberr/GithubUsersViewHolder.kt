package com.example.andeladeveloper.githuberr

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.andeladeveloper.githuberr.model.GithubUser
import com.squareup.picasso.Picasso

class GithubUsersViewHolder(view: View, private var listener: GithubUserListener) : RecyclerView.ViewHolder(view) {

    private var imageView: ImageView = view.findViewById(R.id.userImage)
    private var textView: TextView = view.findViewById(R.id.userName)

    fun bindValues(githubUser: GithubUser) {

        githubUser.also { user ->
            this.itemView.setOnClickListener { this.listener.onGithubUserClicked(user) }
            textView.text = user.username
            Picasso.get()
                    .load(user.avatar)
                    .placeholder(R.drawable.avatar)
                    .error(R.drawable.avatar)
                    .into(this.imageView)
        }

    }
}