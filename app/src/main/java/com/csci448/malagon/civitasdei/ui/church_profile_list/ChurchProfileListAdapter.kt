package com.csci448.malagon.civitasdei.ui.church_profile_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csci448.malagon.civitasdei.FBdata.Church
import com.csci448.malagon.civitasdei.R
import kotlinx.android.synthetic.main.recycler_view_church_item.view.*

class ChurchProfileListAdapter(
        private var churches: List<Church>,
        private val clickListener: (Church) -> Unit
): RecyclerView.Adapter<ChurchProfileListAdapter.ChurchViewModel>() {

    fun setChurches(churches: List<Church>) {
        this.churches = churches as MutableList<Church>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return churches.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ChurchViewModel (
        LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_church_item, parent, false)
    )

    override fun onBindViewHolder(holder: ChurchViewModel, position: Int) {
        holder.itemView.church_name_tv.text = churches[position].name
        holder.itemView.church_mission_tv.text = churches[position].mission
        holder.itemView.setOnClickListener {
            clickListener(churches[position])
        }
    }

    class ChurchViewModel(val view: View): RecyclerView.ViewHolder(view)
}



