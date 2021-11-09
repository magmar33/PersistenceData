package com.example.persistencedata.presentation.detail

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.persistencedata.R
import com.example.persistencedata.domain.Note
import java.util.*

class NoteDetail : AppCompatActivity(), NoteDetailController.View, View.OnClickListener {

    private lateinit var note : Note
    private lateinit var etTitle : TextView
    private lateinit var etNote : TextView
    private lateinit var btnEnviar : Button
    private lateinit var presenter : NoteDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        presenter = NoteDetailPresenter(this,this)

        note = intent.getSerializableExtra("note") as Note

        etTitle = findViewById(R.id.etTitle)
        etTitle.text = note.title
        etNote = findViewById(R.id.etNote)
        etNote.text = note.note

        btnEnviar = findViewById(R.id.btnEnviar)
        btnEnviar.setOnClickListener(this)

    }

    override fun success() {
    finish()
    }

    override fun error(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view: View) {
        when(view.id){
            R.id.btnEnviar -> {

                val title = etTitle.text.toString()
                val nota = etNote.text.toString()

                note.title = title
                note.note = nota

                presenter.saveUpdate(note)
            }
        }
    }


}