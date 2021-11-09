package com.example.persistencedata.presentation.creation

import android.content.Context
import com.example.persistencedata.data.local.MyDatabase
import com.example.persistencedata.domain.Note

class CreationPresenter (private val view : CreationController.View, context: Context): CreationController.Presenter{

    private var database : MyDatabase = MyDatabase.invoke(context)

    override fun createNote(note : Note) {
        when {
            note.title.isEmpty() -> {
                view.error("Por favor escribe un titulo")
            }
            note.note.isEmpty() -> {
                view.error("Por favor escribe una nota")
            }
            else -> {
                database.notesDao().insert(Note.toConvertEntity(note))
                view.success()
            }
        }

    }

}