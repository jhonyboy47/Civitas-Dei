package com.csci448.malagon.civitasdei.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.csci448.malagon.civitasdei.R
import com.csci448.malagon.civitasdei.ui.home.HomeViewModel

/**
 * Author: Jeremiah Navarro
 * March 13, 2021
 *
 * Fragment for the profile page of a church attendant
 */
class AttendantProfileFragment: Fragment() {

    private lateinit var attendantProfileViewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        attendantProfileViewModel = ViewModelProvider(this).get(AttendantProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_attendant_profile, container, false)

        return root
    }
}