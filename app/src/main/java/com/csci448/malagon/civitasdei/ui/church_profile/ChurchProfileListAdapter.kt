package com.csci448.malagon.civitasdei.ui.church_profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csci448.malagon.civitasdei.data.ChurchProfileEntry
import com.csci448.malagon.civitasdei.databinding.ListItemChurchProfileBinding

class ChurchProfileListAdapter(
    private val entries: List<ChurchProfileEntry>
): RecyclerView.Adapter<ChurchProfileEntryHolder>() {

    override fun getItemCount(): Int {
        return entries.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChurchProfileEntryHolder {
        val binding = ListItemChurchProfileBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ChurchProfileEntryHolder(binding)
    }

    override fun onBindViewHolder(holder: ChurchProfileEntryHolder, position: Int) {
        val entry = entries[position]
        holder.bind(entry)
    }
}