package com.example.persistencedata.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.persistencedata.R
import com.example.persistencedata.adapters.NoteAdapterController
import com.example.persistencedata.adapters.NotesAdapter
import com.example.persistencedata.domain.Note
import com.example.persistencedata.presentation.creation.CreationActivity
import com.example.persistencedata.presentation.detail.NoteDetail
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener, MainController.View,
    NoteAdapterController {

    private lateinit var fbAdd : FloatingActionButton
    private lateinit var rvNotes : RecyclerView
    private lateinit var adapterNotes : NotesAdapter
    private lateinit var presenter : MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this,this)

        fbAdd = findViewById(R.id.fbAdd)
        fbAdd.setOnClickListener(this)

        rvNotes = findViewById(R.id.rvNotes)

        adapterNotes = NotesAdapter(mutableListOf(), this)
        rvNotes.layoutManager = LinearLayoutManager(this)
        rvNotes.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
        rvNotes.setHasFixedSize(true)
        rvNotes.adapter = adapterNotes


    }

    override fun onResume() {
        super.onResume()
        presenter.getNotes()
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.fbAdd ->{
            startActivity(Intent(this,CreationActivity::class.java))
            }
        }
    }

    override fun setNotes(notes: MutableList<Note>) {
        adapterNotes.updateData(notes)
    }

    override fun removeNote(note: Note) {
        presenter.deleteNote(note)
    }

    override fun goToNote(note: Note) {
    val intent = Intent(this, NoteDetail::class.java)
        intent.putExtra("note", note)
        startActivity(intent)
    }



}