package com.erselan.unittesting.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
        var name: String,
        var age: Int,
        var emailAddress: String,
        @PrimaryKey(autoGenerate = true) val Id: Int? = null
)