package com.example.persistencedata.domain

import com.example.persistencedata.data.local.notes.NotesEntity
import java.io.Serializable

data class Note (
    var notesId : String,
    var title : String,
    var note : String
): Serializable {
    companion object {
        fun toConvertEntity(note : Note) =
            NotesEntity(
                note.notesId,
                note.title,
                note.note
            )
    }
}