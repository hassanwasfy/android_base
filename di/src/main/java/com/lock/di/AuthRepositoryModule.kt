package com.example.di

import com.dezz.data.repo.NewsRepo
import com.dezz.data.repo.NewsRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AuthRepositoryModule {
    @Binds
    abstract fun providesNewRepo(repo: NewsRepoImpl): NewsRepo
}
