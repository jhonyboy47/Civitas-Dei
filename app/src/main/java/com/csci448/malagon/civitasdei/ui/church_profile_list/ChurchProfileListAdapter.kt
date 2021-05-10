package com.csci448.malagon.civitasdei.ui.church_profile_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
 import com.csci448.malagon.civitasdei.FBdata.Church
import com.csci448.malagon.civitasdei.R
import kotlinx.android.synthetic.main.fragment_church_profile_list.view.*
import kotlinx.android.synthetic.main.list_item_church_profile.view.*
import kotlinx.android.synthetic.main.recycler_view_item_1.view.*

class ChurchProfileListAdapter : RecyclerView.Adapter<ChurchProfileListAdapter.ChurchViewModel>() {

    private var churches = mutableListOf<Church>()

    fun setChurches (churches: List<Church>){
        this.churches = churches as MutableList<Church>
    }

    override fun getItemCount(): Int {
        return churches.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ChurchViewModel (

        LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item, parent, false)
            )

    override fun onBindViewHolder(holder:  ChurchViewModel, position: Int) {
        val itemView = holder.itemView
        itemView.result_title.text = churches[position].name
//        itemView.church_mission_tv.text = churches[position].mission
//        itemView.church_members_tv.text = churches[position].members.toString()
     }
    class ChurchViewModel(val view: View) : RecyclerView.ViewHolder(view)

}



