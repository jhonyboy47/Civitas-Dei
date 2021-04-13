package com.csci448.malagon.civitasdei.ui.attendant_profile

import androidx.recyclerview.widget.RecyclerView
import com.csci448.malagon.civitasdei.data.Post
import com.csci448.malagon.civitasdei.databinding.RecyclerViewItemBinding

class PostHolder(val binding: RecyclerViewItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var post: Post

    fun bind(post: Post, clickListener: (Post) -> Unit){
        this.post = post
        itemView.setOnClickListener {clickListener(this.post)}
        binding.postTitleTextView.text = this.post.title
        binding.actionTextView.text = this.post.action
        binding.profileFeedTimeTextView.text = this.post.time.toString()
    }
}