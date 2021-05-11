package com.csci448.malagon.civitasdei.ui.church_profile_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.csci448.malagon.civitasdei.FBdata.NODE_CHURCHES
import com.csci448.malagon.civitasdei.FBdata.Church
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.lang.Exception

class ChurchProfileListViewModel(): ViewModel() {

    companion object {
        val LOG_TAG = "448.ChurchProfileListViewModel"
    }

    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?>
        get() = _result

    private val dbChurches = FirebaseDatabase.getInstance().getReference(NODE_CHURCHES)

    private val _churches = MutableLiveData<List<Church>>()
    val churches: LiveData<List<Church>>
        get() = _churches

    private val _church = MutableLiveData<Church>()
    val church: LiveData<Church>
        get() = _church

    fun fetchChurches(searchTerms: String) {
        dbChurches.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                Log.d(LOG_TAG, "filterChurches() called with ($searchTerms)")
                var mySearchTerms = searchTerms
                        .trim()
                        .toLowerCase()
                if (searchTerms == null) {
                    mySearchTerms = ""
                }
                Log.d(LOG_TAG, "mySearchTerms: ($mySearchTerms)")

                if (snapshot.exists()) {
                    val churches = mutableListOf<Church>()
                    for (snap in snapshot.children) {
                        val church = snap.getValue(Church::class.java)

                        val name = church?.name
                                ?.trim()
                                ?.toLowerCase()
                        Log.d(LOG_TAG, "church name: $name")

                        church?.id = snap.key.toString()

                        if (name == mySearchTerms) {
                            church.let {
                                if (it != null) {
                                    churches.add(it)
                                }
                            }
                        }
                    }
                    _churches.value = churches
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}