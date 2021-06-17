package com.systems.unittesting.di

import android.content.Context
import androidx.room.Room
import com.systems.unittesting.constant.AppConstant
import com.systems.unittesting.data.local.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // Provide database for app
    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, UserDatabase::class.java, AppConstant.DATA_BASE
    ).build()

    // Provide Dao object
    @Singleton
    @Provides
    fun provideUserDao(userDatabase: UserDatabase) = userDatabase.userDao()

}