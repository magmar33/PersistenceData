package com.example.persistencedata.presentation.main

import android.content.Context
import com.example.persistencedata.data.local.MyDatabase
import com.example.persistencedata.data.local.notes.NotesEntity
import com.example.persistencedata.domain.Note

class MainPresenter(val view: MainController.View, val context: Context) : MainController.Presenter {

    private val database = MyDatabase.invoke(context)

    override fun getNotes() {
        val notes = database.notesDao().getNotes()
        view.setNotes(notes.map(NotesEntity :: convertToNote).toMutableList())
    }

    override fun deleteNote(note: Note) {
        database.notesDao().delete(Note.toConvertEntity(note))
        getNotes()
    }

    override fun updateNote(note: Note) {
        database.notesDao().update(Note.toConvertEntity(note))
        getNotes()
    }
}