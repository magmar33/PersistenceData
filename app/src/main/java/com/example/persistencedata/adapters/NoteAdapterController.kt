package com.example.persistencedata.adapters

import com.example.persistencedata.domain.Note

interface NoteAdapterController {
    fun removeNote(note: Note)
    fun goToNote(note: Note)
}