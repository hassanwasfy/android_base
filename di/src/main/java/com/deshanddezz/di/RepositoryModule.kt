package com.deshanddezz.di

import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Singleton
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

}