package com.csci448.malagon.civitasdei.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.csci448.malagon.civitasdei.data.ChurchProfileEntry
import java.util.*

@Dao
interface ChurchProfileEntryDao {

    @Query("SELECT * FROM churchprofileentry")
    fun getEntries(): LiveData<List<ChurchProfileEntry>>

    @Query("SELECT * FROM churchprofileentry  WHERE id=(:id)")
    fun getEntry(id: UUID): LiveData<ChurchProfileEntry?>

    @Query("DELETE FROM churchprofileentry")
    fun clearHistory()

    @Update
    fun updateEntry(entry: ChurchProfileEntry)

    @Insert
    fun addEntry(entry: ChurchProfileEntry)
}