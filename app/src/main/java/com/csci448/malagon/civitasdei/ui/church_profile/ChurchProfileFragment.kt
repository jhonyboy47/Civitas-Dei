package com.csci448.malagon.civitasdei.ui.church_profile

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.csci448.malagon.civitasdei.FBdata.Church
import com.csci448.malagon.civitasdei.R
import com.csci448.malagon.civitasdei.databinding.FragmentChurchProfileBinding
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_church_profile.*

/**
 * Author: Zabdiyel Tan
 * March 13, 2021
 *
 * Fragment for the attendant_profile page of a church
 */
class ChurchProfileFragment: Fragment() {

    private lateinit var viewModel: ChurchProfileViewModel

    companion object {
        private const val LOG_TAG = "448.ChurchProfileFrag"
    }

    private val args: ChurchProfileFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        Log.d(LOG_TAG, "onAttach() called")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "onCreate() called")
        super.onCreate(savedInstanceState)

//        binding.churchNameTextView.text = args.name
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LOG_TAG, "onCreateView() called")

        viewModel =
                ViewModelProvider(this).get(ChurchProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_church_profile, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "onViewCreated() called")
        super.onViewCreated(view, savedInstanceState)
        church_name_text_view.text = args.name
        num_attendants_text_view.text = "Attendants: ${args.attendants}"
        num_likes_text_view.text = "Likes: ${args.likes}"
        church_bio_text_view.text = args.bio
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "onActivityCreated() called")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(LOG_TAG, "onStart() called")
        super.onStart()
    }

    override fun onResume() {
        Log.d(LOG_TAG, "onResume() called")
        super.onResume()
    }

    override fun onPause() {
        Log.d(LOG_TAG, "onPause() called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(LOG_TAG, "onStop() called")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d(LOG_TAG, "onDestroyView() called")
        super.onDestroyView()

    }

    override fun onDestroy() {
        Log.d(LOG_TAG, "onDestroy() called")
        super.onDestroy()
//        _binding = null
    }

    override fun onDetach() {
        Log.d(LOG_TAG, "onDetach() called")
        super.onDetach()
    }
}