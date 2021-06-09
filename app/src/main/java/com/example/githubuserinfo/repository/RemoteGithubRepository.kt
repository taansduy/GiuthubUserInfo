package com.example.githubuserinfo.repository

import com.example.githubuserinfo.api.GithubApi
import com.example.githubuserinfo.model.UserInfo
import javax.inject.Inject

class RemoteGithubRepository @Inject constructor(
    private val api : GithubApi
) : GithubRepository {
    override suspend fun getUserInfo(user: String): UserInfo = api.getUserInfo(user)

    override suspend fun getUserFollowers(user: String): List<UserInfo> = api.getUserFollowers(user)
}