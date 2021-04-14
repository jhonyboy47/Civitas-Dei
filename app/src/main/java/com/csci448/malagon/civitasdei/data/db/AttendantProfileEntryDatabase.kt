package com.csci448.malagon.civitasdei.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.csci448.malagon.civitasdei.data.AttendantProfileEntry
import java.util.jar.Attributes

@Database(entities = [AttendantProfileEntry::class], version=1)
@TypeConverters(AttendantProfileEntryTypeConverters::class)
abstract class AttendantProfileEntryDatabase: RoomDatabase() {

    abstract val attendantProfileEntryDao: AttendantProfileEntryDao

    companion object {
        private const val DATABASE_NAME = "attendant-profile-database"
        private var INSTANCE: AttendantProfileEntryDatabase? = null

        fun getInstance(context: Context): AttendantProfileEntryDatabase {
            var instance = INSTANCE
            if(instance == null) {
                instance = Room.databaseBuilder(context, AttendantProfileEntryDatabase::class.java, DATABASE_NAME).build()
            }
            return instance
        }
    }
}