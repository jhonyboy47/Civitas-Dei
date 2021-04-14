package com.csci448.malagon.civitasdei.data.repo

import android.content.Context
import androidx.lifecycle.LiveData
import com.csci448.malagon.civitasdei.data.AttendantProfileEntry
import com.csci448.malagon.civitasdei.data.db.AttendantProfileEntryDao
import com.csci448.malagon.civitasdei.data.db.AttendantProfileEntryDatabase
import kotlinx.coroutines.internal.synchronized
import java.util.*
import java.util.concurrent.Executors

class AttendantProfileEntryRepository private constructor(private val attendantProfileEntryDao: AttendantProfileEntryDao) {

    private val executor = Executors.newSingleThreadExecutor()

    companion object{
        private var INSTANCE: AttendantProfileEntryRepository? = null


        fun getInstance(context:Context): AttendantProfileEntryRepository {
                var instance = INSTANCE
                if (instance == null) {
                    val database = AttendantProfileEntryDatabase.getInstance(context)
                    instance = AttendantProfileEntryRepository(database.attendantProfileEntryDao)
                    INSTANCE = instance
                }
                return instance
        }

    }

    fun getAttendant(id: UUID): LiveData<AttendantProfileEntry?> = attendantProfileEntryDao.getAttendant(id)

    fun addAttendant(attendant: AttendantProfileEntry){
        executor.execute {
            attendantProfileEntryDao.addAttendant(attendant)
        }
    }

    fun updateAttendant(attendant: AttendantProfileEntry){
        executor.execute {
            attendantProfileEntryDao.updateAttendant(attendant)
        }
    }
}