package com.csci448.malagon.civitasdei.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.csci448.malagon.civitasdei.data.AttendantProfileEntry
import com.csci448.malagon.civitasdei.data.ChurchProfileEntry
import java.util.*

@Dao
interface AttendantProfileEntryDao {
    @Query("SELECT * FROM attendantprofileentry")
    fun getAttendants(): LiveData<List<AttendantProfileEntry>>

    @Query("SELECT * FROM attendantprofileentry  WHERE id=(:id)")
    fun getAttendant(id: UUID): LiveData<AttendantProfileEntry?>

    @Update
    fun updateAttendant(entry: AttendantProfileEntry)

    @Insert
    fun addAttendant(entry: AttendantProfileEntry)

    @Delete
    fun deleteAttendant(attendantProfileEntry: AttendantProfileEntry)
}