package com.erselan.unittesting.di

import android.content.Context
import androidx.room.Room
import com.erselan.unittesting.data.local.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object AppModuleTest {

    // Provider database object for instrument testing
    @Provides
    @Named("test-db")
    fun provideUserDatabase(@ApplicationContext context: Context) =
        Room.inMemoryDatabaseBuilder(context, UserDatabase::class.java)
            .allowMainThreadQueries().build()
}