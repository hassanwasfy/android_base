package com.deshanddez.deshndezz_android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.deshanddezz.data.UserDto
import com.deshanddezz.domain.GetUserIdUseCase
import com.deshanddezz.domain.User

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.w("HASSAN", UserDto(8).toString())
        Log.w("HASSAN", User(10).toString())
        Log.w("HASSAN", GetUserIdUseCase().invoke().toString())
    }
}