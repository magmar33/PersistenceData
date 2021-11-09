package com.example.persistencedata.data.local.notes

import androidx.room.*
import com.example.persistencedata.data.local.user.UserEntity

@Dao
interface NotesDao {

    @Insert
    fun insert(notes: NotesEntity)

    @Update
    fun update(notes: NotesEntity)

    @Delete
    fun delete(notes: NotesEntity)

    @Query("select * from notes order by title asc")
    fun getNotes(): List<NotesEntity>

}