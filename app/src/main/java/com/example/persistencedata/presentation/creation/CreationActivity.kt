package com.example.persistencedata.presentation.creation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.persistencedata.R
import com.example.persistencedata.domain.Note
import java.util.*

class CreationActivity  : AppCompatActivity(), CreationController.View, View.OnClickListener {

    private lateinit var presenter: CreationPresenter

    private lateinit var etTitle : TextView
    private lateinit var etNote: TextView
    private lateinit var btnEnviar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creation)

        presenter = CreationPresenter(this, this)

        etTitle = findViewById(R.id.etTitle)
        etNote = findViewById(R.id.etTitle)

        btnEnviar = findViewById(R.id.btnEnviar)
        btnEnviar.setOnClickListener(this)
    }

    override fun success() {
        finish()
    }

    override fun error(msg: String) {
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view : View) {
        when(view.id){
            R.id.btnEnviar ->{
                val id = UUID.randomUUID().toString()
                val title = etTitle.text.toString()
                val nota = etNote.text.toString()

                val note = Note(id,title,nota)
                presenter.createNote(note)
            }
        }
    }
}