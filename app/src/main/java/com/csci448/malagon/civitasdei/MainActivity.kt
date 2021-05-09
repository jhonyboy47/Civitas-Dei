package com.csci448.malagon.civitasdei

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.csci448.malagon.civitasdei.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {

    companion object {
        private const val LOG_TAG = "448.MainActivity"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d(LOG_TAG, "onCreate() called")
        super.onCreate(savedInstanceState)

        //////////////////////
        ///FireBase///////////
        //////////////////////
        // Write a message to the database
        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")

        ////////////////////////
       // binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_discover, R.id.navigation_feed, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
            val navHostFragment = supportFragmentManager.findFragmentByTag("nav_host_frag") as NavHostFragment
            return findNavController(navHostFragment.id).navigateUp() || super.onSupportNavigateUp()
        return false
    }
//    override fun onSupportNavigateUp(): Boolean {
//        return findNavController(binding.navHostFragment.id).navigateUp()
//                || super.onSupportNavigateUp()
//    }
}