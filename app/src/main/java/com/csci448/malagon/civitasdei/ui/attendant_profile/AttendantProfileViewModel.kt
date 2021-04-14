package com.csci448.malagon.civitasdei.ui.attendant_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.csci448.malagon.civitasdei.data.AttendantProfileEntry
import com.csci448.malagon.civitasdei.data.repo.AttendantProfileEntryRepository
import java.util.*

class AttendantProfileViewModel(private val attendantProfileEntryRepository: AttendantProfileEntryRepository): ViewModel() {
    fun getAttendant(id: UUID): LiveData<AttendantProfileEntry?>{
        return attendantProfileEntryRepository.getAttendant(id)
    }

    private val attendantIdLiveData = MutableLiveData<UUID>()

    var attendantLiveData: LiveData<AttendantProfileEntry?> = Transformations.switchMap(attendantIdLiveData) {
            attendantId -> attendantProfileEntryRepository.getAttendant(attendantId)
    }


}