package com.example.githubuserinfo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubuserinfo.base.Resource
import com.example.githubuserinfo.model.UserInfo
import com.example.githubuserinfo.repository.GithubRepository
import com.example.githubuserinfo.utils.perform
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: GithubRepository) : ViewModel() {
    val user = MutableLiveData<String>()
    val userInfoViewModel = MutableLiveData<Resource<UserInfo>>()
    val listFollowersViewModel = MutableLiveData<Resource<List<UserInfo>>>()

    fun getUserInfo() = viewModelScope.perform(userInfoViewModel) {
        repo.getUserInfo(user.value ?: "")
    }

    fun getFollowers() = viewModelScope.perform(listFollowersViewModel) {
        repo.getUserFollowers(user.value ?: "")
    }
}