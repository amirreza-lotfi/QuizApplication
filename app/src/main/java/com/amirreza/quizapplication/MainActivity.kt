package com.amirreza.quizapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.amirreza.quizapplication.feature_authentication.domain.entitiy.TokenHolder
import com.amirreza.quizeapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        val hasUserLoggedIn = TokenHolder.isTokenAvailable()

        if(hasUserLoggedIn){
            navController.navigate(R.id.quizFragment)
        }else{
            navController.navigate(R.id.loginFragment)
        }
    }
}