package com.csci448.malagon.civitasdei.ui.church_profile_list

import androidx.lifecycle.ViewModel
import com.csci448.malagon.civitasdei.data.repo.ChurchProfileEntryRepository

class ChurchProfileListViewModel(
    private val entryRepository: ChurchProfileEntryRepository
): ViewModel() {
    val entryListLiveData = entryRepository.getEntries()
}