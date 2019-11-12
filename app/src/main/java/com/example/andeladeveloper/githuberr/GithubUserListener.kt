package com.example.andeladeveloper.githuberr

import com.example.andeladeveloper.githuberr.model.GithubUser

interface GithubUserListener {

    fun onGithubUserClicked(githubUser: GithubUser)
}