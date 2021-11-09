package com.example.persistencedata.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.RecyclerView
import com.example.persistencedata.R
import com.example.persistencedata.domain.Note

class NotesAdapter(var notes : MutableList<Note>, private val controller: NoteAdapterController) : RecyclerView.Adapter<NotesViewHolder>(){

    fun updateData(notes : MutableList<Note>){
        this.notes = notes
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notes, parent, false)
        return  NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note = notes[position]

        holder.tvTitle.text = note.title
        holder.tvNote.text = note.note

        holder.itemView.setOnLongClickListener {
            controller.removeNote(note)
            true
        }

        holder.itemView.setOnClickListener {
            controller.goToNote(note)
        }
    }

    override fun getItemCount(): Int = notes.size

}