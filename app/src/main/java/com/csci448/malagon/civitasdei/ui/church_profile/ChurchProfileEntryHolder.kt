package com.csci448.malagon.civitasdei.ui.church_profile

import androidx.recyclerview.widget.RecyclerView
import com.csci448.malagon.civitasdei.data.ChurchProfileEntry
import com.csci448.malagon.civitasdei.databinding.ListItemChurchProfileBinding

class ChurchProfileEntryHolder(
    val binding: ListItemChurchProfileBinding): RecyclerView.ViewHolder(binding.root){

        private lateinit var entry: ChurchProfileEntry

        fun bind(entry: ChurchProfileEntry) {
            this.entry = entry
            binding.resultTitle.text = this.entry.name
        }
}