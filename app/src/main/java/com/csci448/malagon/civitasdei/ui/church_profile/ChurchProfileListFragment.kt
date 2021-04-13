package com.csci448.malagon.civitasdei.ui.church_profile

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.csci448.malagon.civitasdei.databinding.FragmentChurchProfileListBinding
import java.util.*

/**
 * Author: Zabdiyel Tan
 * March 13, 2021
 *
 * Fragment for the list of results after user searches
 */
class ChurchProfileListFragment: Fragment() {

    private var _binding: FragmentChurchProfileListBinding? = null
    private val binding get() = _binding!!  // valid b/n onCreateView and onDestroyView() only

    companion object {
        private const val LOG_TAG = "448.ResultListFrag"
    }

    override fun onAttach(context: Context) {
        Log.d(LOG_TAG, "onAttach() called")
        super.onAttach(context)
    }

    private lateinit var entryListViewModel: ChurchProfileListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val factory = ChurchProfileListViewModelFactory(requireContext())
        entryListViewModel = ViewModelProvider(this@ChurchProfileListFragment, factory)
            .get(ChurchProfileListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LOG_TAG, "onCreateView() called")
        _binding = FragmentChurchProfileListBinding.inflate(inflater, container, false)
//        binding.cancelButton.setOnClickListener {
//            val action = ChurchProfileListFragmentDirections
//                .actionResultListFragmentToNavigationHome()
//            findNavController().navigate(action)
//        }
//        binding.newSearchButton.setOnClickListener {
//            val action = ChurchProfileListFragmentDirections
//                .actionResultListFragmentToSearchFragment()
//            findNavController().navigate(action)
//        }
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