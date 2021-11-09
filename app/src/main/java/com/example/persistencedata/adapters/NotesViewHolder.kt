package com.example.persistencedata.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.persistencedata.R

class NotesViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
    val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
    val tvNote = view.findViewById<TextView>(R.id.tvNote)

}