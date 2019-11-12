package com.example.andeladeveloper.githuberr.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.andeladeveloper.githuberr.model.GithubUser
import com.example.andeladeveloper.githuberr.model.GithubUsersResponse
import com.example.andeladeveloper.githuberr.service.GithubUsersAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GithubRepository(private val service: GithubUsersAPI) {

    fun getAllUsers() : LiveData<ArrayList<GithubUser>> {

        val allUsers = MutableLiveData<ArrayList<GithubUser>>()

        service.allGithubJavaUsers.enqueue(object : Callback<GithubUsersResponse> {
            override fun onFailure(call: Call<GithubUsersResponse>, t: Throwable) { }

            override fun onResponse(call: Call<GithubUsersResponse>, response: Response<GithubUsersResponse>) {
                response.body()?.let {
                    allUsers.value = it.githubUsers
                }
            }

        })
        return allUsers
    }
}