package com.msruback.cloverbun.fragments.nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.msruback.cloverbun.AuthViewModel
import com.msruback.cloverbun.R

/**
 * A simple [Fragment] subclass.
 */
abstract class AuthorizedFragment : Fragment() {
    private lateinit var authModel: AuthViewModel;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.authModel = ViewModelProvider(this).get(AuthViewModel::class.java)

        if(!this.authModel.isAuthorized()) {
            this.findNavController().navigate(R.id.action_global_toLogin)
        }
    }

}

