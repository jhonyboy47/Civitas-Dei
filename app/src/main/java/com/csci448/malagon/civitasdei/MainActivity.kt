package com.csci448.malagon.civitasdei

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.csci448.malagon.civitasdei.FBdata.Christian
import com.csci448.malagon.civitasdei.FBdata.NODE_CHRISTIANS
import com.csci448.malagon.civitasdei.databinding.ActivityMainBinding
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {

    companion object {
        private const val LOG_TAG = "448.MainActivity"
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d(LOG_TAG, "onCreate() called")
        super.onCreate(savedInstanceState)


       // binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()
        val currentUser = firebaseAuth.currentUser

        //////////////////////
        ///FireBase///////////
        //////////////////////
        // Write a message to the database
        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("message")

        myRef.setValue("Hello, Main Activity")

        ////////////////////////


        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_discover, R.id.navigation_feed
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

    override fun onStart() {
        super.onStart()


        //TODO: Must change the placement of this code so that it only occurs when it is the first time we access our account
        val user = firebaseAuth.currentUser

        val christian = Christian()

        christian.favoriteVerse = "No Favorite Verse set"
        christian.church = "No affiliated Church"
        christian.name = user?.displayName.toString()
        christian.id = user?.uid.toString()

        updateChristian(christian)

    }

    fun updateChristian(christian: Christian){
        val dbChristians = FirebaseDatabase.getInstance().getReference(NODE_CHRISTIANS)
        dbChristians.child(christian.id).setValue(christian)

    }


}