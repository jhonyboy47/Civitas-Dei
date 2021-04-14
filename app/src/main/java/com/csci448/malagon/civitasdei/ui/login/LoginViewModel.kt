package com.csci448.malagon.civitasdei.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.csci448.malagon.civitasdei.data.AttendantProfileEntry
import com.csci448.malagon.civitasdei.data.repo.AttendantProfileEntryRepository

class LoginViewModel(private val attendantProfileEntryRepository: AttendantProfileEntryRepository): ViewModel() {
    fun addAttendant(attendant:AttendantProfileEntry){
        attendantProfileEntryRepository.addAttendant(attendant)
    }
}