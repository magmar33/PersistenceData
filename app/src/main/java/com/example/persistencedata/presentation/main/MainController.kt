package com.example.persistencedata.presentation.main

import com.example.persistencedata.domain.Note

interface MainController {
    interface View{
        fun setNotes(notes : MutableList<Note>)
    }

    interface Presenter{
        fun getNotes()
        fun deleteNote(note: Note)
        fun updateNote(note: Note)
    }
}