package com.example.persistencedata.utils

import android.content.Context

object MySharedPreferences {
    fun setShared(context: Context){
        val shared = context.getSharedPreferences("user",Context.MODE_PRIVATE)
        val edit = shared.edit()
        edit.putBoolean("isSession", true)
        edit.apply()
    }

    fun getShared(context: Context): Boolean{
        val shared = context.getSharedPreferences("user", Context.MODE_PRIVATE)
        return shared.getBoolean("isSession",false)

    }
}