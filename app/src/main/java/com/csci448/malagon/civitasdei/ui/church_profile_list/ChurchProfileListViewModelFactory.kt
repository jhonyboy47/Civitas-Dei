package com.csci448.malagon.civitasdei.ui.church_profile_list

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.csci448.malagon.civitasdei.data.repo.ChurchProfileEntryRepository

class ChurchProfileListViewModelFactory (private val context: Context): ViewModelProvider.Factory {
    override fun <T: ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ChurchProfileEntryRepository::class.java)
            .newInstance(ChurchProfileEntryRepository.getInstance(context))
    }
}