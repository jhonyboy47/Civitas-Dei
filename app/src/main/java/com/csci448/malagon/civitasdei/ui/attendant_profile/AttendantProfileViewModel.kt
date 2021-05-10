package com.csci448.malagon.civitasdei.ui.attendant_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.csci448.malagon.civitasdei.FBdata.Christian
import com.csci448.malagon.civitasdei.FBdata.NODE_CHRISTIANS
import com.google.firebase.database.*
import java.lang.Exception

class AttendantProfileViewModel : ViewModel() {

    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?>
            get() = _result



    private val _christians = MutableLiveData<List<Christian>>()
    val christians: LiveData<List<Christian>>
        get() = _christians



    private val _christian = MutableLiveData<Christian>()
    val christian: LiveData<Christian>
        get() = _christian



    private val dbChristians = FirebaseDatabase.getInstance().getReference(NODE_CHRISTIANS)


    fun updateChristian(christian: Christian){

        dbChristians.child(christian.id).setValue(christian)

    }


//    private val childEventListener = object : ChildEventListener {
//        override fun onCancelled(error: DatabaseError) {}
//
//        override fun onChildMoved(snapshot: DataSnapshot, p1: String?) {}
//
//        override fun onChildChanged(snapshot: DataSnapshot, p1: String?) {
//            val christian = snapshot.getValue(Christian::class.java)
//            christian?.id = snapshot.key.toString()
//            _christian.value = christian!!
//        }
//
//        override fun onChildAdded(snapshot: DataSnapshot, p1: String?) {
//
//        }
//
//        override fun onChildRemoved(snapshot: DataSnapshot) {
//
//        }
//    }
//
//    fun getRealtimeUpdates() {
//        dbChristians.addChildEventListener(childEventListener)
//    }

    fun fetchChristians(){

        dbChristians.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if(snapshot.exists()){
                    val christians = mutableListOf<Christian>()
                    for( snap in snapshot.children){

                        val christian = snap.getValue(Christian::class.java)
                        christian?.id = snap.key.toString()
                        christian?.let { christians.add(it) }

                    }

                    _christians.value = christians
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
    }

//    override fun onCleared() {
//        super.onCleared()
//        dbChristians.removeEventListener(childEventListener)
//    }
}