package com.msruback.cloverbun

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var navController:NavController;
    lateinit var navBar:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode())
        this.navController = findNavController(R.id.nav_host)
        this.navBar = findViewById(R.id.bottom_nav)
        this.navBar.setupWithNavController(navController)

        //Remove BottomNavBar for LoginFragment
        this.navController.addOnDestinationChangedListener { controller, destination, arguments ->
            if(destination.id==R.id.loginFragment){
                this.navBar.visibility = View.GONE
            }else if(this.navBar.visibility==View.GONE){
                this.navBar.visibility=View.VISIBLE
            }
        }
    }
}
