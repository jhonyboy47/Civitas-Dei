package com.csci448.malagon.civitasdei

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.csci448.malagon.civitasdei.FBdata.Church
import com.csci448.malagon.civitasdei.FBdata.NODE_CHURCHES
import com.google.firebase.database.FirebaseDatabase

class ChurchViewModel : ViewModel(){

    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?>
        get() = _result


    fun addChurch(church: Church){
        val dbChurches = FirebaseDatabase.getInstance().getReference(NODE_CHURCHES)

        church.id = dbChurches.push().key.toString()

        dbChurches.child(church.id).setValue(church)
            .addOnCompleteListener{

                if(it.isSuccessful){
                    _result.value = null
                }else{
                    _result.value = it.exception
                }

            }
    }
}