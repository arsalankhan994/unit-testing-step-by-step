package com.systems.unittesting.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.systems.unittesting.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}