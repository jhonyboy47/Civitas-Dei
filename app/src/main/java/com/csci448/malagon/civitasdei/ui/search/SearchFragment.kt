package com.csci448.malagon.civitasdei.ui.search

import android.content.Context
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import com.csci448.malagon.civitasdei.R
import com.csci448.malagon.civitasdei.databinding.FragmentSearchBinding
//import com.google.android.gms.maps.MapFragment
//import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Author: Zabdiyel Tan
 * March 13, 2021
 *
 * Search fragment generated when user selects the search button
 */
class SearchFragment: Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!  // valid b/n onCreateView and onDestroyView() only


    companion object {
        private const val LOG_TAG = "448.SearchFrag"
    }

    override fun onAttach(context: Context) {
        Log.d(LOG_TAG, "onAttach() called")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d(LOG_TAG, "onCreate() called")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LOG_TAG, "onCreateView() called")
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        binding.cancelButton.setOnClickListener {
            val action = SearchFragmentDirections
                .actionSearchFragmentToNavigationHome()
            findNavController().navigate(action)
        }

        binding.searchButton.setOnClickListener {
            val action = SearchFragmentDirections.actionSearchFragmentToResultListFragment(
                    binding.searchBar.text.toString()
            )

            findNavController().navigate(action)
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(LOG_TAG, "onViewCreated() called")
        super.onViewCreated(view, savedInstanceState)
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
        _binding = null
    }

    override fun onDetach() {
        Log.d(LOG_TAG, "onDetach() called")
        super.onDetach()
    }
}