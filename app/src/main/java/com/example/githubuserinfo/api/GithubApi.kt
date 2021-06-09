package com.example.githubuserinfo.api

import com.example.githubuserinfo.model.UserInfo
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {
    @GET("{user}")
    suspend fun getUserInfo(@Path("user") user:String) : UserInfo
    @GET("{user}/followers")
    suspend fun getUserFollowers(@Path("user") user:String) : List<UserInfo>
}