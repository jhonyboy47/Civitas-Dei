package com.csci448.malagon.civitasdei.ui.attendant_profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.csci448.malagon.civitasdei.R
import com.csci448.malagon.civitasdei.data.AttendantProfileEntry
import com.csci448.malagon.civitasdei.data.repo.AttendantProfileEntryRepository
import com.csci448.malagon.civitasdei.ui.church_profile_list.ChurchProfileEntryHolder
import com.csci448.malagon.civitasdei.ui.home.HomeFragment
import com.csci448.malagon.civitasdei.ui.login.LoginViewModel

/**
 * Author: Jeremiah Navarro
 * March 13, 2021
 *
 * Fragment for the attendant_profile page of a church attendant
 */
class AttendantProfileFragment: Fragment() {

    val args: AttendantProfileFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val factory = AttendantProfileViewModelFactory(requireContext())
        val attendantProfileViewModel = ViewModelProvider(this, factory).get(AttendantProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_attendant_profile, container, false)

        val attendant: LiveData<AttendantProfileEntry?> = attendantProfileViewModel.getAttendant(args.attendantID)
        val nameTextView: TextView = root.findViewById(R.id.attendant_name_text_view)
        val churchTextView: TextView = root.findViewById(R.id.church_text_view)
        val firstName = attendant.value?.firstName
        val lastName = attendant.value?.lastName
        val church = attendant.value?.attendingChurch

        nameTextView.text = "$firstName $lastName"
        churchTextView.text = "$church"


        return root
    }
}