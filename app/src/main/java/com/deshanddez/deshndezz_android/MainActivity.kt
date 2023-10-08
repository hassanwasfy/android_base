package com.deshanddez.deshndezz_android

import android.os.Bundle
import android.util.Log
import com.deshanddezz.base.BaseActivity
import com.deshanddezz.data.UserDto
import com.deshanddezz.domain.GetUserIdUseCase
import com.deshanddezz.domain.User
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.w("HASSAN", UserDto(8).toString())
        Log.w("HASSAN", User(10).toString())
        Log.w("HASSAN", GetUserIdUseCase().invoke().toString())
    }
}