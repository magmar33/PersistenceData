package com.example.persistencedata.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.persistencedata.data.local.notes.NotesDao
import com.example.persistencedata.data.local.notes.NotesEntity
import com.example.persistencedata.data.local.user.UserDao
import com.example.persistencedata.data.local.user.UserEntity

@Database(
    entities = [UserEntity::class, NotesEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase(){

    abstract fun userDao(): UserDao
    abstract fun notesDao(): NotesDao

    companion object{
        @Volatile
        private var instance : MyDatabase? = null
        private val LOCK = Any() //Cualquiera

        operator  fun invoke(context: Context) = instance
            ?: synchronized(LOCK){
                instance ?: buildDatabase(context)
                    .also {
                        instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, MyDatabase::class.java,"mydatabase.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
    }
}