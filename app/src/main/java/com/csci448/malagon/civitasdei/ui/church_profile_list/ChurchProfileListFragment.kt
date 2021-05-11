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
import com.csci448.malagon.civitasdei.FBdata.Church
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
        viewModel.fetchChurches()



        val root = inflater.inflate(R.layout.fragment_church_profile_list, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        church_profile_list_recycler_view.adapter = adapter
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