package com.example.andeladeveloper.githuberr.all_users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.andeladeveloper.githuberr.model.GithubUser
import com.example.andeladeveloper.githuberr.repository.GithubRepository
import com.example.andeladeveloper.githuberr.service.GithubService

class MainViewModel: ViewModel() {

    private val allUsers : LiveData<ArrayList<GithubUser>> = GithubRepository(GithubService().api).getAllUsers()

    fun getAllUsers() : LiveData<ArrayList<GithubUser>> {
        return this.allUsers ?: MutableLiveData<ArrayList<GithubUser>>()
    }
}