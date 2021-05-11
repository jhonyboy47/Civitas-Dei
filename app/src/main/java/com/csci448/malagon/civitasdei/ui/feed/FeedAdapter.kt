package com.csci448.malagon.civitasdei.ui.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.csci448.malagon.civitasdei.FBdata.Post
import com.csci448.malagon.civitasdei.R
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class FeedAdapter: RecyclerView.Adapter<FeedAdapter.PostViewModel>() {

     private var posts = mutableListOf<Post>()

    fun setPosts (posts: List<Post>){
        this.posts = posts as MutableList<Post>
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewModel (
         LayoutInflater.from(parent.context)
                    .inflate(R.layout.recycler_view_item, parent, false)
    )

    override fun onBindViewHolder(holder: PostViewModel, position: Int) {
        holder.itemView.post_title_tv.text = posts[position].title
        holder.itemView.post_content_tv.text = posts[position].content
        holder.itemView.post_postee_tv.text = posts[position].postee
    }

    class PostViewModel( val view: View) : RecyclerView.ViewHolder(view)




}