package com.lock.di

import android.content.Context
import androidx.room.Room

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//@Module
//@InstallIn(SingletonComponent::class)
//object RoomDBModule {
//    @Provides
//    @Singleton
//    fun provideRoomDB(@ApplicationContext context: Context): NewsDB {
//        return Room.databaseBuilder(
//            context,
//            NewsDB::class.java,
//            "NewsDB"
//        ).allowMainThreadQueries().build()
//    }
//}