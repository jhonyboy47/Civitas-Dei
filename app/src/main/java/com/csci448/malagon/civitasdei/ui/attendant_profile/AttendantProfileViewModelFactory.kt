package com.csci448.malagon.civitasdei.ui.attendant_profile

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.csci448.malagon.civitasdei.data.repo.AttendantProfileEntryRepository

class AttendantProfileViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(AttendantProfileEntryRepository::class.java).newInstance(
            AttendantProfileEntryRepository.getInstance(context)
        )
    }
}