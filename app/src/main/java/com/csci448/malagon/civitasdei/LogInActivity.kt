package com.csci448.malagon.civitasdei

import android.content.Intent
import android.graphics.LinearGradient
import com.csci448.malagon.civitasdei.R
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.csci448.malagon.civitasdei.FBdata.Christian
import com.csci448.malagon.civitasdei.FBdata.NODE_CHRISTIANS
import com.csci448.malagon.civitasdei.data.AttendantProfileEntry
 import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_log_in.*
import java.util.*


class LogInActivity: AppCompatActivity() {


    private lateinit var signInButton: SignInButton
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var firebaseAuth: FirebaseAuth
    companion object{
        private const val LOG_TAG = "LogInActivity"
        private const val RC_SIGN_IN = 9001

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "OnCreate() called")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_log_in)



         // [START config_signin]
        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)
        // [END config_signin]



        // [START initialize_auth]
        // Initialize Firebase Auth
        firebaseAuth = Firebase.auth

        val user = firebaseAuth.currentUser

        if(user != null){
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        }

        signInButton = findViewById(R.id.sign_in_button)
         signInButton.setOnClickListener({
            signIn()
        })




        // [END initialize_auth]
    }


    private fun logOut(){
        Log.d(LOG_TAG, "logOut() called")
        firebaseAuth.signOut()

        val user = Firebase.auth.currentUser
        if (user != null) {
            Log.d(LOG_TAG, "User ${user} is logged in")
        } else {
           Log.d(LOG_TAG, "No user is currently Signed in")
        }
     }
    // [START signin]
    private fun signIn() {
        Log.d(LOG_TAG, "signIn() called")
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    // [START on_start_check_user]
    override fun onStart() {
        Log.d(LOG_TAG, "onStart() called")
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = firebaseAuth.currentUser
        updateUI(currentUser)
    }
    // [END on_start_check_user]

    // [START onactivityresult]
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.d(LOG_TAG, "onActivityResult() called")
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val exception = task.exception

            if(task.isSuccessful){
                try {
                    // Google Sign In was successful, authenticate with Firebase
                    val account = task.getResult(ApiException::class.java)!!
                    Log.d(LOG_TAG, "firebaseAuthWithGoogle:" + account.id + " " + account.displayName)

                    firebaseAuthWithGoogle(account.idToken!!)
                } catch (e: ApiException) {
                    // Google Sign In failed, update UI appropriately
                    Log.w(LOG_TAG, "Google sign in failed", e)
                }
            } else {

                Log.d(LOG_TAG, exception.toString())
            }
        }
    }
    // [END onactivityresult]

    // [START auth_with_google]
    private fun firebaseAuthWithGoogle(idToken: String) {
        Log.d(LOG_TAG, "firbaseAuthWithGoogle() called")
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(LOG_TAG, "signInWithCredential:success")

                    //This is where we get user data
//                    val user = auth.currentUser
//                    updateUI(user)
                    val mainActivity = Intent(this, MainActivity::class.java)
                    startActivity(mainActivity)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(LOG_TAG, "signInWithCredential:failure", task.exception)
                    updateUI(null)
                }
            }
    }
    // [END auth_with_google]



    private fun updateUI(user: FirebaseUser?) {
        Log.d(LOG_TAG, "UpdateUI() called")







    }





}