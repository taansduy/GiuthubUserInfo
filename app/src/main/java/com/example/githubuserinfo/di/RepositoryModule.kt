package com.example.githubuserinfo.di

import com.example.githubuserinfo.api.GithubApi
import com.example.githubuserinfo.repository.GithubRepository
import com.example.githubuserinfo.repository.RemoteGithubRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideGithubRepository(api: GithubApi): GithubRepository = RemoteGithubRepository(api)
}