package com.csci448.malagon.civitasdei.data.db

import androidx.room.TypeConverter
import java.util.*

class ChurchProfileEntryTypeConverters {
    /* handle UUID objects */
    @TypeConverter
    fun toUUID(uuid: String?): UUID? {
        return UUID.fromString(uuid)
    }
    @TypeConverter
    fun fromUUID(uuid: UUID?): String? {
        return uuid?.toString()
    }
}