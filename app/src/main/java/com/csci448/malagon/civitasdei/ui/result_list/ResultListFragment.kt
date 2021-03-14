package com.csci448.malagon.civitasdei.ui.result_list

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.csci448.malagon.civitasdei.databinding.FragmentResultListBinding
import com.csci448.malagon.civitasdei.ui.search.SearchFragment
import com.csci448.malagon.civitasdei.ui.search.SearchFragmentDirections
import java.util.*

/**
 * Author: Zabdiyel Tan
 * March 13, 2021
 *
 * Fragment for the list of results after user searches
 */
class ResultListFragment: Fragment() {

    private var _binding: FragmentResultListBinding? = null
    private val binding get() = _binding!!  // valid b/n onCreateView and onDestroyView() only

    companion object {
        private const val LOG_TAG = "448.ResultListFrag"
    }

    override fun onAttach(context: Context) {
        Log.d(LOG_TAG, "onAttach() called")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d(LOG_TAG, "onCreate() called")
        super.onCreate(savedInstanceState)

        binding.resultButton.setOnClickListener {
            val action = ResultListFragmentDirections
                .actionResultListFragmentToChurchProfileFragment(
                    UUID.randomUUID()  // TODO: replace with church UUID rather than placeholder
                )
            findNavController().navigate(action)
        }
        binding.cancelButton.setOnClickListener {
            val action = ResultListFragmentDirections
                .actionResultListFragmentToNavigationHome()
            findNavController().navigate(action)
        }
        binding.newSearchButton.setOnClickListener {
            val action = ResultListFragmentDirections
                .actionResultListFragmentToSearchFragment()
            findNavController().navigate(action)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(LOG_TAG, "onCreateView() called")
        _binding = FragmentResultListBinding.inflate(inflater, container, false)
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