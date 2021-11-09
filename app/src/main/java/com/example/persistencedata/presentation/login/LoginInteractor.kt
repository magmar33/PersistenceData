package com.example.persistencedata.presentation.login

import android.os.Message

interface LoginInteractor {
    interface View {
        fun success()
        fun error(msg : String)
    }

    interface Presenter {
        fun goToLogin(email: String, password: String)
        fun getSessionActive()

    }
}