package com.csci448.malagon.civitasdei.data.repo

import android.content.Context
import androidx.lifecycle.LiveData
import com.csci448.malagon.civitasdei.data.ChurchProfileEntry
import com.csci448.malagon.civitasdei.data.db.ChurchProfileEntryDao
import com.csci448.malagon.civitasdei.data.db.ChurchProfileEntryDatabase
import java.util.concurrent.Executors

class ChurchProfileEntryRepository private constructor(private val churchProfileEntryDao: ChurchProfileEntryDao) {
    // singleton model
    companion object {

        private var INSTANCE: ChurchProfileEntryRepository? = null
        private val executor = Executors.newSingleThreadExecutor()

        fun getInstance(context: Context): ChurchProfileEntryRepository {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    val database = ChurchProfileEntryDatabase.getInstance(context)
                    instance = ChurchProfileEntryRepository(database.churchProfileEntryDao)
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    fun getEntries(): LiveData<List<ChurchProfileEntry>> = churchProfileEntryDao.getEntries()

    fun addEntry(entry: ChurchProfileEntry) {
        executor.execute {
            churchProfileEntryDao.addEntry(entry)
        }
    }
}