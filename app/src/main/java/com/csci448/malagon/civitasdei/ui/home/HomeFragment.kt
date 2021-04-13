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
import com.csci448.malagon.civitasdei.data.ChurchProfileEntry
import com.csci448.malagon.civitasdei.data.repo.ChurchProfileEntryRepository

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    // NOTE: TEMPORARY FUNCTION FOR TESTING CHURCH PROFILE DATABASE FUNCTIONALITY
    private fun addToCPDB() {
        val churchProfileEntry = ChurchProfileEntry(
            name = "TEST NAME",
            address = "TEST ADDRESS",
            description = "TEST DESCRIPTION",
            numAttendants = 100,
            numLikes = 100
        )
        entryRepository.addEntry(churchProfileEntry)
    }

    private lateinit var entryRepository: ChurchProfileEntryRepository
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

        entryRepository = ChurchProfileEntryRepository.getInstance(requireContext())
        this.addToCPDB()

        return root
    }
}