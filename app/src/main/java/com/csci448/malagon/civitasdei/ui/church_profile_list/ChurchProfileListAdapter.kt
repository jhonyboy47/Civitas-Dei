package com.csci448.malagon.civitasdei.ui.church_profile_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.csci448.malagon.civitasdei.ChurchViewModel
import com.csci448.malagon.civitasdei.FBdata.Church
import com.csci448.malagon.civitasdei.R
import kotlinx.android.synthetic.main.fragment_church_profile_list.view.*
import kotlinx.android.synthetic.main.list_item_church_profile.view.*
import kotlinx.android.synthetic.main.recycler_view_item_1.view.*

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
                .inflate(R.layout.list_item_church_profile, parent, false)
    )

    override fun onBindViewHolder(holder: ChurchViewModel, position: Int) {
        holder.itemView.result_title.text = churches[position].name
        holder.itemView.setOnClickListener {
            clickListener(churches[position])
        }
    }

    class ChurchViewModel(val view: View): RecyclerView.ViewHolder(view)
}



