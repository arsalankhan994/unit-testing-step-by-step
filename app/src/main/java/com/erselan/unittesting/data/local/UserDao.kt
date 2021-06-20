package com.erselan.unittesting.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.erselan.unittesting.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userEntity: UserEntity)

    @Delete
    suspend fun delete(userEntity: UserEntity)

    @Query("Select * from UserEntity")
    fun getUsersList(): LiveData<List<UserEntity>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(userEntity: UserEntity)

}