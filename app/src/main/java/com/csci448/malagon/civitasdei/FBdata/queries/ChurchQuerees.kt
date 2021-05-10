package com.csci448.malagon.civitasdei.FBdata.queries

import android.renderscript.Sampler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.csci448.malagon.civitasdei.FBdata.Church
import com.csci448.malagon.civitasdei.FBdata.NODE_CHURCHES
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ChurchQuerees {

    private val dbChurches = FirebaseDatabase.getInstance().getReference(NODE_CHURCHES)

    private val _churches = MutableLiveData<List<Church>>()
    val churches: LiveData<List<Church>>
        get() = _churches


    private val _church  = MutableLiveData< Church >()
    val church : LiveData< Church >
        get() = _church

    fun addChurch(church: Church) {

        church.id = dbChurches.push().key.toString()

        dbChurches.child(church.id).setValue(church)

    }


    fun fetchChurches(){
        dbChurches.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){

                    val churches = mutableListOf<Church>()
                    for(churchSnapshot in snapshot.children){
                        val church = churchSnapshot.getValue(Church::class.java)

                        church?.id = churchSnapshot.key.toString()
                        church?.let { churches.add(it) }


                    }
                    _churches.value = churches
                }
             }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }

    fun getChurch(seekingChurch: Church){
        dbChurches.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){

                     for(churchSnapshot in snapshot.children){
                        val church = churchSnapshot.getValue(Church::class.java)

                        church?.id = churchSnapshot.key.toString()

                         if( church?.name == seekingChurch.name ){

                             _church.value = church!!
                         }


                    }
                 }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}