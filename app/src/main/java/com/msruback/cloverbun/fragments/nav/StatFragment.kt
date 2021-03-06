package com.msruback.cloverbun.fragments.nav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.msruback.cloverbun.R


class StatFragment : AuthorizedFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stat, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            StatFragment()
    }
}
