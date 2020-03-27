package com.msruback.cloverbun.fragments.nav

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.msruback.cloverbun.AuthViewModel
import com.msruback.cloverbun.R
import java.lang.Error
import java.lang.Exception


class LoginFragment : Fragment() {

    private lateinit var authModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.authModel = ViewModelProvider(this).get(AuthViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val errorBubble:ConstraintLayout = view!!.findViewById(R.id.errorBubble)
        val email: EditText = view!!.findViewById(R.id.email)
        val password: EditText = view!!.findViewById(R.id.password)
        val submit : MaterialButton = view!!.findViewById(R.id.submit)
        submit.setOnClickListener {
            try {
                authModel.loginUser(email.text.toString(), password.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d(TAG, "signInWithEmail:Success")
                            if (errorBubble.visibility != View.GONE) {
                                errorBubble.visibility = View.GONE
                            }
                            findNavController().popBackStack()
                        } else {
                            Log.w(TAG, "signInWithEmail:Failure")
                            errorBubble.visibility = View.VISIBLE
                        }
                    }
            }catch (e:Exception){
                Log.w(TAG,"signInWithEmail:Failure")
                errorBubble.visibility = View.VISIBLE
            }
        }
    }

    fun login(){

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            LoginFragment()
    }
}
