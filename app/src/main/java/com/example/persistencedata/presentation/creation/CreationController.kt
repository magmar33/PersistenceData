package com.example.persistencedata.presentation.creation

import com.example.persistencedata.domain.Note

interface CreationController {
    interface  View{
    fun success()
    fun error(msg : String)
    }

    interface Presenter {
        fun createNote(note : Note)
    }


}