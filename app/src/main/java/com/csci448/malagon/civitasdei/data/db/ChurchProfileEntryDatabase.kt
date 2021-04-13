package com.csci448.malagon.civitasdei.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.csci448.malagon.civitasdei.data.ChurchProfileEntry

@Database(entities = [ChurchProfileEntry::class], version=2)
@TypeConverters(ChurchProfileEntryTypeConverters::class)
abstract class ChurchProfileEntryDatabase: RoomDatabase() {

    abstract val churchProfileEntryDao: ChurchProfileEntryDao

    // singleton model
    companion object {

        private const val DATABASE_NAME = "church-attendant_profile-database"
        private var INSTANCE: ChurchProfileEntryDatabase? = null

        fun getIntstance(context: Context): ChurchProfileEntryDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            ChurchProfileEntryDatabase::class.java,
                            DATABASE_NAME
                    ).build()
                }
                return instance
            }
        }
    }
}