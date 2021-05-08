package com.csci448.malagon.civitasdei

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.csci448.malagon.civitasdei.data.AttendantProfileEntry
import com.csci448.malagon.civitasdei.ui.discover.DiscoverFragment
import com.csci448.malagon.civitasdei.ui.login.LoginViewModel
import com.csci448.malagon.civitasdei.ui.login.LoginViewModelFactory
import java.util.*

class LoginActivity: AppCompatActivity() {

    private lateinit var attendant: AttendantProfileEntry
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)
        attendant = AttendantProfileEntry()
        val factory = LoginViewModelFactory(this)
        loginViewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
        val homeFragment = DiscoverFragment
        val firstNameText: EditText = findViewById(R.id.editTextFirstName)
        val lastNameText: EditText = findViewById(R.id.editTextLastName)
        val churchText: EditText = findViewById(R.id.editTextAttendingChurch)
        val signUpButton: Button = findViewById(R.id.sign_up_button)
        signUpButton.setOnClickListener {
            if(firstNameText.text.isNotEmpty() && churchText.text.isNotEmpty() && lastNameText.text.isNotEmpty()){

                attendant.firstName = firstNameText.text.toString()
                attendant.lastName = lastNameText.text.toString()
                attendant.attendingChurch = churchText.text.toString()
                loginViewModel.addAttendant(attendant)
                homeFragment.currentAttendantID = attendant.id
                val main = Intent(this,MainActivity::class.java)
                startActivity(main)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
            else
                Toast.makeText(this, "One or more fields must not be left blank!", Toast.LENGTH_LONG).show()
        }
    }

    fun getAttendantId(): UUID {
        return attendant.id
    }
}