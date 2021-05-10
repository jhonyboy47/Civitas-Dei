package com.csci448.malagon.civitasdei.ui.church_profile_list

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.csci448.malagon.civitasdei.R
import com.csci448.malagon.civitasdei.data.ChurchProfileEntry
import com.csci448.malagon.civitasdei.databinding.FragmentChurchProfileListBinding
import com.csci448.malagon.civitasdei.ui.feed.FeedViewModel
import kotlinx.android.synthetic.main.fragment_church_profile_list.*
import kotlinx.android.synthetic.main.list_item_church_profile.*
import java.util.*

/**
 * Author: Zabdiyel Tan
 * March 13, 2021
 *
 * Fragment for the list of results after user searches
 */
class ChurchProfileListFragment: Fragment() {

    private lateinit var viewModel: ChurchProfileListViewModel
    private lateinit var adapter: ChurchProfileListAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        adapter = ChurchProfileListAdapter()
        viewModel =
                ViewModelProvider(this).get(ChurchProfileListViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_church_profile_list, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        church_profile_list_recycler_view.adapter = adapter
//        church_profile_list_recycler_view.layoutManager = LinearLayoutManager(context)
        viewModel.fetchChurches()
        viewModel.churches.observe(viewLifecycleOwner, {
            adapter.setChurches(it)
        })
    }


//    private val args: ChurchProfileListFragmentArgs by navArgs()
//
//    private lateinit var churchProfileListViewModel: ChurchProfileListViewModel
//    private lateinit var adapter: ChurchProfileListAdapter
//    companion object {
//        private const val LOG_TAG = "448.ResultListFrag"
//    }
//
//    private fun updateUI(searchTerms: String?) {
//        Log.d(LOG_TAG, "updateUI() called")
//        churchProfileListViewModel.fetchChurches()
//        churchProfileListViewModel.churches.observe( viewLifecycleOwner, androidx.lifecycle.Observer {
//            adapter.setChurches(it)
//            for (church in churchProfileListViewModel.churches.value!!) {
//
//                Log.d(LOG_TAG, "Church name: ${church.name}, Search terms: $searchTerms")
//
//                //User id is what is being used here to find unique
//                if (searchTerms != null) {
//                    if (church.name == searchTerms.trim()) {
//                        Log.d(LOG_TAG, "found search match")
//                        result_title?.text = searchTerms
//
//                    }
//                }
//            }
//        })
//
//
//
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        adapter = ChurchProfileListAdapter()
//
//        churchProfileListViewModel =
//            ViewModelProvider(this).get(ChurchProfileListViewModel::class.java)
//
//        val root = inflater.inflate(R.layout.fragment_church_profile_list, container, false)
//
//        return root
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        Log.d(LOG_TAG, "onActivityCreated() called")
//        super.onActivityCreated(savedInstanceState)
//
//        church_profile_list_recycler_view.adapter = adapter
//        updateUI(args.searchTerms)
//    }
//
//
//
//    override fun onStart() {
//        Log.d(LOG_TAG, "onStart() called")
//        super.onStart()
//    }
//
//    override fun onResume() {
//        Log.d(LOG_TAG, "onResume() called")
//        super.onResume()
//    }
//
//    override fun onPause() {
//        Log.d(LOG_TAG, "onPause() called")
//        super.onPause()
//    }
//
//    override fun onStop() {
//        Log.d(LOG_TAG, "onStop() called")
//        super.onStop()
//    }
//
//    override fun onDestroyView() {
//        Log.d(LOG_TAG, "onDestroyView() called")
//        super.onDestroyView()
//
//    }
//
//    override fun onDestroy() {
//        Log.d(LOG_TAG, "onDestroy() called")
//        super.onDestroy()
//     }
//
//    override fun onDetach() {
//        Log.d(LOG_TAG, "onDetach() called")
//        super.onDetach()
//    }
}