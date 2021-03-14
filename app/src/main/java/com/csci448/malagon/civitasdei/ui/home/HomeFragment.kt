package com.csci448.malagon.civitasdei.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.csci448.malagon.civitasdei.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val profileCheckSwitch: Switch = root.findViewById(R.id.test_church_profile_switch)
        val profile: Button = root.findViewById(R.id.test_profile_button)
        profile.setOnClickListener {
            if(!profileCheckSwitch.isChecked)
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_attendantProfileFragment)
            else
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_churchProfileFragment)
        }

        val searchButton: Button = root.findViewById(R.id.search_nav_button)
        searchButton.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_searchFragment)
        }

        return root
    }
}