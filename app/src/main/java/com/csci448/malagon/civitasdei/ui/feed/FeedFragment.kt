package com.csci448.malagon.civitasdei.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.csci448.malagon.civitasdei.R
import kotlinx.android.synthetic.main.fragment_feed.*

class FeedFragment : Fragment() {

    private lateinit var feedViewModel: FeedViewModel
    private lateinit var adapter: FeedAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        adapter = FeedAdapter()
        feedViewModel =
                ViewModelProvider(this).get(FeedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_feed, container, false)
//        val feedRecyclerView: RecyclerView = root.findViewById(R.id.feed_recycler_view)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        feed_recycler_view.adapter = adapter
        feedViewModel.fetchPosts()

//        adapter.setPosts(feedViewModel.posts.)
        feedViewModel.posts.observe(viewLifecycleOwner, {

            adapter.setPosts(it)

        })
    }
}