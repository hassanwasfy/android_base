package com.dezz.uitls

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.Fragment


fun Context.startActivityFromOutSideModule(packageName: String) {
    val intentClass = Class.forName(packageName)
// Create Intent object
    val intent = Intent(this, intentClass)

// Start the activity
    startActivity(intent)
}

fun Context?.toast(message: String) {
    this?.let {
        Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
    }
}
fun Fragment.toast(message: String) {
    this.context.let {
        Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
    }
}