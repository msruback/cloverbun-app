package com.msruback.cloverbun

import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel: ViewModel() {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun isAuthorized():Boolean{
        return auth.currentUser != null;
    }

    fun loginUser(email:String,password:String): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email,password);
    }
}