package com.csci448.malagon.civitasdei.ui.log_in

import androidx.lifecycle.ViewModel
import com.csci448.malagon.civitasdei.data.AttendantProfileEntry
import com.csci448.malagon.civitasdei.data.repo.AttendantProfileEntryRepository

class LogInViewModel(private val attendantProfileEntryRepository: AttendantProfileEntryRepository): ViewModel() {
    fun addAttendant(attendant:AttendantProfileEntry){
        attendantProfileEntryRepository.addAttendant(attendant)
    }
}