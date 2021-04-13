package com.csci448.malagon.civitasdei.ui.attendant_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AttendantProfileViewModel: ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is attendant attendant_profile Fragment"
    }
    val text: LiveData<String> = _text
}