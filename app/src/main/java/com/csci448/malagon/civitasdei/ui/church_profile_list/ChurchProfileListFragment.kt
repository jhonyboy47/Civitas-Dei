package com.csci448.malagon.civitasdei.ui.church_profile_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.csci448.malagon.civitasdei.FBdata.Church
import com.csci448.malagon.civitasdei.R
import kotlinx.android.synthetic.main.fragment_church_profile_list.*

/**
 * Author: Zabdiyel Tan
 * March 13, 2021
 *
 * Fragment for the list of results after user searches
 */
class ChurchProfileListFragment: Fragment() {

    private lateinit var viewModel: ChurchProfileListViewModel
    private lateinit var adapter: ChurchProfileListAdapter
    private val args: ChurchProfileListFragmentArgs by navArgs()

    companion object {
        private const val LOG_TAG = "448.ChurchProfileListFrag"
    }

    private fun updateUI(churches: List<Church>) {
        Log.d(LOG_TAG, "updateUI() called")
        adapter = ChurchProfileListAdapter(churches) {
            church: Church -> Unit
            val action = ChurchProfileListFragmentDirections
                    .actionResultListFragmentToChurchProfileFragment(
                            church.name,
                            church.members,
                            church.likes,
                            church.mission
                    )
            findNavController().navigate(action)
        }
        church_profile_list_recycler_view.adapter = adapter
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?): View? {

        viewModel =
                ViewModelProvider(this).get(ChurchProfileListViewModel::class.java)
        viewModel.fetchChurches(args.searchTerms ?: "")
        val root = inflater.inflate(R.layout.fragment_church_profile_list, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(LOG_TAG, "onViewCreated() called")

        val churches = viewModel.churches.value ?: emptyList()
        updateUI(churches)
        viewModel.churches.observe(
            viewLifecycleOwner,
            { churches ->
                churches?.let {
                    adapter.setChurches(it)
                    Log.d(LOG_TAG, "Got churches ${adapter.itemCount}")
                    updateUI(churches)
                }
            }
        )
    }
}