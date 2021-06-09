package com.example.githubuserinfo.repository

import com.example.githubuserinfo.model.UserInfo
import dagger.Provides

interface GithubRepository {
    suspend fun getUserInfo(user:String) : UserInfo
    suspend fun getUserFollowers(user: String): List<UserInfo>
}