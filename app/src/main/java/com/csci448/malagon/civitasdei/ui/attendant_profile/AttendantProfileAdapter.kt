package com.csci448.malagon.civitasdei.ui.attendant_profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csci448.malagon.civitasdei.data.Post
import com.csci448.malagon.civitasdei.databinding.RecyclerViewItemBinding

class AttendantProfileAdapter(private val posts: List<Post>, private val clickListener: (Post) -> Unit) : RecyclerView.Adapter<PostHolder>() {
    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val binding = RecyclerViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostHolder(binding)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bind(posts[position], clickListener)
    }
}