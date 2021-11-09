package com.example.persistencedata.data.local.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "userId") var userId : String,
    @ColumnInfo(name = "name") var name: String,
    @ColumnInfo(name = "lastName") var lastName : String,
    @ColumnInfo(name = "email") var email : String

)
