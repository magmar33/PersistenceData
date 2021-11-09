package com.example.persistencedata.presentation.detail

import android.content.Context
import com.example.persistencedata.data.local.MyDatabase
import com.example.persistencedata.domain.Note


class NoteDetailPresenter (private val view : NoteDetailController.View, context: Context): NoteDetailController.Presenter {
    private var database : MyDatabase = MyDatabase.invoke(context)

    override fun saveUpdate(note: Note) {
        when {
            note.title.isEmpty() -> {
                view.error("Por favor escribe un titulo")
            }
            note.note.isEmpty() -> {
                view.error("Por favor escribe una nota")
            }
            else -> {
                database.notesDao().update(Note.toConvertEntity(note))
                view.success()
            }
        }
    }

}