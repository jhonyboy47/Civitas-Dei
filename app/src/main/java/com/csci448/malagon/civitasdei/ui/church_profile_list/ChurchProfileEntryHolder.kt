package com.csci448.malagon.civitasdei.ui.church_profile_list

import androidx.recyclerview.widget.RecyclerView
import com.csci448.malagon.civitasdei.data.ChurchProfileEntry
import com.csci448.malagon.civitasdei.databinding.ListItemChurchProfileBinding

class ChurchProfileEntryHolder(
    val binding: ListItemChurchProfileBinding): RecyclerView.ViewHolder(binding.root){

        private lateinit var entry: ChurchProfileEntry

        fun bind(entry: ChurchProfileEntry, clickListener: (ChurchProfileEntry) -> Unit) {
            this.entry = entry
            itemView.setOnClickListener {
                clickListener(this.entry)
            }
            binding.resultTitle.text = this.entry.name
        }
}