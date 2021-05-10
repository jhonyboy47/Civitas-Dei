package com.csci448.malagon.civitasdei.ui.discover

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.csci448.malagon.civitasdei.R
import com.csci448.malagon.civitasdei.data.ChurchProfileEntry
import com.csci448.malagon.civitasdei.data.repo.ChurchProfileEntryRepository
import com.google.firebase.auth.FirebaseAuth
import java.lang.ClassCastException
import java.util.*

class DiscoverFragment : Fragment() {

//    interface Callbacks {
//        fun getAttendantID(): UUID
//    }

    private lateinit var discoverViewModel: DiscoverViewModel

//    private var _callbacks: Callbacks? = null
//    private val callbacks get() = _callbacks!!

    private lateinit var firebaseAuth: FirebaseAuth
//    companion object{
//        public lateinit var currentAttendantID: UUID
//    }



//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        try{
//            _callbacks = (context as Callbacks)
//        } catch(e: ClassCastException) {
//
//        }
//    }

    private lateinit var entryRepository: ChurchProfileEntryRepository
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        discoverViewModel =
                ViewModelProvider(this).get(DiscoverViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_discover, container, false)

        val profileCheckSwitch: Switch = root.findViewById(R.id.test_church_profile_switch)
        val profile: Button = root.findViewById(R.id.test_profile_button)
        profile.setOnClickListener {
            if(!profileCheckSwitch.isChecked){

                val action = DiscoverFragmentDirections.actionNavigationHomeToAttendantProfileFragment()
                Navigation.findNavController(root).navigate(action)
            }
            else
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_churchProfileFragment)
        }

        val searchButton: Button = root.findViewById(R.id.search_nav_button)
        searchButton.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_searchFragment)
        }



//TODO: This will change to Firebase stuff
//        entryRepository = ChurchProfileEntryRepository.getInstance(requireContext())
//        this.addToCPDB()

        return root
    }


    // NOTE: TEMPORARY FUNCTION FOR TESTING CHURCH PROFILE DATABASE FUNCTIONALITY
//    private fun addToCPDB() {
//        val churchProfileEntry = ChurchProfileEntry(
//            name = "TEST CHURCH NAME",
//            address = "TEST CHURCH ADDRESS",
//            description = "TEST CHURCH DESCRIPTION",
//            numAttendants = 100,
//            numLikes = 100
//        )
//        entryRepository.addEntry(churchProfileEntry)
//    }
}