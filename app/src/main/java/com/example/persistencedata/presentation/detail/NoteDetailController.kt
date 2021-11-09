package com.example.persistencedata.presentation.detail

import android.os.Message
import com.example.persistencedata.domain.Note

interface NoteDetailController {
    interface View {
        fun success()
        fun error(msg:String)
    }

    interface Presenter {
        fun saveUpdate(note : Note)
    }
}