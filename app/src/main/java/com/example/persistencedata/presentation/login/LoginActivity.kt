package com.example.persistencedata.presentation.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.persistencedata.R
import com.example.persistencedata.presentation.main.MainActivity
import com.example.persistencedata.utils.MySharedPreferences

class LoginActivity : AppCompatActivity(), View.OnClickListener, LoginInteractor.View{
    private lateinit var btnlogin: Button
    private lateinit var etpassword: EditText
    private lateinit var etmail: EditText
    private lateinit var presenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(this, this)
        btnlogin = findViewById(R.id.btnLogin)
        etmail = findViewById(R.id.etEmail)
        btnlogin.setOnClickListener(this)
        etpassword = findViewById(R.id.etPassword)
    }

    override fun onStart() {
        super.onStart()
        presenter.getSessionActive()

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnLogin -> {

                val email = etmail.text.toString()
                val password = etpassword.text.toString()

            presenter.goToLogin(email, password)

            }
        }
    }

    override fun success() {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

    override fun error(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }
}