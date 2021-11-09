package com.example.persistencedata.data.local.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.persistencedata.domain.Note

@Entity(tableName = "notes")
data class NotesEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "notesId") var notesId : String,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "note") var note: String
    ){
    companion object{
        fun convertToNote(notesEntity: NotesEntity) =
            Note(
                notesEntity.notesId,
                notesEntity.title,
                notesEntity.note
            )
    }
}