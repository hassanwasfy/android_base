package com.dezz.uitls

import android.app.Activity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException

class GoogleSignInHelper(private val activity: FragmentActivity) {

    private val signInLauncher =
        activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                handleSignInResult(result.data)
            }
        }

    fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        signInLauncher.launch(signInIntent)
    }

    private fun handleSignInResult(data: Intent?) {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        try {
            val account = task.getResult(ApiException::class.java)
            // Signed in successfully
            // ...
        } catch (e: ApiException) {
            // Sign in failed
            // ...
        }
    }

    fun signOut() {
        googleSignInClient.signOut()
            .addOnCompleteListener {
                // Signed out
            }
    }

    private val googleSignInClient =
        GoogleSignIn.getClient(activity, GoogleSignInOptions.DEFAULT_SIGN_IN)

}