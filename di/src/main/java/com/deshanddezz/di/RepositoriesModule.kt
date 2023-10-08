package com.deshanddezz.di

import com.deshanddezz.data.IRepository
import com.deshanddezz.data.IRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {
    @Binds
    abstract fun provideRepo(
        iRepositoryImpl: IRepositoryImpl
    ): IRepository
}